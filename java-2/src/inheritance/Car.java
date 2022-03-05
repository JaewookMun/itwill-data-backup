package inheritance;

//자동차 정보(소유자명, 모델명)를 저장하기 위한 클래스
//부모 클래스가 없는 경우 기본적으로 Object 클래스 상속
//=> Object 클래스를 제외한 모든 Java 클래스는 무조건 Object 클래스 상속
//Object : 모든 Java 클래스의 최선조 클래스
//=> Object 클래스로 생성된 참조변수에는 모든 Java 인스턴스 저장 가능
public class Car /* extends Object */{
	private String userName;
	private String modelName;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String userName, String modelName) {
		super();
		this.userName = userName;
		this.modelName = modelName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	//인스턴스 필드값을 문자열로 변환하여 반환하는 메소드
	//=> 인스턴스 필드값을 확인하기 위한 목적으로 오버라이드 선언
	@Override
	public String toString() {
		return "소유주 : "+userName+", 모델명 : "+modelName;
	}
		
}
