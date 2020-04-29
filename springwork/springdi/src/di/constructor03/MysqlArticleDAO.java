package di.constructor03;

public class MysqlArticleDAO implements IArticleDAO{
	
	public MysqlArticleDAO() {
		
	}
	
	public void insert(ArticleDTO article) {
		System.out.println("Mysql insert");
	}
}
