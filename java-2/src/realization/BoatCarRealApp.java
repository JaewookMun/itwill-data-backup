package realization;

public class BoatCarRealApp {
	public static void main(String[] args) {
		//BoatCarReal boatCar = new BoatCarReal();
			//인터페이스를 이용해서 참조변수를 만들면 나중에 자식들을 바꾸기에 편리하다.
			//나중에 작업을 할때 디자인패턴상의 사유로 아래처럼
			//인터페이스 참조변수에 자식 인터페이스 정보를 저장하는 케이스가 다수 발생한다.
		BoatCar boatCar = new BoatCarReal();
		
		//묵시적 객체 형변환에 의해 자식 인스턴스의 메소드 호출
		boatCar.run();
		boatCar.navigate();
		boatCar.floating();
		
	}
}
