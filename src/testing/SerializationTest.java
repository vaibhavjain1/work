package testing;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public class SerializationTest {

	class ToSerialize{
		int id;
	}
	class ToSerializeParent implements Serializable{
		ToSerialize obj;
		
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ToSerialize obj = new SerializationTest().new ToSerialize();
		Class.forName ("org.h2.Driver"); 
		Connection con = null;
		try {
			/*con = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
			PreparedStatement pr = con.prepareStatement("insert into temp values(?);");
			pr.setObject(0, obj);*/
			int a=5;
			int b = 7;
			int c = a+b -(b=a);
			System.out.println(c+" "+b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!=null)
				con.close();
		}
	}

}
