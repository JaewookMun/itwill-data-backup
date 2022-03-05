<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="simple" uri="http://www.itwill.xyz/mvc/simple" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - AnyAttribute And AnyBody</h1>
	<simple:helloBody test="true">홍길동</simple:helloBody>
	<simple:helloBody test="false">임꺽정</simple:helloBody>
	<hr>
	<%
		String name="홍길동";
		request.setAttribute("name", name);
	%>
	<simple:helloBody test="홍길동"><%=name%></simple:helloBody>
	<simple:helloBody test="홍길동">${name }</simple:helloBody>
		<%-- tld 작성시 body에 jsp를 적었기 때문에 JSP 관련 표현을 사용할 수 있다. --%>
	<hr>
	<%
		boolean sw=true;
		request.setAttribute("sw", sw);
	%>
	<simple:helloBody test="<%=sw %>">임꺽정</simple:helloBody>
	<simple:helloBody test="${sw }">임꺽정</simple:helloBody>
		<%-- 속성에는 JSP expression과 EL Language 사용안됨-해결방법 --%>
		<%-- 커스텀 태그 - JSP 스크립트를 태그를 통해 대신 사용할 수 있도록 처리 --%>
</body>
</html>