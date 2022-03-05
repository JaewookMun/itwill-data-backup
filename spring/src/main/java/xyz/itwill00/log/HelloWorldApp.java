package xyz.itwill00.log;

public class HelloWorldApp {
	public static void main(String[] args) {
		System.out.println("HelloWorldApp 클래스의 main 메소드 - 시작");
		HelloWorld hw=new HelloWorld();
		String message=hw.helloMessage("홍길동");
		System.out.println("message = "+message);
		System.out.println("HelloWorldApp 클래스의 main 메소드 - 종료");
			// 로그처리를 하는 프로그램이 따로 없을 경우 클래스 내부에서 직접 기록하도록 설정.
			// main 스레드를 차지하는 하나의 명령이 되기 때문에 속도 저하
			// 로그 구현체를 사용하지 않으면 1. 가독성(실행속도)이 떨어지고 2. 프로그램을 위한 명령인지 구분하기 어렵다.
			// => 기록을 위한 프로그램이 필요하고 log4j를 사용
	}
}
