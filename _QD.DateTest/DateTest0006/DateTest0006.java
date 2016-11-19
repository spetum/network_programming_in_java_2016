import java.io.UnsupportedEncodingException;
// import java.io.*;
//import static java.lang.System.out.* ;

public class DateTest0006 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String aKorean = new String ("한글 입력입니다.") ;
		byte[] aKorBuf = aKorean.getBytes("KSC5601");
		
		for (int i=0; i < aKorBuf.length; i++) {
			// System.out.print((long)aKorBuf[i] + " ");
			System.out.print("("+ Byte.toUnsignedInt(aKorBuf[i]) +")");
		}
	}

}
