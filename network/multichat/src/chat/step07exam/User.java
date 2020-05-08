package chat.step07exam;
//	 클라이언트의 정보 클라이언트의 처리를 표현한 User클래스를 작성
//	 클라이언트와 서버가 통신할 수 있는 객체
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class User extends Thread{
	//ChatServerView에서 넘겨받을 데이터
	Socket client;
	ChatServerView serverView;
	
	InputStream is;
	InputStreamReader ir;
	BufferedReader br;
	OutputStream os;
	PrintWriter pw;

	String nickname;
	
	Vector<User> userlist;
	public User() {
		
	}
	//서버가 접속한 클라이언트의 정보를 User객체로 만들때 접속한 User의 소켓객체와 서버뷰, userlist를 전달
	public User(Socket client, ChatServerView serverView, Vector<User> userlist) {
		super();
		this.client = client;
		this.serverView = serverView;
		this.userlist = userlist;
		ioWork();
	}
	
	//ChatServerView에서 가져옴!!
	//접속한 클라이언트와 서버가 통신할 수 있도록 스트림객체 생성
	public void ioWork() { //처음 접속했을 때 한 번 실행되는 메소드
		try {
			is = client.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			
			os = client.getOutputStream();
			pw = new PrintWriter(os,true); //auto flush = true로 설정
			
			//클라이언트와 통신할 수 있는 스트림을 생성하고 클라이언트가 입장하면 
			//클라이언트가 전송하는 nickname을 읽어서 서버창에 출력하기 
			nickname = br.readLine();
			System.out.println("nickname : "+nickname);
			serverView.taclientlist.append("*"+nickname+"님이 입장*\n");
			
			//2. 기존 클라이언트에게 새로운 접속자가 있음을 알려주는 부분 (1번 호출)
			broadCast("new/"+nickname);
			//====================================================
			//3. 새로운 접속자에게 기존 클라이언트의 정보를 알려주기
			int size = userlist.size(); //기존 접속자 인원수
			for (int i = 0; i < size; i++) {
				User user = userlist.get(i);
				sendMsg("old/"+user.nickname); //그냥 sendMsg하면 새접속자에게 user.nickname(기존)을 줌
			}
			//========================================
			userlist.add(this);//5번의 userlist로 넘어감
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//1. 기존 사용자에게 메시지를 보내는 메소드를 정의
	public void broadCast(String msg) {
		int size = userlist.size(); //기존 접속자 인원수
		for (int i = 0; i < size; i++) {
			User user = userlist.get(i);
			//이미 접속한 사용자들에게 새로 접속한 사용자의 nickname을 전송
			user.sendMsg(msg); //user.sendMsg()하면 기존 접속자에게 새접속자의 정보 줌
		}
	}
	//===================================
	public void sendMsg(String message) {
		pw.println(message);
	}
	
	//쓰레드로 처리할 작업 - 접속한 클라이언트가 전송하는 메시지를 계속 받아서 서버창에 출력
	//try catch를 while 밖에 처리하면 while이 끝나버림,
	//           while 안에 처리하면 while 계속 돌아감
	public void run() {
		while(true) {
			try {
				String msg = br.readLine();
				serverView.taclientlist.append(nickname+"이 전송한 메시지 : "+msg+"\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
