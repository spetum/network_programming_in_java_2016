import java.io.* ;

public class floatBitPrint {
	private static final int floatSize = Float.SIZE ; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		float a=-1.0f / 16.0f ;
		// float a=1.0f ;
		int a_bit=0;
		ByteArrayOutputStream ByteArrayOut = new ByteArrayOutputStream();
		DataOutputStream buf = new DataOutputStream(ByteArrayOut);
		
		buf.writeFloat(a);
		buf.flush();
		byte[] array_a = new byte[floatSize];
		array_a = ByteArrayOut.toByteArray() ;
		for (int i = 0; i < array_a.length; i++){
//			System.out.println(i + " " + (int)array_a[i] );
			System.out.print(bitsPrint.bitPrint(array_a[i])+" / ");
		}
		System.out.print("\n");
		
		a_bit = Float.floatToIntBits(a);
		System.out.println(Float.floatToIntBits(a));
		System.out.println(bitsPrint.bitPrint(a_bit));
		
		System.out.println(Integer.toBinaryString(Float.floatToIntBits(a)));
	}
}

