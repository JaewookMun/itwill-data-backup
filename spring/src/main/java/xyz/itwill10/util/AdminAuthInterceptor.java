package xyz.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xyz.itwill10.dto.Userinfo;

// 인터셉터 클래스는 HandlerInterceptor 인터페이스를 상속받아 작성
// => 필요한 메소드를 오버라이드 선언하여 작성
	// 3개다 오버라이드할 필요는 없다.
// => Bean Configuration File에서 Spring Bean으로 등록
	// Spring Bean으로 등록해야 동작된다.

// 관리자 권한 관련 처리를 위한 인터셉터 클래스
// => 요청 처리 메소드 호출 전 비로그인 사용자이거나 관리자가 아닌 경우 에러페이지
public class AdminAuthInterceptor implements HandlerInterceptor  {
	// preHandle : 요청 처리 메소드 호출 전 실행될 명령을 작성하는 메소드
	// => 권한 관련 명령을 실행하기 위해 사용
	// => false 반환 : 요청 처리 메소드 미호출, true 반환 : 요청 처리 메소드 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
			// request.getRequestDispatcher("userinfo/user_r_error.jsp").forward(request, response);
			// return false;
			
			throw new Exception();
				// 예외를 발생시키는 것이 더 편리 - 프론트 컨트롤러가 예외를 받아서 예외처리
		}
		return true;
			// 실질적으로 override하게 되면 preHandle외에는 할 일이 거의 없다.
	}

	
	// postHandle : 요청 처리 메소드 호출 후 실행될 명령을 작성하는 메소드
	// => 요청 처리 메소드에서 예외가 발생된 경우 메소드 미실행
	// => 요청 처리 메소드의 반환값을 조작할 경우 사용
		// 예외가 발생되지 않을 때만 동작 - 사용할 일이 거의 없다. ModelAndView 조작할 떄 사용
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	// afterCompletion : 요청 처리 메소드 호출 후 실행될 명령을 작성하는 메소드
	// => 요청 처리 메소드에서 예외가 발생된 경우에만 메소드 실행
	// => 예외 처리를 목적으로 사용
		// ExceptionHandler가 있기 때문에 사용할 일이 없다.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
