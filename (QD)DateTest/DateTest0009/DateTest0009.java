/*
 * ����� ��µǴ� ������ ���ڷ� ����ϱ�.
 * 
 * */
import java.util.*;
import java.text.*;

public class DateTest0009 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//Date myDate = new Date("Sun 27 Sep 02:15:00 KST 2015");
		// �̷��Դ� ��Ÿ�ӿ� ������ �ȴ�.
		// �Ʒ��� ������ Deprecated �� ������ �� ������δ� ������ ���� ����.
		Date myDate = new Date("Sun 27 Sep 2015");		
		System.out.println(myDate.getYear() + "-"
				+ myDate.getMonth() + "-" 
				+ myDate.getDay());		
		// �����ϸ� 115-8-0 �̶�� ���´�.
		System.out.println((new Date()).toString());
		// ���� ������ �ƴ϶� ���ο� ������ �Է� �غ���.		
		String inString = "Mon, 28 Sep 2015 02:25:37 KST";
		
		/* �Ʒ�ó�� �ϸ� ��Ÿ�� ������ �߻�.
		 * SimpleDateFormat format_1 
		 *               = new SimpleDateFormat("EEE, MM dd hh:mm:ss yyyy", Locale.ENGLISH);
		 * ������ ���� �¾ƾ� �ϴµ��� �����൵ ������ �߻��ϴ� ��찡 �ִ�. MM�� �ƴ϶� MMM�̾�� �Ѵ�.
		*/
		SimpleDateFormat format_1 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
		SimpleDateFormat format_2 = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		
		Date formTime = format_1.parse(inString, pos);
		String outStr = format_2.format(formTime);
		
		System.out.println(outStr);
		// System.out.println((new Date()).toString()); ���� �� ������ ������ �Ľ��� �� �ֵ��� �غ���.
		String inStr = "Mon Sep 28 03:11:18 KST 2015";
		SimpleDateFormat format_3 = new SimpleDateFormat("EEE MMM d HH:mm:ss Z yyyy", Locale.ENGLISH);
		//  format_4���� Locale.English�̳� Locale.Korea�� �������� ������ �ش� �ü���� �������� ���󰣴�.
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
