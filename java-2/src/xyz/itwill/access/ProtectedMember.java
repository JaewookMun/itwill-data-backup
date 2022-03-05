package xyz.itwill.access;

//protected : 필드, 메소드에 설정하는 접근 지정자
// => 다른 패키지의 클래스에서는 접근 불가능
// => 다른 패키지의 클래스와 상속 관계인 경우 접근 가능
public class ProtectedMember {
	protected int num;
	
	protected void display() {
		System.out.println("num = "+num);
	}
}
