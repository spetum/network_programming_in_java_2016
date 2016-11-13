import java.net.*;  // for DatagramSocket, DatagramPacket, and InetAddress
import java.io.*;   // for IOException

public class UDPDateClientTimeout {

  private static final int TIMEOUT = 1500;   // Resend timeout (milliseconds)
  private static final int MAXTRIES = 2;     // Maximum retransmissions
  private static final int ECHOMAX = 255;  // Maximum size of echo datagram

  public static void main(String[] args) throws IOException {

    if ((args.length < 2) || (args.length > 3))  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

    InetAddress serverAddress = InetAddress.getByName(args[0]);  // Server address
    // Convert input String to bytes using the default character encoding
    byte[] bytesToSend = args[1].getBytes();

    int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

    DatagramSocket socket = new DatagramSocket();

    socket.setSoTimeout(TIMEOUT);  // Maximum receive blocking time (milliseconds)

    DatagramPacket sendPacket = new DatagramPacket(bytesToSend,  // Sending packet
        bytesToSend.length, serverAddress, servPort);

/*    DatagramPacket receivePacket =                              // Receiving packet
        new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);
*/
    DatagramPacket receivePacket =                              // Receiving packet
            new DatagramPacket(new byte[ECHOMAX], ECHOMAX);
    
    int tries = 0;      // Packets may be lost, so we have to keep trying
    boolean receivedResponse = false;
    do {
      socket.send(sendPacket);          // Send the echo string
      try {
        socket.receive(receivePacket);  // Attempt echo reply reception

        if (!receivePacket.getAddress().equals(serverAddress))  // Check source
        	throw new IOException("Received packet from an unknown source");

        receivedResponse = true;
      } catch (InterruptedIOException e) {  // We did not get anything
        tries += 1;
        System.out.println("Timed out, " + (MAXTRIES-tries) + " more tries...");
      }
    } while ((!receivedResponse) && (tries < MAXTRIES));

    if (receivedResponse) {
    	String a =  new String(receivePacket.getData(),0, receivePacket.getLength()) ;
    	System.out.print("Received(" + receivePacket.getLength()+"): " + a + "\nSize of receivePacket : " + a.length()) ;
      System.out.println(", Data is "  + new String(receivePacket.getData() ) ) ;
    }
    else
      System.out.println("No response -- giving up.");

    socket.close();
  }
}