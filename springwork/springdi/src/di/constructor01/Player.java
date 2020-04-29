package di.constructor01;

//player가 갖고 있는 Dice를 외부(스프링 컨테이너)에서 Injection받아 사용해야 하므로
//Injection 받을 수 있도록 미리 준비해야 한다
//==> Constructor or Setter메소드
public class Player implements AbstractPlayer {
	AbstractDice d;
	int totalValue=0;
	
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