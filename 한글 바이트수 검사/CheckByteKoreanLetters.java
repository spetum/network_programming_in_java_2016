import java.io.UnsupportedEncodingException;

public class CheckByteKoreanLetters {

	public static void main(String[] args) {
		//String aStr = new String("æ»≥Á«œººø‰.");
		//String aStr = new String("\u03c0");
		//String aStr = new String("\u00a9"); // copy right
		String aStr = new String("\u2122"); // Trade Mark
		System.out.println("aStr =\"" + aStr +"\"");
		System.out.println("aStr.getBytes() = " + aStr.getBytes().length);
		try {
			System.out.println("aStr.getBytes(\"EUC-KR\") = " + aStr.getBytes("EUC-KR").length);
			System.out.println("aStr.getBytes(\"KSC5601\") = " + aStr.getBytes("KSC5601").length);
			System.out.println("aStr.getBytes(\"MS949\") = " + aStr.getBytes("MS949").length);
			System.out.println("aStr.getBytes(\"UTF-8\") = " + aStr.getBytes("UTF-8").length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
