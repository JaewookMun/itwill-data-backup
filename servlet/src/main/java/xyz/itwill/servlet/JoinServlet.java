package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 입력 페이지(form.html)에서 전달된 입력값을 반환받아 클라이언트에게 전달하는 서블릿
@WebServlet("/join.itwill")
public class JoinServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		// 입력 페이지에서(form.html)의 form 태그를 이용하여 [POST] 방식으로 요청하여 실행되는 서블릿
		// => 서블릿을 [GET] 방식으로 요청한 경우 비정상적인 요청
		// 웹프로그램을 비정상적인 방법으로 요청한 경우 클라이언트에게 에러코드를 전달하거나
		// 에러페이지로 이동되도록 처리
			// c.f. 예) 로그인 하지 않은 사용자가 로그인된 사용자가 접근할 수 있는 프로그램에 접근할 경우 에러 제공
		// HttpServletRequest.getMethod() : 클라이언트의 요청방식을 반환하는 메소드
		if(request.getMethod().equals("GET")) { // 클라이언트가 [GET] 방식으로 요청한 경우  // 대문자로 표기
			// HttpServletResponse.sendError(int sc) : 클라이언트에게 에러코드
			// (StatusCode - 4xx or 5xx)를 전달하는 메소드
			// 에러코드는 HttpServletResponse 인터페이스의 상수필드(Constant Field)로 제공
				// statusCode는 줄여서 sc라고 많이 말한다.
				// 1xx 처리중 2xx 완료 3xx 재신청 | 4xx 클라이언트 요청오류 5xx 클라이언트 요청실행 오류
			// response.sendError(HttpServletResponse.SC_BAD_REQUEST); // 400 요청방식이 잘못되었다는 것을 알려줄 때 사용 가능
			// response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // 405 상태코드 : Method not allowed
				// form 태그를 이용하지 않으면 다 get방식이다. (url주소입력 또한 get방식)
			// return; // 서블릿 종료
			
			// HttpServletResponse.sendRedirect(String url) : 클라이언트에게 301 상태코드와
			// URL 주소를 전달하는 메소드
			// => 상태코드 301 : 전달받은 URL 주소의 웹프로그램을 요청하기 위한 상태코드
			// => 클라이언트는 브라우저의 URL 주소를 변경하고 요청한 웹프로그램의 응답결과 출력 - 페이지 이동
			// => 서블릿을 이용한 페이지 이동 방법 - 리다이렉트 이동
				// 제공한 URL주소로 클라이언트가 다시 요청하게 한다.
			response.sendRedirect("error.html");
			return;
		}
		
		// POST 방식으로 웹프로그램을 요청한 경우 리퀘스트 메세지의 BODY에 입력값을 저장하여 전달
		// => 리퀘스트 메세지의 BODY의 기본 캐릭터셋은 ISO-8859-1(서유럽어)로 설정
		// HttpServletRequest.setCharacterEncoding(String encoding) : 리퀘스트 메세지의 BODY로
		// 전달되는 값에 대한 캐릭터셋을 변경하는 메소드
			// Apache Tomcat10.0에서는 없어도 입력값들이 utf-8로 전달
			// 8.0이나 9.0의 경우 깨져서 전달된다.
			// request의 body는 원래 비어있음.
			// get방식은 필요 없다.
		
		request.setCharacterEncoding("utf-8"); // post의 리퀘스트 바디내용을 읽기 위해 필요.
			// 없으면 읽을 때 서유럽어로 읽기 때문에 깨져버림.
			// GET 방식은 필요없음.
		
		// 서블릿 요청에 대한 전달값(사용자 입력값)을 반환받아 저장
		// HttpServletRequest.getParameter(String name) : 웹프로그램 요청 시 전달된 값을 얻어와
		// 반환하는 메소드 - 전달값은 무조건 문자열(String)로 반환
		// => GET : QueryString으로 전달된 값의 이름(식별자)을 이용하여 전달값 반환
		// => POST : 입력태그의 name 속성값을 이용하여 전달값 반환
		// 이름(name)에 해당하는 전달값이 존재하지 않을 경우 null을 반환하며 GET 방식에서
		// 이름만 있고 전달값이 없는 경우 NullString 반환
			// 웹에서 값을 전달할 때는 이름을 이용해서 전달한다.
		String id=request.getParameter("id");

			// 행안부 보안문서 - JS에서 유효성 체크를 할수 있지만 서버측에서도 유효성검사 진행을 권장.
			// 보안상 JavaScript를 믿을 수 없기 때문에 java에서도 검증한다고 보면된다.
			// 국가기관 사이트는 서버측에서도 중요한 값에 대해 검증하는 것을 규칙으로 규정. 
			// 스프링에서 더 쉽게 하는 방법이 있음.
		if(id==null || id.equals("")) {// 전달값이 없는 경우 - 비정상적인 요청
			// 웹문서에서 JS로 1차적으로 입력값에 대한 유효성검사를하여 submit을 하지 못하도록해야함.
			response.sendRedirect("error.html");
				// response.sendRedirect("/servlet/error.html");
			return;
		}
		
		if(!Pattern.matches("^[a-zA-Z]\\w{5,19}$", id)) { // 전달값이 형식에 맞지 않을 경우 - 비정상적인  요청
			
		}
		
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		String sex=request.getParameter("sex");
		String job=request.getParameter("job");
		// 같은 이름으로 전달된 값이 있는 경우 첫번째 전달값만 반환받아 저장
		// String hobby=request.getParameter("hobby");
		// HttpServletRequest.getParameterValues(String name) : 같은 이름으로 전달되는
		// 모든 값들을 문자열 배열로 반환하는 메소드
		// => 다중 선택 기능의 입력태그로 전달되는 값을 반환받을 때 사용하는 메소드
			// e.g. checkbox, select (multiple 기능이 있는 경우)
			// 권장x
		String[] hobby=request.getParameterValues("hobby");
		
		String profile=request.getParameter("profile");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>회원정보 확인</h1>");
		out.println("<hr>");
		out.println("<p>아이디 = "+id+"</p>");
		out.println("<p>비밀번호 = "+pass+"</p>");
		out.println("<p>이름 = "+name+"</p>");
		out.println("<p>주소 = "+addr+"</p>");
		out.println("<p>성별 = "+sex+"</p>");
		out.println("<p>직업 = "+job+"</p>");
		// out.println("<p>취미 = "+hobby+"</p>");
		if(hobby==null) {
			out.println("<p>취미 = 미선택</p>");
		} else {
			out.println("<p>취미 = ");
			for(int i=0; i<hobby.length; i++) {
				out.println(hobby[i]);
				if(i<hobby.length-1) {// 배열의 마지막 요소가 아닌 경우
					out.println(",");
				}
			}
			out.println("</p>");
		}
		// textarea 태그로 입력되어 전달된 값은 엔터(Enter)를 <br> 태그로 변환하여 출력
			//  DB에 저장할 때는 그대로 저장하지만 출력할 때는 형태를 갖추어줘야함.
		out.println("<p>자기소개 <br>"+profile.replace("\n", "<br>")+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
