package basic;

public class ContinueApp {
	public static void main(String[] args) {
		for(int i=1; i<=5; i++) {
			// continue : 반복문의 명령을 처음부터 다시 실행하는 명령
			// => continue 명령이 실행되면 continue 명령 하단에 작성된 명령 미실행
			if(i==3) continue;
			System.out.println(i+"\t");
		}
		System.out.println();
		System.out.println("===========================================");
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				// continue 명령이 작성된 블럭의 반복문을 처음부터 다시 실행
				if(j==3) continue;
				System.out.println("i= "+i+", j = "+j);
			}
		}
		System.out.println("===========================================");
		
		loop: 
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
					//라벨명으로 지정된 반복문을 처음부터 다시 실행
				if(j==3) continue loop;	// for(int i=1; i<=5; i++) 반복문 재실행 
				System.out.println("i= "+i+", j = "+j);
			}
		}
		System.out.println("===========================================");
	}
}
