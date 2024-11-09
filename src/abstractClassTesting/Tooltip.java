package abstractClassTesting;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tooltip {

	public static void main(String[] args) {
		java.sql.Timestamp obj = new Timestamp(new java.util.Date().getTime());
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
		System.out.println(timeStamp);
		List<String> abc = new ArrayList<>();
		abc.add("1");
		abc.add("2");
		abc.remove("2");
		System.out.println(abc);
	}
}
