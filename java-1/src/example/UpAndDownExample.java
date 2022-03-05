package example;

import java.util.Scanner;

//컴퓨터로부터 제공받은 정수 난수값을 키보드로 입력하여 맞추는 프로그램을 작성하세요
// => 1~100 범위의 정수 난수값을 제공받도록 작성
// => 난수값을 맞출 수 있는 기회는 10번만 제공되도록 작성
// => 키보드 입력값이 1~100범위가 아닌 경우 메세지 출력 후 재입력
// => 난수와 입력값이 같은 경우 입력 횟수 출력 후 프로그램 종료
// => 난수값과 입력값이 다른 경우 "큰값 입력" 또는 "작은값 입력" 형식의 메세지 출력
// => 난수값을 10번 안에 맞추지 못한 경우 난수값이 출력되도록 작성
public class UpAndDownExample {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// => 1~100 범위의 정수 난수값
		int random = (int)(Math.random()*100)+1;
		int count = 0;
		
		System.out.println("1~100 범위의 임의의 정수가 생성되었습니다. 숫자를 선택하세요. "+"\n단, 기회는 10회 입니다.");
		// 10번의 기회
		
		/*
		 * 10번의 입력기회를 제공하는 반복문
		 * => 정수값을 입력받아 난수값과 비교
		 * 정답 관련 상태정보를 저장하기 위한 변수 선언
		 * => false : 정답을 맞추지 못한 상태, true : 정답을 맞춘 상태
		 * boolean result = false;
		 */
		
		
		loop:
		while(true) {
			for(int i=1; i<=10; i++) {
				System.out.print("숫자를 골라주세요 >> ");
				int input = scanner.nextInt();
				count++;
				
				// 범위에서 벗어난 경우
				if(input<1 || input>100) {
					System.out.println("주어진 범위[1~100]를 벗어났습니다. 재입력해주세요.");
					continue;
				}
				// 범위안에 들어간 경우
				if(input==random) {
					System.out.println("축하합니다. "+count+"번 시도 후 맞췄습니다.");
					break loop;
				} else if(input>random) {
					System.out.println(input+"보다 작은값을 입력해 보세요");
				} else {
					System.out.println(input+"보다 큰값을 입력해 보세요");
				}
				
				System.out.println();
				
			}
			System.out.println("주어진 기회를 모두 소진하였습니다. "+"\n생성된 숫자는 "+random+"입니다.");
			break;
		}
		scanner.close();
		
	}
}
