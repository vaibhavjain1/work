package daksh;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class GetDataInJsonForIPC {

	public static void main(String[] args) {

		
		
		
		Connection conn = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData metadata = null;
		String query = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         conn = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "admin");
	         stmt =  conn.createStatement();
	        
	        query = "select * from hearing__10096 where district = 'Medak'";
	        rs=  stmt.executeQuery(query);
	        
	        
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Medak_Hearing");
	        
	        int rowCount = -1;
	        int columnCount = -1;
	        Row row = sheet.createRow(++rowCount);
	        Cell cell;
	        metadata = rs.getMetaData(); 
	        for(int j=1;j<metadata.getColumnCount();j++){
	        	cell = row.createCell(++columnCount);
                cell.setCellValue((String) metadata.getColumnName(j));        	
	        }
	        
	        while(rs.next()){
	        	 row = sheet.createRow(++rowCount);
	        	 columnCount=-1;
	        	 for(int i=1;i<metadata.getColumnCount();i++){
	        		 cell = row.createCell(++columnCount);
	                 cell.setCellValue((String) rs.getString(i));
	        		 System.out.println(rs.getString(1));
	        	 }
	         }
	        try (FileOutputStream outputStream = new FileOutputStream("C://Medak_Hearing.xlsx")) {
	            workbook.write(outputStream);
	        }
	        workbook.close();
	        System.out.println("File written successfully");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      } finally {
	    	  try {
				conn.close();
				stmt.close();
				rs.close();
	        	
			} catch (SQLException e) {
				e.printStackTrace();
			}
	      }
	      System.out.println("Opened database successfully");
	

	}

}
