package xyz.itwill.servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 클라이언트의 서블릿 요청횟수를 누적하여 클라이언트에게 응답하는 서블릿
// => 클라이언트의 서블릿 요청횟수를 서버 파일(/WEB-INF/counter.txt)에 저장하여 사용
	// web-inf 밑에 만들면 클라이언트가 요청 불가능
	// 파일을 통해 값을 반 영구적으로 저장
@WebServlet("/counter.itwill")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 서블릿의 요청 횟수를 저장하기 위한 필드
	// => WAS 종료시 인스턴스가 제거되기 전 필드는 자동 소멸 - 필드값 유지 불가능
		// 값을 반영구적으로 유지하기 위해서 저장매체가 필요
	private int count;
	
	// 카운터 정보를 저장하는 파일의 시스템 경로를 저장하기 위한 필드
	private String counterFilePath;
	
	// init() 메소드로 카운터 정보를 저장한 파일에서 서블릿 요청횟수를 읽어 필드에 저장
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 카운터 정보를 저장하는 파일의 시스템 경로를 반환받아 저장
		// => workspace 폴더가 아닌 webapps 폴더의 시스템 경로 반환
		counterFilePath=config.getServletContext().getRealPath("/WEB-INF/counter.txt");
		// System.out.println("counterFilePath = "+counterFilePath);
		
		try {
			// 카운터 정보를 저장하는 파일의 입력 스트림을 생성하여 저장
			// => 카운터 정보를 저장하는 파일이 없는 경우 FileNotFoundException 발생
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(counterFilePath));
			
			// 파일 입력 스트림을 이용하여 파일에 저장된 서블릿 요청횟수를 읽어 필드에 저장
			count=(Integer)in.readObject();
			
			// 파일 입력 스트림 제거
			in.close();
		} catch (Exception e) {
			count=0;
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 서블릿의 요청 횟수를 저장하기 위한 변수
		// => 메소드가 종료되면 자동 소멸되는 지역변수 - 변수값 유지 불가능
		// int count=0;
		
		// 서블릿 요청 횟수 누적
		count++;
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=`'utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("<body>");
		out.println("<h1>서블릿의 카운터</h1>");
		out.println("<hr>");
		out.println("<p>서블릿 요청횟수 = "+count+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
	
	// destroy() 메소드로 카운터 정보를 저장한 파일에 필드에 저장된 서블릿 요청횟수를 저장
	@Override
	public void destroy() {
		try {
			// 카운터 정보를 저장한 파일의 출력 스트림을 생성하여 저장
			// => 카운터 정보를 저장한 파일이 없는 경우 파일을 생성하여 필드값 저장
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(counterFilePath));

			// 필드값을 파일 출력 스트림으로 전달하여 파일에 저장
			out.writeObject(count);
			
			// 파일 출력 스트림 제거
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		// DB를 이용하는 것이 좋으나 간단한 경우 이처럼 파일을 저장매체로 활용가능.
}
