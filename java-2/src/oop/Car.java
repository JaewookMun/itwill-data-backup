package oop;

//자동차를 표현하기 위한 클래스 
	//=> 클래스는 자동차를 표현하기위한 자료형(data type)일 뿐
//=> 클래스를 작성할 떄 필드 또는 메소드에 접근 지정자를 선언하여 접근 유무 설정
//접근 지정자(Access Modifier) : private, package, protected, public
//=> 클래스, 필드, 생성자, 메소드에 선언하여 접근 유무를 지정하는 키워드
//private : 클래스 내부에서만 접근 가능하며 외부에서는 접근 불가능하도록 설정하는 지정자
//=> 필드 선언시 사용 : 인스턴스 필드의 직접적인 접근 차단 - 은닉화(Information Hiding)
//public : 모든 패키지의 클래스에서 접근 가능하도록 설정하는 지정자
//=> 메소드 선언시 사용 : 메소드를 모든 클래스에서 접근하여 사용할 수 있도록 지정
	// 필드에 잘못된 값이 들어올 가능성 차단. (메소드는 이를 알고리즘으로 처리가 가능, 필드는 이것이 불가능..)
	//- 클래스에는 public, package만 사용가능
	//지정자 - 클래스,필드,메소드에 특정 기능을 제공하기 위해 사용
	//필드를 선언할 때는 private을 사용하여 '은닉화'하는 것이 권장된다.
	//public 없이 메소드를 선언하면 동일 패키지내에서만 접근 가능하다.
public class Car {
	//필드(Field) : 표현대상에 대한 속성 구현 - 속성값 저장
	//field역시 camel case 사용
	//=> 클래스에 선언된 모든 메소드에서 필드 접근가능
	private String aliasName;		//이름(별칭) - 고유값
	private boolean engineStatus;	//엔진상태(시동유무) - false : Off, true : On
	private int currentSpeed;		//현재속도
	//표현대상을 설계할 때는 표현대상을 구분할 수 있는 고유값을 저장하는 필드도 필요하다.
	
	/*	[Modelling]
	 *  프로그램을 위해 클래스를 만들 떄 표현대상을 명확히 구분할 수 있는
	 * 고유값을 저장할 수 있는 속성을 주는 것을 권장.
	 * e.g. 이름같은 경우는 중복될 수 있으니 이메일 or 전화번호를 회원가입시 받는 사례  
	 */
	
	//생성자(Constructor) : 객체(인스턴스)를 생성하기 위한 특별한 메소드
	// => 하나의 생성자도 선언하지 않으면 매개변수가 없는 기본생성자가 존재하는 것으로 처리 
	// 생성자가 없는 클래스는 존재하지 않는다.
	
	//메소드(Method) : 표현 대상에 대한 행위를 구현 - 명령들을 이용한 기능 구현
	//e.g.) 자동차로 이뤄질 수 있는 행동들
	// => 필드를 이용하여 표현 대상의 행위를 명령을 통해 기능으로 구현
	//	합리적 행동 / 태도.
	
	//for 자동차를 운전하는 행위
	//시등을 키는 행위를 표현한 메서드 - engineStatus 필드값 변경
	public void startEngine() {
		engineStatus=true;
		System.out.println(aliasName+"의 시동을 켰습니다.");
	}
	
	//시등올 끄는 행위를 표현한 메서드
	public void stoptEngine() {
		//클래스를 설계할 때 그냥 return할 수도 혹은 아래처럼 표현할 수도 있다.
		if(currentSpeed != 0) { //현재 속도가 0이 아닌 경우
			
			/* speedZero()가 가진 메서드와 동일하다
			currentSpeed=0;
			System.out.println(aliasName+"의 자동차를 멈췄습니다.");
			*/
			//클래스 내부에 선언된 메소드는 서로 호출가능
			// => 코드의 중복성 최소화 : 유지보수의 효율성 증가
			speedZero();
		}
		
		engineStatus=false;
		System.out.println(aliasName+"의 시동을 껐습니다.");
	}
	
	//속도를 증가시키는 행위를 표현한 메소드
	//speed에 터무니 없는 값이 들어왔을 때 대응할 수 있도록
	public void speedUp(int speed) {
		if(!engineStatus) {//엔진이 꺼져있는 경우
			System.out.println(aliasName+"의 시동이 꺼져 있습니다.");
			return;
		}
		//매개변수에 비정상적인 값이 전달된 경우 (-> 150 이상이 안나오도록 속도를 조절.)
		//매개변수에 잘못된 값이 전달되어도 이를 자동으로 교정하여 동작되도록 
		// or 메시지 출력도 가능.
		// 메소드를 중지할 수도 있겠지만 정상작동할 수 있도록 조절가능.
		// 이것은 클래스 모델링시 (메소드 설계) 반영
		// 현실세계에 존재하는 것을 프로그램으로 구현
		// 행위의 타당성이 맞지 않으면 해당 메소드는 가치가 없다.
		if(currentSpeed+speed>150) {
			speed=150-currentSpeed;
		}
		
		currentSpeed += speed;
		System.out.println(aliasName+"의 속도가 "+
		speed+"km/h 증가 되었습니다. 현재속도는 "+currentSpeed+"km/h 입니다.");
	}
	
	//속도를 감소하는 행위를 표현한 메소드
	public void speedDown(int speed) {
		if(!engineStatus) {//엔진이 꺼져있는 경우
			System.out.println(aliasName+"의 시동이 꺼져 있습니다.");
			return;
		}
		// 잘못된 값이 들어와도 현재속도 만큼 감소될 수 있도록 조정
		if(currentSpeed<speed) {
			speed=currentSpeed;
		}
		
		currentSpeed -= speed;
		System.out.println(aliasName+"의 속도가 "+
				speed+"km/h 감소 되었습니다. 현재속도는 "+currentSpeed+"km/h 입니다.");
	}
	
	//자동차를 멈추는 행위를 메소드로 표현한 메소드
	public void speedZero() {
		currentSpeed=0;
		System.out.println(aliasName+"의 자동차가 멈췄습니다.");
	}
		// 모델링해서 표현한 클래스
	
		// 원래는 프로그램의 목적이 포함되어야 함.
		// 클래스 -> 객체를 가지고 프로그램을 만들기 위해 만든다.

	//은닉화 선언된 필드를 위해 필드값을 반환하는 Getter 메소드와 필드값을 변경하는 
	//Setter 메소드를 선언 >> 캡슐화 - 필드 자료형이 boolean인 경우 is 메소드 선언.
	//캡슐화(Getter & Setter) 메소드 자동 생성 단축키
	//[Alt]+[Shift]+[S] >> 팝업메뉴 >> [R] >> 생성 메뉴 >> 필드 선택 >> Generate
		// 위 팝업메뉴는 소스메뉴와 유사하다.
		//eclipse - 'Source'를 보면 getter와 setter를 만들어주는 기능이 있다.
	
		//시스템 내부에서만 사용하는 경우 getter, setter를 안만듬.
	
	public String getAliasName() { //Getter 메소드 - 메소드명 : get필드명
		return aliasName; //필드값 반환
	}
	
	public void setAliasName(String aliasName) { //Setter 메소드 - 메소드명 : set필드명
		//매개변수로 전달되어 저장된 값으로 필드값 변경
		// => 매개변수에 전달된 값에 대한 유효성 검사
			// think. 필드를 은닉화한 것이 비정상적인 정보를 제한하기 위해서임.
		this.aliasName=aliasName; //필드값 변경
			//매개변수에 aliasName을 쓸 경우 set메서드에서 aliasName는 매개변수로 인식된다.
			//식별자는 우선 같은지역에서 먼저 찾은 후 더 먼 곳을 찾는다. (필드를 후순위로 찾음.)
			//get메소드에서 매개변수를 먼저 찾았기 때문에 매개변수가 됨.
			//this는 클래스를 의미한다. this를 사용하면 필드가 된다.
	}
	
	//은닉화 선언된 필드의 자료형이 boolean인 경우 Is 메소드로 선언
	public boolean isEngineStatus() {	//true or false 반환
		return engineStatus;
	}

	public void setEngineStatus(boolean engineStatus) {
		this.engineStatus = engineStatus;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	
}
