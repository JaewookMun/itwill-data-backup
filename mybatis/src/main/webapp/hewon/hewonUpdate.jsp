<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디가 [xxx]인 회원의 이름을 [홍길동]으로 변경 --%>
<%
	/*
	MyHewon hewon=new MyHewon(); // 인스턴스 필드에는 기본값 전달
	hewon.setId("xxx");
	hewon.setName("홍길동");
	
	// 전달되는 회원정보 중 아이디와 이름을 제외한 필드에는 기본값이 저장되어 전달
	// => MYHEWON 테이블에 저장된 회원정보가 비정상적으로 변경
	MyHewonDAO.getDAO().updateHewon(hewon);
	*/
	
	// 변경되지 않는 컬럼에 대한 필드값도 기존값으로 변경하여 전달
	MyHewon hewon=new MyHewon(); 
	hewon.setId("xxx");
	hewon.setName("홍길동");
	hewon.setPhone("010-5486-1324");
	hewon.setEmail("xxx@itwill.xyz");
	hewon.setState(4);
	MyHewonDAO.getDAO().updateHewon(hewon);
	
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