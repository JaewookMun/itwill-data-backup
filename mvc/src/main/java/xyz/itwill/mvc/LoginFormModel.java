package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 클라이언트가 [/loginForm.do]를 요청한 경우 동작되는 모델 클래스
// => [user_login.jsp]로 포워드 이동하기 위한 정보 반환
public class LoginFormModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		actionForward.setForward(true);
		actionForward.setPath("model_two/user_login.jsp");
		
		return actionForward;
	}

		// 모든 페이지 요청은 controller를 통해 진행된다.
		// 아직 jsp 문서가 WEB-INF나 META-INF에 저장되어있지 않지만
		// 향후에는 WEB-INF나 META-INF에 저장하여 숨김처리 한다.
}
