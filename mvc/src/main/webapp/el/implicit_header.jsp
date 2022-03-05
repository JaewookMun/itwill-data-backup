<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>El 내장객체 - Request Header</h1>
	<hr>
	<h3>EL 미사용</h3>
	<ul>
		<li>접속서버 = <%=request.getHeader("host")%></li>
		<li>브라우저 종류 = <%=request.getHeader("user-Agent")%></li>
		<li>Accept = <%= request.getHeaders("accept").nextElement() %></li>
			<%-- 클라이언트가 리퀘스트 메세지를 보낼 떄 Header 부분에 필요한 클라이언트 관련정보 전달 --%>
	</ul>
	<hr>
	<h3>EL 사용</h3>
	<ul>
		<li>접속 서버 = ${header.host }</li>
		<li>브라우저 종류 = ${header["user-Agent"] }</li>
		<li>Accept = ${headerValues.accept[0] }</li>
	</ul>
</body>
</html>