package basic;

public class IfApp {
	public static void main(String[] args) {
		int su = 40;

		// 변수값이 50이상인 경우에만 변수값 출력 (조건에 따라 선택적으로 실행, or not)
		if (su >= 50) {
			System.out.println("su = " + su);
		}
		
		System.out.println("==========================================");
		int score = 80;
		/*
		 * if(score>=60) { System.out.println("[결과]점수가 60점 이상이므로 합격입니다."); }
		 * System.out.println("==========================================");
		 * if(score<60) { System.out.println("[결과]점수가 60점 미만이므로 불합격입니다."); }
		 * System.out.println("==========================================");
		 */

		if (score >= 60) {
			System.out.println("[결과]점수가 60점 이상이므로 합격입니다.");
		} else {
			System.out.println("[결과]점수가 60점 미만이므로 불합격입니다.");
		}

		int num = 10;

		// 변수값을 홀수와 짝수로 구분하여 출력
		if (num % 2 != 0) {
			System.out.println(num + ">> 홀수");
		} else {
			System.out.println(num + ">> 짝수");
		}
		System.out.println("==========================================");

		char mun = 'O';

		// 변수값을 영문자 또는 비영문자로 구분하여 출력
		if (mun >= 'A' && mun <= 'Z' || mun >= 'a' && mun <= 'z') {
			System.out.println("[결과]" + mun + " >> 영문자");
		} else {
			System.out.println("[결과]" + mun + " >> 비영문자");
		}

		// 변수값이 0~100 범위의 유효값인지 아닌지 구분하여 출력 - 유효성 검사

		int jumsu = 88;

		if (jumsu >= 0 && jumsu <= 100) {
			//System.out.println("[결과]0~100 범위의 정상적인 값이 입력되었습니다.");
			
			//변수값에 따른 등급을 구분하여 출력
			//100~90:A, 89~80:B, 79~70:C, 69~60:D, 59~0:F
			
			// Null Character : 문자값이 존재하지 않는 문자
			char grade; // 학점을 저장하기위한 변수
			
			if (jumsu>=90) {
				grade = 'A';
			} else if (jumsu>=80) {
				grade = 'B';
			} else if (jumsu>=70) {
				grade = 'C';
			} else if (jumsu>=60) {
				grade = 'D';
			} else {
				grade = 'F';
			}
			
			System.out.println("[결과]"+jumsu+"점 >> " +grade+"학점");
		} else {
			System.out.println("[에러]0~100 범위를 벗어난 비정상적인 값이 입력되었습니다.");
		}

		/* [사용불가능] > 질문하기
		 * if(0<num<100) {
		 * 
		 * }
		 */
	}
}
