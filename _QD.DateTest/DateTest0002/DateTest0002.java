import java.util.*;

public class DateTest0002 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date ( );
		Calendar c = Calendar.getInstance ( );
		c.setTime ( d );
		System.out.println( c.toString());
		// this result is 
		// java.util.GregorianCalendar[time=1442829650677,areFieldsSet=true,
		// areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",
		// offset=32400000,dstSavings=0,useDaylight=false,transitions=22,lastRule=null], 
		// firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2015,MONTH=8,WEEK_OF_YEAR=39,
		// WEEK_OF_MONTH=4,DAY_OF_MONTH=21,DAY_OF_YEAR=264,DAY_OF_WEEK=2,DAY_OF_WEEK_IN_MONTH=3,
		// AM_PM=1,HOUR=7,HOUR_OF_DAY=19,MINUTE=0,SECOND=50,MILLISECOND=677,ZONE_OFFSET=32400000,
		// DST_OFFSET=0]
		System.out.println (c.getFirstDayOfWeek());
		System.out.println (c.getTimeZone());
		System.out.println (c.getTimeZone().getID());
		// Let other examples make to print time and date!
	}

}
