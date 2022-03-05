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
	//ȸ�������� �Է¹��� ��û ó�� �޼ҵ�
	// => ��α��� ������̰ų� �����ڰ� �ƴ� ��쿡 ��û�ϸ� ���� �߻�
	// => ����ó�� �޼ҵ尡 ����� ��� ���ܸ� �߻����� ���� - �����޼��� ���
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public String join(HttpSession session) throws Exception {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
			// return "userinfo/user_error";
				// ����ó�� �޼ҵ尡 ������ JSP�� �̵��ص� ���ڸ� ����ó�� �޼ҵ带 Ȱ���ϴ� ���� ����
				// ������������ �ٲ� ���ɼ� ���
			throw new Exception(); //
		}
		return "userinfo/user_write";
	}
	*/
	
	// ���ͼ��͸� �̿��Ͽ� ��α��� ����� �Ǵ� �����ڰ� �ƴ� ��� ��û ó�� �޼ҵ尡 ȣ��
	// ���� �ʵ��� ����
	// ���ͼ���(Interceptor) : Front Controller�� ���� ��û ó�� �޼ҵ尡 ȣ��Ǳ� �� �Ǵ�
	// ȣ�� �Ŀ� ����� ������� - ���� ó��
	// => ���ͼ��� Ŭ������ �ۼ��ϰ� Bean Configuration File(servlet-context.xml)����
	// ���ͼ��Ͱ� ���۵ǵ��� ����(AOP)
		// �Ϲ� AOP�� ��������� �ٸ���.
		// ���ͼ��� Ŭ������ ������ִµ� - Advice ������ �Ѵ�.
		// ���ͼ��� - �帧�� ��ģ��.
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public String join(){
		return "userinfo/user_write";
	}
		// �ߺ��� �ڵ带 �ּ�ȭ �ϰ� �ڵ带 �ܼ�ȭ ��Ű�� ���� AOP �̿�
	
	/*
	//ȸ�������� ���޹޾� USERINFO ���̺� �����Ͽ� �����ϴ� ��û ó�� �޼ҵ�
	// => userinfoService Ŭ������ �޼ҵ� ȣ��� ���� �߻� ���� - ���� ���� ó��
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
		// try catch�� ����� Service���� �߻��ϴ� ���ܸ� ���� ��Ƽ� �ذ��� �� ������
		// ���ܸ� �����Ͽ� �ذ��� ���� �ִ�.
	*/
	
	//ȸ�������� ���޹޾� USERINFO ���̺� �����Ͽ� �����ϴ� ��û ó�� �޼ҵ�
	// => userinfoService Ŭ������ �޼ҵ� ȣ��� ���� �߻� ���� - ���� ����
	//��û ó�� �޼ҵ忡�� ���� ó���� ���� �ʰ� ������ ��� Front Controller���� ���� ����
	// => Front Controller������ ���ܰ� �߻��� ��� �����ڵ�(500) ����
	//����ó�� �޼ҵ�(Exception Handler Method)�� ����� ��� Front Controller���� ���ܰ� 
	//�߻��Ǹ� Front Controller�� ����ó�� �޼ҵ带 �ڵ� ȣ���Ͽ� ���� ó��
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute Userinfo userinfo, Model model) throws UserinfoExistsException {
		userinfoService.addUserinfo(userinfo);
		return "redirect:/userinfo/login";
	}

	//��α��� ������� ��� ���̵�� ��й�ȣ�� �Է¹޴� ��û ó�� �޼ҵ�
	// => �α��� ������� ��� ȯ�� �޼����� ����ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		return "userinfo/user_login";
	}
	
	//���̵�� ��й�ȣ�� ���޹޾� �α��� ó��(����)�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo, HttpSession session) 
			throws LoginAuthFailException, UserinfoNotFoundException {
		//userinfoService Ŭ������ �޼ҵ带 ȣ���Ͽ� ���� ó��
		// => ���� ���н� ���� �߻� 
		userinfoService.loginAuth(userinfo);		
		
		//���� ���� - HttpSession ��ü�� ���� ���� ������ ����
		session.setAttribute("loginUserinfo", userinfoService.getUserinfo(userinfo.getUserid()));
		
		return "userinfo/user_login";
	}
	
	// �α׾ƿ��� ó���ϴ� ��ûó�� �޼ҵ�
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
			// session�� ����ε� or loginUserinfo �Ӽ��� ����
		return "userinfo/user_login";
	}

	// ȸ������� ����ϴ� ��ûó�� �޼ҵ�
	// => �α��� ����ڸ� ��û �����ϵ��� ���ͼ��� �̿�
	@RequestMapping("/list")
	public String logout(Model model) {
		model.addAttribute("userinfoList", userinfoService.getUseinfoList());
		return "userinfo/user_list";
	}

	
	// ȸ���������� ����ϴ� ��û ó�� �޼ҵ�
	// => �α��� ����ڸ� ��û�����ϵ��� ���ͼ��� �̿�
	@RequestMapping("/view")
	public String view(@RequestParam String userid, Model model) throws UserinfoNotFoundException {
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_view";
	}

	// ȸ�������� �����ϴ� ������ �Է��ϴ� �������� ����ϴ� ��û ó�� �޼ҵ�
	// => �����ڸ� ��û�����ϵ��� ���ͼ��� �̿�
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@RequestParam String userid, Model model) throws UserinfoNotFoundException {
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_modify";
	}
	
	// ȸ�������� �����ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute Userinfo userinfo, HttpSession session) throws UserinfoNotFoundException {
		userinfoService.modifyUserinfo(userinfo);
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		// ����ȸ���� ���� �α��� ������� ��� ���ǿ� ����� ���� ���� ����
		if(loginUserinfo.getUserid().equals(userinfo.getUserid())) {
			session.setAttribute("loginUserinfo", userinfoService.getUserinfo(userinfo.getUserid()));
				// ���ǿ� ����� ������ ������ �����̱� ������ ������ ������ �ٲ�����Ѵ�.
		}
		
		return "redirect:/userinfo/view?userid="+userinfo.getUserid();
	}
	
	// ȸ�������� �����ϴ� ��û ó�� �޼ҵ�
	// => �����ڸ� ��û�����ϵ��� ���ͼ��� �̿�
	@RequestMapping("/remove")
	public String remove(@RequestParam String userid,HttpSession session) throws UserinfoNotFoundException {
		userinfoService.removeUserinfo(userid);
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		// ����ȸ���� ���� �α��� ������� ��� �α׾ƿ� ó���ϰ� �ƴ� ��� ȸ�������� ��û
		if(loginUserinfo.getUserid().equals(userid)) {
			return "redirect:/userinfo/logout";
		} else {
			return "redirect:/userinfo/list";
			
		}
	}
	
	
	
	// @ExceptionHandler : Controller Ŭ������ ��û ó�� �޼ҵ忡�� ���޵� ���ܸ� ó���ϱ�
	// ���� ����ó�� �޼ҵ带 �����ϴ� ������̼�
	// value �Ӽ� : ���� ó���� ���� Ŭ����(Clazz)�� �Ӽ������� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
		// try ~ catch �� ���� ���� ó���� �� ������ �̸� Front Controller���� �����Ͽ� ó���� �� �ִ�.
		// ���޵� ���� - throws�� ���� ���޵Ǵ� ���ܸ� �ǹ�
		// �߻��� ���ܴ� Front Controller���� �ְ� Front Controller�� ExceptionHandler�� ���� ���ܸ� ó���Ѵ�.
		// => �ڵ鷯�� ������ ó��(500������ �߻����� �ʴ´�.) / ������ 500 �����ڵ� �߻�
	@ExceptionHandler(UserinfoExistsException.class)
	// ����ó�� �޼ҵ��� �Ű��������� ���� ���� ������ ���޹޾� �����Ͽ� ���� ó�� �� ViewName ��ȯ - JSP ����
	public String exceptionHandler(UserinfoExistsException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userinfo", exception.getUserinfo());
		
		return "userinfo/user_writer";
			// ���ܸ� ó���ϰ� ViewName�� ��ȯ�Ͽ� ���ܸ� ó���� �� �ְ� �ۼ���.
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
		// ��� ���ܸ� �� ��Ƴ���. - �ٸ� ��Ʈ�ѷ����� �߻��� ���ܴ� ���� �� ����.
	public String exceptionHandler() {
		
		return "userinfo/user_error";
	}
		// ���⼭ ������ Exception Handler�� UserinfoController ���� �����Ǵ� ���ܸ�
		// ó�� �����ϴ�.
		// �ٸ� ��Ʈ�ѷ����� �߻��� ���ܴ� ���� �� ����.
}









