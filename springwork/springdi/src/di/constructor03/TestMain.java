package di.constructor03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ArticleDTO dto = new ArticleDTO();
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("config/bean.xml");
		IWriteArticleMgr mgr = factory.getBean("Mgr",IWriteArticleMgr.class);
		mgr.write(dto);
	}
}
