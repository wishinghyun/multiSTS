package sync;

public class ThreadSyncTest02 {

	public static void main(String[] args) {
		//1. ������ü �����
		SharedObj obj = new SharedObj();
		obj.acc1 = new Account("111-222-3333", 5000, "����");
		obj.acc2 = new Account("333-555-7777", 1000, "������");
		
		//2. ������ ����
		SumPrintThread t1 = new SumPrintThread(obj);
		Thread t2 = new Thread(new TransferThread(obj));
		
		//3. ������ ������ start��Ű��
		t1.start();
		t2.start();
	}
}
	