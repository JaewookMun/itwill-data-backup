package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	@RequestMapping(value="/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}
	
	/*
	// 요청 처리 메소드에 HttpServletRequest 자료형의 매개변수를 선언하여 클라이언트의
	// 요청정보(리퀘스트 메세지 - HttpServletRequest 객체)를 자동으로 제공받아 저장
	// => HttpServletRequest 객체를 이용하여 전달값을 반환받아 사용
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String form(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "param_display";
	}
	*/

	/*
	// 전달값의 이름과 동일한 이름의 매개변수(String)를 선언하면 자동으로 전달값이 매개변수에 저장되어 제공
		// 전달값의 이름과 매개변수의 이름이 같아야하는 점이 중요하다.
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String form(String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
		// POST 방식은 리퀘스트 메시지의 바디에 저장 - ISO-8859-1 타입 (한글은 깨져보인다.)
		// => Filter 프로그램 활용 c.f. MVC
		// 요청 URL과 연결된 처리메소드가 호출되기 전에 필터클래스로 입력값을 전처리
		// Spring MVC - web.xml에서 Encoding Filter 클래스를 설정하는 것은 필수다.
	
	/*
	// @RequestParam : 전달값을 매개변수에 저장하기 위한 어노테이션
	// => 매개변수의 이름과 같은 이름의 전달값이 없는 경우 400 에러 발생
	// => 매개변수에 반드시 저장되도록 사용하는 어노테이션
		// Bad Request Error를 의도적으로 발생시킴 - 필수 전달값이 없으면 에러발생
		// => 필수 전달값을 위해 활용 가능
		// RequestParam 어노테이션을 작성하지 않으면 에러가 발생하지 않고 출력페이지로 이동한다.
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String form(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	/*
	// @RequestParam 어노테이션의 value 속성을 사용하여 전달값의 이름에 대한 설정 가능
	// value 속성 : 전달값의 이름을 속성값으로 설정
	// => 전달값의 이름과 매개변수의 이름이 다른 경우 사용
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	// required 속성 : false(전달값 선택) 또는 true(전달값 필수 - 기본) 중 하나를 속성값으로 설정
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String form(@RequestParam(value = "username", required = true) String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	// defaultValue 속성 : 전달값이 없어 매개변수에 아무런 값도 저장되지 않을 경우 매개변수에
	// 저장될 기본값을 속성값으로 설정
		// username으로 전달되는 값이 없을 경우 사용할 기본값 설정 - 자동저장.
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String form(@RequestParam(value = "username", defaultValue = "임꺽정") String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
}
