<%@page import="xyz.itwill.dto.MyUser"%>
<%@page import="xyz.itwill.dao.MyUserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyUserDAO.getDAO().insertUser(new MyUser("aaa", "홍길동"));
	MyUserDAO.getDAO().insertUser(new MyUser("bbb", "임꺽정"));
	MyUserDAO.getDAO().insertUser(new MyUser("ccc", "전우치"));
		// 위 명령이 제대로 실행된다는 것은 맵퍼역시 제대로 설정되었다는 것이다.

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
</head>
<body>
	<h1>회원등록</h1>
	<hr>
	<h3>회원정보를 성공적으로 등록하였습니다.</h3>
</body>
</html>