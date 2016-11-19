
public class longBitsPrintOut {

	public static void main(String[] args) {
		long la = -8L;
		// long la = 0xFEDCBA0987654321L;
		// long la = 0x0000FFFFFFFFFFFFFL;
		System.out.println(bitsPrint.bitPrint(la));
		System.out.println(Long.toHexString(la));
		System.out.println(Long.toBinaryString(la));

	}

}
