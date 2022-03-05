package xyz.itwill.thread;

public class PriorityOne extends Thread {

	@Override
	public void run() {
		while(true) {
			System.out.print("A");
		}
	}
		//run()이 끝나면 스레드가 소멸하기 때문에 무한루프를 통해 소멸시키지 않는 경우도 있다.
}
