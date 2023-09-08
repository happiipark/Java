import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Dao {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties db = new Properties();
			db.load(new FileInputStream("db.properties"));
			Class.forName(db.getProperty("driver"));
			conn = DriverManager.getConnection(db.getProperty("url"), db.getProperty("user"),
					db.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Account selectAccount(Connection conn, String id) {
		Account acc = null;
		String sql = "select * from account where 1=1 and id = ? ";
		// 가변으로 바꿔 들어오는 데이터는 '?' 로 표시
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				String rid = rs.getString("id"); // db에 컬럼명이 파라미터로 들어간다 Account 테이블의 첫번째 컬럼 id
				String rname = rs.getString("name");
				Integer rbalance = rs.getInt("balance");
				String rgrade = rs.getString("grade");
				acc = new Account(rid, rname, rbalance, rgrade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}

	public static int insertAccount(Connection conn, Account acc) {
		int cnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into account values(?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			pstmt.setString(4, acc.getGrade());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public static int updateAccount(Connection conn, Account acc) {
		int cnt = 0;
		PreparedStatement pstmt = null;
		String sql = "update account set balance = ? where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance());
			pstmt.setString(2, acc.getId());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;

	}
	
	public static List<Account> selectAccountList(Connection conn) {
		List<Account> accList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from account where 1=1";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs != null) {
				while(rs.next()) {
					String rid = rs.getString(1);
					String rname =rs.getString(2);
					Integer rbalance = rs.getInt(3);
					String rgrade =rs.getString(4);
					accList.add(new Account(rid, rname, rbalance, rgrade));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null ) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return accList;
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
