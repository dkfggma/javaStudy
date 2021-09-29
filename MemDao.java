package db04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DAO : data access object
public class MemDao {
	// fields
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String dbuid = "test";
	private String dbpsw = "1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemDao() {
		open();
	}

	public Connection open() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbuid, dbpsw);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
	
	public void close() {
		try {
			if( conn != null) conn.close();
			if( pstmt != null) pstmt.close();
			if( rs != null) rs.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public MEMVO getMem(int memid) {
		MEMVO mem = null;
		String sql = "SELECT MEMID, MEMNAME, EMAIL,IN_DATE ";
		sql		  += " FROM MEM ";
		sql		  += " WHERE MEMID = ?";
		try {
		
		pstmt = conn.prepareStatement( sql );
		pstmt.setInt(1, memid);
		
		rs    = pstmt.executeQuery();
		if(rs.next()) { //조회ok
			int mid        = rs.getInt("MEMID");
			String memname = rs.getString("MEMNAME");
			String email   = rs.getString("EMAIL");
			String indate  = rs.getString("IN_DATE");
			
			mem = new MEMVO(mid, memname, email, indate);
		} else {
			
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return mem;
	}

	
	public MEMVO deleteMem(int memid) {
		MEMVO mem = null;
		String sql = "DELETE FROM MEM ";
		sql		  += " WHERE MEMID = ?";
		try {
		
		pstmt = conn.prepareStatement( sql );
		pstmt.setInt(1, memid);
		
		rs    = pstmt.executeQuery();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}

	public MEMVO updateMem(int memid, String email) {
		MEMVO mem = null;
		String sql = "UPDATE MEM ";
		sql		  += " SET EMAIL = ?";
		sql		  += " WHERE MEMID = ?";
		try {
		
		pstmt = conn.prepareStatement( sql );
		pstmt.setInt(2, memid);
		pstmt.setString(1, email);
		
		rs    = pstmt.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}

	public MEMVO insertMem(String name, String email) {
		MEMVO mem = null;
		String sql = "INSERT INTO MEM(MEMID, MEMNAME, EMAIL) ";
		sql		  += " VALUES ((SELECT NVL(MAX(MEMID),0)+1 FROM MEM),?,?)";
		
		try {
		
		pstmt = conn.prepareStatement( sql );
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		
		rs    = pstmt.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}


	public ArrayList<MEMVO> getMemList() {
		ArrayList<MEMVO> memList = new ArrayList<MEMVO>();
		String sql = "SELECT MEMID, MEMNAME, EMAIL,IN_DATE ";
		sql		  += " FROM MEM ";
		sql       += "ORDER BY MEMID ASC";
		try {
		
		pstmt = conn.prepareStatement( sql );
		
		rs    = pstmt.executeQuery();
		while(rs.next()) { 
			int mid = rs.getInt("MEMID");
			String memname = rs.getString("MEMNAME");
			String email = rs.getString("EMAIL");
			String indate = rs.getString("IN_DATE");
			
			MEMVO mem = new MEMVO(mid, memname, email, indate);
			memList.add(mem);
			
		} 
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return memList;
	}

}
