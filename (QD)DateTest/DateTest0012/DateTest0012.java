/*
 * retrieved a date of Last modified for file
 * */
import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.util.Properties;

public class DateTest0012 {
	//String sepStr = new String( 
    // System.getProperties().getProperty("file.separator"));
	public static void main(String[] args) {
		String fileSep = new String(System.getProperties().getProperty("file.separator"));
		String directory_str = "." + fileSep ;
		String filename_str = "DateTest0012.java";
		
		Calendar cal_file_lastModified = Calendar.getInstance();
		
		File f = new File( directory_str, filename_str );
		Date date_of_file_lastModified = new Date(f.lastModified()) ;

		cal_file_lastModified.setTime(date_of_file_lastModified);
		
		System.out.println("Date and time of last modified for \"" + directory_str + filename_str +"\"");
		System.out.println("Year: " + cal_file_lastModified.get(Calendar.YEAR));
		System.out.println("Month: " + (cal_file_lastModified.get(Calendar.MONTH)+1) );
		System.out.println("Day " + cal_file_lastModified.get(Calendar.DAY_OF_MONTH));
		System.out.println("Hour: " + cal_file_lastModified.get(Calendar.HOUR_OF_DAY));
		System.out.println("Minute: " + cal_file_lastModified.get(Calendar.MINUTE));
		System.out.println("Second: " + cal_file_lastModified.get(Calendar.SECOND));
		System.out.println("Millisecond: " + cal_file_lastModified.get(Calendar.MILLISECOND));		
	}
}
