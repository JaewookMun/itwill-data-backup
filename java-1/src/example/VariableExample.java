package example;

public class VariableExample {
	public static void main(String[] args) {
		//가로의 길이가 7이고 세로의 길이가 10인 사각형의 넓이를 계산하여 출력하세요.
		int width = 7, height = 10;
		int recArea = width*height;
		
		System.out.println("사각형 넓이는 = " +recArea);
		
		//높이가 9이고 밑변의 길이가 7인 삼각형의 넓이를 계산하여 출력하세요.
		width = 7;
		height = 9;
		double triArea = (double)(width*height)/2;
		
		System.out.println("삼각형 넓이는 = " + triArea);
		
		
		//10명 전체 몸무게가 759Kg인 경우 평균 몸무게를 계산하여 출력하세요.
		int count = 10, totalWeight = 759;
		double avgWeight = (double)totalWeight/count;
		
		System.out.println("평균 몸무게 = " +avgWeight);
				
		//이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
		//총점과 평균을 계산하여 이름, 총점, 평균을 출력하세요.
		//단, 평균은 소숫점 한자리까지만 출력하고 나머지는 절삭처리하세요.
		
		String name = "홍길동";
		int kor=89, eng=93, math=95;
		
		int total = kor+eng+math;
		double average = (double)total/3;
		
		System.out.println("이름: "+name+ ", 총점: "+total+", 평균: "+(int)(average*10)/10.);
		// 변수에 변형된 데이터를 저장하는 것은 권장되지 않고 출력할 때 조건에 맞추어 변형하는 것이 추천됨.
	}
}