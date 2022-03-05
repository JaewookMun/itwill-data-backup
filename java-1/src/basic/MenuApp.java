package basic;

import java.util.Scanner;

//키보드로 메뉴 중 하나를 입력받아 선택메뉴에 대한 기능을 제공하는 프로그램을 작성하세요 - Menu Program
// => [프로그램 종료] 메뉴를 선택하기 전까지 사용자가 원하는 기능을 계속 제공
// => 선택 메뉴가 존재하지 않을 경우 에러 메세지 출력 후 재입력
public class MenuApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// '입력-처리-출력'을 반복
		System.out.println("<<학생 관리 프로그램>>");
		
		while(true) {
			//메뉴 목록 출력
			System.out.println("1.학생정보 저장");
			System.out.println("2.학생정보 변경");
			System.out.println("3.학생정보 삭제");
			System.out.println("4.학생정보 검색");
			System.out.println("5.학생정보 종료");
			
			//메뉴 입력
			System.out.println("메뉴 선택[1~5]");
			int choice=scanner.nextInt();
			
			//선택 메뉴에 대한 유효성 검사
			if(choice<1 || choice>5) { //선택 메뉴가 비정상적인 경우
				System.out.println("[에러]선택한 메뉴가 존재하지 않습니다.");
				continue;
			}
			
			//선택 메뉴에 대한 기능 제공
			if(choice==5) break; // 반복문 종료
			
			switch(choice) {
			case 1:
				System.out.println("[결과]학생정보를 성공적으로 저장하였습니다.");
				break;
			case 2:
				System.out.println("[결과]학생정보를 성공적으로 변경하였습니다.");
				break;
			case 3:
				System.out.println("[결과]학생정보를 성공적으로 삭제하였습니다.");
				break;
			case 4:
				System.out.println("[결과]학생정보를 성공적으로 검색하였습니다.");
				break;
			}
		}
		
		
		System.out.println("[메세지]학생 관리 프로그램을 종료합니다.");
		scanner.close();
		
	}
}
