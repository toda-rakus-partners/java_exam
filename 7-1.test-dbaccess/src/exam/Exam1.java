package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exam1 {
    public static void main(String[] args) {
		// 接続情報
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "Sho23792379";

		Connection con = null; // 使用する変数の宣言
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			// (1)データベースに接続
			con = DriverManager.getConnection(url, user, password);

			// (2)SQL文を作成
			sql = "INSERT INTO test_members (name, age, dep_id) VALUES(?, ? ,?)";

			// (3)SQL実行準備
			pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "山田太郎");
            pstmt.setInt(2, 62);
            pstmt.setInt(3, 1);
			pstmt.executeUpdate();
			pstmt.setString(1, "佐藤花子");
            pstmt.setInt(2, 33);
            pstmt.setInt(3, 2);
			pstmt.executeUpdate();
			pstmt.setString(1, "遠藤次郎");
            pstmt.setInt(2, 55);
            pstmt.setInt(3, 2);
			pstmt.executeUpdate();

			// (4)SQL実行
		    // int num = pstmt.executeUpdate();

			// (5)結果の操作
			

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
