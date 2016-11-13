import java.io.*;
import java.net.*;

public class TCPFileSender {
	static final long MAX_SIZE = 32768L ;
	public static void main(String[] args) throws IOException {
		File fsource = new File("8765.txt");
		FileInputStream fis = new FileInputStream(fsource) ;
		int readByte ;
		int fileSize  ;
		if ( MAX_SIZE >= fsource.length()) {
			fileSize = (int) fsource.length() ;
		} else {
			fileSize = (int)MAX_SIZE ;
		}
		Socket fileSenderSocket = new Socket ("127.0.0.1", 5354);
		OutputStream out = fileSenderSocket.getOutputStream();
		byte [] bytesRead = new byte[fileSize];
		int nCount = 0 ;
		while ( (readByte = fis.read(bytesRead)) != -1) {
			out.write(bytesRead);
			nCount++ ;
		}
		System.out.println("transfer counts : " + nCount);
		fileSenderSocket.close();
	}
}
