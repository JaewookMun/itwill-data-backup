package oop;

//Car 클래스를 이용하여 작성된 프로그램
public class CarApp {
	public static void main(String[] args) {
		//클래스로 객체(인스턴스)를 생성하여 참조변수에 저장
		//형식) 클래스명 참조변수=new 클래스명();
		// => 객체(인스턴스)를 생성하면 인스턴스 필드에는 기본값이 자동으로 저장되어 초기화된다. 
		// => 기본값 - 숫자형:0, 논리형:false, 참조형: null
		Car carOne = new Car();
		Car carTwo = new Car();
		System.out.println("carOne = "+carOne);
		System.out.println("carTwo = "+carTwo);
		/*
		 * 동일한 클래스를 통해 서로 다른 객체가 생성된다.
		 * carOne = oop.Car@4926097b
		 * carTwo = oop.Car@762efe5d
		 */
		System.out.println("==================================================");
		//참조변수를 이용하여 참조변수에 저장된 객체(인스턴스)의 요소에 접근하여 사용
		// => . 연산자를 이용하여 객체(인스턴스)의 요소에 접근
			// 기본값이 싫으면 필드에 접근하여 바꿀 수 있음.
		//문제점) 인스턴스로 필드에 직접적인 접근을 허용할 경우 비정상적인 값 저장에
		//대한 제한(limit)을 할 수 없어 실행결과가 잘못되는 오류발생 가능
		//해결법) 인스턴스로 필드에 직접적인 접근을 허용하지 않도록 필드의 은닉화 처리
		// => 은닉화 선언된 필드에 접근할 경우 에러 발생 The field ' ' is not visible.
		//=> Getter 메소드와 Setter 메소드를 호출하여 필드를 간접적으로 접근하여 제어
		//carOne.aliasName="티코";
		carOne.setAliasName("티코"); //Setter 메소드를 호출하여 필드값 변경
		//carOne.engineStatus=false;
		carOne.setEngineStatus(false);
		//carOne.currentSpeed=0;
		carOne.setCurrentSpeed(0);
		
		//System.out.println("첫번째 자동차의 별칭 = "+carOne.aliasName);
		//Getter 메소드를 호출하여 필드값을 반환받아 사용
		System.out.println("첫번째 자동차의 별칭 = "+carOne.getAliasName());
		//System.out.println("첫번째 자동차의 엔진상태 = "+carOne.engineStatus);
		System.out.println("첫번째 자동차의 엔진상태 = "+carOne.isEngineStatus());
		//System.out.println("첫번째 자동차의 현재속도 = "+carOne.currentSpeed);
		System.out.println("첫번째 자동차의 현재속도 = "+carOne.getCurrentSpeed());
		System.out.println("==================================================");
		//carTwo.aliasName="싼타페";	// aliasName은 null이 들어가 있으니 지정
		carTwo.setAliasName("싼타페");
		
		//System.out.println("두번째 자동차의 별칭 = "+carTwo.aliasName);
		System.out.println("두번째 자동차의 별칭 = "+carTwo.getAliasName());
		//System.out.println("두번째 자동차의 엔진상태 = "+carTwo.engineStatus);
		System.out.println("두번째 자동차의 엔진상태 = "+carTwo.isEngineStatus());
		//System.out.println("두번째 자동차의 현재속도 = "+carTwo.currentSpeed);
		System.out.println("두번째 자동차의 현재속도 = "+carTwo.getCurrentSpeed());
		// => 객체(인스턴스)를 생성하면 인스턴스 필드에는 기본값이 자동으로 저장되어 초기화된다. 
		// 필드내용을 직접 바꾸지 않아도 기본값이 인스턴스가 생성된 순간 기본값이 저장됨
		System.out.println("==================================================");
		//객체(인스턴스)를 이용하여 메소드 호출 - 기능 구현
			//메서드를 호출할 때도 순서가 있다. - 차례대로 호출하지 않았을 때 동작되지 않는 조건 추가.
		carOne.startEngine();
		carOne.speedUp(30);
		carOne.speedUp(50);
		carOne.speedDown(40); // 잘못된 값이 들어왔을 때 메소드가 동작되지 않도록 해야함.
		carOne.speedZero();
		carOne.stoptEngine();
		System.out.println("==================================================");
		// 객체가 가진 필드나 메서드를 활용하여 프로그래밍
	}
}
