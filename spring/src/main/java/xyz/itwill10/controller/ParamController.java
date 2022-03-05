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
	// ��û ó�� �޼ҵ忡 HttpServletRequest �ڷ����� �Ű������� �����Ͽ� Ŭ���̾�Ʈ��
	// ��û����(������Ʈ �޼��� - HttpServletRequest ��ü)�� �ڵ����� �����޾� ����
	// => HttpServletRequest ��ü�� �̿��Ͽ� ���ް��� ��ȯ�޾� ���
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String form(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "param_display";
	}
	*/

	/*
	// ���ް��� �̸��� ������ �̸��� �Ű�����(String)�� �����ϸ� �ڵ����� ���ް��� �Ű������� ����Ǿ� ����
		// ���ް��� �̸��� �Ű������� �̸��� ���ƾ��ϴ� ���� �߿��ϴ�.
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String form(String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
		// POST ����� ������Ʈ �޽����� �ٵ� ���� - ISO-8859-1 Ÿ�� (�ѱ��� �������δ�.)
		// => Filter ���α׷� Ȱ�� c.f. MVC
		// ��û URL�� ����� ó���޼ҵ尡 ȣ��Ǳ� ���� ����Ŭ������ �Է°��� ��ó��
		// Spring MVC - web.xml���� Encoding Filter Ŭ������ �����ϴ� ���� �ʼ���.
	
	/*
	// @RequestParam : ���ް��� �Ű������� �����ϱ� ���� ������̼�
	// => �Ű������� �̸��� ���� �̸��� ���ް��� ���� ��� 400 ���� �߻�
	// => �Ű������� �ݵ�� ����ǵ��� ����ϴ� ������̼�
		// Bad Request Error�� �ǵ������� �߻���Ŵ - �ʼ� ���ް��� ������ �����߻�
		// => �ʼ� ���ް��� ���� Ȱ�� ����
		// RequestParam ������̼��� �ۼ����� ������ ������ �߻����� �ʰ� ����������� �̵��Ѵ�.
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String form(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	/*
	// @RequestParam ������̼��� value �Ӽ��� ����Ͽ� ���ް��� �̸��� ���� ���� ����
	// value �Ӽ� : ���ް��� �̸��� �Ӽ������� ����
	// => ���ް��� �̸��� �Ű������� �̸��� �ٸ� ��� ���
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	// required �Ӽ� : false(���ް� ����) �Ǵ� true(���ް� �ʼ� - �⺻) �� �ϳ��� �Ӽ������� ����
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String form(@RequestParam(value = "username", required = true) String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	// defaultValue �Ӽ� : ���ް��� ���� �Ű������� �ƹ��� ���� ������� ���� ��� �Ű�������
	// ����� �⺻���� �Ӽ������� ����
		// username���� ���޵Ǵ� ���� ���� ��� ����� �⺻�� ���� - �ڵ�����.
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String form(@RequestParam(value = "username", defaultValue = "�Ӳ���") String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
}
