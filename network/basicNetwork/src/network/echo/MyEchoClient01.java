package network.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//지속적으로 서버와 통신하는 채팅
public class MyEchoClient01 {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		BufferedReader keyin = null; //키보드로 입력받을 BufferedReader  
		try {
			socket = new Socket("70.12.115.57", 12345);
			System.out.println("서버접속완료..."+socket);
			in = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			
			//키보드로 입력한 데이터를 읽기 위한 스트림생성
			keyin = new BufferedReader(
					new InputStreamReader(System.in));//키보드 입력 System.in
			
			//*****통신시작*****
			//키보드로 입력한 데이터를 서버로 지속적으로 전송
			//서버가 다시 보내오는 데이터를 콘솔에 출력
			String sendMsg = ""; //서버로 보낼 메시지
			String resMsg = "";  //서버에서 받는 메시지
			//보내고 받고 반복해야되니까 while문
			while((sendMsg=keyin.readLine())!=null) {//보낼 메시지가 있으면
				//1. 클라이언트 -> 서버(키보드로 입력하는 데이터를 서버로 전송)
				out.println(sendMsg);
				//2. 클라이언트 <- 서버
				resMsg = in.readLine();
				System.out.println("서버가 보내는 메시지 >> "+resMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
