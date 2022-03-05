package oop;


//실행이 목적인 클래스 - 프로그램
// => 데스크탑 어플리케이션은 반드시 main() 메소드 선언
public class MethodApp {
	//JVM에 의해 자동 호출되는 메소드
	public static void main(String[] args) {
		//객체(인스턴스:Instance)를 생성하여 참조변수에 저장
		//클래스명 참조변수=new 클래스명();
		//=> 동일 패키지의 클래스는 패키지 표현없이 클래스명만 표현하여 사용가능
		//=> 원래는 패키지를명시 예) oop.Method  (oop패키지에 있는 클래스)
		
		//=> 이렇게 사용하는 것이 불편해서 만들어진 것이 import 개념이다.
		//=> new 클래스명() : new 연산자로 클래스의 생성자(Constructor)를 호출하여 객체 생성.
		//=> 클래스명 참조변수 : 클래스로 생성된 객체의 정보를 저장하기위한 참조변수 생성
		//=> 참조변수를 이용하여 저장된 객체의 필드 또는 메소드에 접근하여 사용
		Method method=new Method();
		System.out.println("method = "+method);
		
		// method = oop.Method@4926097b
		// method는 oop팩키지의 Method클래스 @ 메모리주소(해시코드)  
		// -> 참조변수에 저장된 객체의 클래스 이름과 heap메모리 주소
		System.out.println("===========================================================");
		//메소드 호출
		//형식) 참조변수.메소드명(값,값,...);
		// => 참조변수에 저장된 객체(인스턴스)의 메소드 호출
		// => 메소드명 또는 매개변수에 값이 잘못 전달된 경우 메소드 호출 불가능
		//메소드를 호출하면 스레드(프로그램 흐름)가 메소드로 이동하여 메소드의 명령
		//실행 후 귀환
		method.displayOne();
		method.displayTwo();
		method.displayOne();
		
		//인스턴스를 통해 필요한 기능을 계속 호출할 수 있다.
		System.out.println("============================================================");
		method.printOne();
		System.out.println("============================================================");
		method.printTwo(50);
		method.printTwo(80);
		
		method.printTwo(-30);
		System.out.println("============================================================");
		method.printThree(55, 80);
		method.printThree(2, 49);
		
		method.printThree(70, 40);
		System.out.println("============================================================");
		//메소드 호출시 반환되는 결과값을 변수에 저장
		//=>반환되는 결과값을 지속적으로 사용하고자 할 경우 변수에 저장.
		int total=method.returnTot(36, 79);
		//입력 및 출력 명령은 프로그램에서 작성 - 메소드에서는 입출력 명령을 미작성
		System.out.println("메소드 호출 결과 = "+total);
		
		//메소드 호출 시 반환되는 결과값 출력 - 반환값 일시적 사용
		System.out.println("합계 = "+method.returnTot(40, 80));
		System.out.println("============================================================");
		boolean result=method.isOddEven(10); //반환값이 재사용된다면 변수 사용.
		if(result) { //result 변수값이 true인 경우
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		// if 구문의 조건식 대신 논리값을 반환하는 메소드 호출 가능
		if(method.isOddEven(11)) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		System.out.println("=============================================================");
		
		String nameResult=method.nameHello("홍길동");
		System.out.println(nameResult);
		System.out.println(method.nameHello("임꺽정"));
		System.out.println("=============================================================");
		//메소드를 호출하여 반환된 배열을 참조변수 저장 
		int[] num=method.returnArray();
		System.out.print("반환된 요소값 >> ");
		for(int temp:num) {
			System.out.print(temp+" ");
		}
		System.out.println();
		System.out.println("=============================================================");
		System.out.println("합계 = "+method.sumOne(10, 20, 30));
		//메소드의 매개변수에 값이 정상적으로 전달되지 않은 경우 메소드 호출 에러발생
		//System.out.println("합계 = "+method.sumOne(10, 20, 30, 40, 50, 60));
		System.out.println("=============================================================");
		System.out.println("합계 = "+method.sumTwo(new int[] {10,20,30}));
		System.out.println("합계 = "+method.sumTwo(new int[] {10,20,30,40,50}));
		System.out.println("=============================================================");
		System.out.println("합계 = "+method.sumThree(10,20,30));
		System.out.println("합계 = "+method.sumThree(10,20,30,40,50));
		
	}
}
