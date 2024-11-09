package daksh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class CopyDataFromDakshToLocal {

	public static void main(String[] args) {
		
		/*First, connect to our VPN: Server: vpn.dakshlegal.in; user: dkblr; password: dkblr2015.

		kishore [8:02 AM]
		Then, use JDBC/ODBC to connect to the database:
		-  Server: data1.dakshlegal.in
		-  User: dkblr, password: dkblr2015
		-  Database name: zynata.*/
		
		Connection conn = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		
		Connection conn1 = null;
		PreparedStatement preStmt = null;
		
		ResultSetMetaData metadata = null;
		String query = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         conn = DriverManager
	            .getConnection("jdbc:postgresql://data1.dakshlegal.in:5432/zynata","dkblr", "dkblr2015");
	         stmt =  conn.createStatement();
	         
	         //query = "select * from HEARING__10096 where district is not null limit 100";
	         query = "select * from case__10096 limit 1";
	        rs=  stmt.executeQuery(query);
	        
	        metadata = rs.getMetaData(); 
	        for(int j=1;j<metadata.getColumnCount();j++){
	        	 metadata.getColumnName(j);
	        }
	       
	        conn1 = DriverManager
		            .getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "admin");
	        
	        String sql = "INSERT INTO case__10096 values";
	        sql+="(?";
	        for(int i=0;i<328;i++)
	        	sql+=",?";
	        sql+=")";
	        
	        preStmt = conn1.prepareStatement(sql);
	        while(rs.next()){
	        	 for(int i=1;i<metadata.getColumnCount();i++){
	        		 if(rs.getString(i)!=null)
	        		 preStmt.setObject(i, rs.getString(i));
	        		 else
	        			 preStmt.setObject(i, null); 
	        		 System.out.println(i+" "+rs.getString(i));
	        	 }
	        	 preStmt.addBatch();
	         }
	        System.out.println("insert: "+preStmt.executeBatch());
	        conn1.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      } finally {
	    	  try {
				conn.close();
				stmt.close();
				rs.close();
	        	conn1.close();
	        	preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	      }
	      System.out.println("Opened database successfully");
	}

}
