package xyz.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.exception.UserinfoExistsException;
import xyz.itwill10.exception.UserinfoNotFoundException;
import xyz.itwill10.service.UserinfoService;

@Controller
@RequestMapping("/userinfo")
public class UserinfoController {
	@Autowired
	private UserinfoService userinfoService;
	
	/*
	//회원정보를 입력받은 요청 처리 메소드
	// => 비로그인 사용자이거나 관리자가 아닌 경우에 요청하면 예외 발생
	// => 예외처리 메소드가 선언된 경우 예외를 발생시켜 전달 - 에러메세지 출력
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public String join(HttpSession session) throws Exception {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
			// return "userinfo/user_error";
				// 예외처리 메소드가 없으면 JSP로 이동해도 되자만 예외처리 메소드를 활용하는 것을 권장
				// 예외페이지가 바뀔 가능성 고려
			throw new Exception(); //
		}
		return "userinfo/user_write";
	}
	*/
	
	// 인터셉터를 이용하여 비로그인 사용자 또는 관리자가 아닌 경우 요청 처리 메소드가 호출
	// 되지 않도록 설정
	// 인터셉터(Interceptor) : Front Controller에 의해 요청 처리 메소드가 호출되기 전 또는
	// 호출 후에 실행될 명령제공 - 권한 처리
	// => 인터셉터 클래스를 작성하고 Bean Configuration File(servlet-context.xml)에서
	// 인터셉터가 동작되도록 설정(AOP)
		// 일반 AOP와 설정방식이 다르다.
		// 인터셉터 클래스를 만들어주는데 - Advice 역할을 한다.
		// 인터셉터 - 흐름을 훔친다.
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public String join(){
		return "userinfo/user_write";
	}
		// 중복된 코드를 최소화 하고 코드를 단순화 시키기 위해 AOP 이용
	
	/*
	//회원정보를 전달받아 USERINFO 테이블에 삽입하여 저장하는 요청 처리 메소드
	// => userinfoService 클래스의 메소드 호출시 예외 발생 가능 - 직접 예외 처리
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute Userinfo userinfo, Model model) {
		try {
			userinfoService.addUserinfo(userinfo);
		} catch (UserinfoExistsException e) {
			model.addAttribute("message", e.getMessage());
			return "userinfo/user_write";
		} catch (Exception e) {
			e.printStackTrace();
			return "userinfo/user_error";
		}		
		return "redirect:/userinfo/login";
	}
		// try catch를 사용해 Service에서 발생하는 예외를 직접 잡아서 해결할 수 있지만
		// 예외를 전달하여 해결할 수도 있다.
	*/
	
	//회원정보를 전달받아 USERINFO 테이블에 삽입하여 저장하는 요청 처리 메소드
	// => userinfoService 클래스의 메소드 호출시 예외 발생 가능 - 예외 전달
	//요청 처리 메소드에서 예외 처리를 하지 않고 전달한 경우 Front Controller에게 예외 전달
	// => Front Controller에서는 예외가 발생될 경우 에러코드(500) 응답
	//예외처리 메소드(Exception Handler Method)가 선언된 경우 Front Controller에서 예외가 
	//발생되면 Front Controller가 예외처리 메소드를 자동 호출하여 예외 처리
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute Userinfo userinfo, Model model) throws UserinfoExistsException {
		userinfoService.addUserinfo(userinfo);
		return "redirect:/userinfo/login";
	}

	//비로그인 사용자인 경우 아이디와 비밀번호를 입력받는 요청 처리 메소드
	// => 로그인 사용자인 경우 환영 메세지를 출력하는 요청 처리 메소드
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		return "userinfo/user_login";
	}
	
	//아이디와 비밀번호를 전달받아 로그인 처리(인증)하는 요청 처리 메소드
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo, HttpSession session) 
			throws LoginAuthFailException, UserinfoNotFoundException {
		//userinfoService 클래스의 메소드를 호출하여 인증 처리
		// => 인증 실패시 예외 발생 
		userinfoService.loginAuth(userinfo);		
		
		//인증 성공 - HttpSession 객체에 권한 관련 정보를 저장
		session.setAttribute("loginUserinfo", userinfoService.getUserinfo(userinfo.getUserid()));
		
		return "userinfo/user_login";
	}
	
	// 로그아웃을 처리하는 요청처리 메소드
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
			// session을 언바인딩 or loginUserinfo 속성을 제거
		return "userinfo/user_login";
	}

	// 회원목록을 출력하는 요청처리 메소드
	// => 로그인 사용자만 요청 가능하도록 인터셉터 이용
	@RequestMapping("/list")
	public String logout(Model model) {
		model.addAttribute("userinfoList", userinfoService.getUseinfoList());
		return "userinfo/user_list";
	}

	
	// 회원상세정보를 출력하는 요청 처리 메소드
	// => 로그인 사용자만 요청가능하도록 인터셉터 이용
	@RequestMapping("/view")
	public String view(@RequestParam String userid, Model model) throws UserinfoNotFoundException {
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_view";
	}

	// 회원정보를 변경하는 정보를 입력하는 페이지를 출력하는 요청 처리 메소드
	// => 관리자만 요청가능하도록 인터셉터 이용
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@RequestParam String userid, Model model) throws UserinfoNotFoundException {
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_modify";
	}
	
	// 회원정보를 변경하는 요청 처리 메소드
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute Userinfo userinfo, HttpSession session) throws UserinfoNotFoundException {
		userinfoService.modifyUserinfo(userinfo);
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		// 변경회원이 현재 로그인 사용자인 경우 세션에 저장된 관련 정보 변경
		if(loginUserinfo.getUserid().equals(userinfo.getUserid())) {
			session.setAttribute("loginUserinfo", userinfoService.getUserinfo(userinfo.getUserid()));
				// 세션에 저장된 정보가 변경전 정보이기 때문에 세션의 정보도 바꿔줘야한다.
		}
		
		return "redirect:/userinfo/view?userid="+userinfo.getUserid();
	}
	
	// 회원정보를 삭제하는 요청 처리 메소드
	// => 관리자만 요청가능하도록 인터셉터 이용
	@RequestMapping("/remove")
	public String remove(@RequestParam String userid,HttpSession session) throws UserinfoNotFoundException {
		userinfoService.removeUserinfo(userid);
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		// 삭제회원이 현재 로그인 사용자인 경우 로그아웃 처리하고 아닌 경우 회원페이지 요청
		if(loginUserinfo.getUserid().equals(userid)) {
			return "redirect:/userinfo/logout";
		} else {
			return "redirect:/userinfo/list";
			
		}
	}
	
	
	
	// @ExceptionHandler : Controller 클래스의 요청 처리 메소드에서 전달된 예외를 처리하기
	// 위한 예외처리 메소드를 설정하는 어노테이션
	// value 속성 : 예외 처리할 예외 클래스(Clazz)를 속성값으로 설정
	// => 다른 속성이 없는 경우 속성값만 설정 가능
		// try ~ catch 를 통해 예외 처리할 수 있으나 이를 Front Controller에게 전달하여 처리할 수 있다.
		// 전달된 예외 - throws를 통해 전달되는 예외를 의미
		// 발생된 예외는 Front Controller에게 주고 Front Controller는 ExceptionHandler를 통해 예외를 처리한다.
		// => 핸들러가 있으면 처리(500에러가 발생하지 않는다.) / 없으면 500 에러코드 발생
	@ExceptionHandler(UserinfoExistsException.class)
	// 예외처리 메소드의 매개변수에는 예외 관련 정보를 전달받아 저장하여 예외 처리 후 ViewName 반환 - JSP 응답
	public String exceptionHandler(UserinfoExistsException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userinfo", exception.getUserinfo());
		
		return "userinfo/user_writer";
			// 예외를 처리하고 ViewName을 반환하여 예외를 처리할 수 있게 작성됨.
	}
	
	@ExceptionHandler(LoginAuthFailException.class)
	public String exceptionHandler(LoginAuthFailException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userid", exception.getUserid());
		
		return "userinfo/user_login";
	}
	/*
	@ExceptionHandler(UserinfoNotFoundException.class)
	public String exceptionHandler() {
		
		return "userinfo/user_error";
	}
	*/
	
	@ExceptionHandler(Exception.class)
		// 모든 예외를 다 잡아낸다. - 다른 컨트롤러에서 발생한 예외는 잡을 수 없다.
	public String exceptionHandler() {
		
		return "userinfo/user_error";
	}
		// 여기서 생성한 Exception Handler는 UserinfoController 에서 생성되는 예외만
		// 처리 가능하다.
		// 다른 컨트롤러에서 발생한 예외는 잡을 수 없다.
}









