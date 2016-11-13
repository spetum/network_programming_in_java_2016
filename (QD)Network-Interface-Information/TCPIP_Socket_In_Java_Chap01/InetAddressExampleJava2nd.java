import java.util.Enumeration;
import java.net.*;

public class InetAddressExampleJava2nd {
	public static void main(String[] args) {
		// Get the network interfaces and associated addresses for this host
		try {
			Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
			if (interfaceList == null) {
				System.out.println("--No interfaces found--");
			} else {
				while (interfaceList.hasMoreElements()) {
					NetworkInterface iface = interfaceList.nextElement();
					// 추가한 부분 : 시작
					byte [] MACAddress = iface.getHardwareAddress() ;
					System.out.print ("MAC Address : >" );
					if (MACAddress != null){
						int mac_i ;
						for (mac_i =0; mac_i < MACAddress.length-1; mac_i ++)
							System.out.print ( "(" + MACAddress[mac_i] + ")-");
						System.out.println ("(" + MACAddress[mac_i]+")<");
					}
					else 
						System.out.println("null<");
					// 추가한 부분 : 끝
					System.out.println("Interface " + iface.getName() + ":");
					Enumeration<InetAddress> addrList = iface.getInetAddresses();
					if (!addrList.hasMoreElements()) {
						System.out.println("\t(No addresses for this interface)");
					} // end of if
					
					while (addrList.hasMoreElements()) {
						InetAddress address = addrList.nextElement();
						System.out.print("\tAddress " 
								+ ((address instanceof Inet4Address ? "(v4)"
								: (address instanceof Inet6Address ? "(v6)" : "(?)"))));
						System.out.println(": " + address.getHostAddress());
					} // end of while for addrList.hasMoreElements()
				} //end of while for interfaceList.hasMoreElements()
			} // end of if .. else
		} catch (SocketException se) {
			System.out.println("Error getting network interfaces:" + se.getMessage());
		} // end of try..catch for SocketException

		// Get name(s)/address(es) of hosts given on command line
		for (String host : args) {
			try {
				System.out.println(host + ":");
				InetAddress[] addressList = InetAddress.getAllByName(host);
				for (InetAddress address : addressList) {
					System.out.println("\t" + address.getHostName() + "/" + address.getHostAddress());
				}
			} catch (UnknownHostException e) {
				System.out.println("\tUnable to find address for " + host);
			} // end of try..catch
		} // end of for String host: args
	} // end of main
 } // end of class