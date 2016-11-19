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
			// 여기서 소켓을 닫으면 병행 제어상의 오류가 된다.
			// 버그는 아닌데도 제대로 콘솔이나 기타 제어가 불가능한 경우가 있다.
			// 따라서 쓰레드 상에서 처리를 하는 것이 좋다.
		} // end of while
	}
}