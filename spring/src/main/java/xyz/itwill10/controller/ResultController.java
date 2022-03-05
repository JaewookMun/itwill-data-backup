package xyz.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 요청 처리 메소드의 처리결과를 뷰페이지(JSP)에게 제공하는 방법
// 1. ModelAndView 객체를 이용하여 처리결과 제공
// => 요청 처리 메소드는 반드시 ModelAndView 객체 반환
// 2. HttpServletRequest 객체에 처리결과를 속성값으로 저장하여 제공 
// 3. Model 객체에 처리결과를 속성값으로 저장하여 제공 
	// 3번째 방법이 많이 사용됨

@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMVC")
	public ModelAndView modelAndViewResult() {
		ModelAndView modelAndView=new ModelAndView("result_display");
		// ModelAndView.addObject(String attributeName, Object attributeValue)
		// => 뷰페이지에서 사용 가능하도록 처리결과(객체)를 저장하는 메소드 - Request Scope
			// 특별한 경우가 아니면 모두 Request Scope가 적용된다.
		modelAndView.addObject("mavName", "홍길동");
		return modelAndView;
	}
	*/
	
	// 요청처리 메소드는 Front Controller에 의해 자동 호출되는 메소드
	// => 요청처리 메소드에 매개변수를 작성하면 Spring Container로부터 Spring Bean 객체를 
	// 제공받아 자동 저장
		// 필요한 객체가 있다면 만들어 사용해도 되지만(구상클래스), 
		// Spring Container가 관리하고 있는 객체일 때는 제공받아 저장해준다.
	@RequestMapping("/resultMVC")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result_display");
		modelAndView.addObject("mavName", "홍길동");
		return modelAndView;
		
	}
		/*
			기존(desktop application)에는 getBean()을 사용했지만,
			web에서는 Spring Container가 관리하고 있는 Spring bean 객체를 전달받을 수 있다.
			Spring Container에게 받을 수 있는 객체 중 하나가
			ModelAndView 객체이다.
		 */
	
	@RequestMapping("/resultRequest")
	public String requestResult(HttpServletRequest request) {
		request.setAttribute("requestName", "임꺽정");
		
		return "result_display";
	}
		// -> 잘 권장하지 않는다. 단순히 속성값을 저장하기 위해 사용되지 않음. - 다양한 정보들이 저장되어 있음.
		// HttpServletRequest 클라이언트의 요청관련 정보가 모두 전달된다.
		// 속성값을 저장하기 위해 불필요한 정보가 많이 딸려온다. (쿠키, 요청방식 등.)
	
	
	// Model : 처리결과를 저장하기 위한 객체(ModelMap)
		// ModelAndView의 Model만 빼온 거라고 보면된다.
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		// Model.addAttribute(String attributeName, Object attributeValue)
		// => 뷰페이지에서 사용 가능하도록 처리결과(객체)를 저장하는 메소드 - Request Scope
		model.addAttribute("modelName", "전우치");
		return "result_display";
	}
}
