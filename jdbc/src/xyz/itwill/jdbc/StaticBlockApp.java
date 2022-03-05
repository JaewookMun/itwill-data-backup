package xyz.itwill.jdbc;

public class StaticBlockApp {
	public static void main(String[] args) {
		/*
		//ClassLoader 프로그램에 의해 클래스(Class 파일)를 읽어 메모리에 저장 - 자동(1번)
		//new 연산자가 메모리에 저장된 클래스(Clazz)의 생성자를 호출하여 인스턴스 생성
		//=> 생성된 인스턴스를 참조변수에 저장
			//클래스를 이용하면 가장 먼저 동작되는 기능
			//자바는 클래스를 통해 객체를 만들어서 프로그램을 만드는 객체지향언어
		StaticBlock sb = new StaticBlock();
		
		//참조변수에 저장된 인스턴스의 메소드 호출 - 기능 구현
		sb.display();
		*/
		
		/*
		//Class :  클래스 정보를 저장하기 위한 클래스
		//Class.forName(String className) : 문자열로 표현된 패키지를 포함한 클래스를 전달받아 
		//ClassLoader 프로그램을 이용하여 클래스를 읽어 메모리에 저장하는 메소드
		///=> 메모리에 저장된 클래스 정보(Class 인스턴스 - Clazz) 반환
		//=> ClassNotFoundException 발생 - 예외처리
			//수동으로 ClassLoader를 불러와 메모리에 클래스 정보를 저장하는 기능 - 일반적으로 JVM을 통해 자동으로 처리되는 명령
		//Class.newInstance() : 메모리에 저장된 클래스(Clazz)의 기본 생성자를 이용하여 인스턴스를 생성하는 메소드
		//=> InstantiationException, IllegalAccessException 발생 - 예외처리
		//=> Object 타입의 인스턴스를 반환 : 명시적 객체 형변환
		//리플렉션(Reflection) : 클래스를 직접 메모리에 저장하여 인스턴스를 생성하는 방법
			//텍스트파일에만 문자열만 입력하여 클래스경로를 잡아주면 팩토리클래스(컨테이너클래스)를 통해 생성(?) - advanced java
			//리플렉션을 이용하면 접근제어자와 상관없이 메소드 사용가능 regardless of private or public
		try {
			StaticBlock sb = (StaticBlock)Class.forName("xyz.itwill.jdbc.StaticBlock").newInstance();
			sb.display();
		} catch (ClassNotFoundException e) {
			System.out.println("[에러] 클래스를 찾을 수 없습니다.");
		} catch (Exception e) {
			System.out.println("[에러] 실행 프로그램에서 문제가 발생 하였습니다.");
			
		}
		*/
		
		try {
			//정적영역에서 인스턴스가 생성되어 메소드 호출
				//클래스파일을 읽어들여 메모리에 저장!!!!!
				//Class.forname() 메소드가 어떤 역할을 하는지정도만 check!
			Class.forName("xyz.itwill.jdbc.StaticBlock");
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]클래스를 찾을 수 없습니다.");
		}
		
		
		
	}
}
