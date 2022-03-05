<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>El 내장객체 - Cookie</h1>
	<hr>
	<h3>EL 미사용</h3>
	<%
		Cookie[] cookies=request.getCookies();
			// cookie를 모두 보내기 때문에..
		String userName="";
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("userName")){
				userName=cookie.getValue();
			}
		}
			// 쿠키가 많을 수록 가독성이 떨어진다.
	%>
	<p>쿠키에 저장된 사용자명 = <%=userName%></p>
	<hr>
	<h3>EL 사용</h3>
	<p>쿠키에 저장된 사용자명 = ${cookie.userName.value }</p>
	<p>JSESSIONID = ${cookie.JSESSIONID.value }</p>
		<%-- cookie - Map 객체, value는 getValue()라고 생각가능 --%>
		<%-- JSESSIONID - session의 고유 쿠키 바인딩하기 위해 가지고 있음. --%>
		<%-- 중요 - 알고있기! --%>
</body>
</html>