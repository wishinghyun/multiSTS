package di.constructor03;

public class OracleArticleDAO implements IArticleDAO{
	
	public OracleArticleDAO() {
		
	}
	
	public void insert(ArticleDTO article) {
		System.out.println("Oracle insert");
	}
}
