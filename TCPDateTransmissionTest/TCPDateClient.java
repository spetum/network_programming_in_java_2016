import java.net.*;  // for Socket
import java.io.*;   // for IOException and Input/OutputStream

public class TCPDateClient implements MsgFrame {
	public static void main(String[] args) throws IOException {
		if ((args.length < 2) || (args.length > 3))  // Test for correct # of args
		      throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");
		      
		String server = args[0];       // Server name or IP address
		byte[] byteBuffer = args[1].getBytes();
		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

		// Create socket that is connected to server on specified port
		Socket socket = new Socket(server, servPort);
		System.out.println("Connected to server...sending echo string");
		
		OutputStream out = socket.getOutputStream();
		out.write(byteBuffer);  // Send the encoded string to the server
		out.write(END_OF_MSG);
		
		InputStream in = socket.getInputStream(); 

		// Receive the same string back from the server
		int totalBytesRcvd = 0;  // Total bytes received so far
		int recvByte;           // Bytes received in last read		
		try {
			// 메시지의 끝이 아니라 스트림의 끝을 체크하면 스트림을 닫는 작업을 하기 때문에
			// 무한 대기를 하게 된다.
			// while ((recvByte = in.read())!= -1 ) ; --> 이런 게 스트림의 끝을 찾는 것이 된다.
			// 따라서 해당 텍스트에서 사용하지 않는 문자를 끝문자로 사용해서 전송하는 메카니즘
			// 즉 송수신 프로토콜을 정의해야 한다.
			// 추가되는 자료 수신을 부분		
			if ((recvByte = in.read()) == -1 ) {
				throw new SocketException ("Socket Stream has closed prematurely.");
			}
			ByteArrayOutputStream RecvBuffer = new ByteArrayOutputStream ();
			// socket.setSoTimeout(2000);
			do {
				RecvBuffer.write(recvByte);
				totalBytesRcvd ++ ;
			} while ((recvByte = in.read())!= END_OF_MSG ) ;
			
			System.out.println("Received: (" + totalBytesRcvd + " bytes) " 
					+ new String(RecvBuffer.toByteArray(),0 , totalBytesRcvd));
		} catch (IOException e) {
			
		}
		socket.close();  // Close the socket and its streams
	}
}
