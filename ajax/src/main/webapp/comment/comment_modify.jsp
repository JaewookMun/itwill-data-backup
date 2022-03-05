<?xml version="1.0" encoding="utf-8"?>
<%@page import="xyz.itwill.dao.AjaxCommentDAO"%>
<%@page import="xyz.itwill.dto.AjaxCommentDTO"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 댓글정보를 전달받아 AJAX_COMMENT 테이블에 저장도니 댓글정보를 변경하고 변경결과를
XML 텍스트 데이터로 응답하는 JSP 문서 --%>

<%
	if(request.getMethod().equals("GET")){
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}

	request.setCharacterEncoding("UTF-8");
	
	int num=Integer.parseInt(request.getParameter("num"));
	String writer=request.getParameter("writer");
	String content=request.getParameter("content");
	
	AjaxCommentDTO ajaxComment=new AjaxCommentDTO();
	ajaxComment.setNum(num);
	ajaxComment.setWriter(writer);
	ajaxComment.setContent(content);
	
	int rows=AjaxCommentDAO.getDAO().updateAjaxComment(ajaxComment);
%>

<result>
	<% if(rows>0) { // 변경행이 있는 경우 %>
	<code>success</code>
	<% } else { // 변경행이 없는 경우 %>
	<code>error</code>
	<% } %>

</result>