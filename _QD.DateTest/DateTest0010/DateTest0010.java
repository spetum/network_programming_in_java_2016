import java.text.*;
import java.util.*;

public class DateTest0010 {
	public static void main(String[] args) {
		Date conFromDate = new Date();
		@SuppressWarnings("deprecation")
		long tmtl = conFromDate.parse("Sep 27, 2015 10:10:10");
		/* long tmtl = conFromDate.parse("Sep 27, 2015 10:10:10");
		 * 대신 
		 * long tmtl = Date.parse("Sep 27, 2015 10:10:10");
		 * 로 해도 된다.
		 * 아울러 deprecated 된 내용이다.
		 * 나중에 DateTest0005에 했던 방법으로 특정 날짜를 지정하는 방식을 이용해보자.
		 * thread safe하지 못하기 때문이다. 
		 */
		System.out.println(tmtl);
		Date today = new Date(tmtl);
		DateFormat format_1 = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
		String formatted_Date = format_1.format(today);
		System.out.println(formatted_Date);
	}

}
