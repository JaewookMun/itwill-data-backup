<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>회원목록</h1>
	<hr>
	<c:forEach var="member" items="${memberList }">
		<div>아이디 = ${member.id }, 이름 = ${member.name }</div>
	</c:forEach>
	
		<%--
			web-inf private 폴더이기 때문에 이제 jsp문서를 요청하면 접근할 수 없다.
		--%>
</body>
</html>