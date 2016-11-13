import java.net.*;  // for Socket
import java.io.*;   // for IOException and Input/OutputStream
// Original Prototype of TCPEchoClient
public class TCPSender {

  public static void main(String[] args) throws IOException {

    if ((args.length < 2) || (args.length > 3))  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

    String server = args[0];       // Server name or IP address
    // Convert input String to bytes using the default character encoding
    // String.getBytes(): Encodes this String into a sequence of bytes using
    // the platform's default charset, storing the result into 
    // a new byte array
    
    byte[] byteBuffer = args[1].getBytes();

    int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

    // Create socket that is connected to server on specified port
    Socket socket = new Socket(server, servPort);
    System.out.println("Connected to server...sending echo string");

    OutputStream out = socket.getOutputStream();

    out.write(byteBuffer);  // Send the encoded string to the server

    socket.close();  // Close the socket and its streams
  }
}
