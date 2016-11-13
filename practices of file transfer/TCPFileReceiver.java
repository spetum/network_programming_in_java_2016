import java.io.*;
import java.net.*;
public class TCPFileReceiver {
	static final long MAX_SIZE = 32768L ;
	public static void main(String[] args) throws IOException {
		String pathStr = new String(System.getProperties().getProperty("java.io.tmpdir"));		
		String fileSep = new String(System.getProperties().getProperty("file.separator"));
		String fTargetName = new String(pathStr +fileSep + "43210.txt");
		File ftarget = new File(fTargetName);
		
		ServerSocket fileReceiverSocket = new ServerSocket (5354);
		byte [] bytesRead = new byte[(int)MAX_SIZE];
		int nCount = 0 ;	
		int readByte ;
		
		for(;;) {
			Socket fileWriteSocket = fileReceiverSocket.accept();
			FileOutputStream fos = new FileOutputStream(ftarget) ;
			InputStream in_file = fileWriteSocket.getInputStream();
			while ((readByte=in_file.read(bytesRead))!=-1) {
				fos.write(bytesRead, 0, readByte);
			} // end of while
			fos.flush();
			fos.close();
			fileWriteSocket.close();
		} // end of for(;;)

	}
}
