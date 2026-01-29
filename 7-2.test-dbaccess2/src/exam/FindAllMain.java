package exam;

import dao.MemberDao;

import dto.Member;
import java.util.List;

/**
 * findAll()メソッド、動作確認用の実行クラスです.
 * 
 * @author igamasayuki
 *
 */
public class FindAllMain {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();

		List<Member> list = dao.findAll();

		for (Member one : list) {
			System.out.println(one.getId());
			System.out.println(one.getName());
			System.out.println(one.getAge());
			System.out.println(one.getDepId());
		}
	}

}
