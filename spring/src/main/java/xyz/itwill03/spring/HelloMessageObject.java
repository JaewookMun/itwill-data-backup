package xyz.itwill03.spring;

public class HelloMessageObject implements MessageObject {

	@Override
	public String getMessage() {
		return "Hello!!!";
	}
	
		/*
			Factory 클래스 생성 대신 Spring container 사용
		 */
}
