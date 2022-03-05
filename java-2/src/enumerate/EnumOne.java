package enumerate;

//나열형(Enumerate Type) : 상수필드를 선언하기 위한 자료형
public enum EnumOne {
	//상수필드 선언 - public static final int 생략
	//=> 상수필드에는 0부터 1씩 증가된 정수값이 자동 저장
		//선언하면 오히려 에러발생
	INSERT, UPDATE, DELETE, SELECT;
	
}
