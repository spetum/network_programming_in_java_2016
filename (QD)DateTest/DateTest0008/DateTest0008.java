/* 
 * 특정 시간대(TimeZone)를 정하고 날짜확인하
 * 주어진 시간대에 맞게 현재 시각을 초기화 된 GregorianCalendar를 반환
 * 혹은 Calendar ca = Calendar.getInstance(Locale.KOREA);
 * 
 */
import java.util.*;

public class DateTest0008 {
	public static void main(String[] args) {
		// KST만 너무 많이 써서 이번에는 JST로 .. .. ..
		TimeZone jst = TimeZone.getTimeZone("JST");
		Calendar ca = Calendar.getInstance(jst);
		System.out.println( ca.get(Calendar.YEAR) + "년 "
				+ ca.get(Calendar.MONTH) + "월 "
				+ ca.get(Calendar.DATE) + "일 "
				+ ca.get(Calendar.HOUR_OF_DAY) + "시 "
				+ ca.get(Calendar.MINUTE) + "분 "
				+ ca.get(Calendar.SECOND) + "초" );
	}

}
