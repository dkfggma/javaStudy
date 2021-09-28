package db01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestDB02 {
	
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbuid  = "hr";
	private static String dbpsw  = "1234";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Scanner를 써서 직원번호,이름,전화,월급
		Class.forName( driver );
		Connection conn = DriverManager.getConnection(url, dbuid, dbpsw);
		Statement  stmt = conn.createStatement();
		Scanner    in   = new Scanner(System.in);
		System.out.println("찾을 이름을 입력 :");
		String     name = in.next().toUpperCase();
		String     sql  = "SELECT EMPLOYEE_ID, FIRST_NAME||' '||LAST_NAME ENAME";
	    sql            += ", PHONE_NUMBER, SALARY FROM EMPLOYEES ";
	    sql            += "WHERE UPPER(FIRST_NAME||' '||LAST_NAME) LIKE '%"+name+"%'";
	    ResultSet   rs  = stmt.executeQuery(sql);
	    System.out.println(sql);
	    while(rs.next()) {
	    	System.out.print(rs.getString(1)+", ");
	    	System.out.print(rs.getString(2)+", ");
	    	System.out.print(rs.getString(3)+", ");
	    	System.out.println(rs.getString(4));
	    }
	    
	    in.close();
	    rs.close();
	    stmt.close();
	    conn.close();
	    
	}

}
