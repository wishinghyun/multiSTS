package basic;
public class InsaImpl implements Insa {
	MemberDAO dao;
	//1. 생성자를 이용해서 작업
	public InsaImpl() {//기본생성자
		
	}
	public InsaImpl(MemberDAO dao) {
		super();
		this.dao = dao;
	}
	//2. setter메소드를 호출이용해서 작업하는 방법
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void addUser(MemberDTO user) {
		dao.add(user);
	}

	@Override
	public MemberDTO getUser(String id) {
		MemberDTO memdto = dao.getUser("id");
		return memdto;
	}

}
