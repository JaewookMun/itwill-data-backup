package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.exception.PasswordMissMatchException;
import xyz.itwill.exception.UserinfoNotFoundException;
import xyz.itwill.service.UserinfoService;

// 클라이언트가 [/login.do]를 요청한 경우 동작되는 모델 클래스
// => 인증정보를 전달받아 USERINFO 테이블에 저장된 회원정보와 비교하여 인증처리 기능 제공
// => 인증 성공 : 세션에 권한 관련 정보를 저장하고 [loginForm.do]로 리다이렉트 이동하기 위해 정보 반환
// => 인증 실패 : [user_login.jsp]로 포워드 이동하기 위해 정보 반환 - JSP 문서에 메세지와 아이디 제공
	/*
		'user_login.jsp'가 client의 권한상태에 따라 다른 화면을 보여주기 때문에 loginForm을 재요청 
		비회원 - 로그인 창 / 회원 - 환영페이지 역할 수행
	 */
public class LoginModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		
		// 요청에 대한 처리시 발생되는 모든 예외를 잡아 예외처리
		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception(); // 인위적 예외 발생
					// catch가 잡아내어 error 페이지로 이동처리
			}
			
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
				// 아이디와 비밀번호를 user_login_action과 똑같이 처리해도 되지만 다른 방식으로 처리.
			
			// 모델 클래스의 요청 처리 메소드는 서비스 클래스의 메소드를 호출하여 요청 처리
			// UserinfoService 클래스의 인증 처리 메소드 호출
			// => 서비스 클래스의 메소드에서 예외가 발생된 경우 인증 실패
			UserinfoService.getService().auth(userid, password);
			
			// 서비스 클래스의 메소드를 호출하여 예외가 발생되지 않은 경우 인증 성공
			// => 세션에 권한 관련 정보를 속성값으로 저장
			HttpSession session=request.getSession(); // 세션을 바인딩하여 저장
				// JSP에서는 세션이 자동 바인딩되지만 서블릿에서는 자동바인딩 되지 않는다.
			session.setAttribute("loginUserinfo", UserinfoService.getService().getUserinfo(userid));
			
			actionForward.setForward(false);
			actionForward.setPath("loginForm.do");
		} catch (UserinfoNotFoundException | PasswordMissMatchException e) { // JDK1.7 이상
				// catch 에서 여러개의 Exception 처리는 jdk1.7 이상에서 가능
			// Request Scope : 스레드가 이동되는 JSP 문서에서만 속성값으로 저장된 인스턴스를
			// 반환받아 사용가능
			request.setAttribute("message", e.getMessage());
			request.setAttribute("userid", request.getParameter("userid"));
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_login.jsp");
		} catch (Exception e) { // 모든 발생 예외에 대한 처리 - 에러페이지로 리다이렉트 이동
			System.out.println("[예외]메세지 = "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		
		return actionForward;
	}

}
