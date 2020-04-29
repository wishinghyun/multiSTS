package basic;
class DigitThread extends Thread{
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.print(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i%10==0) {
				System.out.println();
			}
		}
	}
}
class AlpahThread extends Thread{
	public void run() {
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i%5==0) {
				System.out.println();
			}
		}
		
	}
}
public class ThreadExam01 {
	public static void main(String[] args) {
		System.out.println("main");
		AlpahThread alpha = new AlpahThread();
		DigitThread digit = new DigitThread();
		digit.start();
		alpha.start();
		System.out.println("main");		
	}

}
