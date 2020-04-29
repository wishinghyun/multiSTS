package exam.anno01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("myplayer")
public class Player implements AbstractPlayer {
	@Autowired //해당 타입의 빈이 생성된 것이 있다면 자동으로 매핑
	@Qualifier("dice2")
	AbstractDice d;
	int totalValue=0;
	
	public Player() {
		
	}
	public Player(AbstractDice d) {
		super();
		this.d = d;
		System.out.println("Player의 매개변수 1개 생성자");
	}
	public void play(){
		totalValue=0;
		for (int i = 0; i < 3; i++) {
			totalValue+=d.getDiceValue();
		}
	}
	public int getTotalValue(){
		return totalValue;
	}
}