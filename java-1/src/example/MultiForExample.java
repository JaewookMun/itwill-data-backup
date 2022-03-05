package example;

public class MultiForExample {
	public static void main(String[] args) {
		//★★★★★
		//★★★★
		//★★★
		//★★
		//★
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<= 6-i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
	
		System.out.println("==================================");		
		//★★★★★
		//☆★★★★
		//☆☆★★★
		//☆☆☆★★
		//☆☆☆☆★
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5 ; j++) {
				if(i<=j) {
					System.out.print("★");
				} else {
					System.out.print("☆");
				}
				
			}
			System.out.println();
		}
		
		/*			<< 강사님 >>
		 * 2가지 방법을 통해 풀이 (반복처리방식과 선택출력방식)
		 * 
		 */
		
		System.out.println("==================================");
		//★
		//★★★
		//★★★★★
		//★★★★★★★
		//★★★★★★★★★
		
		// @ 짝수 연산식: 2n			@ 홀수 연산식: 2n-1 
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=2*i-1; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		
		
		System.out.println("==================================");
		//★☆☆☆★
		//☆★☆★☆
		//☆☆★☆☆
		//☆★☆★☆
		//★☆☆☆★

		/*
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(i==j) {
					System.out.print("★");
				} else if(j==6-i) {
					System.out.print("★");
					
				} else {
					System.out.print("☆");
				}
			}
			System.out.println();
		}
		*/
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(i==j || i+j==6) {
					System.out.print("★");
				} else {
					System.out.print("☆");
				}
			}
			System.out.println();
		}

		// 알고리즘을 이해하려면 다중 for문을 많이봐야함 -> 반복을 제어하기 위해서
		
	}
}
