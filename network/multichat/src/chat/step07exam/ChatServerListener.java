package chat.step07exam;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ChatServerListener implements ActionListener{
	ChatServerView view;

	public ChatServerListener(ChatServerView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==view.btnstartServer){ //서버 시작버튼을 누르면 
			String port = JOptionPane.showInputDialog(view, 
					"port를 입력하세요",JOptionPane.INFORMATION_MESSAGE);
			view.serverStart(Integer.parseInt(port)); //서버 스타트 호출함
		}else if(e.getSource()==view.btnstop){
			System.out.println("서버중지");
		}
	}
	
	
}
