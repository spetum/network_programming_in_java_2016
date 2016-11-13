import java.io.*;

public class retFileSize {
	static final long MAX_SIZE = 32768L ;
	public static void main(String[] args) throws IOException{
		String pathStr = new String(System.getProperties().getProperty("java.io.tmpdir"));		
		String fileSep = new
		String(System.getProperties().getProperty("file.separator"));
		String fTargetName = new String(pathStr +fileSep + "4321.txt");
		
		File fsource = new File("8765.txt");
		File ftarget = new File(fTargetName);

		System.out.println("File size is " + fsource.length() );
		FileInputStream fis = new FileInputStream(fsource) ;
		FileOutputStream fos = new FileOutputStream(ftarget) ;
		
		int readByte ;
		int fileSize  ;
		if ( MAX_SIZE >= fsource.length()) {
			fileSize = (int) fsource.length() ;
		} else {
			fileSize = (int)MAX_SIZE ;
		}
		byte [] bytesRead = new byte[fileSize];
		int nCount = 0 ;
		while ( (readByte = fis.read(bytesRead)) != -1) {
			System.out.println("read " + readByte + "-byte (" + nCount +")" ) ;
			// fos.write(bytesRead);  // Error prone 
			fos.write(bytesRead, 0, readByte);
			fos.flush();
			nCount ++ ;
		}
		fis.close();
		fos.close();
	}

}
