package sync;
//������ü - ��� Thread�� �����ؼ� ����ϴ� ��ü
public class Toilet {
	//synchronized�� ������ü �ϳ��� ������϶� ���� �Ǵ�
	/*synchronized (������ü){
		�̿��ؼ� �κ� �ڵ忡 lock ����
	}*/
	public synchronized void open(String user_name) {
		System.out.println(user_name+"�� ���� ���� ����");
		for (int i = 1; i <= 100000000; i++) { //������ ȿ�� �ַ��� i ��ũ����
			if (i==10000) {
				System.out.println("��~~~~~~~��~~~~~~~~");
			}
		}
		System.out.println(user_name+"�� ���� �Ŀ� ����");
	}
}
