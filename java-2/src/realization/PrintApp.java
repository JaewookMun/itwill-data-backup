package realization;

public class PrintApp {
	public static void main(String[] args) {
		//기본 메소드를 호출하기 위해서는 참조변수를 부모 인터페이스로 선언
		
		Printable printOne = new PrintSingle();
		
		printOne.print();
		printOne.scan(); //기본 메소드 호출
		System.out.println("================================================");
		
		Printable printTwo = new PrintMuliple();
		
		printTwo.print();
		printTwo.scan(); //자식 인스턴스의 오버라이드 메소드 호출
		System.out.println("================================================");
		
		
		
	}
}
