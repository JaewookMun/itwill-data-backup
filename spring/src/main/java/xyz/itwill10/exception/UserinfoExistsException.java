package xyz.itwill10.exception;

import xyz.itwill10.dto.Userinfo;

// ȸ����Ͻ� ����ڰ� �Է��� ���̵� �̹� �����ϴ� ��츦 ����Ͽ� �ۼ��� ����Ŭ����
public class UserinfoExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	// ���� ó���� �ʿ��� ���� �����ϱ� ���� �ʵ�
	// => ����ڰ� �Է��� ȸ�������� �����ϱ� ���� �ʵ�
		// �޼����� �����ϴ� �ʵ�� �θ�Ŭ������ �̹� ����
	private Userinfo userinfo;
	
	public UserinfoExistsException() {
		
	}
	
		// ���ܸ� ó���ϱ� ���� ������ �޾� ó���ϱ� ���� ������ ����
	public UserinfoExistsException(String message, Userinfo userinfo) {
		super(message);
		this.userinfo=userinfo;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	
}