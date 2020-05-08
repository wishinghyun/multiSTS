package chat.step09;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ChatLoginListener  implements ActionListener{ //onClickLister와 같음
	ChatLogin view; //이벤트를 발생시키는 화면 - ChatLogin
	String nickname;
	public ChatLoginListener(ChatLogin view) {
		super();
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) { //onCreate와 같음
		
		if(e.getSource()==view.btnConnect){ //e.getSource() = v.getId()
			nickname = view.txtId.getText().trim();
			if(nickname.isEmpty()) {
				JOptionPane.showMessageDialog(view,
						"대화명을 입력하세요", "대화명오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String ip = view.cboServer.getSelectedItem()+"";
			int port = Integer.parseInt(view.cboPort.getSelectedItem()+"");
			System.out.println(ip+port);
			
			ClientChatView client = new ClientChatView(ip,port,nickname); //같은 패키지의 ClientChatView!!
			view.dispose(); //로그인 창을 닫는다
		}
	}
}