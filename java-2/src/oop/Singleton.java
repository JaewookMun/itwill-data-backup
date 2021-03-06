package oop;

//싱글톤 디자인 패턴을 적용하여 작성된 클래스 : 싱글톤 클래스(Singleton Class)
//=> 프로그램에 인스턴스를 하나만 제공하기 위한 클래스
	//필드가 없는 클래스(Business Object)를 만들 때 사용하는 것을 권장.
public class Singleton {
	//클래스의 인스턴스 정보를 저장하기 위한 필드 선언
	//=> static 지정자를 이용하여 정적필드로 선언
	//시스템 필드 : 클래스 내부에서만 사용될 값을 저장하기 위한 필드
	//=> Getter & Setter 메소드 미선언
	//=> 필드의 이름은 _로 시작되도록 선언하는 것을 권장
	private static Singleton _instance;
		
		//정적필드를 사용하지 않을 경우 아래처럼 표현
		//private static Singleton _instance = new Singleton();
	
	//★생성자를 은닉화 선언 - 클래스 외부에서 인스턴스 생성 불가능
		//생성자를 은닉화 했기 때문에 '상속'이 불가능하다.
		//싱글톤클래스를 만드는 방식은 다양하지만, 생성자를 은닉화시켜주는 것은 똑같다.
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	//정적영역(Static Block) : 클래스가 메모리(Static)에 저장된 후 자동 실행될 명령을
	//작성하는 영역 - 프로그램에서 한번만 실행
	//=> 정적 필드 또는 정적 메소드만 사용 가능
	//클래스로 인스턴스를 생성하여 시스템 필드(정적필드)에 저장
		//JVM의 클래스 로더가 클래스를 읽어들여서 static 메모리에 저장시킴 (1번만)
	static {
		_instance = new Singleton();
	}
	//시스템 필드에 저장된 인스턴스를 반환하는 정적 메소드 선언
	//=> 메소드를 호출하면 시스템 필드에 저장된 인스턴스를 제공받아 사용가능
		//static을 쓰는 이유는 클래스로 접근하기 위해서 & _instance가 static필드이기 때문
	public static Singleton getInSingleton() {
		return _instance;
	}
	
	public void display() {
		System.out.println("Singleton 클래스의 display() 메소드 호출");
	}
	
}
