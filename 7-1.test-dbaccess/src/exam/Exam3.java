package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam3 {
    public static void main(String[] args) {
		// 接続情報
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "Sho23792379";

		Connection con = null; // 使用する変数の宣言
		PreparedStatement pstmt = null;
		String sql = null;
        ResultSet rs = null;

		try {
			// (1)データベースに接続
			con = DriverManager.getConnection(url, user, password);

			// (2)SQL文を作成
			sql = "SELECT * FROM test_members JOIN test_deps ON id = dep_id";

			// (3)SQL実行準備
			pstmt = con.prepareStatement(sql);

			// (4)SQL実行
		    rs = pstmt.executeQuery();

			// (5)結果の操作
			while(rs.next()) {
				int id = rs.getInt("id");
				System.out.print("id=" + id + ",");
				String name = rs.getString("name");
				System.out.print("name=" + name + ",");
				int age = rs.getInt("age");
				System.out.print("age=" + age + ",");
				int dep_name = rs.getInt("dep_id");
				// System.out.println("dep_name=" + dep_id);
			}

		} catch (SQLException ex) {
			System.err.println("SQL = " + sql);
			ex.printStackTrace();
		} finally {
			try {
				// (6) メモリの解放(切断)
                if (con != null) {
                    con.close();
                }

                if(pstmt != null) {
                    pstmt.close();
                }
			} catch (Exception ex) {}
		}
	}
}
