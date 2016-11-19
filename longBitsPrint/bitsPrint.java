
public class bitsPrint {
	private static final int longSize = Long.SIZE ;
	private static final int intSize = Integer.SIZE ;
	private static final int byteSize = Byte.SIZE ;	
	
	public static String bitPrint(long value){		
		long mask = 1L << longSize -1 ; // rather than 1 without L
		StringBuffer strBuf = new StringBuffer(longSize+12);
		
		for (int k=1; k <= longSize; k++) {
			if ((value & mask) == 0)
				strBuf.append("0");
			else 
				strBuf.append("1");
			
			value <<= 1 ;
			
			if ((k%4)==0) 
				if ((k % 8)== 0 && (k!=longSize))
					strBuf.append(" / ");
				else
					strBuf.append(" ");
		}
		return strBuf.toString() ;
	}
	public static String bitPrint(int value){		
		int mask = 1 << intSize -1 ;
		StringBuffer strBuf = new StringBuffer(intSize+12);
		
		for (int k=1; k <= intSize; k++) {
			if ((value & mask) == 0)
				strBuf.append("0");
			else 
				strBuf.append("1");
			value <<= 1 ;
			if ((k%4)==0)
				if ((k % 8)== 0 && (k!=intSize))
					strBuf.append(" / ");
				else
					strBuf.append(" ");
		}
		return strBuf.toString() ;
	}
	
	public static String bitPrint(byte value){
		int mask = 1 << byteSize -1 ;
		StringBuffer strBuf = new StringBuffer(byteSize+12);
		
		for (int k=1; k <= byteSize; k++) {
			if ((value & mask) == 0)
				strBuf.append("0");
			else 
				strBuf.append("1");
			value <<= 1 ;
			if ((k % 4)==0)
				if ((k % 8)== 0 && (k!=byteSize))
					strBuf.append(" / ");
				else
					strBuf.append(" ");
		}
		return strBuf.toString() ;
	}

	public static void printOut(int value) {
		int mask = 1 << intSize -1 ;
		for (int i = 1 ; i <= intSize; i++) {
			if ((value & mask) == 0)
				System.out.print("0");
			else
				System.out.print("1");
			value <<= 1 ;
			if ((i % 8)== 0 && (i!=intSize))
				System.out.print(" / ");			
		} //end of for
		System.out.println("\n");
	}//end of printOut()
}
