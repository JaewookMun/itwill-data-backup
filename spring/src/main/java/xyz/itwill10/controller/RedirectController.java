package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	@RequestMapping("/forward_print")
	public String forward(Model model) {
		// ������������ ����� ��ü ���� - Request Scope
		model.addAttribute("name", "ȫ�浿");
		
		// ViewName ��ȯ >> ��������(JSP)�� ������ �̵�
		// ������ �̵� : ���������� �ٸ� �����α׷����� �����带 �̵��Ͽ� ���� ó��
		// => Ŭ���̾�Ʈ�� ��û URL �ּ� �̺���, Request Scope�� �����Ǵ� ��ü ���
		return "movement/forward_display";
	}
	
	/*
	@RequestMapping("/redirect_print")
	public String redirect(Model model) {
		model.addAttribute("name", "�Ӳ���");
		return "movement/redirect_display";
	}
	
	
	@RequestMapping("/redirect")
	public String redirect() {
		// ��ȯ�Ǵ� ViewName�� redirect ���λ�(NameSpace)�� ����ϸ� �����̷�Ʈ �̵�
		// => ViewName�� ���� ��������(JSP)�� �����ϴ� ��� Ŭ���̾�Ʈ���� URL �ּ� ����
		// �����̷�Ʈ �̵� : Ŭ���̾�Ʈ���� URL �ּҸ� �����Ͽ� ���û�Ͽ� ���� ó��
		// => Ŭ���̾�Ʈ�� ��û URL �ּ� ����, Request Scope�� �����Ǵ� ��ü ��� �Ұ���
			// ���û�ϱ� ������ �ٸ� ������Ʈ�� ����Ѵ�.
		return "redirect:/redirect_print";
	}
	*/

	@RequestMapping("/redirect_print")
	public String redirect() {
		return "movement/redirect_display";
	}
	
	// RedirectAttributes : �����̷�Ʈ �̵��� ���� ȣ��Ǵ� ��û ó�� �޼ҵ��� ������������
	// �Ӽ����� �����ϱ� ���� ��ü
	
	@RequestMapping("/redirect")
	public String redirect(/*Model model*/ RedirectAttributes attributes) {
		// model.addAttribute("name", "�Ӳ���");
		
		// RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
		// => �����̷�Ʈ �̵��� ���� ȣ��Ǵ� ��û ó�� �޼ҵ��� ������������ ������ �Ӽ����� �����ϴ� �޼ҵ�
			// addAttribute�� ����ϸ� �ȵȴ�. - Model �������̽��� ��ӹ��� �������̽�
		attributes.addFlashAttribute("name", "�Ӳ���");
		
		return "redirect:/redirect_print";
			// redirect: ���λ縦 �ٿ��� �����̷�Ʈ �̵��� ��ų �� �ִ�.
	}
	
		// �Ϲ������� ������ �̵��� ���� ����ϳ� �ʿ信 ���� �����̷�Ʈ�� �̿��� �� �ִ�.
		// eg) ȸ������ �� ���� ���� �������� ����� �� ������ �ٸ� �ּҷ� �����̷�Ʈ �̵���ų ���� �ִ�.
		// => ������ ������ ������ ���� ����� �޶�����.
	
}
