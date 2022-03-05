package oop;

public class Overload {
	public void displayInt(int param) {
		System.out.println("정수값 = "+param);
	}
	
	public void displayBoolean(boolean param) {
		System.out.println("논리값 = "+param);
	}
	
	public void displayString(String param) {
		System.out.println("문자열 = "+param);
	}
		// 유사한 기능을 사용하는 메소드는 메소드 이름을 통일성 있게 만드는 것을 권장
	
		//메소드는 매개변수까지 식별자로 인식하기 때문에 아래 3개의 메소드는 이름은 같을지 몰라도 
		// 서로 다른것으로 인식
		// 즉, 메소드의 이름이 같더라도 "매개변수의 조건(자료형, 갯수)이 다르면 다른 것으로 인식"되기 때문에
		// 오버로드하여 사용 가능.
	
	//메소드 오버로드(Method Overload) 선언 : 하나의 클래스에서 동일한 기능을 제공하는 
	//메소드가 매개변수에 의해 여러 개 선언되어야 할 경우 메소드명을 같게 선언하는 방법
	//=> 매개변수의 갯수 또는 자료형을 같지 않도록 선언
	//=> 접근 지정자 또는 반환형은 오버로드 선언과 무관
		// 여기서 중요한 조건은 "동일한 기능을 제공하는 경우"다.
	public void display(int param) {
		System.out.println("정수값 = "+param);
	}
	
	public void display(boolean param) {
		System.out.println("논리값 = "+param);
	}
	
	public void display(String param) {
		System.out.println("문자열 = "+param);
	}
	
}
