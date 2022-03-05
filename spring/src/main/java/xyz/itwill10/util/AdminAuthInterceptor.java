package xyz.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xyz.itwill10.dto.Userinfo;

// ���ͼ��� Ŭ������ HandlerInterceptor �������̽��� ��ӹ޾� �ۼ�
// => �ʿ��� �޼ҵ带 �������̵� �����Ͽ� �ۼ�
	// 3���� �������̵��� �ʿ�� ����.
// => Bean Configuration File���� Spring Bean���� ���
	// Spring Bean���� ����ؾ� ���۵ȴ�.

// ������ ���� ���� ó���� ���� ���ͼ��� Ŭ����
// => ��û ó�� �޼ҵ� ȣ�� �� ��α��� ������̰ų� �����ڰ� �ƴ� ��� ����������
public class AdminAuthInterceptor implements HandlerInterceptor  {
	// preHandle : ��û ó�� �޼ҵ� ȣ�� �� ����� ����� �ۼ��ϴ� �޼ҵ�
	// => ���� ���� ����� �����ϱ� ���� ���
	// => false ��ȯ : ��û ó�� �޼ҵ� ��ȣ��, true ��ȯ : ��û ó�� �޼ҵ� ȣ��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
			// request.getRequestDispatcher("userinfo/user_r_error.jsp").forward(request, response);
			// return false;
			
			throw new Exception();
				// ���ܸ� �߻���Ű�� ���� �� �� - ����Ʈ ��Ʈ�ѷ��� ���ܸ� �޾Ƽ� ����ó��
		}
		return true;
			// ���������� override�ϰ� �Ǹ� preHandle�ܿ��� �� ���� ���� ����.
	}

	
	// postHandle : ��û ó�� �޼ҵ� ȣ�� �� ����� ����� �ۼ��ϴ� �޼ҵ�
	// => ��û ó�� �޼ҵ忡�� ���ܰ� �߻��� ��� �޼ҵ� �̽���
	// => ��û ó�� �޼ҵ��� ��ȯ���� ������ ��� ���
		// ���ܰ� �߻����� ���� ���� ���� - ����� ���� ���� ����. ModelAndView ������ �� ���
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	// afterCompletion : ��û ó�� �޼ҵ� ȣ�� �� ����� ����� �ۼ��ϴ� �޼ҵ�
	// => ��û ó�� �޼ҵ忡�� ���ܰ� �߻��� ��쿡�� �޼ҵ� ����
	// => ���� ó���� �������� ���
		// ExceptionHandler�� �ֱ� ������ ����� ���� ����.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
