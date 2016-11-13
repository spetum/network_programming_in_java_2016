import java.net.*;
import java.io.*;

public class DayTimeClient {
	private static final int dayTimePort = 5145;
	private static final int MAX_STRING = 1024;
	public static void main(String[] args) throws IOException {
		try {
			Socket con = new Socket(args[0], dayTimePort);
			InputStream in_s = con.getInputStream();
			BufferedReader buf_read = new BufferedReader(new InputStreamReader(in_s)) ;
			char [] buf_char = new char[MAX_STRING] ;
			
			System.out.print("The time at " + args[0] + " is ");
			while ( (buf_read.read(buf_char,0,MAX_STRING)) > 0  ) {
				//String timeStr = buf_read.readLine();
				System.out.print(buf_char);
				con.close();
			}
		} catch (Exception e){
		} // end of try..catch for Exception
	} // end of main method
}
