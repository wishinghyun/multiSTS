package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//바이너리데이터를 읽고 쓰지 않는 경우 - 문자열인 경우
public class MyNetServer04 {
	public static void main(String[] args) {
		Socket client = null;
		//쌓아놨다가 한번에 처리
		BufferedReader in = null; //input
		PrintWriter out = null; //output
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버접속완료........");
			while(true) {
				client = server.accept();
				InetAddress clientInfo = client.getInetAddress();
				System.out.println("접속한 클라이언트 : "+
									clientInfo.getHostAddress());
				in = new BufferedReader(
						new InputStreamReader(
								client.getInputStream()));
				//생성할때 autoflush옵션을 설정하면 flush 자동으로 됨
				out = new PrintWriter(client.getOutputStream(),true);
				
				//*****통신시작*****
				//1. 서버 -> 클라이언트
				//print하면 안됨 println해야 됨!!!!!!!!!!!
				out.println("클라이언트님 접속 성공");
				//출력하기 위한 데이터를 출력버퍼에 임시로 쌓았다가 스트림으로 출력되기 위해서
				//버퍼에 쌓여있는 데이터를 내보내는 작업 - flush()
				//flush는 버퍼를 비우는 명령어 - autoflush하면 필요없음
				//out.flush();
				
				//2. 서버 <- 클라이언트
				String msg = in.readLine();
				System.out.println("클라이언트가 전송한 메시지 : "+msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
