package inheritance;

public class MemberCastApp {
	public static void main(String[] args) {
		//부모클래스 참조변수 = new 부모 클래스(); : 가능
		//=> 부모 인스턴스를 생성하여 부모 참조변수에 부모 인스턴스를 저장
		Member member1 = new Member();
		
		//참조변수를 이용하여 부모 인스턴스의 메소드 호출
		member1.setId("aaa");
		member1.setName("홍길동");
		
		member1.display();
		System.out.println("===================================================");
		//자식 클래스 참조변수 = new 자식클래스();
		//=> 부모 인스턴스와 자식 인스턴스를 생성하여 자식 참조변수에 자식 인스턴스를 저장
		MemberEvent member2=new MemberEvent();
		
		//참조변수를 이용하여 자식 인스턴스의 메소드 호출
		//=> 자식 인스턴스는 부모 인스턴스를 참조할 수 있으므로 참조변수는 부모 인스턴스의 메소드 호출가능
		member2.setId("bbb");
		member2.setName("임꺽정");
		member2.setEmail("bbb@daum.net");

		member2.display();
		System.out.println("===================================================");
		//자식클래스 참조변수 = new 부모클래스(); : 불가능 - 에러
		//=> 자식 참조변수에는 자식 인스턴스만 저장할 수 있는데, 부모인스턴스만 생성되어 자식인스턴스가 없으므로 에러 발생
		// MemberEvent member3=new Member();
		System.out.println("===================================================");
		
		//부모클래스 참조변수 = new 자식클래스() : 가능
		//부모 인스턴스와 자식 인스턴스를 생성하여 부모 참조변수에 부모 인스턴스를 저장
			//자식클래스의 생성자가 호출되기 전에 부모 인스턴스가 생성되고 자식인스턴스가 생성되고
			//부모 인스턴스를 저장하기 때문에 가능
		Member member4 = new MemberEvent();
		
		//참조변수를 이용하여 부모 인스턴스의 메소드 호출 가능
		//=> 자식 인스턴스의 메소드는 호출 불가능
		member4.setId("ddd");
		member4.setName("전우치");
		
		//객체 형변환을 이용하면 부모 클래스의 참조변수로 자식 인스턴스의 메소드 호출 가능
		//=> 명시적 객체 형변환(강제 형변환), 묵시적 객체 형변환(자동 형변환)
		
		//명시적 객체 형변환 : 참조변수의 자료형을 자식 클래스로 변경하면 일시적으로
		//참조변수의 자식 인스턴스가 자동으로 저장
		//형식) (자식클래스)참조변수 >> Cast 연산자 이용
		//=> 참조변수를 이용하여 부모 인스턴스와 자식 인스턴스의 메소드 호출
		
		/*
		//자식 인스턴스의 메소드를 지속적으로 호출하여 사용하고자 할 경우 객체 형변환되어 저장된
		//자식 인스턴스를 자식 참조변수에 저장
		MemberEvent event=(MemberEvent)member4;
		event.setEmail("ddd@naver.com");
		*/
		
		System.out.println("member4 = "+member4);
		
		//자식 인스턴스의 메소드를 한번만 호출하고자 할 경우 객체 형변환 후 메소드 직접 호출
		//=> 연산자 우선 순위를 고려하여 메소드 호출
			//도트연산자 : 최우선 연산자, cast operator : 단항연산자
		((MemberEvent)member4).setEmail("ddd@naver.com");
		
		//묵시적 객체 형변환 : 자식 클래스에서 오버라이드 선언된 메소드는 부모 클래스의
		//숨겨진메소드 대신 호출되어 사용
		//=> 참조변수의 자료형이 자동으로 자식 클래스로 변경되어 자식 인스턴스를 저장
		member4.display();
			//부모가 자식 인스턴스로 바뀌어서 자식인스턴스를 호출하는 개념...
			//자식-> 부모의 개념을 뒤집은것과 같은이치로 판단됨.
			//상속 -> 1:1 관계 & 1:n관계가 있다.
		System.out.println("===================================================");
		
	}
}
