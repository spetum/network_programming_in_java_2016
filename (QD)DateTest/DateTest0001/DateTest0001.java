
import static java.lang.System.out ;

public class DateTest0001 {
	private static final long DAY_Millisecond = 24 * 60 * 60 * 1000 ;
	private static final long HOUR_Millisecond = 60 * 60 *1000;
	private static final long MINUTE_Millisecond = 60 * 1000;
	private static final long SECOND_Millisecond = 1000; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		long Year, Month, Day, Hour, Minute, Second, Millisecond;
		long Day_Remainder, Hour_Remainder, Minute_Remainder, Second_Remainder;
		long time = System.currentTimeMillis ( );
		System.out.println ( time );
		Day = time / DAY_Millisecond ;
		Day_Remainder = time % DAY_Millisecond ;
		out.println ("Day : " + Day);
		out.println ("Day Remainder : " + Day_Remainder);
		
		Hour = Day_Remainder / HOUR_Millisecond ;
		Hour_Remainder = Day_Remainder % HOUR_Millisecond ;
		out.println("Hour : " + Hour);
		out.println("Hour Remainder :" + Hour_Remainder);
		
		Minute = Hour_Remainder / MINUTE_Millisecond;
		Minute_Remainder = Hour_Remainder % MINUTE_Millisecond;
		out.println("Minute : " + Minute);
		out.println("Minute Remainder: " + Minute_Remainder);
		
		Second = Minute_Remainder / SECOND_Millisecond;
		Second_Remainder = Minute_Remainder % SECOND_Millisecond;
		out.println("Second : " + Second);
		out.println("Second Remainder: " + Second_Remainder);
		
		out.println("Millisecond : " + Second_Remainder);
	}

}
