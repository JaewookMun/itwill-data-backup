package example;


public class IfExample {
	public static void main(String[] args) {
		//변수에 저장된 문자값을 출력하세요.
		//단, 변수에 저장된 문자값이 소문자인 경우 대문자로 변환하여 출력하세요.
		char mun='x';
		
		if (mun>='a' && mun<='z') {
			System.out.println("mun = "+(char)(mun-32));
		} else {
			System.out.println("mun = "+mun);
		}
		
		/*
		 * 'mun-32'의 결과는 int형이다.(4byte) 때문에 mun = mun-32는 에러가 생긴다.
		 * (4바이트 이하의 계산은 int형이기 때문이다.)
		 *  mun-=32; -> 자동형변환이 안일어난다.
		 */
		
		
		System.out.println("============================================================");
		//변수에 저장된 정수값이 4의 배수인지를 구분하여 출력하세요.
		int num=345644;
		
		switch (num%4) {
		case 0:
			System.out.println("변수에 저장된 값은 4의 배수입니다.");
			break;
		default:
			System.out.println("변수에 저장된 값은 4의 배수가 아닙니다.");
		}
		
		
		System.out.println("============================================================");
		//올해가 평년인지 윤년을 구분하여 출석하세요.
		// => 년도를 4로 나누어 나머지가 0인 경우 윤년
		// => 위 조건을 만족하는 년도 중 100으로 나누어 나머지가 0인 경우 평년
		// => 위 조건을 만족하는 년도 중 400으로 나누어 나머지가 0인 경우 윤년
		int year=2021;
		
		// 외워야하는 문장.
		// str = num1%4==0 && num1%100!=0 || num1%400==0 ? "윤년" : "평년";
		// (year%4==0) && (year%100==0) : 평년      // (year%4==0) && (year%400==0) : 윤년 
		
		if (year%4==0 && year%100!=0 || year%400==0) {
			System.out.println(year+"년은 윤년입니다.");
		} else {
			System.out.println(year+"년은 평년입니다.");
		}
		
				
		
		System.out.println("============================================================");
		//이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
		//총점과 평균, 학점을 계산하여 이름, 총점, 평균, 학점을 출력하세요.
		// => 국어,영어,수학 점수 중 하나라도 0~100 범위가 아닌 경우 프로그램 강제 종료	@입력받은 직후
		//    System.exit(0) : 프로그램을 강제로 종료하는 메소드	
		// => 평균을 이용한 학점 계산 : 100~90:A, 89~80:B, 79~70:C, 69~60:D, 59~0:F
		// => 평균은 소숫점 두자리까지만 출력하고 나머지는 절삭 처리 하세요.

		String name = "홍길동";
		int kor=89, eng=93, math=95;
		
		// 입력받은 직후 입력값에 대한 유효성검사(Validation) 진행 - 유효성검사를 할때 정상적이지 않으면 메시지출력
		boolean valid = false;
		
		if (kor<0 || kor>100) {
			System.out.println("[에러]0~100 범위를 벗어난 비정상적인 국어점수가 입력되었습니다.");
			valid = true;
		}
		
		if (eng<0 || eng>100) {
			System.out.println("[에러]0~100 범위를 벗어난 비정상적인 국어점수가 입력되었습니다.");
			valid = true;
		}
		
		if (math<0 || math>100) {
			System.out.println("[에러]0~100 범위를 벗어난 비정상적인 국어점수가 입력되었습니다.");
			valid = true;
		}
		
		// 조건식 대신 boolean 변수값을 이용하여 명령선택 가능
		if(valid) {	
			System.exit(0);
		}
		
		int totalScore = kor+eng+math;
		double avgScore = (double)totalScore/3;
		String grade ="";
		
		switch ((int)avgScore/10) {
		case 10:
		case 9:	grade = "A"; break;
		case 8:	grade = "B"; break;
		case 7:	grade = "C"; break;
		case 6:	grade = "D"; break;
		default: grade="F";
		}
		
		System.out.println("이름: "+name+", 총점: "+totalScore+", 평균: "+(int)(avgScore*100)/100.0+", 학점: "+grade);

		/*
		if ((kor<0 || kor>100) || (eng<0 || eng>100) || (math<0 || math>100)) {
			System.out.println("부적합한 점수입니다. 프로그램을 강제종료합니다.");
			System.exit(0);
			
		} else {
			System.out.println("이름: "+name+", 총점: "+totalScore+", 평균: "+(int)(avgScore*100)/100.0+", 학점: "+grade);
		}
		*/
		
		/*		<<  강사님 풀이 >>
		 * 변수 선언부 바로밑에 코드작성
		 * if (!(kor>=0 && kor<=100) || (eng<0 || eng>100) || (math<0 || math>100)){
		 * "[에러]0~100 범위를 벗어난 비정상적인 영어점수가 입력되었습니다."
		 * System.exit(0); // 프로그램 종료
		 * }
		 * 
		 * 위 행처럼 작성 안하고 국어, 영어, 수학점수별로 구분하여 코드를 작성하여 어떤 값을 잘못 입력했는지
		 * 확인시켜줌
		 */
		
		
		
		System.out.println("============================================================");
	}
}









