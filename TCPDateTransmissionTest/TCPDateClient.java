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
			// �޽����� ���� �ƴ϶� ��Ʈ���� ���� üũ�ϸ� ��Ʈ���� �ݴ� �۾��� �ϱ� ������
			// ���� ��⸦ �ϰ� �ȴ�.
			// while ((recvByte = in.read())!= -1 ) ; --> �̷� �� ��Ʈ���� ���� ã�� ���� �ȴ�.
			// ���� �ش� �ؽ�Ʈ���� ������� �ʴ� ���ڸ� �����ڷ� ����ؼ� �����ϴ� ��ī����
			// �� �ۼ��� ���������� �����ؾ� �Ѵ�.
			// �߰��Ǵ� �ڷ� ������ �κ�		
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
