package xyz.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelloWorldApp {
	// Logger : 로그 구현체에게 기록을 전달하기 위한 인스턴스
	// LoggerFactory : Logger 인스턴스를 제공하기 위한 클래스
	// LoggerFactory.getLogger(Class<T> clazz) : 메모리에 저장된 클래스(Clazz)에서 발생된
	// 기록을 로그 구현체에게 전달하는 Logger 인스턴스를 반환하는 메소드
		// log4j를 기반으로 만들어진 slf4j (The Simple Logging Facade for Java)
	private static final Logger logger=LoggerFactory.getLogger(LogHelloWorldApp.class);
		// 로그 인스턴스를 제공받아 로그 메소드를 기록처리
		// (getLogger의 파라미터로 전달되는 클래즈와 연결) 클래즈에서 발생하는 이벤트에대한 메세지를 전달하는 로거 인스턴스 사용
	public static void main(String[] args) {
		// Logger.info(String message) : 로그 이벤트를 발생하여 로그 구현체에게 메세지를
		// 전달하는 메소드
		logger.info("시작");
			// log4j.xml의 logger 의 범위에 설정되어있지 않기 때문에 info 메소드로 이벤트를 발생시켜도
			// 기록되지 않는다. logger엘리먼트에 설정되어 있지 않으면 root 의 범위인 warn 이상의 메세지만 가능
			// log4j를 사용하는 다른 스레드를 통해 기록처리 - 프로그램에 영향을 덜 준다.
		LogHelloWorld hw=new LogHelloWorld();
		String message=hw.hello("홍길동");
		System.out.println("message = "+message);
		logger.info("종료");
			// 보통 웹서비스의 작업이 이루어졌을 때 관련 로그를 표기
	}
}
