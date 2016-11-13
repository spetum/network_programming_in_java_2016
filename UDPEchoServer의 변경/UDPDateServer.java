import java.net.*;  // for DatagramSocket, DatagramPacket, and InetAddress
import java.io.*;   // for IOException
import java.util.*;

public class UDPDateServer {

  private static final int ECHOMAX = 255;  // Maximum size of echo datagram

  public static void main(String[] args) throws IOException {

    if (args.length != 1)  // Test for correct argument list
      throw new IllegalArgumentException("Parameter(s): <Port>");

    int servPort = Integer.parseInt(args[0]);

    DatagramSocket socket = new DatagramSocket(servPort);
    DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);

    for (;;) {  // Run forever, receiving and echoing datagrams
      socket.receive(packet);     // Receive packet from client
      System.out.println("Handling client at " +
        packet.getAddress().getHostAddress() + " on port " + packet.getPort());
      System.out.println("Packet Data size " + packet.getLength()
      	+ ": " + new String(packet.getData(),0,packet.getLength()) );
      // Add here
      String ResendStr = new String ( packet.getData(), 0, packet.getLength());
      ResendStr = "<<" + ResendStr + ">> "  + new String ((new Date().toString()));
      byte[] bytesToResend = ResendStr.getBytes();
      packet.setData(bytesToResend);
      packet.setLength(bytesToResend.length);
      
      socket.send(packet);       // Send the same packet back to client
      //packet.setLength(ECHOMAX); // Reset length to avoid shrinking buffer
    }
    /* NOT REACHED */
  }
}