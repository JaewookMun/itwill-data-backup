package realization;

//인터페이스는 다른 인터페이스를 상속받아 작성 가능
//=> extends 키워드를 이용하여 상속 처리
//=> 인터페이스는 다중 상속 가능
	//인터페이스가 클래스를 상속받을 수는 없지만 인터페이스를 상속가능
public interface BoatCar extends Car, Boat {
	void floating();
}
