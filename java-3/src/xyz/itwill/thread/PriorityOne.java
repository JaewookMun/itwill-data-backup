package xyz.itwill.thread;

public class PriorityOne extends Thread {

	@Override
	public void run() {
		while(true) {
			System.out.print("A");
		}
	}
		//run()�� ������ �����尡 �Ҹ��ϱ� ������ ���ѷ����� ���� �Ҹ��Ű�� �ʴ� ��쵵 �ִ�.
}
