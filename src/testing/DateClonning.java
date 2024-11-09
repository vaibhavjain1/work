package testing;

import java.util.Date;

public class DateClonning {

	public void changeDate(Date d){
		Date e = (Date) d.clone();
		e.setDate(20);
		d.setDate(22);
	}
	
	public static void main(String[] args) {
		DateClonning obj = new DateClonning();
		Date d = new Date("10-May-2018");
		obj.changeDate(d);
		System.out.println(d);
	}

}
