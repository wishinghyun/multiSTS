package sync;
//공유객체 - 모든 Thread가 공유해서 사용하는 객체
public class Toilet {
	//synchronized는 공유객체 하나가 사용중일때 락을 건다
	/*synchronized (공유객체){
		이용해서 부분 코드에 lock 적용
	}*/
	public synchronized void open(String user_name) {
		System.out.println(user_name+"가 문을 열고 들어옴");
		for (int i = 1; i <= 100000000; i++) { //딜레이 효과 주려고 i 개크게줌
			if (i==10000) {
				System.out.println("끙~~~~~~~야~~~~~~~~");
			}
		}
		System.out.println(user_name+"가 종료 후에 나감");
	}
}
