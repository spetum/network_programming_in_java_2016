// 어제와 오늘 날짜 구하기
// 특정일 이후/이전 일자 구하기
import java.util.*;

public class DateTest0011 {
	public static void main(String[] args) {
		// 초단위를 빼주고 어제를 구하는 방식
		// setTime을 이용하는 방식
		Date today = new Date() ;
		Date yesterday = new Date() ;
		yesterday.setTime(today.getTime()- ((long)1000*60*60*24));
		Date tommorow = new Date() ;
		tommorow.setTime(today.getTime() +((long)1000*60*60*24));
		
		System.out.println("Yesterday\t\t:" + yesterday.toString());
		System.out.println("Today\t\t\t:" + today.toString());
		System.out.println("Tommorow\t\t:" + tommorow.toString());
		
		// Calendar 객체의 날짜 더하기 메소드를 이용해 특정일을 구하기.
		Calendar date_1 = Calendar.getInstance();
		Calendar date_2 = Calendar.getInstance();
		Calendar date_3 = Calendar.getInstance();
		// 내일 날짜 구하기
		date_1.add(Calendar.DATE, 1);
		Date Cal_Tommorow = date_1.getTime();
		// 어제 날짜 구하기
		date_2.add(Calendar.DATE, -1);
		Date Cal_Yesterday = date_2.getTime();
		// 그냥 오늘 날짜
		Date Cal_Today = date_3.getTime();
		
		System.out.println("Yesterday of cal\t:" + Cal_Yesterday.toString());
		System.out.println("Today of cal\t\t:" + Cal_Today.toString());
		System.out.println("Tommorow of cal\t\t:" + Cal_Tommorow.toString());

		// 다음달과 이전달 구하기
		Calendar date_4 = Calendar.getInstance();
		Calendar date_5 = Calendar.getInstance();
		Calendar date_6 = Calendar.getInstance();
		// 이전달 구하기
		date_4.add(Calendar.MONTH,-1);
		Date Cal_Date_4 = date_4.getTime();
		// 그냥 오늘 날짜
		Date Cal_Date_5 = date_5.getTime();
		// 다음달 구하기
		date_6.add(Calendar.MONTH, 1);
		Date Cal_Date_6 = date_6.getTime();
		
		System.out.println("today before a month\t:" + Cal_Date_4.toString()) ;
		System.out.println("today\t\t\t:" + Cal_Date_5.toString()) ;
		System.out.println("today after a month\t:" + Cal_Date_6.toString()) ;
		
		// 1월 29일의 다음달/이전달은 언제가 될지 확인해보자.
		Calendar date_7 = Calendar.getInstance();
		Calendar date_8 = Calendar.getInstance();
		Calendar date_9 = Calendar.getInstance();
		//date_7.set(2000, 0, 29, 12, 34, 56); // 이렇게 해도 되지만 일단 시간은 빼자.
		// 2000년 1월 29일은 가능하다. 하지만 2001년 1월 29일은?
		// 2001년 2월 29일은 당연 없기에 2001년 2월 28일이 된다고 나온다.
		date_7.set(2001, 0, 29);
		date_8.set(2001, 0, 29);
		date_9.set(2001, 0, 29);
		
		date_7.add(Calendar.MONTH, -1);
		Date Cal_Date_7 = date_7.getTime() ;
		Date Cal_Date_8 = date_8.getTime();
		date_9.add(Calendar.MONTH, 1);
		Date Cal_Date_9 = date_9.getTime();
		
		System.out.println("today before a month\t:" + Cal_Date_7.toString()) ;
		System.out.println("today\t\t\t:" + Cal_Date_8.toString()) ;
		System.out.println("today after a month\t:" + Cal_Date_9.toString()) ;

	}
}
