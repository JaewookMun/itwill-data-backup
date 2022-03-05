package xyz.itwill.exception;

// 기존 회원정보와 중복될 경우 발생되는 예외 클래스
// => 예외 클래스는 반드시 Exception 클래스를 상속받아 작성
public class ExistUserinfoException extends Exception {
	private static final long serialVersionUID = 1L;

	public ExistUserinfoException() {
		// TODO Auto-generated constructor stub
	}

	public ExistUserinfoException(String message) {
		super(message);
	}
	
		/*
			프로그램을 만들 때 발생할 수 있는 여러 예외 사항들이 존재하기 때문에
			이를 반영하기 위해서 에러클래스 생성
		 */

}
