package xyz.itwill10.exception;

// 회원정보의 변경,삭제,검색 시 아이디의 회원정보가 없는 경우 
public class UserinfoNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UserinfoNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public UserinfoNotFoundException(String message) {
		super(message);
	}
	
}
