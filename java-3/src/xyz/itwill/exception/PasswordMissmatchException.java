package xyz.itwill.exception;

//Exception Ŭ���� ��ӹ޾� ���� Ŭ���� �ۼ�
public class PasswordMissmatchException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PasswordMissmatchException() {
		
	}
	
	public PasswordMissmatchException(String message) {
		super(message);
	}
	
}
