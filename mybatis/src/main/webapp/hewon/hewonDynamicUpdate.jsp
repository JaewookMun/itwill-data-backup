<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디가 [xxx]인 회원의 이름을 [홍경래]으로 변경 --%>
<%
	
	// 변경되지 않는 컬럼에 대한 필드값도 기존값으로 변경하여 전달
	MyHewon hewon=new MyHewon(); 
	hewon.setId("xxx");
	hewon.setName("홍경래");
	MyHewonDAO.getDAO().updateDynamicHewon(hewon);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
</head>
<body>
	<h1>회원변경</h1>
	<hr>
	<h3>회원정보를 성공적으로 변경 하였습니다.</h3>

</body>
</html>