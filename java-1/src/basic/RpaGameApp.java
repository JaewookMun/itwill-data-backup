package basic;

import java.util.Scanner;

//가위바위보 게임 프로그램을 작성하세요.
// => 컴퓨터(난수)와 사용자(키보드)의 가위바위보 대결
// => 사용자가 이길 경우 대결을 반복실행하며 질 경우 게임 종료
// => 게임이 종료된 후 사용자가 이긴 횟수 출력
public class RpaGameApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 사용자의 이긴 횟수를 저장하기 위한 변수
		int count = 0;
		
		//가위바위보 게임 - 반복문을 이용한 반복 처리
		while(true) {
			//컴퓨터에게 가위바위보 중 하나를 제공받아 저장 >> 난수(1~3)
			// => 1: 가위, 2: 바위, 3: 보
			int computer = (int)(Math.random()*10)%3+1;
			
			//사용자에게 가위바위보 중 하나를 제공받아 저장 >> 키보드(1~3)
			// => 입력값이 1~3범위의 정수값이 아닌 경우 메세지 출력 후 재입력
			
			int user;
			// while문 안의 while문
			// 원하는 값이 나오면 나갈 수 있게 if( ) break; 사용
			while(true) {
				System.out.println("가위바위보 입력[1.가위, 2.바위, 3.보] >>");
				user=scanner.nextInt();
				if(user>=1 && user<=3) break;
				System.out.println("[에러]가위, 바위, 보 셋 중 하나만 선택 가능합니다.");
			}
			
			// 컴퓨터와 사용자가 제공한 가위바위보 출력
			System.out.print("[입력]컴퓨터 = ");
			if(computer==1) System.out.println("가위");
			else if(computer==2) System.out.println("바위");
			else if(computer==3) System.out.println("보");
			
			System.out.print("[입력]사용자 = ");
			if(user==1) System.out.println("가위");
			else if(user==2) System.out.println("바위");
			else if(user==3) System.out.println("보");

			System.out.println();
			
			//컴퓨터와 사용자의 승패를 판단하여 결과 출력
			// => 사용자가 이긴 경우 연승횟수 1증가 >> 재대결
			// => 사용자가 진 경우 반복문 종료
			
			if(computer==user) {
				System.out.println("[결과]사용자와 컴퓨터가 서로 비겼습니다.");
			} else if ((computer==1 && user==2) || (computer==2 && user==3) || (computer==3 && user==1)) {
				System.out.println("[결과]사용자가 컴퓨터에게 이겼습니다.");
				count++; //연승 횟수 증가
			} else {
				System.out.println("[결과]컴퓨터가 사용자에게 이겼습니다.");
				break;
			}
					
			
		}	//게임 반복 종료
		
		System.out.println();
		if(count==0) {
			System.out.println("[메세지]사용자가 컴퓨터에게 한번도 이기지 못했습니다.");
		} else {
			System.out.println("[메세지]사용자가 컴퓨터에게 "+count+"번 연속적으로 이겼습니다.");
		}
		
		scanner.close();
		
	}
}
