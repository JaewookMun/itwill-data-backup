package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 클라이언트에서 보내온 쿠키를 읽어 클라이언트에게 쿠키값을 전달하는 서블릿
// => 클라이언트는 요청 URL 주소의 접속서버를 이용하여 해당서버 정보로 모든 쿠키를 무조건 전달
	// 리퀘스트 메세지의 해드로
@WebServlet("/read.itwill")
public class CookieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 클라이언트에서 보내온 모든 쿠키를 반환받아 저장
		// HttpServletRequest.getCookies() 클라이언트에서 보내온 모든 쿠키를 Cookie
		// 인스턴스 배열로 반환하는 메소드
		Cookie[] cookies = request.getCookies();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 읽기</h1>");
		out.println("<hr>");
		if(cookies==null) {// 클라이언트에서 보내온 쿠키가 없는 경우
			out.println("<p>네 안에 쿠키 없다. </p>");
			
		}else {
			String id="";
			String count ="";
			
			// 클라이언트에서 보내온 쿠키 중 원하는 쿠키의 쿠키값만 반환받아 저장
			for(Cookie cookie:cookies) {
				// Cookie.getName() : 쿠키에 저장된 쿠키명을 반환하는 메소드
				if(cookie.getName().equals("id")) {
					// Cookie.getValue() : 쿠키에 저장된 쿠키값을 반환하는 메소드
					id=cookie.getValue();
				} else if(cookie.getName().equals("count")) {
					count=cookie.getValue();
				}
			}
			
			// 쿠키값을 클라이언트에게 전달
			if(!id.equals("")) {// 쿠키값이 있는 경우
				out.println("<p> 아이디 = "+id+"</p>");
			}

			if(!count.equals("")) {// 쿠키값이 있는 경우
				int cnt=Integer.parseInt(count)+1;
				out.println("<p>요청횟수 = "+cnt+"</p>");
				
				// Cookie 인스턴스를 생성하여 클라이언트에게 전달
				// => 쿠키명이 같은 경우 기존 쿠키값 대신 새로운 쿠키값으로 변경
				Cookie cookie=new Cookie("count", cnt+"");
				cookie.setMaxAge(24*60*60);
				response.addCookie(cookie);
					// 쿠키를 만들어서 클라이언트에게 전달
					// 동일한 이름의 쿠키를 만들어서 전달하면 덮어씌우기가 된다. overwrite
			}
		}
		out.println("<hr>");
		out.println("<p><a href='create.itwill'>쿠키 전달</a></p>");
		out.println("<p><a href='remove.itwill'>쿠키 제거</a></p>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
