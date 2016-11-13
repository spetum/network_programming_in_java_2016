import java.net.*;  // for Socket, ServerSocket, and InetAddress
import java.io.*;   // for IOException and Input/OutputStream
import java.util.*;

public class TCPDateServer implements MsgFrame {
	
	private static final int BUFSIZE = 32;   // Size of receive buffer
	
	public static void main(String[] args) throws IOException {
		if (args.length != 1)  // Test for correct # of args
			throw new IllegalArgumentException("Parameter(s): <Port>");
			
		int servPort = Integer.parseInt(args[0]);
		
		// Create a server socket to accept client connection requests
		ServerSocket servSock = new ServerSocket(servPort);

//		int recvMsgSize;   // Size of received message
		//byte[] byteBuffer = new byte[BUFSIZE];  // Receive buffer
		int recvByte ;
		int totalBytesRcvd = 0;
		for (;;) { // Run forever, accepting and servicing connections
			Socket clntSock = servSock.accept();     // Get client connection
			totalBytesRcvd = 0;
			System.out.println("Handling client at " + 
					clntSock.getInetAddress().getHostAddress() + 
				" on port " +
					clntSock.getPort());
					
			InputStream in = clntSock.getInputStream();
			
			OutputStream out = clntSock.getOutputStream();

			// Receive until client closes connection, indicated by -1 return
//			while ((recvMsgSize = in.read(byteBuffer)) != -1) {
//				for (int k=0; k<recvMsgSize;k++)
//					System.out.print( (char)byteBuffer[k]);
//				System.out.print("\n");
				// 메시지의 끝이 아니라 스트림의 끝을 체크하면 스트림을 닫는 작업을 하기 때문에
				// 무한 대기를 하게 된다.
				// 따라서 해당 텍스트에서 사용하지 않는 문자를 끝문자로 사용해서 전송하는 메카니즘
				// 즉 송수신 프로토콜을 정의해야 한다.
				//수신 메시지에 날짜 추가해서 보내기. 
			if ((recvByte=in.read()) == -1) {
				throw new SocketException ("Socket has closed prematurely.");
			}
			ByteArrayOutputStream RecvBuffer = new ByteArrayOutputStream ();
			
			do {
				RecvBuffer.write(recvByte);
				totalBytesRcvd ++ ;
			} while ((recvByte=in.read()) != END_OF_MSG) ;
			
			System.out.println("Received: (" + totalBytesRcvd + " bytes) " 
					+ new String(RecvBuffer.toByteArray(),0 , totalBytesRcvd));
			String date_temp = new String( (new Date()).toString());
			String recv_msg = new String (RecvBuffer.toByteArray(),0, totalBytesRcvd);
			recv_msg += " " + date_temp ;
			byte[] temp_byte_buffer = recv_msg.getBytes() ;
			out.write(temp_byte_buffer);
			out.write(END_OF_MSG);
			out.flush();
			System.out.println("Generated message (" + recv_msg.length() + " bytes)" + recv_msg);
			
			clntSock.close();  // Close the socket.  We are done with this client!
		} // end of for (;;)
		/* NOT REACHED */
	} // end of main
} // end of class
