package xyz.itwill10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// @Controller : 클라이언트의 요청을 처리하는 Controller 클래스를 Spring Bean으로 등록하는 어노테이션
// => 기본적으로 클래스 이름을 beanName으로 등록(첫문자는 소문자) = value 속성으로 beanName 변경
// => Controller 인터페이스를 상속받지 않아도 Controller 클래스로 작성 가능
// => 클라이언트의 요청을 처리하는 다수의 요청 처리 메소드 작성 가능 - @RequestMapping 어노테이션 사용
	// => Command Controller 와 차이 존재 - 다수의 요청처리 메소드 작성 가능
	// command controller는 하나의 메소드로 하나의 요청만 처리할 수 있다.
@Controller
public class HelloController {
	private static final Logger logger=LoggerFactory.getLogger(HelloController.class);

	// 요청 처리 메소드에서 Front Controller에게 ViewName을 전달하는 방법
	// => Front Controller는 전달받은 ViewName을 ViewResolver 클래스에게 제공하여 JSP 파일
	// 위치를 반환받아 포워드 이동하여 응답 처리
	// 1. 요청 처리 메소드의 반환형을 void로 작성하면 메소드명을 ViewName으로 전달
	// 2. 요청 처리 메소드의 반환형을 String으로 작성하면 반환되는 문자열을 ViewName으로 전달
	// 3. 요청 처리 메소드의 반환형을 ModelAndView로 작성하면 ModelAndView 객체의 ViewName을 저장하여 전달
		// 두번째 방식이 많이 사용된다. - 세번째는 과거방식
	
	// 클라이언트의 요청을 처리하기 위한 메소드
	// @RequestMapping : 클라이언트의 요청정보(URL)를 등록하여 클라이언트 요청시 메소드를 호출하는 어노테이션
	// => @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 등의 어노테이션으로 사용 가능
		// 위 방식(겟매핑 등)은 REST(JSON)로 응답할 때 자주 사용 - GetMapping으로 바꾸어도 상관없다.
		// REST - 처리결과를 java 객체로 전달하는 것이 아니라 json이나 xml로 전달하는 웹프로그램을 지칭
	// value 속성 : 클라이언트의 요청정보(URL)를 속성값으로 설정
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	// => 다른 요청 처리 메소드와 요청정보(URL)가 중복될 경우 WAS 실행 시 에러 발생
		// 최근에는 .do 등 의미없는 확장자를 붙이지 않는 경우가 많다.
		// value 속성(식별자 역할) 중복 시 Spring Container가 읽을 때 문제가 있는것으로 인식하여 서버 시작시 에러발생.
		// context로 전환되지 않기 때문에...
		// hello 앞은 context root
	@RequestMapping(value="/hello")
		// @RequestMapping는 요청 메소드와 상관 없이 /hello URL을 요청하면 요청에 대한 응답을 처리한다. 
	public void hello() {
		// 요청 처리명령 작성 - Service 클래스의 메소드 호출
		logger.info("/hello 요청 >> HelloController 클래스의 hello() 메소드를 호출하여 요청 처리");
	}
	
	@RequestMapping("/helloViewName")
	public String helloViewName() {
		logger.info("/helloViewName 요청 >> HelloController 클래스의 helloViewName() 메소드 호출하여 요청 처리");
		return "hello";
	}
		// 문자열을 반환형으로 해서 ViewName을 지정하는 방식이 널리 사용된다. - 2nd type
	
	@RequestMapping("/helloModelAndView")
	public ModelAndView helloModelAndView() {
		logger.info("/helloModelAndView 요청 >> HelloController 클래스의 helloModelAndView() 메소드 호출하여 요청 처리");
		
		/*
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("hello");
		*/
		
		// ModelAndView 객체 생성 시 생성자로 ViewName을 전달받아 저장
		ModelAndView modelAndView =new ModelAndView("hello");
		
		return modelAndView;
	}
		// DispatcherServlet에게 뷰네임을 전달해야한다.
}
