import java.net.*;  // for Socket, ServerSocket, and InetAddress
import java.io.*;   // for IOException and Input/OutputStream

public class TCPEchoServer {
	
	private static final int BUFSIZE = 32;   // Size of receive buffer
	
	public static void main(String[] args) throws IOException {
		if (args.length != 1)  // Test for correct # of args
			throw new IllegalArgumentException("Parameter(s): <Port>");
			
		int servPort = Integer.parseInt(args[0]);
		
		// Create a server socket to accept client connection requests
		ServerSocket servSock = new ServerSocket(servPort);

		int recvMsgSize;   // Size of received message
		byte[] byteBuffer = new byte[BUFSIZE];  // Receive buffer
		
		for (;;) { // Run forever, accepting and servicing connections
			Socket clntSock = servSock.accept();     // Get client connection
			System.out.println("Handling client at " + 
					clntSock.getInetAddress().getHostAddress() + 
				" on port " +
					clntSock.getPort());
					
			InputStream in = clntSock.getInputStream();
			
			// TCPReceiverServer.java에서 추가되는 부분
			OutputStream out = clntSock.getOutputStream();

			// Receive until client closes connection, indicated by -1 return
			while ((recvMsgSize = in.read(byteBuffer)) != -1) {
				// System.out.print("+"+ new String(byteBuffer));
				// System.out.print("+");
				
				for (int k=0; k<recvMsgSize;k++)
					System.out.print( (char)byteBuffer[k]);
				System.out.print("\n");

				// TCPReceiverServer.java에서 추가되는 부분
				out.write(byteBuffer, 0, recvMsgSize);
			}
			clntSock.close();  // Close the socket.  We are done with this client!
		} // end of for (;;)
		/* NOT REACHED */
	} // end of main
} // end of class
