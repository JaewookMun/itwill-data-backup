package xyz.itwill10.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.itwill10.dto.Member;

// REST(Representation State Transfer) ����� �����ϴ� ��Ʈ�ѷ�
// REST : Ŭ���̾�Ʈ ��û�� ���� ��û ó�� �޼ҵ忡�� ��û ó�� �� ó�� ����� ���ҽ�
// (TEXT, XML, JSON ��)�� �����ϴ� ���
// => �پ��� ����� ��û�� ���� �������� ���������� ó�� ������ �ؽ�Ʈ �����ͷ� �����ϴ� ���� ������ �����α׷�
// => ����Ʈ�� ������ �� AJAX ������� ��û�ϰ� �������� JSON���� �����޾� DHTML�� ������ ��ȯ �ۼ�
	// JSP�� �����ϴ� ���� �ƴ϶� ���ҽ��� ���� (JSON�� ���� ���)
	// XML ��� JSON�� ���� - �����͸� �����ϰ� ǥ���� �� �ִ�. > high speed
	// �پ��� ��⿡�� ���۵� �� �ִ� ���α׷��� ����� ���ؼ� REST�� ����Ѵ�.
	// ����Ʈ��� ���� ��� ��κ� REST�� ���� �����͸� �ְ�޴´�.
	// ���̺긮�� �� - ���ͳ��� ���� �ʿ��� ������ �ְ�޴� ���ø����̼� (�̶�, REST�� ���� �ְ�޴´�.)
	// ����Ƽ�� �� - ���ͳ��� �ȵǵ� �۵� 
	// => ��� ���ο� ����� �����͸� ���� �۵�
	// ����Ͽ��� DB�� �����ϴ� ���� ���� ����. ��κ��� ���α׷��� �� ���α׷��� �� ó���ϰ�
	// ����Ͽ����� �����α׷��� ó���� �������� ����±���� ���� 
	// Front Controller�� �ΰ� ����� ��� ���� - 1. ��(classic) / 2. mobile ���(REST ����� ���� JSON���� ����)
@Controller
public class RestfulController {
	
	@RequestMapping(value="/rest", method = RequestMethod.GET)
	public String rest() {
		return "rest/input";
	}
	
	/*
	@RequestMapping(value="/rest", method = RequestMethod.POST)
	public String rest(@RequestParam String id, @RequestParam String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "rest/output";
	}
	*/
	
	// @ResponseBody : ��û ó�� �޼ҵ��� ��ȯ��(���ڿ�)�� Ŭ���̾�Ʈ���� ���� ����ǵ��� �����ϴ� ������̼�
	// => ���ڿ�(String)�θ� ���� ���� - Java �ڷ����� Bean ��ü�� ���� �Ұ���
	// @RequestBody : POST, PUT, PATCH, DELETE ���� ��û�� ���� ���޵� ��� ���� JSON ������
	// �ؽ�Ʈ ������(Object ��ü)�� ���޹޾� �����ϱ� ���� ������̼� 
	// => ���ް� : �̸�=��&�̸�=��&... >> Object ��ü : {�̸�:��,�̸�:��,...}
	// => GET ������� ��û�Ͽ� ���޵� ���� �Ű������� ���� �Ұ���
	// => AJAX ��û�� ���� ���޵� ���� �����ϱ� ���� ���
		// JS�� Object ��ü ǥ�����	
		// Front Controller���� ���� �ʰ� ���� ����
		// text�� ���޵� ���� JavaScript�� JSON Ŭ������ �޼ҵ带 ���� Object�� �Ľ̵� �� �ִ�. -> JSON.parse(text);
		// GET����� request message�� body�� �ƴ϶� url�� query string���� ���޵Ǳ� ������ @Requestbody�� GET�� ����� �� ����. 
	@RequestMapping(value="/rest", method = RequestMethod.POST)
	@ResponseBody
	public String rest(@RequestBody String input) {
		System.out.println(input);
		return input;
	}
		// REST���� ����ϴ� ������̼� RequestBody(����) / ResponseBody(����) 2�� - �ϱ�
	
	// ȸ�������� JSON ������ �ؽ�Ʈ �����ͷ� �����ϴ� ��û ó�� �޼ҵ�
	// => ���ڿ��� �ƴ� Java �ڷ����� ��ü�� ������ ��� 406 ���� �߻�
	// Java �ڷ����� ��ü�� JSON ������ �ؽ�Ʈ ������(���ڿ�)�� �ڵ���ȯ�Ͽ� ����ǵ��� ����
	// => jackson-databind ���̺귯�� ���� ó��
		// pom.xml�� ���� ó�� �� ������ �۾��� �ʿ����� ����.
	@RequestMapping("/rest_member")
	@ResponseBody
	public Member restMember() {
		Member member=new Member();
		member.setId("abc123");
		member.setPasswd("123456");
		member.setName("ȫ�浿");
		member.setEmail("abc@itwill.xyz");
		
		return member;
	}
	
	@RequestMapping("/rest_memberList")
	@ResponseBody
	public List<Member> restMemberList(){
		List<Member> memberList=new ArrayList<Member>();
		
		Member member1=new Member();
		member1.setId("abc123");
		member1.setPasswd("123456");
		member1.setName("ȫ�浿");
		member1.setEmail("abc@itwill.xyz");
		memberList.add(member1);
		
		Member member2=new Member();
		member2.setId("xyz789");
		member2.setPasswd("789123");
		member2.setName("�Ӳ���");
		member2.setEmail("xyz@itwill.xyz");
		memberList.add(member2);
		
		return memberList;
			// List�� ���� List ��ü�� ��ȯ�ϸ� Array ��ü�� ���޵ȴ�.
			// JSON Viewer �� ��ġ�Ǿ��ֱ� ������ JSON �ؽ�Ʈ �����͸� ���� Ȯ�ΰ��� (AJAX �н��� chrome�� �÷����� ��ġ)
	}
		// important!!
	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String input() {
		return "rest/input";
	}
	
	// �Ű������� �ڷ����� Map���� �����ϸ� ��� ���ް��� Map ��ü�� ��Ʈ��(Key:�̸�,Value:���ް�)�� 
	// �����޾� ���� - @RequestParam ������̼��� �ݵ�� ����Ͽ� ����
	// => JavaBean(DTO) Ŭ������ ���� ��� Map ��ü�� �̿��Ͽ� ���ް��� ���� �ްų� ���� ó�� 
		// ���ް��� �޾� �����Ϸ��� ���� �Ķ���ͷ� �ްų� Command ��ü�� �޾ƾ��Ѵ�. - command ��ü�� ��� �ش� Ŭ������ �����ؾ��� (����)
		// => Map�� ����ϸ� ��Ʈ�� ���·� �ڵ� ����
		// Map�� ����� �� RequestParam�� �����ϸ� ���� �߻�
		// DTO�� �ȸ������ �� ����ϸ� ���ϴ�. - Java bean ���� Object ��ü�� �����ϴ� ���
	@RequestMapping(value = "/map", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> output(@RequestParam Map<String, String> map){
		return map;
	}
	
}
