package chat.step02;
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
	//swing에서 버튼이 클릭될때 호출되는 메소드
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
		}
	}
}