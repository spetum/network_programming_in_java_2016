import java.net.*;
import java.io.*;

public class DayTimeServerThread {
	private static final int dayTimePort = 5145;
	public static void main(String[] args) throws IOException {		
		ServerSocket dtServer = new ServerSocket (dayTimePort) ;
		System.out.println("Server Start:" );
		while (true) {
			Socket con = dtServer.accept();
			dtThread dtThread_1 = new dtThread() ;
			dtThread_1.setSocket(con) ;
			dtThread_1.start() ;
			//con.close();
			// ���⼭ ������ ������ ���� ������� ������ �ȴ�.
			// ���״� �ƴѵ��� ����� �ܼ��̳� ��Ÿ ��� �Ұ����� ��찡 �ִ�.
			// ���� ������ �󿡼� ó���� �ϴ� ���� ����.
		} // end of while
	}
}