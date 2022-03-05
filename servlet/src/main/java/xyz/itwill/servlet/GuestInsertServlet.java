package xyz.itwill.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

// 입력페이지(insert.html)에서 전달된 방명록 게시글을 반환받아 GUEST 테이블에 저장하고
// 출력페이지(select.itwill)를 요청하여 이동하는 정보를 전달하는 서블릿 - 처리페이지(저장)
	// html페이지를 만들어서 보내주지 않는다. (자료의 처리만 진행하는 프로그램)
@WebServlet("/insert.itwill")
public class GuestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비정상적인 요청에 대한 처리
		if(request.getMethod().equals("GET")) {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
		
		// 리퀘스트 메세지의 바디에 저장된 입력값에 대한 캐릭터셋 변경
			// POST로 들어오는 값들을 어떻게 읽어들일 것인지 설정한다.
		request.setCharacterEncoding("utf-8");
		
		// 전달값(입력값)을 반환받아 저장
		// => 전달값의 앞 또는 뒤의 공백을 제거한 후 저장
		// => XSS 공격에 대한 방어를 위해 태그 관련 기호를 회피(Escape)문자로 변환하여 저장
		// XSS(Cross Site Scripting) : 입력태그에 악의적인 스크립트를 입력하여 페이지가 변형
		// 시키거나 개인 정보를 특정 사이트로 유출하는 공격
			// 입력을 할 때 사용자가 공백을 입력할 수 있기 때문에
			// 게시글의 내용에 HTML or script 태그를 집어넣는 경우 존재.
			// replace("<", "&lt;").replace(">","&gt;") 를 통해 최소한의 방어를 할 수 있다. 
		String name=request.getParameter("name").trim().replace("<", "&lt;").replace(">","&gt;");
		String title=request.getParameter("title").trim().replace("<", "&lt;").replace(">","&gt;");
		String content=request.getParameter("content").trim().replace("<", "&lt;").replace(">","&gt;");
		
		// DTO 인스턴스를 생성하여 반환받은 전달값으로 필드값 변경
		GuestDTO guest=new GuestDTO();
		guest.setName(name);
		guest.setTitle(title);
		guest.setContent(content);
		
		// GUEST 테이블에 방명록을 게시글을 저장하는 DAO 클래스의 메소드 호출
		GuestDAO.getDAO().insertGuest(guest);
		
		// 클라이언트에 출력페이지(select.itwill)에 대한 요청 URL 주소 전달 - 리다이렉트 이동
		response.sendRedirect("select.itwill");
		

	}
}
