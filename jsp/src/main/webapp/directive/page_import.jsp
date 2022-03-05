<%-- page Directive에서는 동일한 속성에 다른 속성값으로 중복 선언한 경우 500 에러 발생 --%>
<%-- => import 속성은 다른 속성값으로 여러번 선언 가능 --%>
<%-- <%@page import="java.util.ArrayList, java.util.List"%> --%>
<%-- page Directive의 import 속성은 이클립스에서 자동 완성 --%>
	<%-- 동일 속성값으로하면 에러 발생하지 않는다. --%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<%-- 기본적으로 session 속성값은 true로 되어있음 > 세션이 자동으로 바인딩되어 제공 --%>
		
<%
	// java.util.List<java.lang.String> nameList = new java.util.ArrayList<java.lang.String>();
	List<String> nameList = new ArrayList<String>();
	
	nameList.add("홍길동");
	nameList.add("임꺽정");
	nameList.add("전우치");
	nameList.add("일지매");
	nameList.add("장길산");
		// page directive는 대다수는 기본값을 이용 contentType, import, error 체크
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>page Directive - import 속성</h1>
	<hr>
	<p>JSP 문서에서 사용될 클래스 또는 인터페이스의 패키지를 명확하게 표현하기 위한 속성</p>	
	<hr>
	<ul>
		<% for(String name : nameList){%>
			<%-- <li><%= name %></li> --%>
		<% } %>
	</ul>
</body>
</html>