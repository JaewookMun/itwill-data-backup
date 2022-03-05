package association;

public class CarApp {
	public static void main(String[] args) {
		//엔진 생성
		Engine engine=new Engine();
		//engine.engineDisplay();
		engine.setFualType("경유");
		engine.setDisplacement(2000);
		
		//자동차 생성
		Car carOne=new Car();
		//carOne.carDisplay();
		
		carOne.setModelName("쏘렌토");
		carOne.setProductionYear(2018);
		//자동차에 엔진 포함 - Setter 메소드를 호출하여 포함 관계 성립
		carOne.setCarEngine(engine);

		carOne.carDisplay();
		System.out.println("==========================================");
		//자동차 생성 - 엔진 포함
		//=> 생성자를 이용하여 포함관계 성립
		Car carTwo=new Car("싼타페", 2020, new Engine("휘발유", 3000));
		carTwo.carDisplay();
		System.out.println("==========================================");
		System.out.println(carOne.getModelName()+"의 엔진 정보 >> ");
		engine.engineDisplay();
		System.out.println("==========================================");
		System.out.println(carTwo.getModelName()+"의 엔진 정보 >> ");
		//carTwo.getCarEngine() : 참조필드에 저장된 Engine 인스턴스 반환
		//=> 반환받은 포함 관계의 인스턴스를 이용하여 메소드 호출
			//참조변수에 저장하지 않고 이처럼 직접 호출하는 경우가 많다. - 참조변수를 많이 사용할 필요 없음.
			//Car클래스에서 Engine클래스의 메소드를 호출할 수 있다.
		carTwo.getCarEngine().engineDisplay();
		System.out.println("==========================================");
		
	}
}
