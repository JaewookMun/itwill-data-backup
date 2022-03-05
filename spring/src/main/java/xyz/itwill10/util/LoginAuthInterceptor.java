package xyz.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

// 로그인 관련 권한 처리를 위한 인터셉터 클래스
// => 비로그인 사용자인 경우 에러 페이지로 이동 처리
	// 로그인 페이지로 이동하게끔 처리할 수도 있다. - 모두 에러페이지로 보낼 필요는 없다.
public class LoginAuthInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session=request.getSession();
		
		if(session.getAttribute("loginUserinfo")==null) {
			throw new Exception();
		}
		
		return true;
	}

}
