<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// POST 방식으로 요청하여 전달된 값에 대한 캐릭터셋(인코딩) 변경
	request.setCharacterEncoding("utf-8");

	//전달값을 반환받아 저장
	String name=request.getParameter("name");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
</head>
<body>
	<%=name%>님, 환영합니다.
</body>
</html>