<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css">
	<%-- head 영역은 include 태그를 쓰는 것보다는 link 태그 사용을 권장 
		일반적으로 <head>부분은 include로 동일한 생성을 권장하지 않는다. --%>
<%-- 
<style type="text/css">
	div {
		margin: 5px;
		padding: 5px;
	}

	#header {
		height: 200px;
		border: 1px solid red;
	}
	
	#header h1{
		text-align: center;
	}
	
	#menu {
		font-size: 1.5em;
		text-align: right;
	}
	
	#menu a, #menu a:visited {
		text-decoration: none;
		color: black;
	}
	
	#menu a:hover {
		color: orange;
	}

	#content {
		min-height: 500px;
		border: 1px solid green;
		text-align: center;
	}
	
	#footer {
		height: 150px;
		border: 1px solid blue;
		text-align: center;
		font-size: 1.2em;
	}
</style>
 --%>
</head>
<body>
	<%-- header 영역 : 로고, 메뉴 등 --%>
	<%-- 
	<div id="header">
		<h1><a href="index.jsp">쇼핑몰</a></h1>
		<div id="menu">
			<a href="product.jsp">제품소개</a>&nbsp;&nbsp;
			<a href="cart.jsp">장바구니</a>&nbsp;&nbsp;
			<a href="order.jsp">주문내역</a>&nbsp;&nbsp;
			<a href="review.jsp">사용후기</a>&nbsp;&nbsp;
		</div>
	</div>
	--%>
	<%@include file="header.jspf" %>
		<%-- <body>의 공통적 요소 (e.g. header, footer) 의 경우 include 를 통해 캡슐화 처리
		다른 문서에서는 include를 통해 포함 가능 
		나중에 header의 내용이 바뀌면 jsp 문서마다 가서 바꿀 필요 없이 header.jspf내용을 바꾸면 손쉽게 변경가능 --%>
	
	<%-- content 영역 : 요청에 대한 응답결과를 제공 --%>
	<div id="content">
		<h2>메인 페이지</h2>
	</div>
	
	<%-- footer 영역 : 저작권, 약관, 개인정보 보호정책 등 --%>
	<%--  
	<div id="footer">
		<p>Copyright © itwill Corp. All rights reserved.</p>
	</div>
	--%>
	<%@include file="footer.jspf" %>
</body>
</html>