package xyz.itwill10.exception;

// 로그인에 대한 인증 실패 시를 위해 작성된 예외 클래스
public class LoginAuthFailException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String userid;
	
	public LoginAuthFailException() {
		// TODO Auto-generated constructor stub
	}

	public LoginAuthFailException(String message, String userid) {
		super(message);
		this.userid=userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
		// 필요한 정보를 저장할 수 있는 필드 생성
}
