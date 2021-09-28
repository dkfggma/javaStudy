package db01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB01 {
	// Connenction String : 연결 문자열
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbuid  = "hr";
	private static String dbpwd  = "1234";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//드라이버를 불러온다, new
		Class.forName( driver );
		Connection conn = DriverManager.getConnection(url, dbuid, dbpwd);
		Statement  stmt = conn.createStatement();
		String     sql  = "SELECT FIRST_NAME||' '||LAST_NAME ENAME FROM EMPLOYEES";
		sql            += " WHERE DEPARTMENT_ID = 60";
		ResultSet  rs   = stmt.executeQuery(sql); 
		while(rs.next()) {
			//System.out.print(rs.getString("FIRST_NAME")+" ");
			//System.out.println(rs.getString("LAST_NAME"));
			//System.out.println(rs.getString("FIRSTNAME||' '||LAST_NAME"));
			System.out.println(rs.getString("ENAME"));
			System.out.println(rs.getString(1));
		}
		rs.close();
		stmt.close();
		conn.close();

	}

}
