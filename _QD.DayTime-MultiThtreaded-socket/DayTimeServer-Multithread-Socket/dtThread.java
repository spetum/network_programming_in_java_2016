import java.net.* ;
import java.io.*;
import java.util.* ;

public class dtThread extends Thread {
	Socket con = null ;
	public void setSocket(Socket con) {
		this.con = con ;
	}
	public void run() {
		try {
			PrintWriter out = new PrintWriter(con.getOutputStream(), true);
			Date now = new Date() ;
			// out.println(now.toString());			
			// System.out.println("Call at " + con.getInetAddress().getHostAddress() 
			//		+ " Port : " + con.getPort() + "\nMessage :" + now.toString()
			//		+ "(in Thread Name "+ Thread.currentThread().getName() +")");
			// 간혹 Thread.currentThread().getName()에서 Thread를 제외해도 되는 경우가 있다.
			// 이미 Thread class를 부모로 갖고 있는 경우에는 가능한 경우도 있다.
			String msgOut = new String();
			msgOut = msgOut + "Call at " + con.getInetAddress().getHostAddress() 
					+ " 포트Port : " + con.getPort() + "\nMessage (\"" + now.toString()
					+ "\" in Thread Name "+ Thread.currentThread().getName() +")" ;
			out.println(msgOut);			
			con.close();
		} catch (IOException ie) {
		} // end of try..catch for IOException
	}
}
