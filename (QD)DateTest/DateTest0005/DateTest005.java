import java.util.*;
import java.text.*;

public class DateTest005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance ( );
		//cal.set ( Integer.parseInt ( args[0] ), Integer.parseInt ( args [1] ) - 1, Integer.parseInt ( args [2] ) );
		cal.set (1999, 9, 30) ; // �Ѵ��� ����� �Ѵ�. 1999�� 10�� 30���� �Էµȴ�.
		
		SimpleDateFormat dFormat = new SimpleDateFormat ( "yyyy-MM-dd" );
		System.out.println ( "�Է� ��¥ " + dFormat.format ( cal.getTime ( ) ) );
		System.out.println ( "�ش� ���� ������ ���� : " + cal.getActualMaximum ( Calendar.DATE ) );
		
		
		cal.set (1999, 8, 30) ; 		
		// SimpleDateFormat dFormat = new SimpleDateFormat ( "yyyy-MM-dd" );
		System.out.println ( "�Է� ��¥ " + dFormat.format ( cal.getTime ( ) ) );
		System.out.println ( "�ش� ���� ������ ���� : " + cal.getActualMaximum ( Calendar.DATE ) );
		Date date_Sep_30_1999 = cal.getTime();
		System.out.println("Sep 30 1999 : " + date_Sep_30_1999.toString());
	}

}
