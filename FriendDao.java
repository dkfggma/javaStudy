package ex03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class FriendDao {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String dbuid = "test";
	private String dbpsw = "1234";

	private Connection conn;
	private CallableStatement cstmt; // stored procedure 사용
	private ResultSet rs;

	public FriendDao() {
		open();
	}

	private void open() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbuid, dbpsw);

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (cstmt != null)
				cstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// --------------------------------------------------------------

	public void insertFriend(String name) {
		String sql = "INSERT INTO FRIEND (NUM, NAME)";
		sql       += " VALUES (SEQ_FRIEND.NEXTVAL, ?)";
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, name);

			cstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteFriend(int num) {
		String sql = "{CALL PKG_FRIEND.DELETEFRIEND(?)}";
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, num);

			cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public FriendVo getFriend(int num) {
		FriendVo fr = new FriendVo();
		String sql = "{CALL PKG_FRIEND.GETFRIEND(?, ?)}";
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, num);
			cstmt.registerOutParameter(2, Types.NUMERIC);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			

			cstmt.executeQuery();
			int    n     = cstmt.getInt(2);
			String name  = cstmt.getString(3);
			
			fr = new FriendVo(n, name);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fr;
	}

	public ArrayList<FriendVo> getFriendList() {
		ArrayList<FriendVo> fr = new ArrayList<FriendVo>();
		String sql = "{CALL PKG_FRIEND.GETFRIENDLIST(?)}";
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.registerOutParameter(1, oracle.jdbc.internal.OracleTypes.CURSOR);
			
			cstmt.executeQuery();
			rs = (ResultSet) cstmt.getObject(1);
			while( rs.next()) {
				int    num      = rs.getInt("num");
				String name     = rs.getString("name");
				
				FriendVo friend = new FriendVo(num, name);
				fr.add(friend);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fr;
	}
}
