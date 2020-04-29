package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyNetClient03 { //클라이언트 페이지
	public static void main(String[] args) {
		Socket socket= null;
		InputStream is = null; //클라이언트와 input할 수 있는 스트림
		DataInputStream dis = null; //최종적으로 클라이언트와 DataInputStream을 이용해서 
									//클라이언트로 부터 전송되는 데이터를 읽기
		OutputStream os = null; //클라이언트와 output할 수 있는 스트림
		DataOutputStream dos = null;
		try {
			socket = new Socket("70.12.115.57", 12345);
			System.out.println("서버접속완료..."+socket);
			
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			//---여기까지가 기본 셋팅---
			
			//1. 클라이언트 <- 서버 
			String data = dis.readUTF();
			System.out.println("서버가 전송하는 메시지 : "+data);
			int intdata = dis.readInt();
			for (int i = 1; i <= 9; i++) {
				System.out.println(intdata+" * "+i+" = "+(intdata*i));
			}
			
			//2. 클라이언트 -> 서버
			if (intdata%2==1) {
				dos.writeUTF("홀수");
			}else {
				dos.writeUTF("짝수");
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
