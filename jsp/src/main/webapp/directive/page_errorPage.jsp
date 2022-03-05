<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%> --%>
<%-- [web.xml] 파일에서 모든 웹프로그램에 대한 요청에러(4XX)와 응답에러(5XX)에 대한 
에러페이지 설정 - 클라이언트의 요청 URL 주소 미변경 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%-- 
	errorPage="error.jsp"
	> error가 발생하면 500코드를 주는 것이 아니라 error.jsp가 만들어준 문서를 보여준다. (url주소는 변경되지 않는다.)
	이런 식으로 에러페이지를 설정하면 나중에 에러페이지를 변경하면 모든 jsp문서를 변경해야하는 단점 존재
	> 권장하지 않는다.
	--%>
<%
	String text="ABCDEFG";
	// String text=null;
		// <error-code> 보다 <exception-type>의 우선순위가 더 높다.
		// (모두 조건 설정을 했을 때)
		// 500 & NullPointerException 발생 시 exception type으로 처리 
	
	int su=10/0; // ArithmeticException 발생
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>page Directive - errorPage 속성</h1>
	<hr>
	<p>JSP 문서 실행시 예외가 발생된 경우 클라이언트에게 에러코드(500; status code) 대신  에러 메세지를
	전달하는 JSP 문서를 설정하기 위한 속성 - 클라이언트의 요청 URL 주소 미변경</p>
		<!-- 500이되 에러메세지를 주기 위해서 사용하는 속성 -->
	<hr>
	<p>문자열의 문자갯수 = <%=text.length() %></p>
</body>
</html>