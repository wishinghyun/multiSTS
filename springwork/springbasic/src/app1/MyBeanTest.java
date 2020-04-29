package app1;
/*
 * 	결합도가 극도로 높은 프로그램
 * 	=> 클래스간의 결합도가 강하고 의존성이 높다
 * 	=> 사용되는 클래스를 변경하면 이 클래스를 사용하고 있는 모든 소스를 수정해야 한다
 * 	      즉, 수정해야 하는 범위가 넓어진다
 * 	   oop특성도 적용되어 있지 않다
 */
public class MyBeanTest {
	public static void main(String[] args) {
		MyBeanStyleB obj = new MyBeanStyleB();
		run(obj);
		show(obj);
	}
	public static void run(MyBeanStyleB obj) {
		System.out.println("******************");
		obj.hello("현빈");
		obj.hello("현빈");
		System.out.println("******************");
	}
	public static void show(MyBeanStyleB obj) {
		System.out.println("====================");		
		obj.hello("현빈");
		obj.hello("현빈");
		System.out.println("====================");		
	}
}
