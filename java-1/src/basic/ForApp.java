package basic;

public class ForApp {
	public static void main(String[] args) {
		//"Java Programming"를 화면에 5번 출력
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("==================================================");
		//"Java Programming"를 화면에 5번 출력
		for(int i=1;i<=5;i++) {//i 변수는 for 구문이 종료되면 소멸
			System.out.println("Java Programming");
		}
		System.out.println("==================================================");
		//"Java Programming"를 화면에 5번 출력
		for(int i=5;i>=1;i--) {
			System.out.println("Java Programming");
		}
		System.out.println("==================================================");
		//"Java Programming"를 화면에 5번 출력
		for(int i=2;i<=10;i+=2) {
			System.out.println("Java Programming");
		}
		System.out.println("==================================================");
		//"1    2    3    4    5"를 화면에 출력
		for(int i=1;i<=5;i++) {
			System.out.print(i+"\t");
		}
		System.out.println();//엔터(\n)만 출력
		System.out.println("==================================================");
		//"5    4    3    2    1"를 화면에 출력
		/*
		for(int i=1;i<=5;i++) {
			System.out.print((6-i)+"\t");
		}
		System.out.println();
		*/
		
		for(int i=5;i>=1;i--) {
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("==================================================");
		//1~10 범위의 정수 중 짝수만 화면에 출력 >> "2    4    6    8    10"
		/*
		for(int i=2;i<=10;i+=2) {
			System.out.print(i+"\t");
		}
		System.out.println();
		*/
		
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				System.out.print(i+"\t");
			}
		}
		System.out.println();
		System.out.println("==================================================");
		//1~100 범위의 정수들의 합계를 계산하여 출력하세요.
		// => 1+2+3+....+98+99+100 = ?
		int tot=0;
		for(int i=1;i<=100;i++) {
			tot+=i;
		}
		System.out.println("1~100 범위의 정수들의 합계 = "+tot);
		System.out.println("==================================================");
		//두 변수에 저장된 정수값 범위의 정수들의 합계를 계산하여 출력하세요.
		//int begin=20, end=80;
		int begin=80, end=20;
		
		/*
		if(begin>end) {
			System.out.println("[에러]시작값이 종료값보다 작아야 됩니다.");
			System.exit(0);
		}
		*/
		
		//시작값이 종료값보다 큰 경우 두 변수값을 서로 바꾸어 저장되도록 작성
		if(begin>end) {
			//치환 알고리즘(Swap Algorithm)
			// => 알고리즘(Algorithm) : 어떠한 문제를 해결하기 위한 명령들의 실행 순서
			int temp=begin;
			begin=end;
			end=temp;
		}
		
		int sum=0;
		for(int i=begin;i<=end;i++) {
			sum+=i;
		}
		
		System.out.println(begin+"~"+end+" 범위의 정수들의 합계 = "+sum);
		System.out.println("==================================================");
		//초기식 또는 증감식은 , 기호를 이용하여 여러 개 나열 작성 가능
		for(int i=1,j=5;i<=3;i++,j--) {
			System.out.println("i = "+i+", j = "+j);
		}
		System.out.println("==================================================");
		int i=1;//for 구문에 상관없이 계속 존재
		//초기식, 조건식, 증감식 생략 가능
		for(;i<=4;i++) {
			System.out.print(i+"  ");
		}
		
		//i=5;
		for(;i>=1;i--) {
			System.out.print(i+"  ");
		}
		System.out.println();
		System.out.println("==================================================");
		/*
		//조건식이 생략된 경우 무조건 참(true)으로 처리 - 무한루프(종료되지 않는 반복문)
		for(;;) {
			System.out.println("무한 반복되어 실행되는 명령");
		}
		//무한루프 하단에 작성된 명령은 읽지 못하는 명령이므로 에러 발생
		System.out.println("==================================================");
		*/
	}
}
