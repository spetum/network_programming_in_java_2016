/*
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
*/
import java.net.*;
import java.util.*;

import static java.lang.System.out;

public class MACAddr_Display {

    public static void main(String args[]) throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);
    }

    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        out.printf("Display name: %s\n", netint.getDisplayName());
        out.printf("Name: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            out.printf("InetAddress: %s\n", inetAddress);
        }
        // Arrays.copyOf(original, newLength)로 처리해보자.
        byte[] MAC_Addr = netint.getHardwareAddress();
        String MAC_Addr_Str = Arrays.toString(MAC_Addr);
        try{        	
            int i;
            if (MAC_Addr != null) {
            	int[] HW_Address = new int[MAC_Addr.length];        
            	for (i=0; i < MAC_Addr.length;i++)
            		HW_Address[i]= Byte.toUnsignedInt(MAC_Addr[i]);            	
            	
            	out.printf("Hardware address: ");
            	for (i=0; i < MAC_Addr.length-1;i++)
            		out.print(Integer.toHexString(HW_Address[i])+":");
            	out.println(Integer.toHexString(HW_Address[i]));
            } else
            	out.printf("Hardware address: %s\n", MAC_Addr_Str);
            	// end of if
        } catch (ArrayIndexOutOfBoundsException e) {
          
        }
/*        
        out.printf("Up? %s\n", netint.isUp());
        out.printf("Loopback? %s\n", netint.isLoopback());
        out.printf("PointToPoint? %s\n", netint.isPointToPoint());
        out.printf("Supports multicast? %s\n", netint.supportsMulticast());
        out.printf("Virtual? %s\n", netint.isVirtual());
        out.printf("Hardware address: %s\n",
                    Arrays.toString(netint.getHardwareAddress()));
        out.printf("MTU: %s\n", netint.getMTU());
*/
        out.printf("\n");
    }
}
