package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// 입력페이지에서 전달된 멀티파트 폼데이터를 처리하기 위한 클래스 필요
// => Apache 그룹에서 배포한 commons-fileupload 라이브러리의 클래스 사용 - 선택적 파일 업로드
// => Oreilly 그룹에서 배포한 cos 라이브러리의 클래스 사용 - 무조건 파일 업로드
	// Apache 그룹의 라이브러리는 업로드 처리가 복잡하지만(여러개의 클래스) cos는 좀 더 편리함. (유효성검사 등을 하면 아파치)

// Oreilly 그룹에서 배포한 cos 라이브러리 파일을 다운로드 받아 프로젝트에 빌드(Build) 처리하는 방법
// 1. http://www.servlets.com >> COS File Upload Library 메뉴 클릭 >> cos-20.08.zip 다운로드
// 2. cos-20.08.zip 파일 압축 풀기 >> 압축 폴더 >> lib >> cos.jar 복사
// 3. 프로젝트 >> src/main/webapp >> WEB-INF >> lib 폴더에 붙여넣기
// => 라이브러리가 자동으로 프로젝트에 빌드 처리 - Web App Libraries 확인
	// MultipartRequest, DefaultFileRenamePolicy 두 클래스 중요
	// cos : com.oreilly.service 의 약자

// 입력페이지(file_upload.html)에서 전달된 입력값과 입력 파일명을 반환받아 클라이언트에게 전달
// => 입력파일을 전달받아 서버 디렉토리에 저장되도록 처리 - 업로드(Upload)
@WebServlet("/upload.itwill")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("file_upload.html"); // 입력페이지로 이동 처리
			return;
		}
		
		// 전달된 파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
		// => 작업 디렉토리(WorkSpace)가 아닌 웹 디렉토리(WebApps)의 시스템 경로 반환
		// 주의) WAS 실행시 작업디렉토리의 프로젝트가 웹 디렉토리의 컨텍스트로 동기화 처리
		// 되면서 컨텍스트에 존재하는 기존 업로드 파일이 없어지는 문제 발생
			// 이클립스의 workspace가 웹디렉토리에 복사된다. (project가 context로 복사)
			// 이클립스는 업로드가 되는지 확인하면됨.
			// 아니라면 context파일을 복사해서 이클립스의 upload폴더에 붙여넣으면 동기화되어도 괜찮다.
		String saveDirectory = request.getServletContext().getRealPath("/upload");
		// System.out.println("saveDirectory = "+saveDirectory);
		
		// MultipartRequest 클래스로 인스턴스 생성
		// => MultipartRequest : 멀티파트 폼데이터를 처리하기 위한 기능을 제공하는 인스턴스
		// => MultipartRequest 인스턴스를 생성하면 모든 입력파일을 전달받아 서버 디렉토리에 업로드
		// MultipartRequest(HttpServletRequest request, String saveDirectory[, int maxPostSize]
		// [, String encoding][, FileRenamePolicy policy]) 생성자를 사용하여 인스턴스 생성
		// => request : 요청정보를 저장한 HttpServletRequest 인스턴스 전달
		// => saveDirectory : 전달 파일을 저장하기 위한 서버 디렉토리의 시스템 경로 전달
		// => maxPostSize : 처리 가능한 멀티파트 폼데이터의 최대 크기 전달 - 단위 : Byte
		// => encoding : 멀티파트 폼데이터로 전달된 입력값의 캐릭터셋 전달
		// => policy : FileRenamePolicy 인스턴스 전달
		// FileRenamePolicy : 파일 업로드 처리시 입력파일과 같은 이름의 파일이 업로드 되는
		// 서버 디렉토리에 존재할 경우 입력파일의 이름을 자동 변경하는 인스턴스
		// => FileRenamePolicy 인스턴스를 전달하지 않으면 기존 파일을 입력파일로 덮어씌우기(OverWrite)
			// 30*1024*1024 -> 파일을 30 메가바이트 까지 전달 가능
			// FileRenamePollicy : 전송한 파일이 중복될 경우 어떻게 처리할 지 결정
			// 별도의 조치 없이 MulitpartRequest 인스턴스를 만들면 파일을 전달받아 저장 가능
			// 자동으로 저장되는 디렉토리는 context폴더에 upload란 이름으로 되어있다.
			// 웹디렉토리에 저장 - upload
		//MultipartRequest mr=new MultipartRequest(request, saveDirectory, 30*1024*1024, "utf-8");
		
		// FileRenamePolicy 인터페이스를 상속받은 자식클래스로 FileRenamePolicy 인스턴스 생성
		// DefaultFileRenamePolicy : FileRenamePolicy 인터페이스를 상속받은 자식 클래스
		// => 입력 파일명 뒤에 숫자를 붙여 자동으로 변경하는 기능을 제공
		MultipartRequest mr=new MultipartRequest(request, saveDirectory, 30*1024*1024
				, "utf-8", new DefaultFileRenamePolicy());
			// 위처럼 인스턴스를 만들면 저장됨.
			// Apache Tomcat 10.0을 9.0으로 변경하여 진행 ( error 때문에 ...)
		
		// 입력값을 반환받아 저장
		// MultipartRequest.getParameter(String name) : 멀티파트 폼데이터의 입력값을 반환하는 메소드
		String name=mr.getParameter("name");
		
		// 입력 파일명을 반환받아 저장
		// MultipartRequest.getOriginalFileName(String name) : 멀티파트 폼데이터의 입력 파일명을 반환하는 메소드
		// String fileOne=mr.getOriginalFileName("fileone");
		// String fileTwo=mr.getOriginalFileName("filetwo");
		
		
		// 서버 디렉토리에 저장된 업로드 파일명을 반환받아 저장
		// MultipartRequest.getFilesystemName(String name) : 서버 디렉토리에 실제 저장된 파일명을 반환하는 메소드
		String fileOne = mr.getFilesystemName("fileone");
		String fileTwo = mr.getFilesystemName("filetwo");

		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>파일 업로드</h1>");
		out.println("<hr>");
		out.println("<p>올린이 = "+name+"</p>");
		out.println("<p>파일-1 = "+fileOne+"</p>");
		out.println("<p>파일-2 = "+fileTwo+"</p>");
		out.println("</body>");
		out.println("</html>");
		
			// 프로젝트의 자원들을 web directory의 컨텍스트에 저장(동기화)할때 
			// workspace에 있는 디렉토리가 web directory의 upload 폴더에 덮어씌어진다.
			// workspace의 webapp에 자원을 만들면 WAS의 webapps의 context로 이동한다.
	}
}
