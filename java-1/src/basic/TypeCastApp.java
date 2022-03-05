package basic;

// 형변환(Type Cast) : 값의 자료형을 일시적으로 변환하여 사용하는 방법
// => 자동형변환 : JVM, 강제 형변환 : 프로그래머

public class TypeCastApp {
	public static void main(String[] args) {
		
		
		// 자동 형변환 : 자료형이 다른 값를 연산하기 위해 JVM(Java Virtual Machine)이 자료형을 일시적으로 변환        

		System.out.println("결과 = " +(3+1.5)); // 3이 3.0으로 바뀌는 자동형변환 발생
		System.out.println("결과 = " +(95/10)); // 두 정수값에 대한 연산결과 값 : 정수 
		System.out.println("결과 = " +(95.0/10.0)); // 9.5 
		System.out.println("결과 = " +(95/10.0)); // 자동형변환 
		
		
		int kor=95, eng=90;
		int tot=kor+eng;
		// double ave=tot/2; //연산 후 결과를 변수에 저장 : 92 
		double ave=tot/2.; // 92.5
		
		System.out.println("총점 = " + tot+ ", 평균 = "+ave);
		
		byte su1=10, su2=20;
		int su3=su1+su2;
		System.out.println("su3 = " +su3);
		System.out.println("======================================================");

		
		//강제 형변환 : 프로그래머가 Cast연산자를 이용하여 원하는 자료형의 값으로 일시적으로 변환하여 사용하는 방법  
		
		int num=(int)12.3;
		System.out.println("num= " + num);
		
		int num1=95, num2=10;
		double num3=(double)num1/num2; // 정수로 연산한 뒤 대입했기 때문에 실수값이 나올 수 없다.
		System.out.println("num3 = " +num3);
		
		// 정수값이 큰 경우 _를 이용하여 표현 가능
		int num4=100_000_000, num5=30;
		long num6 = (long) num4*num5; // 연산결과가 int자료형의 표현범위를 초과할 경우 쓰레기값 발생
		System.out.println("num6 = "+num6);
		
		double number = 1.23456789;
		System.out.println("number = "+number);

		// 소수점 2자리까지만 출력되도록 프로그램 작성
		System.out.println("number(버림) = "+(int)(number*100)/100.0); //1.23
		System.out.println("number(반올림) = "+(int)(number*100+0.5)/100.0); //1.23
		System.out.println("number(올림) = "+(int)(number*100+0.9)/100.0); //1.24

	}
}
