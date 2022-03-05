<?xml version="1.0" encoding="utf-8"?>
<%@page import="xyz.itwill.util.Utility"%>
<%@page import="xyz.itwill.dao.AjaxCommentDAO"%>
<%@page import="xyz.itwill.dto.AjaxCommentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX_COMMENT 테이블에 저장된 모든 댓글정보를 검색하여 XML 텍스트 데이터로 응답하는 JSP 문서 --%>

<%
	List<AjaxCommentDTO> ajaxCommentList=AjaxCommentDAO.getDAO().selectAjaxCommentList();
%>

<result>
	<% if(!ajaxCommentList.isEmpty()) { // 검색결과가 있는 경우 %>
	<code>success</code>
	<data><![CDATA[
		<%-- parser는 CDATA 세션 안에 있는 내용을 해석하지 않고 값(데이터)으로 인식한다.
		> 사용할 수 있는 문자를 사용가능 e.g. 부등호, 더블쿼테이션 등... --%>
		[
		<% for(int i=0; i<ajaxCommentList.size(); i++) { %>
			<% if(i>0) { %>,<%}%>
			{"num": <%=ajaxCommentList.get(i).getNum()%>,
				<%-- num은 숫자이기 때문에 ~getNum()은 더블쿼테이션이 없다. --%>
			"writer": "<%=Utility.toJSON(ajaxCommentList.get(i).getWriter())%>",
			"content": "<%=Utility.toJSON(ajaxCommentList.get(i).getContent())%>",
				<%-- 사용자 입력값을 그대로 사용할 수 없을 때 회피문자를 활용하여 문제를 해결한다. --%>
			"writeDate": "<%=ajaxCommentList.get(i).getWriteDate()%>"}
		<%}%>
		]
	]]></data>
	<% } else { // 검색결과가 없는 경우 %>
	<code>empty</code>
	<message><![CDATA[첫번째 댓글을 입력해 주세요.]]></message>
	<% } %>
</result>