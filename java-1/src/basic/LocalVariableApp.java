package basic;

public class LocalVariableApp {
	public static void main(String[] args) {
		int num1=100;
		
		//임의 블럭
		{
			int num2 = 200;
			
			System.out.println("========= 임의블럭 내부 =========");
			System.out.println("num1 = "+num1);
			System.out.println("num2 = "+num2);
		}
		
		
		System.out.println("========= 임의블럭 외부 =========");
		System.out.println("num1 = "+num1);
		/* 임의 블럭 종료시 num2 변수가 자동 소멸되므로 사용불가능
		System.out.println("num2 = "+num2);
		*/
		
		// int num2; // 임의 블럭 종료시 같은 이름의 변수를 선언해도 에러는 안뜬다.
	}
}
