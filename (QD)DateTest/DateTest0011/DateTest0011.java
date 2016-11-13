// ������ ���� ��¥ ���ϱ�
// Ư���� ����/���� ���� ���ϱ�
import java.util.*;

public class DateTest0011 {
	public static void main(String[] args) {
		// �ʴ����� ���ְ� ������ ���ϴ� ���
		// setTime�� �̿��ϴ� ���
		Date today = new Date() ;
		Date yesterday = new Date() ;
		yesterday.setTime(today.getTime()- ((long)1000*60*60*24));
		Date tommorow = new Date() ;
		tommorow.setTime(today.getTime() +((long)1000*60*60*24));
		
		System.out.println("Yesterday\t\t:" + yesterday.toString());
		System.out.println("Today\t\t\t:" + today.toString());
		System.out.println("Tommorow\t\t:" + tommorow.toString());
		
		// Calendar ��ü�� ��¥ ���ϱ� �޼ҵ带 �̿��� Ư������ ���ϱ�.
		Calendar date_1 = Calendar.getInstance();
		Calendar date_2 = Calendar.getInstance();
		Calendar date_3 = Calendar.getInstance();
		// ���� ��¥ ���ϱ�
		date_1.add(Calendar.DATE, 1);
		Date Cal_Tommorow = date_1.getTime();
		// ���� ��¥ ���ϱ�
		date_2.add(Calendar.DATE, -1);
		Date Cal_Yesterday = date_2.getTime();
		// �׳� ���� ��¥
		Date Cal_Today = date_3.getTime();
		
		System.out.println("Yesterday of cal\t:" + Cal_Yesterday.toString());
		System.out.println("Today of cal\t\t:" + Cal_Today.toString());
		System.out.println("Tommorow of cal\t\t:" + Cal_Tommorow.toString());

		// �����ް� ������ ���ϱ�
		Calendar date_4 = Calendar.getInstance();
		Calendar date_5 = Calendar.getInstance();
		Calendar date_6 = Calendar.getInstance();
		// ������ ���ϱ�
		date_4.add(Calendar.MONTH,-1);
		Date Cal_Date_4 = date_4.getTime();
		// �׳� ���� ��¥
		Date Cal_Date_5 = date_5.getTime();
		// ������ ���ϱ�
		date_6.add(Calendar.MONTH, 1);
		Date Cal_Date_6 = date_6.getTime();
		
		System.out.println("today before a month\t:" + Cal_Date_4.toString()) ;
		System.out.println("today\t\t\t:" + Cal_Date_5.toString()) ;
		System.out.println("today after a month\t:" + Cal_Date_6.toString()) ;
		
		// 1�� 29���� ������/�������� ������ ���� Ȯ���غ���.
		Calendar date_7 = Calendar.getInstance();
		Calendar date_8 = Calendar.getInstance();
		Calendar date_9 = Calendar.getInstance();
		//date_7.set(2000, 0, 29, 12, 34, 56); // �̷��� �ص� ������ �ϴ� �ð��� ����.
		// 2000�� 1�� 29���� �����ϴ�. ������ 2001�� 1�� 29����?
		// 2001�� 2�� 29���� �翬 ���⿡ 2001�� 2�� 28���� �ȴٰ� ���´�.
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
