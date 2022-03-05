package basic;

public class DataTypeApp {
	public static void main(String[] args) {
		System.out.println("<<정수형>>");
		// println() 출력메소드는 정수값을 10진수로 변환하여 출력한다.
		System.out.println("정수값(10진수) = " + 100);
		System.out.println("정수값(10진수) = " + 0100);
		System.out.println("정수값(10진수) = " + 0x100);

		System.out.println("정수값(4Byte) =" +2147483647);
		// System.out.println("정수값(4Byte) =" +2147483648); int(4Byte)로 표현할 수 없는 정수값)
		System.out.println("정수값(4Byte) =" +2147483648L);
		
		byte a1=127;
		short a2 = 32767;
		int a3=2147483647;
		long a4 = 2147483648L;
	
		System.out.println("a1 = " +a1);
		System.out.println("a2 = " +a2);
		System.out.println("a3 = " +a3);
		System.out.println("a4 = " +a4);

		// int a5 = 100L // 데이터손실 가능성에 의한 에러발생
		long a5 =100; // 문제없음.
		System.out.println(a5);
		System.out.println("=============================================");
		System.out.println("<<실수형>>");
		System.out.println("실수값(4Byte) = "+1.23f);
		System.out.println("실수값(8Byte) = "+1.23);
		// println() 출력 메소드는 아주 작은 또는 아주 큰 실수값을 지수형으로 변환하여 출력처리
		System.out.println("실수값(8Byte) = "+0.00000123);
		// 실수값을 지수형으로 표현 가능
		System.out.println("실수값(8Byte) = "+1.23E2);
		
		// float b1=1.23; // 8byte값을 4byte에 넣으려고 하기 떄문에 에러발생
		
		float b1 = 1.23456789f; // 가수부 표현범위 : 소수점 7자리
		double b2 = 1.23456789; // 가수부 표현범위 : 소수점 15자리
		
		System.out.println("b1 = " +b1);
		System.out.println("b2 = " +b2);
		System.out.println("=============================================");
		
		float b3 = 2147483648L;
		System.out.println("b3 = " +b3);
		System.out.println("=============================================");
		
		System.out.println("<<문자형>>");
		System.out.println("문자값(2Byte) = "+ 'A');
		System.out.println("문자값(2Byte) = "+ '한');
		System.out.println("문자값(2Byte) = "+ '\'');
		System.out.println("문자값(2Byte) = "+ '\\');
		
		// 'A' : 65, 'a' : 97, '0': 48, ' ' : 32, '\n' : 13, '가' : 44032 (한글은 14,000글자.)
		char c1='A'; //문자는 내부적으로 약속된 정수값으로 저장
		char c2 = 65; //약속된 정수값을 직접 저장가능
		char c3 = 'a'-32; 
		
		System.out.println("c1 = " +c1);
		System.out.println("c2 = " +c2);
		System.out.println("c3 = " +c3);
		
		char c4=45000;
		System.out.println("c4 = " +c4);
		System.out.println("=============================================");
		System.out.println("<<논리형>>");
		System.out.println("논리값(1Byte) = "+ false);
		System.out.println("논리값(1Byte) = "+ true);
		System.out.println("논리값(1Byte) = "+ (20>10));
		System.out.println("논리값(1Byte) = "+ (20<10));
		
		boolean d1=false;
		boolean d2=20>10;

		System.out.println("d1 = " +d1);
		System.out.println("d2 = " +d2);
		System.out.println("=============================================");
		
		System.out.println("<<문자형>>");
		System.out.println("문자열 = "+" 홍길동");
		System.out.println("유관순 열사가 \"대한독립 만세\"라고 외쳤습니다.");
		
		String e1 = "Java";
		String e2 = "열심히 공부해요.";
		System.out.println("e1 = " +e1);
		System.out.println("e2 = " +e2);
		
		System.out.println(e1 +" "+e2);
		
		
	}
}
