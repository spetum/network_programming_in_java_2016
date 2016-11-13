/*
 * 영어로 출력되는 내용을 숫자로 출력하기.
 * 
 * */
import java.util.*;
import java.text.*;

public class DateTest0009 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//Date myDate = new Date("Sun 27 Sep 02:15:00 KST 2015");
		// 이렇게는 런타임에 에러가 된다.
		// 아래의 내용은 Deprecated 된 것으로 이 방법으로는 가급적 쓰지 말자.
		Date myDate = new Date("Sun 27 Sep 2015");		
		System.out.println(myDate.getYear() + "-"
				+ myDate.getMonth() + "-" 
				+ myDate.getDay());		
		// 실행하면 115-8-0 이라고 나온다.
		System.out.println((new Date()).toString());
		// 위의 내용이 아니라 새로운 형식을 입력 해보자.		
		String inString = "Mon, 28 Sep 2015 02:25:37 KST";
		
		/* 아래처럼 하면 런타임 오류가 발생.
		 * SimpleDateFormat format_1 
		 *               = new SimpleDateFormat("EEE, MM dd hh:mm:ss yyyy", Locale.ENGLISH);
		 * 형식이 서로 맞아야 하는데도 맞춰줘도 오류가 발생하는 경우가 있다. MM이 아니라 MMM이어야 한다.
		*/
		SimpleDateFormat format_1 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
		SimpleDateFormat format_2 = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		
		Date formTime = format_1.parse(inString, pos);
		String outStr = format_2.format(formTime);
		
		System.out.println(outStr);
		// System.out.println((new Date()).toString()); 했을 때 나오는 내용을 파싱할 수 있도록 해보자.
		String inStr = "Mon Sep 28 03:11:18 KST 2015";
		SimpleDateFormat format_3 = new SimpleDateFormat("EEE MMM d HH:mm:ss Z yyyy", Locale.ENGLISH);
		//  format_4에서 Locale.English이나 Locale.Korea를 지정하지 않으면 해당 운영체제의 로케일을 따라간다.
		// SimpleDateFormat format_4 = new SimpleDateFormat("yyyy-MM-dd(EEEEEEEE)", Locale.ENGLISH);		
		SimpleDateFormat format_4 = new SimpleDateFormat("yyyy-MM-dd(EEEEEEEE)", Locale.KOREA);
		// SimpleDateFormat format_4 = new SimpleDateFormat("yyyy-MM-dd(EEE)", Locale.ENGLISH);
		// SimpleDateFormat format_4 = new SimpleDateFormat("yyyy-MM-dd(EEE)", Locale.KOREA);
		ParsePosition pos_new = new ParsePosition(0);
		
		Date frmDate = format_3.parse(inStr, pos_new);
		String output_date = format_4.format(frmDate);
		System.out.println(output_date);
	}

}
