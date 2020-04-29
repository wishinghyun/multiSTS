package basic;
/*
 * ��Ƽ������ ���α׷���
 * 1. Runnable�������̽��� �����ϴ� Ŭ������ ����
 * 2. Runnable�������̽��� ���� �ִ� �߻�޼ҵ��� run�޼ҵ带 �������̵�
 *    => ���� �۾��ϰ� ���� ������ ����
 * 3. �ۼ��� Runnable��ü�� �̿��ؼ� Thread��ü�� ����
 *    => Thread��ü�� �����ϸ鼭 �Ű������� Runnable��ü�� ����
 * 4. ������ Thread��ü�� startȣ��
 */
class RunnableDemo1 implements Runnable{
	public void run() {
		//1���� 20���� ����ϴ� �ڵ�
		for (int i = 1; i <= 20; i++) {
			//Thread.currentThread()�� ���� �������� Thread�� ������ �����Ѵ�
			System.out.print(i+"("+Thread.currentThread().getName()+")");
			try {
				Thread.sleep(500);//�����帧�� �����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(i%5==0) {
				System.out.println();
			}
		}
	}
}
//ThreadTest01��ü�� Ȱ���Ͽ� ��Ƽ������ ���α׷��� ����
public class RunnableTest01 {
	public static void main(String[] args) {
		System.out.println("******���α׷�����******");
		RunnableDemo1 r1 = new RunnableDemo1();
		RunnableDemo1 r2 = new RunnableDemo1();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		System.out.println("�۾���......");
		for (int i = 1; i <= 10; i++) {
			System.out.println("main");
			try {
				Thread.sleep(200);//�����帧�� �����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(i%5==0) {
				System.out.println();
			}
		}
		System.out.println("******���α׷�����******");
	}

}
