package utilities;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	public static String getUserLoginDate(String format)
	{
		DateFormat dateformat=new SimpleDateFormat(format);
		Date currentdate=new Date();
		return dateformat.format(currentdate);
	}
	public static String formatDate(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
	public static String getCurrentDateTimeInISOFormat1() {
        DateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        isoFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return isoFormat.format(new Date());
    }
	
    public static String getDayOfWeek(Date date) {
        DateFormat dayFormat = new SimpleDateFormat("Wednesday");
        return dayFormat.format(date);
    }
    public static boolean isDateInPast(Date date) {
        return date.before(new Date());
    }
}
