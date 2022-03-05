package oop;

// 참조가 목적인 클래스 - 인스턴스(객체) 생성을 위한 클래스
public class Method {
	//클래스를 선언하면 클래스 내부에는 매개변수가 없는 생성자(Default Constructor)가 
	//선언된 것으로 인식
	
	//메소드 선언
	//메소드는 호출해야 원하는 기능을 실행할 수 있다.
	
	//클래스는 특정 프로그램에 종속되어서는 안된다. -> 사용범위가 작아진다.
	//입출력기능이 들어간 메서드는 좋은 메서드는 아니다. (넣으면 특정 프로그램에 종속됨.)
	//web과 desktop app는 입출력 기능이 다름.
	// 아래처럼 생성하면 desktop app 그것도 콘솔에서만 사용 가능...
	// 일반 프로그램 콘솔에서는 System.out.println으로 출력 가능하지만 
	// Gui desktop (e.g. 계산기) -> component
	// Android - 위젯, Web - HTML
	// 입출력행위가 들어가면 특정프로그램에서만 사용가능하다.
	//클래스의 메서드에 입출력 기능을 집어넣는 것은 권장되지 않는다.
	// -> 코드의 재사용을 위해서.
	//=> 입출력은 프로그램이 해주는것. 메서드는 처리하는 기능만 제공.
	//=> 메서드는 출력하는 기능대신 반환 (return)을 사용
	// 메서드에서 반환되는 결과를 저장하여 프로그램에서 출력.
	void displayOne() {
		System.out.println("Method 클래스의 displayOne() 메소드 호출");
	}
	
	void displayTwo() {
		System.out.println("Method 클래스의 displayTwo() 메소드 호출");
	}
	
	void printOne() {
		int tot=0;
		for(int i=1; i<=100; i++) {
			tot+=i;
		}
		System.out.println("1~100 범위의 정수들의 합계 = "+tot);
	}
	void printTwo(int num) {
		//매개변수에 전달되어 저장된 값에 대한 유효성 검사 (권장됨.) -> 실행오류를 막기위함. (원하는 결과를 얻기위해서...)
		if(num<=0) { //비정상적인 매개변수에 전달된 경우
			System.out.println("[에러]매개변수에는 0보다 큰 값이 전달되어야 됩니다.");
			return;	// 메소드 강제종료
		}
		
		int tot=0;
		for(int i=1; i<=num; i++) {
			tot+=i;
		}
		System.out.println("1~"+num+" 범위의 정수들의 합계 = "+tot);
	}
	
	void printThree(int num1, int num2) {
		/*
		if(num1>num2) {
			System.out.println("[에러]첫번째 매개변수에 전달된 값이 두번쨰 매개변수에 전달된 값보다 작아야 됩니다.");
			return;
		}
		*/
		// 잘못된 값이 입력되었을 때 강제로 종료하는 것이 알맞은 결과이다.
		if(num1>num2) {
			int temp=num1;
			num1=num2;
			num2=temp;
		}
		
		int tot=0;
		for(int i=num1; i<=num2; i++) {
			tot+=i;
		}
		System.out.println(num1+"~"+num2+" 범위의 정수들의 합계 = "+tot);
	}
	
	int returnTot(int num1, int num2) {
		if(num1>num2) {
			int temp=num1;
			num1=num2;
			num2=temp;
		}
		
		int tot=0;
		for(int i=num1; i<=num2; i++) {
			tot+=i;
		}
		//=> 메소드의 반환형과 같은 자료형의 값을 반환
		return tot;
	}
	
	//매개변수에 전달된 정수값이 홀수인 경우 false, 짝수인 경우 true 반환
	//메서드 이름이 is로 시작되면 대부분 true or false로 반환하는 메서드이다.
	boolean isOddEven(int num) {
		if(num%2 != 0) {
			return false;
		}
		return true; // 메서드가 종료되지 않을 때는 true를 반환하겠다는 의미
	}

	//매개변수로 객체를 전달받거나 객체 반환 가능
	String nameHello(String name) {
		return name+"님 안녕하세요.";
		// return name+"님 안녕하세요."; 메소드에서 return은 한개만 사용가능
	}
	
	// 값을 여러개 반환하고 싶다면 배열에 저장하여 배열을 반환해야함. (배열의 해시코드를 반환하는 개념)
	// => 원칙적으로 메소드는 값을 하나만 반환할 수 있음.
	// 배열을 반환하는 메소드 - 배열의 모든 요소값을 참조할 수 있다.
	int[] returnArray() {	// 함수 returnArray의 반환형은 int[]
		/*
		int[] array= {10,20,30,40,50};
		return array;
		*/
		
		return new int[] {10,20,30,40,50}; // 참조변수 없이 반환되는 배열을 만들 때.
		// return {10,20,30,40,50} 은 에러 발생 중괄호만 쓰면 배열이 아니다.
	}
	
	// 3개의 매개변수에 정수값을 전달받아 합계를 계산하여 반환하는 메서드
	int sumOne(int num1, int num2, int num3) {
		return num1+num2+num3;
	}
	
	//매개변수로 배열을 전달받아 배열 요소들의 합계를 계산하여 반환하는 메소드
	int sumTwo(int[] num) {
		int tot=0;
		for(int temp:num) {
			tot+=temp;
		}
		return tot;
	}
	
	// <JDK 1.5 version 이상부터>
	//매개변수 생략기호(...)를 사용한 매개변수를 선언한 경우 값을 0개 이상 전달받아
	//배열 형식으로 사용가능 - 배열처럼 처리
	// => 원하는 갯수만큼 사용가능 (0개 이상)
	int sumThree(int... num) {
		int tot=0;
		for(int temp:num) {
			tot+=temp;
		}
		return tot;
	}
	
}
