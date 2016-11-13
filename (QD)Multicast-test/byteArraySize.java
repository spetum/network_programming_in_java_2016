public class byteArraySize {
	public static void main(String args[]) {
		String msg = "this is a Test" ;
		byte[] byteMsg = msg.getBytes();
		System.out.println("Size of byteMsg is " + byteMsg.length) ;
		System.out.println("Size of msg is " + msg.length()) ;
	}
}
