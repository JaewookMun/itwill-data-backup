package basic;

import java.util.Scanner;

// 키보드로 점수를 입력받아 학점을 계산하여 출력하는 프로그램을 작성하세요
// => 100~90 : A, 89~80: B, 79~70: C, 69~60: D, 59~0: F
// => 입력된 점수가 0~100 범위의 정수값이 아닌 경우 메세지 출력 후 재입력
public class InputCheckApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		System.out.print("점수 입력[0~100] >> ");
		int score = scanner.nextInt();
		*/
		// 위와 같은 코드는 비정상적인 값이 입력된 경우 정상적인 값을 입력될 수 있도록 처리할 수 없음.
		// 정상적인 값이 입력될 때 까지 진행해야하기 때문에 while문 사용
		
		
		/*
		//비정상적인 값이 입력될 경우 반복 처리 - 정상적인 값이 입력되면 반복문 종료
		//반복문의 조건식이 참이되는 임의값을 변수에 저장
		 * 
		
		int score= -1;
		while(score<0 || score>100) {
			System.out.print("점수 입력[0~100] >> ");
			score= scanner.nextInt(); 
			if(score<0 || score>100) {
				System.out.println("[에러]점수는 0~100 범위의 정수값만 입력 가능합니다.");
			}
		}
		*/
		
		
		// 조건식을 미리 처리 안해도 된다. (socore 값을 미리 지정하지 않아도 됨.)
		// 조건문이 두번나와야해서 비효율
		/*
		int score;
		do {
			System.out.print("점수 입력[0~100] >> ");
			score= scanner.nextInt(); 
			if(score<0 || score>100) {
				System.out.println("[에러]점수는 0~100 범위의 정수값만 입력 가능합니다.");
		} while (score<0 || score>100);
		*/
		
		/*
		 * [while문에 true를 사용해 무한루프를 돌린 상태에서 정상적일 때 나가게 하는 것이
		 * 좀 더 고급스러운 방식이다.]
		 *  <위의 코드들보다 좋은 3가지 이유> 
		 * 1. 비정상적인 값보다는 정상적인 값을 표현하는 것이 더 쉽다.
		 * 2. 조건식이 중복되지 않는 점
		 * 3. 반복문을 중간에서 (내가 원할 때) 종료할수 있는 점
		 */
		// do-while문을 쓰지 않아도 되고 if-break를 통해 내가 원할 떄 나갈 수 있도록 처리할 수 있다. 
		
		int score;
		while(true) {	//조건식 대신 true 작성 : 무조건 참 - 무한루프
			System.out.print("점수 입력[0~100] >> ");
			score = scanner.nextInt(); 
			// 정상적인 값이 입력된 경우 반복문 종료
			if(score>=0 && score<=100) break;
			// 비정상적인 값이 입력된 경우 실행될 명령 
			System.out.println("[에러]점수는 0~100 범위의 정수값만 입력 가능합니다.");
		}
		
		
		String grade;
		switch (score/10) {
		case 10:
		case 9:	grade="A"; break;
		case 8: grade="B"; break;
		case 7: grade="C"; break;
		case 6: grade="D"; break;
		default: grade="F";
		}
		
		System.out.println("[결과]"+score+"점 >> "+grade+"학점");
		scanner.close();
	}
}
