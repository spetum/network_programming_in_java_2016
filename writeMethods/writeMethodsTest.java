import java.io.* ;

public class writeMethodsTest {
	private static final int charSize = Character.SIZE ;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//char s = '가';
		String str = new String("가나다라") ;
//		String str = new String("가") ;
		ByteArrayOutputStream ByteArrayOut = new ByteArrayOutputStream();
		DataOutputStream buf = new DataOutputStream(ByteArrayOut);
		
//		buf.writeChar(s);
		buf.writeChars(str);
		buf.flush();
		byte[] array_a = ByteArrayOut.toByteArray() ;
		
		for (int i=0; i < str.length(); i++) {
			System.out.println(bitsPrint.bitPrint(str.charAt(i)));
//			System.out.print(bitsPrint.bitPrint(str.charAt(i))+" / ");
		}
		System.out.print("\n");
		
		System.out.println("after writeChars()");

		for (int i = 0; i < array_a.length; i++){
			if ((i+1) % 2 == 0)
				System.out.println(bitsPrint.bitPrint(array_a[i]));
			else 
				System.out.print(bitsPrint.bitPrint(array_a[i])+" / ");
		}
		System.out.print("\n");
		
		System.out.println("after getBytes()");
//		byte[] array_b = str.getBytes("KSC_5601");
		byte[] array_b = str.getBytes("EUC-KR");
//		byte[] array_b = str.getBytes("ISO-2022-KR");
		for (int i = 0; i < array_b.length; i++){
			if ((i+1) % 2 == 0)
				System.out.println(bitsPrint.bitPrint(array_b[i]));
			else 
				System.out.print(bitsPrint.bitPrint(array_b[i])+" / ");
		}
		 
		System.out.print("\n");
		System.out.println(new String(array_b, "KSC_5601"));
		System.out.println(new String(array_b, "EUC-KR"));
		System.out.println(new String(array_b, "ISO-2022-KR"));

		System.out.println("after writeUTF()");
		
		ByteArrayOutputStream ByteArrayOut2 = new ByteArrayOutputStream();
		DataOutputStream buf2 = new DataOutputStream(ByteArrayOut2);
		
		buf2.writeUTF(str);
		buf2.flush();
		
//		byte[] array_c = new byte[charSize*str.length()];
		byte[] array_c =  ByteArrayOut2.toByteArray() ;
			
		for (int i = 0; i < array_c.length; i++){
			if ((i+1)%2==0)
				System.out.println(bitsPrint.bitPrint(array_c[i]));
			else
				System.out.print(bitsPrint.bitPrint(array_c[i])+" / ");
		}
		System.out.print("\n");
		char ss1 = '\uac00' ; // 1010 1100  / 0000 0000
		char ss2 = '\uB098' ; // 1011 0000  / 1001 1000
		char ss3 = '\uB2E4' ; // 1011 0010  / 1110 0100
		char ss4 = '\uB77C' ; // 1011 0111  / 0111 1100
		System.out.print(ss1);
		System.out.print(ss2);
		System.out.print(ss3);
		System.out.println(ss4);
	}

}
