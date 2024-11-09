package accolite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class WeekOf {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println("datetimeutc" + ":" + dateFormat.format(new Date()));

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(2);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        dateFormat.applyPattern("MMM dd,yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println("weekof" + ":" + "Week of " + dateFormat.format(calendar.getTime()));
    }
}
