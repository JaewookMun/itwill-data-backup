package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill10.dto.Member;

@Controller
public class JoinController {
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
	/*
	// ���ް��� �̸��� ���� �̸��� �Ű������� �ۼ��Ͽ� ���ް� ����
	// @RequestParam ������̼��� ����Ͽ� �Ű������� �̸��� ���� �̸��� ���ް��� ���� ��� 400 ���� �߻�
	// => value �Ӽ��� �̿��Ͽ� �Ű������� �ٸ� �̸��� ���ް��� �����޾� �Ű������� ���尡��
		// �Ϲ������� ���ް��� �Ű������� �̸��� �����ϴ� ���� ����
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		
		return "join_display";
	}
	*/

	/*
	// @ModelAttribute ������̼��� �Ű������� ������ ��� �Ű������� ����� ���� ��û ó��
	// �޼ҵ��� ���������� �ڵ����� ����
	// => �Ű������� �̸��� ���� �̸��� ���ް��� ��� 400 ���� �̹߻�
	// => �Ű������� �ڷ����� �⺻��(Wrapper) �Ǵ� ���ڿ�(String)�� ��� value �Ӽ��� �ݵ�� ����
	// value �Ӽ� : ������������ �Ű������� ����� ���� �����ϴ� �Ӽ����� �Ӽ������� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
		// �Ϲ� �������� ��� value �Ӽ��� ǥ��� ���û���
		// RequestParam �� ModelAttribute�� ���� ����� �� ����.
		// value - view���������� ����� �̸�
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute(value="id") String id
			, @ModelAttribute("passwd") String passwd
			, @ModelAttribute("name") String name
			, @ModelAttribute("email") String email) {
		
		return "join_display";
	}
	*/
	
		/*
			���ް��� ����� �뵵�� ����ϴ� ���� ���� ����. (SQL ó��)
			ModelAttribute�� Form �±׿��� �ַ� ���ȴ�.
		 */
	
	// ��û ó�� �޼ҵ��� �Ű����� �ڷ����� JavaBean Ŭ������ ������ ��� JavaBean ��ü��
	// �����Ͽ� ���ް��� �ʵ忡 �ڵ����� �����Ͽ� ���� - Command ��ü
	// Command ��ü : ���ް��� �ʵ忡 ������ ��ü�� �Ű������� �ڵ� ����ǰ� ������������
	// ���ǵ��� �����Ǵ� ��ü
	// => ���ް��� ������ �̸��� �ʵ忡 ����
	// Command ��ü�� ���������� �����ǵ��� @ModelAttribute ������̼��� ����Ͽ� ����
	// => @ModelAttribute ������̼��� �ۼ����� �ʾƵ� �ڵ� ó��
	// => value �Ӽ��� ������ ��� Ŭ�������� �Ӽ������� �ڵ� ���� - ù���ڴ� �ҹ��ڷ� ��ȯ
		// �ش��ϴ� �ʵ尡 ������ ����� �� ����.
		// �ۼ����� �ʾƵ� ������, Command ��ü �տ� ModelAttribute�� �ۼ��ϴ� ���� �����̴�.
		// Java Bean ��ü�� �θ��� �ʰ� ���⼭�� Command ��ü��� �θ���. (��û�� ���� ��ü)
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute("mem") Member member, Model model) {
		if(member.getId().equals("abc123")) { // ���̵� �ߺ��� ���
			model.addAttribute("message", "�̹� ������� ���̵��Դϴ�.");
			return "join_form";
		}
		
		return "join_display";
	}
		// ModelAttribute�� ����ϸ� ��ûó�� �޼ҵ��� ��� ������������ �Ű������� ����� ���ް����� ����� �� �ִ�.
}
