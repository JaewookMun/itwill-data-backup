package xyz.itwill06.oop;

//여러 클래스에서 중복 선언된 동이롼 기능의 메소드를 제공하기 위한 클래스
	// 객체 지향 프로그래밍에서 가장 큰 단점이 코드의 중복이다. - 이를 피하기위한 편법이 사용됨.
	// 추상화 & 캡슐화를 위반하게 되지만 중복을 피할 수 있다.
	// 하지만 이것이 계속될 경우 가독성이 떨어진다.
public class OopLogger {
	public void beforeLog() {
		System.out.println("### 메소드의 명령 실행 전 기록될 내용 ###");
	}
}
