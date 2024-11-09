package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Db4Free {

	public static void main(String[] args) throws Exception {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net/sql12274592","sql12274592","BYKrdA3mDn");
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from emp;");  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  	"+rs.getString(3));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			con.close();
		}	
	}

}
