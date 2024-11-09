package abstractClassTesting;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class DateMani {

	public static void main(String[] args) {
		/*Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		Date test = new Date("8/9/2020");
		calendar.setTime(test);
		System.out.println(calendar.getTime());
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println(calendar.getFirstDayOfWeek());
		
		Calendar currentDate=new GregorianCalendar();
		String dayOfWeek = currentDate.getDisplayName( Calendar.DAY_OF_WEEK ,Calendar.LONG, Locale.getDefault());
		System.out.println(dayOfWeek);
		System.out.println(java.time.LocalDateTime.now().getDayOfWeek());
		*/
		
		List<String> list = new ArrayList<>();
		list.add("AQ_TABLE_10_1597295973815"); 
		list.add("AQ_TABLE_11_1597295974878"); 
		list.add("AQ_TABLE_1_1597295964628");
		Collections.sort(list);
		System.out.println(list);
	}
}
