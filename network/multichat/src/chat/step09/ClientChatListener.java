package chat.step09;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ClientChatListener implements ActionListener{
	ClientChatView view;

	public ClientChatListener(ClientChatView view) {
		super();
		this.view = view;
	}

	//버튼을 누를때, 텍스트상자에서 엔터키를 입력할때 actionPerformed가 호출된다
	@Override
	public void actionPerformed(ActionEvent e) {
		//ActionEvent를 발생시킨 객체가 텍스트필드 이거나 버튼이면 실행하라는 의미 (if문 조건)
		if (e.getSource()==view.txtinput | e.getSource()==view.btnsend) {
			//1.
			view.sendMsg("chatting/"+view.txtinput.getText().trim()+"/"+view.nickname);
			//====
			view.txtinput.setText("");
		}
	}
	
	
}
