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
			// ��Ȥ Thread.currentThread().getName()���� Thread�� �����ص� �Ǵ� ��찡 �ִ�.
			// �̹� Thread class�� �θ�� ���� �ִ� ��쿡�� ������ ��쵵 �ִ�.
			String msgOut = new String();
			msgOut = msgOut + "Call at " + con.getInetAddress().getHostAddress() 
					+ " ��ƮPort : " + con.getPort() + "\nMessage (\"" + now.toString()
					+ "\" in Thread Name "+ Thread.currentThread().getName() +")" ;
			out.println(msgOut);			
			con.close();
		} catch (IOException ie) {
		} // end of try..catch for IOException
	}
}
