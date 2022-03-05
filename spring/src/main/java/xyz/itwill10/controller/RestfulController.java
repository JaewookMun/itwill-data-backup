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

// REST(Representation State Transfer) 기능을 제공하는 컨트롤러
// REST : 클라이언트 요청에 대한 요청 처리 메소드에서 요청 처리 후 처리 결과를 리소스
// (TEXT, XML, JSON 등)로 응답하는 기능
// => 다양한 기기의 요청에 대한 응답결과로 공통적으로 처리 가능한 텍스트 데이터로 응답하는 것이 목적인 웹프로그램
// => 사이트를 구현할 때 AJAX 기능으로 요청하고 응답결과를 JSON으로 제공받아 DHTML로 페이지 변환 작성
	// JSP로 응답하는 것이 아니라 리소스를 제공 (JSON을 많이 사용)
	// XML 대비 JSON의 장점 - 데이터를 간결하게 표현할 수 있다. > high speed
	// 다양한 기기에서 동작될 수 있는 프로그램을 만들기 위해서 REST를 사용한다.
	// 스마트기기 같은 경우 대부분 REST를 통해 데이터를 주고받는다.
	// 하이브리드 앱 - 인터넷을 통해 필요한 정보를 주고받는 어플리케이션 (이때, REST를 통해 주고받는다.)
	// 네이티브 앱 - 인터넷이 안되도 작동 
	// => 기기 내부에 저장된 데이터를 통해 작동
	// 모바일에서 DB에 연결하는 등의 일은 없다. 대부분의 프로그램은 웹 프로그램이 다 처리하고
	// 모바일에서는 웹프로그램이 처리한 데이터의 입출력기능을 구현 
	// Front Controller를 두개 만드는 경우 존재 - 1. 웹(classic) / 2. mobile 기기(REST 기능을 통해 JSON으로 전달)
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
	
	// @ResponseBody : 요청 처리 메소드의 반환값(문자열)을 클라이언트에게 직접 응답되도록 설정하는 어노테이션
	// => 문자열(String)로만 응답 가능 - Java 자료형의 Bean 객체는 응답 불가능
	// @RequestBody : POST, PUT, PATCH, DELETE 등의 요청에 의해 전달된 모든 값을 JSON 형식의
	// 텍스트 데이터(Object 객체)로 전달받아 저장하기 위한 어노테이션 
	// => 전달값 : 이름=값&이름=값&... >> Object 객체 : {이름:값,이름:값,...}
	// => GET 방식으로 요청하여 전달된 값을 매개변수에 저장 불가능
	// => AJAX 요청에 의해 전달된 값을 저장하기 위해 사용
		// JS의 Object 객체 표현방식	
		// Front Controller에게 주지 않고 직접 전달
		// text로 전달된 값은 JavaScript의 JSON 클래스의 메소드를 통해 Object로 파싱될 수 있다. -> JSON.parse(text);
		// GET방식은 request message의 body가 아니라 url의 query string으로 전달되기 때문에 @Requestbody는 GET을 사용할 수 없다. 
	@RequestMapping(value="/rest", method = RequestMethod.POST)
	@ResponseBody
	public String rest(@RequestBody String input) {
		System.out.println(input);
		return input;
	}
		// REST에서 사용하는 어노테이션 RequestBody(저장) / ResponseBody(응답) 2개 - 암기
	
	// 회원정보를 JSON 형식의 텍스트 데이터로 응답하는 요청 처리 메소드
	// => 문자열이 아닌 Java 자료형의 객체로 응답할 경우 406 에러 발생
	// Java 자료형의 객체를 JSON 형식의 텍스트 데이터(문자열)로 자동변환하여 응답되도록 설정
	// => jackson-databind 라이브러리 빌드 처리
		// pom.xml에 빌드 처리 후 별도의 작업이 필요하지 않음.
	@RequestMapping("/rest_member")
	@ResponseBody
	public Member restMember() {
		Member member=new Member();
		member.setId("abc123");
		member.setPasswd("123456");
		member.setName("홍길동");
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
		member1.setName("홍길동");
		member1.setEmail("abc@itwill.xyz");
		memberList.add(member1);
		
		Member member2=new Member();
		member2.setId("xyz789");
		member2.setPasswd("789123");
		member2.setName("임꺽정");
		member2.setEmail("xyz@itwill.xyz");
		memberList.add(member2);
		
		return memberList;
			// List를 만들어서 List 객체로 반환하면 Array 객체로 전달된다.
			// JSON Viewer 가 설치되어있기 때문에 JSON 텍스트 데이터를 쉽게 확인가능 (AJAX 학습시 chrome에 플러그인 설치)
	}
		// important!!
	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String input() {
		return "rest/input";
	}
	
	// 매개변수의 자료형을 Map으로 선언하면 모든 전달값을 Map 객체의 엔트리(Key:이름,Value:전달값)로 
	// 제공받아 저장 - @RequestParam 어노테이션을 반드시 사용하여 선언
	// => JavaBean(DTO) 클래스가 없는 경우 Map 객체를 이용하여 전달값을 제공 받거나 응답 처리 
		// 전달값을 받아 저장하려면 개별 파라미터로 받거나 Command 객체로 받아야한다. - command 객체의 경우 해당 클래스가 존재해야함 (생성)
		// => Map을 사용하면 엔트리 형태로 자동 저장
		// Map을 사용할 때 RequestParam을 제거하면 에러 발생
		// DTO를 안만들어줄 때 사용하면 편리하다. - Java bean 없이 Object 객체로 전달하는 방법
	@RequestMapping(value = "/map", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> output(@RequestParam Map<String, String> map){
		return map;
	}
	
}
