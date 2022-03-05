package inheritance;

public class CarApp {
	public static void main(String[] args) {
		Car car=new Car("홍길동", "싼타페");
		
		System.out.println("소유주 = "+car.getUserName());
		System.out.println("모델명 = "+car.getModelName());
		System.out.println("=============================================================");
		//Car 클래스는 Object 클래스를 상속 받기 때문에 Object 클래스의 메소드 호출 가능
		//Object.toString() : 인스턴스를 문자열로 변환하여 반환하는 메소드
		//Car 클래스에서 toString() 메소드를 오버라이드 선언하면 Object 클래스의 toString()
		//메소드는 숨겨지고 Car 클래스의 toString() 메소드 호출 - Car 인스턴스의 필드값 확인
		System.out.println("car.toString() = "+car.toString());
		
		//참조변수에 저장된 인스턴스를 출력할 경우 Object 클래스의 toString() 메소드가
		//자동 호출되어 인스턴스를 문자열로 반환받아 출력
		System.out.println("car = "+car);
		System.out.println("=============================================================");
		String name = "홍길동";
		
		//String 클래스에서 toString() 메소드를 오버라이드 선언하여 String 클래스의 toString() 메소드 호출
		//String.toString() : String 인스턴스에 저장된 문자열을 반환하는 메소드
		System.out.println("name.toString() = "+name.toString());
		//참조변수의 인스턴스를 출력할 경우 자동으로 toString() 메소드 호출
		System.out.println("name = "+name);
		System.out.println("=============================================================");
		
	}
}
