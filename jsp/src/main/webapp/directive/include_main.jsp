<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>include Directive</h1>
	<hr>
	<p>컨텍스트에 존재하는 파일의 코드를 현재 JSP 문서에 포함하는 지시어 - 정적 포함</p>
		<%-- 파일의 코드를 포함시킨다. e.g. html, css, or java 코드 --%>
	<hr>
	<%-- 
	<p>클라이언트 요청에 대한 응답</p>
	<p>클라이언트 요청에 대한 응답</p>
	<p>클라이언트 요청에 대한 응답</p>
	<p>클라이언트 요청에 대한 응답</p>
	<p>클라이언트 요청에 대한 응답</p>
	<p>클라이언트 요청에 대한 응답</p>
	<p>클라이언트 요청에 대한 응답</p>
	<p>클라이언트 요청에 대한 응답</p>
	<p>클라이언트 요청에 대한 응답</p>
	<p>클라이언트 요청에 대한 응답</p>
	--%>
	
	<%-- file 속성값으로 설정된 외부파일의 내용(코드)을 include Directive 위치에 포함 --%>
	<%-- => file 속성값으로 설정된 외부파일이 존재하지 않을 경우 에러 발생 --%>
	<%@include file="include_sub.jspf" %> 
		<%-- 코드를 포함시킨다. --%>
		<%-- 프로그램을 만들 때 코드의 중복이 발생한다. 이는 유지보수를 어렵게 만들 뿐 아니라 속도도 느리게 만든다. --%>
</body>
</html>