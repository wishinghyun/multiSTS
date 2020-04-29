package di.setter02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new GenericXmlApplicationContext("config/setter.xml");
		Service myservice = factory.getBean("service",Service.class);
		myservice.test();
	}
}
