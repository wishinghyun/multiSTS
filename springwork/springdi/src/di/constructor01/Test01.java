package di.constructor01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test01 {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("config/bean.xml");
		AbstractPlayer player = factory.getBean("myplayer",AbstractPlayer.class);
		player.play();
		System.out.println("세번 굴린 주사위의 합:"+player.getTotalValue());
		factory.close();
	}

}
