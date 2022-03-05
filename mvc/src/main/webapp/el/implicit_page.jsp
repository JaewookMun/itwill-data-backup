<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - pageContext</h1>
	<hr>
	<h3>EL 미사용</h3>
	<%--  
	<p>컨텍스트 경로 = <%=request.getContextPath()%></p>
	<p>요청자원의 주소 = <%=request.getRequestURI()%></p>
	--%>
	<p>컨텍스트 경로 = <%=((HttpServletRequest)pageContext.getRequest()).getContextPath()%></p>
	<p>요청자원 주소 = <%=((HttpServletRequest)pageContext.getRequest()).getRequestURI()%></p>
		<%-- request가 없을 경우가 있는데 pageContext를 가지고 웹 요청과 관련된 메소드를 사용 가능 --%>
		<%-- 웹 관련 클래스들은 pageContext를 제공한다. --%>
	<hr>
	<h3>EL 사용</h3>	
	<p>컨텍스트 경로 = ${pageContext.request.contextPath }</p>
	<p>요청자원 주소 = ${pageContext.request.requestURI }</p>
		<%-- again) 메소드의 get이 생략되었다고 보면된다. --%>
		<%-- JSP파일에서 JAVA 코드를 제거하고 EL이 이를 대체 - cookie와 pageContext는 내장객체 중 그나마 
		사용하는 경우가 존재. --%>
</body>
</html>