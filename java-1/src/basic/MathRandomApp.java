package basic;

//컴퓨터로부터 난수값을 제공받아 출력하는 프로그램을 작성하세요
// => 난수값 : 불규칙하게 제공되는 숫자값 (프로그램을 만들 때 이런 난수값들이 많이 이용된다.)
public class MathRandomApp {
	public static void main(String[] args) {
		//Math 클래스 : 수학 관련 기능을 제공하는 메소드가 선언된 클래스
		
		//Math.random() : 0.0보다 크거나 같고 1.0보다 작은 실수 난수값을 반환하는 메소드
		//				  같은 숫자가 나올 수도 있다.
		for(int i=1; i<=5;i++) {
			System.out.println(i+"번째 실수 난수값 = "+Math.random());
		}
		System.out.println("===============================================");
		//0~99 범위의 정수 난수값을 제공받아 출력
		for(int i=1; i<=5;i++) {
			System.out.println(i+"번째 실수 난수값 = "+(int)(Math.random()*100));
		}
		System.out.println("===============================================");
		//1~45 범위의 정수 난수값을 제공받아 출력
		for(int i=1; i<=5;i++) {
			System.out.println(i+"번째 실수 난수값 = "+((int)(Math.random()*100)%45+1));
		}
		System.out.println("===============================================");
		
		
	}
}
