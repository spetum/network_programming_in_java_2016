import java.util.*;
import java.text.*;

public class DateTest0003 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
		Date currentDate = new Date() ;
		String formattedDate_ForLocale = formatter.format(currentDate);
		System.out.println(formattedDate_ForLocale);
	}
}
