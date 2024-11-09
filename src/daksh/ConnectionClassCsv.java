package daksh;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionClassCsv {

	public static void main(String[] args) {
		
		/*First, connect to our VPN: Server: vpn.dakshlegal.in; user: dkblr; password: dkblr2015.

		kishore [8:02 AM]
		Then, use JDBC/ODBC to connect to the database:
		-  Server: data1.dakshlegal.in
		-  User: dkblr, password: dkblr2015
		-  Database name: zynata.*/
		
		Connection conn = null;
		
		Statement stmt = null;
		FileWriter fileWriter = null;
		ResultSet rs = null;
		ResultSetMetaData metadata = null;
		String query = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         conn = DriverManager
	            .getConnection("jdbc:postgresql://data1.dakshlegal.in:5432/zynata","dkblr", "dkblr2015");
	         stmt =  conn.createStatement();
	         
	         //query = "select * from HEARING__10096 where district is not null limit 100";
	         query = "select * from case__10096 where district = 'Medak'";
	        rs=  stmt.executeQuery(query);
	        
	        fileWriter = new FileWriter("C://Medak_Case.csv");

	        metadata = rs.getMetaData(); 
	        for(int j=1;j<metadata.getColumnCount();j++){
	        	 fileWriter.append(metadata.getColumnName(j));
        		 fileWriter.append(",");
	        }
	        fileWriter.append("\n");
	        fileWriter.append("\n");
	         while(rs.next()){
	        	 for(int i=1;i<metadata.getColumnCount();i++){
	        		 fileWriter.append(String.valueOf(rs.getString(i)));
	        		 System.out.println(rs.getString(1));
	        		 fileWriter.append(",");
	        	 }
	        	 fileWriter.append("\n");
	         }
	         fileWriter.append("\n");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      } finally {
	    	  try {
				conn.close();
				stmt.close();
				rs.close();
	        	 try {
					fileWriter.flush();
					 fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	      }
	      System.out.println("Opened database successfully");
	}

}
