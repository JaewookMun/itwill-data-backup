package xyz.itwill10.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

// @ControllerAdvice 예외처리 메소드만 선언된 Controller 클래스에서 사용하는 어노테이션
// => 모든 컨트롤러의 요청 처리 메소드에서 발생되는 예외에 대한 처리 가능
@ControllerAdvice
public class ExceptionController {
	/*
	@ExceptionHandler(Exception.class)
	public String exceptionHandler() {
		
		return "userinfo/user_error";
	}
	*/
		/*
			Controller에 ExceptionHandler를 만들 수 있지만
			컨트롤러 안에서만 발생하는 예외만 처리할 수 있다. 
			ControllerAdvice를 사용해서 만든 ExceptionHandler는 모든 예외를 처리한다.
			=> 완성 직전 마지막에 작성하는 것을 권장.
			=> 웹브라우저에서 500 에러가 발생하지 않기 때문에 에러 메시지를 확인하여 에러를 수정할 수 없다.
			
			ControllerAdvice를 사용하면 모든 컨트롤러에서 발생하는 예외에 대한 
			ExceptionHandler를 생성할 수 있다.
			 
			때문에, 요청 처리 메소드는 예외를 직접 처리하는 것이 아니라 예외를
			Front Controller에게 전달하여 Exception handler가 처리하게 한다.
			try-catch를 사용할 필요가 없다.
			
			
			
			Today's point
			
			1. 비밀번호 암호화 (JBcryptor?)
			2. 예외처리 front 컨트롤러에 떠넘김
			3. Interceptor 클래스
		 */
}
