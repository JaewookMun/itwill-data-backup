package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 세션을 바인딩하여 클라이언트에게 세션정보를 전달하는 서블릿
// 세션(Session) : 서버(웹프로그램)와 클라이언트와의 연결 지속성을 제공하기 위해 서버에
// 저장하는 값 - 세션 아이디로 클라이언트를 구분하여 세션값(인스턴스) 저장
// 세션 바인딩(Session Binding) : 세션을 웹프로그램에서 사용할 수 있도록 연결하는 작업 - WAS에 의해 처리
// 클라이언트에서 JSESSIONID 이름의 쿠키를 제공하지 않은 경우에는 세션을 생성하여 바인딩 처리
// => 생성된 세션의 아이디(식별자)를 JSESSIONID 이름의 쿠키값으로 저장하여 클라이언트에게 전달
// 클라이언트에서 JSESSIONID 이름의 쿠키를 제공한 경우 세션 트렉킹 후 바인딩 처리
// => 세션 트렉킹 후 검색된 세션이 없는 경우 세션을 생성하여 바인딩 처리
// 세션 트렉킹(Session Tracking) : 클라이언트에서 제공된 JSESSIONID의 쿠키값을 서버에 존재하는
// 세션의 아이디와 비교하여 검색하는 작업

	// 세션에 너무 많은 값을 저장하면 서버에 부담을 준다. - 세션은 서버메모리만 사용하기 때문에...
	// 보안을 요하는 정보(권한 등)를 세션에 저장하고 다른 정보는 쿠키에
	// 쿠키는 무조건 문자열만 저장
	// 클라이언트 별로 Session을 구분하여 생성
	// 서버에는 클라이언트들을 위한 여러 세션이 존재함. 클라이언트에 해당하는 세션을 찾아서 사용하는 것을 바인딩이라고 한다.
	
@WebServlet("/session.itwill")
public class SessionServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// HttpServletRequest.getSession() : 바인딩된 세션(HttpSession 인스턴스)를 반환하는 메소드
		// => HttpSession 인스턴스를 생성하여 바인딩하거나 기존 HttpSession 인스턴스를 바인딩하여 반환
		// 세션이 생성되어 바인딩된 경우 생성된 세션의 식별자(ID)를 JSESSIONID 쿠키로 클라이언트에게 전달
		// => JSESSIONID 쿠키는 기본적으로 유지시간이 -1로 설정되어 브라우저 종료시 소멸
		// HttpSession : 세션을 저장하기 위한 인스턴스 - WAS에 의해 관리
			// 직접 만들지 않아도 되며 자동으로 관리된다.
		HttpSession session = request.getSession();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>세션(Session)</h1>");
		out.println("<hr>");
		// HttpSession.isNew() : 세션을 트렉킹하여 바인딩 한 경우 false 반환, 세션을 생성하여
		// 바인딩된 경우 true를 반환하는 메소드
		if(session.isNew()) {
			out.println("<p>세션을 생성하여 바인딩 하였습니다.</p>");
		} else {
			out.println("<p>세션을 트렉킹하여 바인딩 하였습니다.</p>");
		}
		
		// HttpSession.getId() : 바인딩된 세션의 식별자를 반환하는 메소드
		out.println("<p>세션 아이디 = "+session.getId()+"</p>");
			// JSESSIONID를 의미함.
		
		// HttpSession.getCreationTime() : 바인딩된 세션이 생성된 시간(TimeStamp)을 반환하는 메소드
		out.println("<p>세션 생성시간 = "+session.getCreationTime()+"</p>");
		
		// HttpSession.getMaxInactiveInterval() : 바인딩된 세션의 유지시간(초)을 반환하는 메소드
		// => 세션 유지시간을 변경하지 않은 경우 기본값은 1800초(30분)으로 설정
		out.println("<p>세션 유지시간 = "+session.getMaxInactiveInterval()+"</p>");

		// HttpSession.setAttribute(String name, Object value) : 바인딩된 세션에 세션값을 저장하는 메소드
		// => 세션의 속성명(AttributeName - String)과 속성값(AttributeValue - Instance)을 하나로 묶어서 저장
		// => 세션을 바인딩한 모든 웹프로그램에서 속성명을 이용해 속성값을 반환받아 사용 - 인스턴스 공유
		session.setAttribute("now", new Date());
		
		// HttpSession.getAttribute(String name) : 바인딩된 세션에 저장된 속성값(인스턴스)를
		// 속성명으로 반환하는 메소드
		// => 속성값은 Object 타입의 인스턴스로 반환되므로 명시적 객체 형변환 처리하여 저장
		// => 속성명에 대한 속성값이 없는 경우 null 반환
			// 속셩명을 이용해서 속성값을 반환
		Date now = (Date)session.getAttribute("now");
		out.println("<p>세션에 저장된 인스턴스 = "+now+"</p>");

		// HttpSession.removeAttribute(String name) : 바인딩된 세션에 저장된 속성값(인스턴스)를
		// 속성명으로 제거하는 메소드
		session.removeAttribute("now");

		// HttpSession.invalidate() : 바인딩된 세션을 언바인딩(UnBinding)하고 제거하는 메소드 - 세션 제거
			// 세션자체를 없앤다.
		// session.invalidate();
		
		out.println("</body>");
		out.println("</html>");
		
			// 로그인에 성공하면 세션에 권한에 대한 정보를 저장한다.
			// -> 세션에 권한정보를 저장해서 접근할 수 있는 페이지를 제할할 수 있다.
			// 세션 굉장히 중요
	}
}
