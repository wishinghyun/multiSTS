package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private Socket socket;
	ServerSocket serverSocket;
	private BufferedReader in;
	private PrintWriter out;
	public Server() {
		try {
			serverSocket = new ServerSocket(12345);
			System.out.println("�����غ��...");
			//�����尡 �����ִٰ� ���� ��û�� ������ ����
			socket = serverSocket.accept();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			//Ŭ���̾�Ʈ���� ���� ���ڿ� ����
			System.out.println(in.readLine());
			
			//Ŭ���̾�Ʈ ���ڿ� ������ - print�ߴٰ� ����� �Ǵ°� �ƴ϶� ��� �װ� �ִ� ���� flush����� ������.
			out.println("���ۿϷ�");
			out.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/*try {
				if(socket!=null)socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		}
	}
	public static void main(String[] args) {
		Server server = new Server();
	}
}
