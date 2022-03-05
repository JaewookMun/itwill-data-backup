package example;

import java.util.Scanner;

//키보드로 정수값을 5번 입력받아 합계를 계산하여 출력하는 프로그램을 작성하세요.
//ex) 1번째 정수값 입력 >> 10
//    2번째 정수값 입력 >> 20
//    3번째 정수값 입력 >> 30
//    4번째 정수값 입력 >> 40
//    5번째 정수값 입력 >> 50
//    [결과]합계 = 150
public class TotalOneExample {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// scanner 객체를 통해 정수를 입력받아 그 값을 j에 저장한 뒤 누적.
		// 프로그램을 만들 때는 설계도를 먼저 그리는게 좋다.
		// 설계도 없이 프로그램을 만들면 문제가 생기게 된다.
		int sum = 0;
		for(int i=1, j=0; i<=5; i++) {
			System.out.print(i+"번째 정수값 입력 >> ");
			j=scanner.nextInt();
			sum+=j;
		}
		
		System.out.println("[결과]합계 = "+sum);
		scanner.close();
		
	}
}
