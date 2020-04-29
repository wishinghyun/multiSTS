package network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyNetClient01 { //클라이언트 페이지
	public static void main(String[] args) {
		//서버와 통신할 수 있는 소켓객체를 생성 - new Socket(host, port) host는 서버의 ip
		Socket socket;
		try {
			socket = new Socket("70.12.115.57", 12345);
			System.out.println("서버접속완료..."+socket);
		} catch (UnknownHostException e) {
			//ip를 잘못 입력했을때 발생 - IOException하위임
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
