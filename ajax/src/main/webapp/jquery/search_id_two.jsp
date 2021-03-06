<?xml version="1.0" encoding="utf-8"?>
<%@page import="xyz.itwill.dto.AjaxMemberDTO"%>
<%@page import="xyz.itwill.dao.AjaxMemberDAO"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이름과 이메일을 전달받아 AJAX_MEMBER 테이블에 저장된 해당 회원의 아이디를 검색하여
XML 텍스트 데이터로 응답하는 JSP 문서 --%>

<%
	if(request.getMethod().equals("GET")){
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}
	
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	
	// String id=AjaxMemberDAO.getDAO().selectAjaxMemberId(name, email);
	
	AjaxMemberDTO ajaxMember=new AjaxMemberDTO();
	ajaxMember.setName(name);
	ajaxMember.setEmail(email);
	
	String id=AjaxMemberDAO.getDAO().selectAjaxMemberId(ajaxMember);
	
	/*
		MyBatis의 경우 값을 하나만 전달할 수 있다.
		값이 여러개 있을 경우 DTO를 생성하여 전달하는 경우가 많기 때문에 selectAj~() 메소드에 파라미터로 DTO 값을 전달
	
	*/
%>

<result>
	<% if(id!=null){ // 검색된 아이디가 있는 경우 %>
	<code>ok</code>
	<id><%=id%></id>
	<% } else { // 검색된 아이디가 없는 경우 %>
	<code>empty</code>
	<% } %>
</result>