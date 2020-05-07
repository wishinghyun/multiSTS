package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public Client(String ip, int port) {
		try {
			//������ ��û������
			socket = new Socket(ip, port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			//�޽��� ������
			out.println("�����϶�~~~");
			out.flush();
			
			System.out.println(in.readLine());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				 //�������� �ݴ� Ŭ���̾�Ʈ���� �ݴ� �� �ʿ��� ������ ��� ����
				if(socket!=null)socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new Client("192.168.25.33", 12345);
	}

}
