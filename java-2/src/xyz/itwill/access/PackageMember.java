package xyz.itwill.access;

//package(default) : 클래스, 필드, 메소드에 설정하는 접근 지정자
// => 접근 지정자 관련 키워드를 사용하지 않으면 package 접근 지정자로 자동 처리
// => 다른 패키지의 클래스에서는 무조건 접근 불가능

//public 접근 지정자를 설정하지 않는 자료형은 같은 패키지의 클래스에서만 접근 가능
// => 다른 패키지의 클래스에서 접근할 경우 에러 발생
public class PackageMember {
	int num;
	
	void display() {
		System.out.println("num = "+num);
	}
}
