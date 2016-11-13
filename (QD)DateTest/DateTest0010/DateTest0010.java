import java.text.*;
import java.util.*;

public class DateTest0010 {
	public static void main(String[] args) {
		Date conFromDate = new Date();
		@SuppressWarnings("deprecation")
		long tmtl = conFromDate.parse("Sep 27, 2015 10:10:10");
		/* long tmtl = conFromDate.parse("Sep 27, 2015 10:10:10");
		 * ��� 
		 * long tmtl = Date.parse("Sep 27, 2015 10:10:10");
		 * �� �ص� �ȴ�.
		 * �ƿ﷯ deprecated �� �����̴�.
		 * ���߿� DateTest0005�� �ߴ� ������� Ư�� ��¥�� �����ϴ� ����� �̿��غ���.
		 * thread safe���� ���ϱ� �����̴�. 
		 */
		System.out.println(tmtl);
		Date today = new Date(tmtl);
		DateFormat format_1 = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
		String formatted_Date = format_1.format(today);
		System.out.println(formatted_Date);
	}

}
