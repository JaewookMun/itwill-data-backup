package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	@RequestMapping("/forward_print")
	public String forward(Model model) {
		// 뷰페이지에서 사용할 객체 제공 - Request Scope
		model.addAttribute("name", "홍길동");
		
		// ViewName 반환 >> 뷰페이지(JSP)로 포워드 이동
		// 포워드 이동 : 서버측에서 다른 웹프로그램으로 스레드를 이동하여 응답 처리
		// => 클라이언트의 요청 URL 주소 미변경, Request Scope로 제공되는 객체 사용
		return "movement/forward_display";
	}
	
	/*
	@RequestMapping("/redirect_print")
	public String redirect(Model model) {
		model.addAttribute("name", "임꺽정");
		return "movement/redirect_display";
	}
	
	
	@RequestMapping("/redirect")
	public String redirect() {
		// 반환되는 ViewName에 redirect 접두사(NameSpace)를 사용하면 리다이렉트 이동
		// => ViewName에 의해 뷰페이지(JSP)로 응답하는 대신 클라이언트에게 URL 주소 전달
		// 리다이렉트 이동 : 클라이언트에게 URL 주소를 전달하여 재요청하여 응답 처리
		// => 클라이언트의 요청 URL 주소 변경, Request Scope로 제공되는 객체 사용 불가능
			// 재요청하기 때문에 다른 리퀘스트를 사용한다.
		return "redirect:/redirect_print";
	}
	*/

	@RequestMapping("/redirect_print")
	public String redirect() {
		return "movement/redirect_display";
	}
	
	// RedirectAttributes : 리다이렉트 이동에 의해 호출되는 요청 처리 메소드의 뷰페이지에게
	// 속성값을 제공하기 위한 객체
	
	@RequestMapping("/redirect")
	public String redirect(/*Model model*/ RedirectAttributes attributes) {
		// model.addAttribute("name", "임꺽정");
		
		// RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
		// => 리다이렉트 이동에 의해 호출되는 요청 처리 메소드의 뷰페이지에게 제공될 속성값을 저장하는 메소드
			// addAttribute를 사용하면 안된다. - Model 인터페이스를 상속받은 인터페이스
		attributes.addFlashAttribute("name", "임꺽정");
		
		return "redirect:/redirect_print";
			// redirect: 접두사를 붙여서 리다이렉트 이동을 시킬 수 있다.
	}
	
		// 일반적으로 포워드 이동을 자주 사용하나 필요에 따라서 리다이렉트를 이용할 수 있다.
		// eg) 회원가입 후 가입 축하 페이지를 출력할 수 있으나 다른 주소로 리다이렉트 이동시킬 수도 있다.
		// => 구상한 페이지 구조에 따라 사용이 달라진다.
	
}
