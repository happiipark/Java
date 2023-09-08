package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.Team;

public class TeamDAO {

	// db 연결
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
	
	// 팀명 중복 체크
		public static boolean idDoubleCheck(Connection conn, String name) {
			boolean res = true;
			String sql = "select * from team where 1=1 and name = ? ";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				if (rs != null && rs.next()) {
					res = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return res;
		}

		
		// 팀 번호 자동 채번 등록한 순서대로
		public static int selectTeamNumber() {
			Connection conn = getConnection();
			int teamNumber = 0;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "select max(num) from team ";
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs != null && rs.next()) { // 값이 있을경우
					System.out.println(rs.getInt(1));
					teamNumber = rs.getInt(1) + 1;

				} else {

					teamNumber = 1; // 값이 없으면 1로 해서 값 넣어주기
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return teamNumber;
		}
		
		
	// 팀 등록
	public static int insertTeam(Connection conn, Team team) {
		int cnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into team values(?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, team.getNum());
			pstmt.setString(2, team.getName());
			pstmt.setString(3, team.getLocal());
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

	// 특정 팀 조회
	public static Team selectTeam(Connection conn, String teamName) {
		Team team = null;
		String sql = "select * from team where 1=1 and name = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teamName);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				Integer rnum = rs.getInt("num");
				String rname = rs.getString("name");
				String rlocal = rs.getString("local");
				team = new Team(rnum, rname, rlocal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return team;
	}
	

	public static List<Team> selectTeamList(Connection conn) {
		List<Team> teamList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from team";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if( rs != null) {
				while( rs.next()){
					Integer num = rs.getInt(1);
					String name = rs.getString(2);
					String local = rs.getString(3);
					teamList.add(new Team(num, name, local));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt != null ) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return teamList;
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
