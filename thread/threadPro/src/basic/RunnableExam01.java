package basic;
class DigitRunnable implements Runnable{
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
class AlpahRunnable implements Runnable{
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
public class RunnableExam01 {
	public static void main(String[] args) {
		System.out.println("main");
		DigitRunnable digit = new DigitRunnable();
		Thread digitT = new Thread(digit);
		digitT.start();
		new Thread(new AlpahRunnable()).start();
		System.out.println("main");		
	}

}
