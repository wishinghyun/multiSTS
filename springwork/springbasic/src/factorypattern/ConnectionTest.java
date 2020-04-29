package factorypattern;
public class ConnectionTest {
	public static void main(String[] args) {
		ConnectionFactory factory=new ConnectionFactory();
		Connection db=factory.getConnection (args[0]);
		db.connect();
	
	}

}
