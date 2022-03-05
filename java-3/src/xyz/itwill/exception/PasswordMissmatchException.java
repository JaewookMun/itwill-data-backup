package xyz.itwill.exception;

//Exception 클래스 상속받아 예외 클래스 작성
public class PasswordMissmatchException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PasswordMissmatchException() {
		
	}
	
	public PasswordMissmatchException(String message) {
		super(message);
	}
	
}
