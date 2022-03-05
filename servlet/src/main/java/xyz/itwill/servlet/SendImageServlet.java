package xyz.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 클라이언트 요청에 대해 이미지 파일로 응답하기 위한 서블릿
@WebServlet("/image.itwill")
public class SendImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트에게 이미지 파일로 응답되도록 설정
		// => 이미지 파일로 응답하기 때문에 캐릭터셋 미설정
			// server를 더블클릭했을 때 나오는 오버뷰 우측 하단에 mime mapping에서 패턴확인 가능
		response.setContentType("image/jpeg");
		
		// 클라이언트에게 응답될 이미지 파일을 생성하기 위한 출력 스트림을 반환받아 저장
		ServletOutputStream out = response.getOutputStream();
		
		// 서버에 저장된 이미지 파일의 시스템 경로를 반환받아 저장
		// HttpServletRequest.getServletContext() : ServletContext 인스턴스를 반환하는 메소드
		// ServletContext : 클라이언트가 요청한 컨텍스트의 정보를 저장한 인스턴스
		// => 컨텍스트(Context) : 웹 관련 자원이 저장된 그룹 - 이클립스의 프로젝트
		// ServletContext.getRealPath(String contextFilePath) : 컨텍스트에 존재하는 파일의
		// 시스템 경로를 반환하는 메소드
			// 시스템 경로는 실제 경로를 의미 (운영체제 경로) 
			// 컨텍스트 정보를 통해 컨텍스트에 존재하는 파일의 실제 경로를 반환 (WAS가 읽어들일 수 있는 자원의 실제 경로)
			// WAS는 아파치 톰캣 폴더의 webapps 폴더에 접근하여 웹어플리케이션을 처리한다.
			// webapp에는 client가 접근할 수 없는 private 폴더가 존재하며 서블릿은 접근가능
		String filePath=request.getServletContext().getRealPath("/WEB-INF/Koala.jpg");
		
		// 서버에 존재하는 이미지 파일을 읽기 위한 입력 스트림을 생성하여 저장
		FileInputStream in=new FileInputStream(filePath);
		
		// 입력 스트림(서버 이미지 파일)에서 원시 데이터를 읽어 출력 스트림(클라이언트
		// 응답 파일)으로 전달 - 반복 처리
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		
		// 입력 스트림 제거
		in.close();
	}
}
