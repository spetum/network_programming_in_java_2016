/*
 * Date format:
 * (Year/Month/Day Hour:Minute:Second)
 * with specific Locale String */
import java.util.*;
import java.text.*; // DateFormat

public class DateTest0007 {
	public static void main(String[] args) {
		DateFormat df = DateFormat.getDateInstance (DateFormat.LONG, Locale.KOREA) ;
		Calendar cal = Calendar.getInstance(Locale.KOREA);
		String JustDayAndTime = df.format(cal.getTime());
		
		System.out.println(JustDayAndTime);
	}

}
