package xyz.itwill.access;

//public : 클래스, 필드, 메소드에 설정하는 접근 지정자
// => 패키지에 상관없이 모든 클래스에서 접근 가능하도록 설정하는 지정자

//Java 자료형(Class, Interface, Enum) 선언시 public 접근 지정자를 설정하면
//다른 패키지의 자료형에서 접근하여 사용 가능
public class PublicMember {
	public int num;
	
	public void display() {
		System.out.println("num = "+num);
	}
}
