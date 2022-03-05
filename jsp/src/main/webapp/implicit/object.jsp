<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>내장객체(Implicit Object)</h1>
	<hr>
	<p>WAS에 의해 JSP 문서에 기본적으로 제공되는 Java 객체(인스턴스)</p>
		<%-- 기본적으로 8개의 내장객체 제공 --%>
	<hr>
	<p>1. page(HttpJspPage) : JSP 문서를 표현하기 위한 인스턴스(메소드의 this와 유사)</p> <%-- 잘 사용 x --%>
	<p>2. config(ServletConfig) : WAS에 등록된 값을 제공하기 위한 인스턴스</p> <%-- 잘 사용 x --%>
	<p>3. out(JspWriter) : 클라이언트에게 전달할 응답 문서를 만들기 위한 인스턴스(출력 스트림) <%-- 잘 사용 x --%>
	<p>4. request(HttpServeltRequest) : 클라이언트의 요청정보를 제공하기 위한 인스턴스</p>
	<p>5. response(HttpServletResponse) : 클라이언트에게 응답정보를 제공하기 위한 인스턴스</p>
	<p>6. session(HttpSession) : 클라이언트와의 연결 지속성을 제공하기 위한 인스턴스</p>
	<p>7. application(ServletContext) : 컨텍스트 정보를 저장한 인스턴스</p>
	<p>8. pageContext(PageContext) : JSP 문서에 필요한 Java 객체를 제공하기 위한 인스턴스</p>
	<p>9. exception(Throwable) : JSP 실행시 발생되는 예외를 저장하기 위한 인스턴스
	- page Direcitve의 isErrorPage 속성값을 [true]로 설정한 경우에만 제공되는 내장객체</p>
	
		<%-- 1. page 내장객체는 사용할 수 있는 메소드가 거의 없다. (Object 클래스의 메소드 수준) --%>
	
</body>
</html>