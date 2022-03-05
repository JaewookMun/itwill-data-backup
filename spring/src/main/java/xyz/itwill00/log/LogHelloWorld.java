package xyz.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelloWorld {
	private static final Logger logger=LoggerFactory.getLogger(LogHelloWorld.class);
		// 기록을 하고 싶다면 logger를 생성
	
	public String hello(String name) {
		logger.info("시작");
		String message=name+"님, 안녕하세요";
		logger.info("종료");
		return message;
	}
}
