package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Member;

/**
 * membersテーブルを操作するリポジトリ.
 * 
 * @author igamasayuki
 *
 */
@Repository
public class MemberRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * Memberオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setAge(rs.getInt("age"));
		member.setDepId(rs.getInt("dep_id"));
		return member;
	};

	/**
	 * メンバー一覧情報を年齢順で取得します.
	 * 
	 * @return 全メンバー一覧 メンバーが存在しない場合はサイズ0件のメンバー一覧を返します
	 */
	public List<Member> findAll() {
		String sql = "SELECT id, name, age, dep_id FROM test_members ORDER BY age DESC";

		List<Member> memberList = template.query(sql, MEMBER_ROW_MAPPER); // ←ここに実行の処理を書く

		return memberList;
	}

	/**
	 * 主キー検索を行います.
	 * 
	 * @param id 検索したい主キーの値
	 * @return メンバー情報(検索されなかった場合は非検査例外が発生します)
	 */
	public Member load(Integer id) {
		String sql = "SELECT id, name, age, dep_id FROM test_members WHERE id = :id";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		Member member = template.queryForObject(sql, param, MEMBER_ROW_MAPPER); // ←ここに実行処理を書く

		return member;
	}

	/**
	 * メンバー情報を登録or更新します.
	 * 
	 * @param member メンバー情報
	 * @return メンバー情報
	 */
	public Member save(Member member) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(member);

		if (member.getId() == null) { // ←正しい条件に修正する
			String insertSql = "INSERT INTO test_members (name, age, dep_id) VALUES (:name, :age, :depId)";
			template.update(insertSql, param);
		} else {
			String updateSql = "UPDATE test_members SET name=:name, age=:age, dep_id=:depId WHERE id = :id";
			template.update(updateSql, param);
			// ここに実行処理を書く
		}

		return member;
	}

}
