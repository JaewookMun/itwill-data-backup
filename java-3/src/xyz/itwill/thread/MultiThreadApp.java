package xyz.itwill.thread;

//���� ������ ���α׷� - main ������� �ٸ� �����带 �����Ͽ� ��� ����
//=> ��� �����尡 �Ҹ�Ǿ�߸� ���α׷� ����
public class MultiThreadApp {
	//main �޼ҵ忡�� ���޵Ǵ� ��� ���ܴ� JVM�� �ڵ����� ����ó��
	public static void main(String[] args) throws InterruptedException {
		//JVM�� ���� main ������ �ڵ� ����
		
		//=> Thread �ν��Ͻ��� start()�޼ҵ带 ȣ���Ͽ� ������ ����
		//=> ������ ������� �ڵ����� run() �޼ҵ��� ��� ����
		//Thread Ŭ������ ����� run() �޼ҵ忡�� ����� ��� ������
		//=> �ڽ�Ŭ������ �̿��Ͽ� run()�޼ҵ带 �������̵� �����Ͽ� ����� ��� �ۼ�
		/*
		MultiThreadOne thread=new MultiThreadOne();
		thread.start();
		 */

		//Thread Ŭ������ ��ӹ��� �ڽ� Ŭ������ �ν��Ͻ� ����
		//=> �ڽ� Ŭ������ �����ڷ� �ν��Ͻ��� �����Ͽ� �θ�(Thread) �ν��Ͻ��� ���� ����
		//�θ�(Thread) �ν��Ͻ��� start() �޼ҵ带 ȣ���Ͽ� ������ ����
		//=> ������ ������� �ڽ� Ŭ�������� �������̵� ����� run() ��� ����
		/*
		MultiThreadOne thread=new MultiThreadOne();
		thread.start();
		 */
		
			//���������� ����� ������ ���������� ���� ���������� �ν��Ͻ��� Ȱ���ϰ����ϴ� ���̴�.
		//Thread �ν��Ͻ��� start() �޼ҵ�� ȣ���� �޼ҵ尡 ���� ��� �������� ���� �޼ҵ� ȣ��
		new MultiThreadOne().start();
		//�ϳ��� Thread �ν��Ͻ��� �ϳ��� �����常 ���� ����
			//�����带 �ϳ� �� ������� �ν��Ͻ��� �ϳ� �� �������Ѵ�.
		new MultiThreadOne().start(); 
		
		/*
		//Runnable �������̽��� ��ӹ��� �ڽ� Ŭ������ �ν��Ͻ� ����
		MultiThreadTwo multiThreadTwo = new MultiThreadTwo();
		//Thread Ŭ������ �ν��Ͻ� ����
		//=> Runnable �ν��Ͻ��� ���޹޾� Thread �ν��Ͻ� �����ϴ� ������ ȣ��
		//=> run() �޼ҵ尡 �������̵� ����Ǵ� �Ͱ� ���� ȿ��
		Thread thread = new Thread(multiThreadTwo);
		//Thread �ν��Ͻ��� start() �޼ҵ� ȣ�� - ���ο� �����带 �����Ͽ� 
		thread.start();
		*/
		new Thread(new MultiThreadTwo()).start();
			//c.f. �ĺ��ڰ� ���� ���� ���������� ȿ������ ������.
		
		/*
		for(char i='a'; i<='z'; i++) {
			System.out.print(i);
			
			//Thread.sleep(long ms) : ���� ����� �����ϴ� �����带 ���ϴ� �ð�(ms)���� 
			//�Ͻ� �����ϴ� �޼ҵ�
			//=> InterruptedException �߻� - �ݵ�� ���� ó��
				//���� �߻��� ���� ���� ������ try ~ catch���ٴ� JVM�� ���ѱ�� �������� �ִ�.
				//������, ����ó���ϴ°� ����
				//���ÿ� ����Ǵ� ��ó�� ���̰� ���� �� �ִ�.
			Thread.sleep(500); // ms=1/1000��    e.g) 500 = 0.5��
		}
		*/
		for(char i='0'; i<='9'; i++) {
			System.out.print(i);
			Thread.sleep(500); // ms=1/1000��    e.g) 500 = 0.5��
		}
	}
}
