package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

// JNDI (Java Naming Directory Interface) : 인스턴스 생성에 필요한 정보에 이름을 부여하여
// WAS의 자원으로 등록하고 필요한 경우 인스턴스를 생성하여 사용하는 기술
// => 인스턴스 생성에 필요한 정보를 저장한 파일 필요 - /src/main/webapp/META-INF/context.xml
	// Resource 엘리먼트를 이용하여 정보를 저장
	// WAS가 실행될 떄 메모리에 로드되기 때문에 인스턴스를 좀 더 빠르게 만들 수 있다.

// WAS에 등록된 자원을 이용하여 DataSource 인스턴스(ConnectionPool)를 생성해 Connection
// 인스턴스를 제공받아 클라이언트에게 전달하는 서블릿
@WebServlet("/jndi.itwill")
public class JndiServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			// InitialContext 인스턴스 생성
			// InitialContext : WAS에 등록된 자원을 자원의 식별자로 읽어 인스턴스를 생성하여
			// 반환하는 기능을 제공하는 인스턴스
			InitialContext ic = new InitialContext();
			
			// InitialContext.lookup(String name) : 자원의 식별자로 인스턴스 생성에 필요한
			// 정보를 읽어 인스턴스를 생성하여 반환하는 메소드
			// => Object 타입으로 인스턴스를 반환하므로 명시적 객체 형변환하여 사용
			// => NamingException 발생 : 식별자로 등록된 자원이 없는 경우 발생되는 예외
				// java자원, comp폴더 밑의 environment 폴더의 java자원으로 등록
			DataSource dataSource = (DataSource)ic.lookup("java:comp/env/jdbc/oarcle");
				// WAS에는 굉장히 많은 자원들이 등록되어있음. 
				// [java:comp/env/] 영역에 자동으로 저장된다.
				// 직접 객체를 만드는 것이 아닌 다른 기능을 통해 객체를 만들어주는 방식 - ioc 기능
			
			Connection con= dataSource.getConnection();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='utf-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Apache DBCP</h1>");
			out.println("<hr>");
			out.println("<p> Connection = "+con+"</p>");
			out.println("</body>");
			out.println("</html>");
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
