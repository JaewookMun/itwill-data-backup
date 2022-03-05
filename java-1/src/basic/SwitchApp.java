package basic;

public class SwitchApp {
	public static void main(String[] args) {
		//int choice=1;
		//int choice=2;
		int choice=3;
		
		switch(choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
		case 3:
			System.out.println("화성으로 이동합니다.");
		}
		System.out.println("=================================================");
		choice=4;
		
		switch(choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
		case 3:
			System.out.println("화성으로 이동합니다.");
		}
		System.out.println("=================================================");
		choice=4;
		
		switch(choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
		case 3:
			System.out.println("화성으로 이동합니다.");
		//모든 case 값이 맞지 않을 경우 무조건 실행되는 명령을 작성하는 위치 표현
		default:
			System.out.println("지구로 이동합니다.");
		}
		System.out.println("=================================================");
		choice=1;
		switch(choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
			break;//switch 구문 강제 종료
		case 3:
			System.out.println("화성으로 이동합니다.");
		default:
			System.out.println("지구로 이동합니다.");
		}
		System.out.println("=================================================");
		int jumsu=88;
		
		//변수값이 0~100 범위의 유효값인지 아닌지를 구분하여 출력
		if(jumsu>=0 && jumsu<=100) {
			//System.out.println("[결과]0~100 범위의 정상적인 값이 입력 되었습니다.");
			
			//변수값에 따른 등급을 구분하여 출력
			//100~90 : A, 89~80 : B, 79~70 : C, 69~60 : D, 59~0 : F
			String grade="";
			switch(jumsu/10) {
			case 10:
			case 9:	grade="A"; break;
			case 8: grade="B"; break;
			case 7: grade="C"; break;
			case 6: grade="D"; break;
			default: grade="F";
			}
			
			System.out.println("[결과]"+jumsu+"점 >> "+grade+"학점");
		} else {
			System.out.println("[에러]0~100 범위를 벗어난 비정상적인 값이 입력 되었습니다.");
		}
		System.out.println("=================================================");
		String kor="둘";
		//String eng;
		String eng="";
		
		//JDK1.7 이상에서는 switch 구문으로 문자열을 비교하여 명령 선택 실행 가능 
		switch(kor) {
		case "하나": eng="One"; break;
		case "둘": eng="Two"; break;
		case "셋": eng="Three"; break;
		}
		
		System.out.println("[결과]"+kor+" = "+eng);
		System.out.println("=================================================");
	}
}

