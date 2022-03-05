package basic;

public class VariableApp {

	public static void main(String[] args) {
		int su;
		su = 100;
		System.out.print("초기값 = ");
		System.out.println(su);
		
		su= 200;
		System.out.print("변경값 = ");
		System.out.println(su);
		System.out.println("=============================================");
		
		int num = 100;
		System.out.println("num = "+num);
		System.out.println("=============================================");
		System.out.println("올해는 "+2+0+2+1+"년입니다.");
		System.out.println(2+0+2+1+"년은 소띠해입니다.");
		System.out.println(""+2+0+2+1+"년은 소띠해입니다.");
		System.out.println("=============================================");
		
		// 동일한 자료형의 변수는 ',' 기호를 통해서 나열할 수 있음.
		int num1=100, num2=200;
		System.out.println("연산결과 = "+ (num1+num2));
		System.out.println("연산결과 = "+ (num1*num2)); // 28행과 비교했을 떄 더 빠름.
		System.out.println("연산결과 = "+ num1*num2);
		System.out.println("=============================================");
		
		int kor=88, eng=90;
		int tot = kor+eng;
		
		System.out.println("점수합계 = "+ tot);
		System.out.println("=============================================");
		/*
		int number;
		변수에 값이 저장되어있지 않은 상태로 사용하면 에러
		System.out.println("number =" + number);
		*/
		
		// int number= 10.0; // 변수에 저장할 수 없는 값을 저장할 경우 에러 발생
	}
}
