package xyz.itwill02.factory;

public class HelloMessageObject implements MessageObject {

	@Override
	public String getMessage() {
		return "Hello!";
	}
}
	/*
		Factory Design 패턴의 핵심 - 인터페이스를 통해 같은 형태의 클래스를 만드는 강제력 부여
		IoC (결합도 떨어트리기) - 1. 다형성 (Factory Pattern), 2. Container 
		
		유지보수가 편리
		
		Interface > 상속 클래스 
			Factory > 인터페이스를 상속받은 클래스를 생성하여 제공
			다른 클래스에서 factory 클래스에서 생성한 인스턴스를 활용
			App에서 이를 사용 
	 */

