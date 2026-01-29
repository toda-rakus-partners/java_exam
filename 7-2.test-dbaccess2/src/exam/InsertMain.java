package exam;

import dto.Member;

import dao.MemberDao;

/**
 * insert()メソッド、動作確認用の実行クラスです.
 * 
 * @author igamasayuki
 *
 */
public class InsertMain {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		Member member = new Member();
		member.setName("シロー");
		member.setAge(54);
		member.setDepId(3);
		dao.insert(member);

		

		System.out.println("insert終了");
	}

}
