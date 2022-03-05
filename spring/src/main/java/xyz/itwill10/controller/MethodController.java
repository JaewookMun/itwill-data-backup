package xyz.itwill10.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
	// 입력페이지에 대한 ViewName을 반환하는 요청 처리 메소드
	// => GET 방식으로 요청하여 동작되는 요청 처리 메소드
	@RequestMapping("/method_input")
	public String inputOne() {
		return "method_input1";
	}
	
	// 전달값을 반환받아 출력페이지에 제공하고 출력헤이지에 대한 ViewName을 반환하는 메소드
	// => POST 방식으로 요청하여 동작되는 요청 처리 메소드 - GET 방식 요청 가능
	@RequestMapping("/method_output")
	public String outputOne(HttpServletRequest request) throws UnsupportedEncodingException {
		if(request.getMethod().equals("GET")) { // GET 방식으로 요청한 경우
			return "method_input1"; // 입력페이지의 ViewName 반환
		}
		
		// HttpServletRequest.setCharacterEncoding(String encoding) : POST 방식으로 요청하여 
		// 전달된 값에 대한 캐릭터셋 변경
		// => UnsupportedEncodingException 발생 - 예외처리
			// DispatcherServlet이 처리할 것이다.
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		
		
		return "method_output1";
	}
	
	// 입력페이지에 대한 ViewName을 반환하는 요청 처리 메소드
	// => GET 방식으로 요청하여 동작되는 요청 처리 메소드
	// method 속성 : 클라이언트의 요청방식을 속성값으로 설정
	// => RequestMethod 자료형(Enum)의 상수를 속성값으로 설정
	// 클라이언트의 요청 URL 주소가 동일한 경우 요청방식에 의해 요청 처리 메소드를 구분하여 호출
	// => 요청방식에 따라 @GetMapping, @PostMapping 등의 어노테이션으로 요청 처리 메소드 설정
	@RequestMapping(value = "/method", method = RequestMethod.GET)
		// 대신 @GetMapping을 사용해서 요청 url만 설정해도 된다.
	public String inputTwo() {
		return "method_input2";
	}
	
	// 전달값을 반환받아 출력페이지에 제공하고 출력헤이지에 대한 ViewName을 반환하는 메소드
	// => POST 방식으로 요청하여 동작되는 요청 처리 메소드 - GET 방식 요청 불가능
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public String outputTwo(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		
		
		return "method_output2";
	}
		// 요청방식(method)가 다들 경우 요청 url이 같아도 에러가 발생하지 않는다.
		// 입력페이지와 입력페이지의 값을 전달받아 처리하는 페이지의 이름을 똑같이 설정하면
		// 좀 더 효율적인 프로그래밍이 가능하다.
	
}
