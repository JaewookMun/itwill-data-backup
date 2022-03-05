package xyz.itwill10.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

// @ControllerAdvice ����ó�� �޼ҵ常 ����� Controller Ŭ�������� ����ϴ� ������̼�
// => ��� ��Ʈ�ѷ��� ��û ó�� �޼ҵ忡�� �߻��Ǵ� ���ܿ� ���� ó�� ����
@ControllerAdvice
public class ExceptionController {
	/*
	@ExceptionHandler(Exception.class)
	public String exceptionHandler() {
		
		return "userinfo/user_error";
	}
	*/
		/*
			Controller�� ExceptionHandler�� ���� �� ������
			��Ʈ�ѷ� �ȿ����� �߻��ϴ� ���ܸ� ó���� �� �ִ�. 
			ControllerAdvice�� ����ؼ� ���� ExceptionHandler�� ��� ���ܸ� ó���Ѵ�.
			=> �ϼ� ���� �������� �ۼ��ϴ� ���� ����.
			=> ������������ 500 ������ �߻����� �ʱ� ������ ���� �޽����� Ȯ���Ͽ� ������ ������ �� ����.
			
			ControllerAdvice�� ����ϸ� ��� ��Ʈ�ѷ����� �߻��ϴ� ���ܿ� ���� 
			ExceptionHandler�� ������ �� �ִ�.
			 
			������, ��û ó�� �޼ҵ�� ���ܸ� ���� ó���ϴ� ���� �ƴ϶� ���ܸ�
			Front Controller���� �����Ͽ� Exception handler�� ó���ϰ� �Ѵ�.
			try-catch�� ����� �ʿ䰡 ����.
			
			
			
			Today's point
			
			1. ��й�ȣ ��ȣȭ (JBcryptor?)
			2. ����ó�� front ��Ʈ�ѷ��� ���ѱ�
			3. Interceptor Ŭ����
		 */
}
