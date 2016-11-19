import java.util.*;
public class DateTest0004 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar today = new GregorianCalendar ( );
		int year = today.get ( Calendar.YEAR );
		int month = today.get ( Calendar.MONTH ) + 1;
		int day_of_month = today.get ( Calendar.DAY_OF_MONTH );
		int day_of_week = today.get (Calendar.DAY_OF_WEEK) ;
		System.out.print("Year: " + year + " Month: " + month + " Day : " + day_of_month);
		System.out.print(" Day of week: " + day_of_week + "\n");
		
		GregorianCalendar gc = new GregorianCalendar ( );		
		System.out.println ( gc.get ( Calendar.YEAR ) );
		System.out.println ( String.valueOf ( gc.get ( Calendar.MONTH ) + 1 ) );
		System.out.println ( gc.get ( Calendar.DATE ) );
		//System.out.println ( gc.get() );

	}
}
