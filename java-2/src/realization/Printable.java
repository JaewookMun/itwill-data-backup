package realization;

public interface Printable {
	//추상 메소드는 자식 클래스에서 반드시 오버라이드 선언
	void print();
	
	//JDK8 이상에서는 인터페이스에 명령을 작성할 수 있는 기본 메소드 선언 가능
	//=> default 키워드로 메소드 선언
	//기본 메소드(Default Method) : 인터페이스를 상속받은 자식 클래스에서 오버라이드
	//선언하지 않아도 되는 메소드
	//=> 오버라이드 선언하지 않을 경우 기본 메소드의 명령 실행
	default void scan() {
		System.out.println("[에러]스캔 기능을 제공하지 않습니다.");
	}
}
