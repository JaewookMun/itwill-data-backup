package xyz.itwill.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 필터(Filter) 클래스 : 클라이언트의 특정 웹프로그램 요청에 대한 처리 전 요청정보를 변경하거나
// 응답전 응답정보를 변경하기 위한 클래스 - Filter 인터페이스를 상속받아 작성
	/*
		client -> WAS - filter - web_program
		client가 요청한 요청을 filter에서 웹프로그램에서 사용하기 적합한 형태로 변경하거나
		웹프로그램의 결과를 클라이언트에게 전달하기 전에 적합한 형태로 변경하는 역할
	 */

// 클라이언트의 모든 웹프로그램 요청에 대한 요청정보의 전달값 캐릭터셋을 변경하는 필터 클래스
// @WebFilter 어노테이션 또는 web.xml 파일의 filter 엘리먼트를 이용하여 필터클래스가 동작되도록 설정
public class EncodingFilter implements Filter {
		// Servlet이랑 유사함
		// Servlet - 클라이언트의 요청 시 / Filter - 클라이언트 요청 후 & 응답 전
	
	// 변경할 캐릭터셋의 인코딩을 저장하기 위한 필드
	private String encoding;
	
	//필터 클래스가 인스턴스로 생성된 후 가장 먼저 한번만 호출되는 메소드 - 초기화 작업
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// encoding="utf-8";
		
		// web.xml 파일의 init-param 엘리먼트로 제공된 값을 반환받아 필드에 저장 
		encoding=filterConfig.getInitParameter("encoding");
			// => 나중에 배포 후에 수정이 필요하더라도 소스를 건들지 않고 web.xml의 파일을 수정하여 값을 설정할 수 있다.
			// * 배포 후 소스를 변경할 수 없는 경우도 있기 때문에 완성된 프로그램의 소스를 변경하지 않을 수 있도록 고려 * 
	}
	
	// 클라이언트 요청에 의해 동작될 웹프로그램의 실행 전 또는 후에 작업될 명령을 작성하는 메소드
	// => 클라이언트에게 제공받은 요청정보를 변경하거나 클라이언트에게 응답될 응답정보를 변경하는 기능 제공
	// => 클라이언트 요청마다 자동으로 반복 호출되는 메소드
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 클라이언트에게 제공받은 요청정보 변경 - 전달값에 대한 캐릭터셋 변경
		if(request.getCharacterEncoding()==null ||
				!request.getCharacterEncoding().equalsIgnoreCase(encoding)) {
					// 대소문자 구분하지 않고 비교.
			request.setCharacterEncoding(encoding);
			
		}
		
		// 클라이언트 요청을 처리하기 위한 웹프로그램을 연결하여 실행되도록 설정
		chain.doFilter(request, response); // 요청 웹프로그램 실행
		
		// 클라이언트에게 응답될 응답정보 변경
			// 해줄게 없으면 안해도 ㅗ딤
	}

}
