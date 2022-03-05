package enumerate;

public enum StringEnum {
	//상수필드의 자료형은 기본적으로 정수형(int)으로 설정
	//생성자가 선언된 경우 상수필드는 생성자를 이용하여 생성
	//=> 생성자 매개변수에 값을 전달하여 초기화 작업
	INSERT("삽입"), UPDATE("변경"), DELETE("삭제"), SELECT("검색");
	
	//상수필드의 자료형을 변경하기 위해서는 필드 선언
	//=> private final 지정자를 이용하여 선언
	//=> 필드를 이용하여 상수필드에 원하는 초기값을 저장하기 위해 생성자 선언
	private final String value; //상수필드를 표현하기 위한 필드
	
	//private final 필드를 통해 상수필드에 초기값을 저장하기 위한 생성자
	//=> 생성자는 반드시 private 지정자를 이용하여 선언
	//=> 매개변수에 전달된 값을 private final 필드에 저장하여 상수필드의 초기값 부여 가능
		//객체를 못 만들게하기 위해...
	private StringEnum(String value) {
		this.value=value;
	}

	
	//private final 필드값을 반환하는 메소드 >> Getter 메소드
	//=> Getter 메소드를 호출하면 상수필드에 저장된 초기값 반환
	public String getValue() {
		return value;
	}
	
	
}
