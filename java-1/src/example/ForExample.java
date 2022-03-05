package example;

public class ForExample {
	public static void main(String[] args) {
		//1. 본인 이름을 화면에 7번 출력하세요
		//ex) 홍길동 홍길동 홍길동 홍길동 홍길동 홍길동 홍길동 
		
		for(int i=1; i<=7; i++) {
			System.out.print("문재욱 ");
		}
		System.out.println();

		
		System.out.println("==================================");
		//1~10 범위의 정수 중 홀수를 화면에 출력하세요
		//ex)	1	3	5	7	9
		
		for(int i=1; i<=10; i++) {
			if(i%2 != 0) {
				System.out.print(i+"\t");
			}
		}
		System.out.println();
		
		
		System.out.println("==================================");
		// 1~100 범위의 정수에서 3의 배수들의 합계와 5의 배수들의 합계를 계산하여
		// 3의 배수의 합계에서 5의 배수의 합계를 뺀 결과를 출력하세요.
		// ex) 결과 = 633
		int sumT=0, sumF=0;
		
		for (int i=1; i<=100; i++) {
			if(i%3==0) {
				sumT+=i;
			}
			if(i%5==0) {
				sumF+=i;
			}
		}
		int result = sumT-sumF;
		System.out.println("result: "+result);
		// 강사님은 결과값을 따로 변수화하지 않고 print메서드에서 직접 계산하여 출력함.
		
		
		System.out.println("==================================");
		// 구구단 중 7단을 화면에 출력하세요
		// ex) 7 * 1 = 7
		// ex) 7 * 2 = 14
		// ...
		// ex) 7 * 8 = 56
		// ex) 7 * 9 = 63
		
		// 7을 dan이라는 정수형 변수에 대입하여 dan*i 형태로 작성하심.		
		for(int i=1; i<=9; i++) {
			System.out.println("7 * "+i+" = "+7*i);
		}
		
		
		System.out.println("==================================");
		// 5!의 결과값을 출력하세요. (5!=5*4*3*2*1
		// ex) 5!=120
		
		/* mine
		int result1 = 1;
				
		for(int i=1; i<=5; i++) {
			result1*=i;
		}
		System.out.println("5!의 결과값: " +result1);
		*/
		
		// 5!의 '5'를 변수처리해서 for문 괄호내부에서 사용.
		int num=5, result1 = 1;
		
		for(int i=1; i<=num; i++) {
			result1*=i;
		}
		System.out.println("5!의 결과값: " +result1);
		
		
		System.out.println("==================================");
		// 두 변수에 저장된 정수값 사이의 정수들을 화면에 출력하세요
		// 단, 한 줄에 정수값이 7개씩 출력되도록 작성하세요
		//ex)	36	27	38	39	40	41	42
		//		43	44	45	46	47	48	49
		//		50	51	52	53	54	55	56
		//		57
		
		/*
		int begin=36, end=57;
				
		for(int i=begin; i<=end; i++) {
			if(i%7 != 0) {
				System.out.print(i+"\t");
			} else {
				System.out.println(i);
			}
		}
		System.out.println();
		*/
		
		/* 원하는 결과값을 얻기 위해서 변수를 추가할 수 있어야함.
		 * 이 문제의 핵심은 프로그램에서 만든 결과가 나타날때마다 이를 카운트하여 
		 * 써먹는 것이다.
		 */
		
		int begin=36, end=57;
		int count=0;
		
		for(int i=begin; i<=end; i++) {
			System.out.print(i+"\t");
			count++;
			
			if(count%7 == 0) {
				System.out.println();
			}
		}
		if(count%7 != 0) {
			System.out.println();
		}
		
		
		System.out.println("==================================");
		
		
		
		
		
		
	}
}
