import java.net.*;  // for Socket
import java.io.*;   // for IOException and Input/OutputStream

public class TCPSenderClient {

  public static void main(String[] args) throws IOException {

    if ((args.length < 2) || (args.length > 3))  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

    String server = args[0];       // Server name or IP address
    // // Convert input String to bytes using the default character encoding
    // String.getBytes(): Encodes this String into a sequence of bytes using the platform's default charset, 
    // storing the result into a new byte array
    // 네트워크로 전송할 때는 전달하거나 전달받는 시스템의 character set을 맞춰야 하는데 이 때 시스템 디폴트 캐릭터 셋으로
    // 만들어서 주고 받으면 된다. 사실 Java는 Unicode를 기반으로 하기 때문에 이런 문제에서는 자유롭지만
    // 구형 Web-server나 DBMS에 설정된 Character Set가 서로 다른 경우에는 
    // String src2Dest=new String(str.getBytes("8859_1"),"KSC5601"); 
    // (한글 데이터를 데이터 베이스로부터 가져올 때)
    // 혹은 역으로 String DestFromSrc = new String(str.getBytes("KSC5601"),"8859_1"); 
    // ( 한글 데이터를 데이터 베이스에 저장할 때 )
    // 이런 식으로 하면 된다.
    // 단 Java끼리나 기본적으로 Unicode를 기반으로 하는 C#에서는 이런 작업을 하지말고
    // byte[] byteArray = str.getBytes() ;로만 해서 보내면 된다.
    byte[] byteBuffer = args[1].getBytes();

    int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

    // Create socket that is connected to server on specified port
    Socket socket = new Socket(server, servPort);
    System.out.println("Connected to server...sending echo string");

    //InputStream in = socket.getInputStream();
    OutputStream out = socket.getOutputStream();

    out.write(byteBuffer);  // Send the encoded string to the server

    socket.close();  // Close the socket and its streams
  }
}
