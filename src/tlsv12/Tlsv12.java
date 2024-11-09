package tlsv12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Tlsv12 {

	public static void main(String[] args) {
		try {
			//Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Not able to load driver");
		}


		String url ="";
		Connection conn = null;
		try {
			
			url = "jdbc:sqlserver://SMM-BLUEBELL\\SQL2012E;";
			System.out.println(url);
			conn = DriverManager.getConnection(url,"sa","control*88");
			System.out.println("Connected succesfully");
		} catch (SQLException e) {
			System.out.println(e);
			//e.printStackTrace();
		} finally {
			if(conn!=null)
				try {
					conn.close();
					System.out.println("Connection closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
