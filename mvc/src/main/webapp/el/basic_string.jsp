<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// pageContext.setAttribute(String attributeName, Object attributeValue)
	// => 스코프 객체에 속성명(문자열)과 속성값(인스턴스)을 저장하는 메소드
	// => pageContext 내장객체에 속성값을 저장 - Page Scope
	// Page Scope : 속성값을 저장한 웹프로그램에서만 속성값을 반환받아 사용 가능
	pageContext.setAttribute("name", "홍길동");
		// JSP 내장객체를 스코프 객체로 변경
		// pageScope => 잘 사용하지 않음.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<p>EL : 스코프 객체에 저장된 속성값을 쉽게 제공받아 출력하기 위해 사용하는 언어</p>
	<hr>
	<h2>EL 미사용</h2>
	<%
		// pageContext.getAttribute(String attributeName) : 속성명을 전달받아 스코프 객체에
		// 저장된 속성값(인스턴스)을 반환하는 메소드
		// => Object 타입의 인스턴스를 반환하므로 명시적 객체 형변환하여 사용
		String name=(String)pageContext.getAttribute("name");
		
		// 속성명으로 저장된 속성값이 없는 경우 null 반환
		String pageName=(String)pageContext.getAttribute("pageName");
	%>
	<p>이름 = <%=name%></p>
	<%-- JSP 표현식의 값이 null인 경우 "null" 문자열로 변환되어 출력 --%>
	<p>이름 = <%=pageName%></p>
	<%-- if 구문을 이용하여 null이 아닌 경우에만 값이 출력되도록 설정 --%>
	<p>이름 = <% if(pageName!=null) { %><%= pageName %><% } %></p>
	<hr>
	<h2>EL 사용</h2>
	<%-- ${속성명} : 스코프 객체에 저장된 속성값을 EL 표현식의 속성명으로 제공받아 출력 --%>
	<%-- => getAttribute() 메소드와 JSP 표현식을 동시에 구현하는 것과 같은 효과 --%>
	<p>이름 = ${name }</p>
	<%-- 속성명으로 저장된 속성값이 없는 경우 EL 미실행 - 값 미출력 --%>
		<%-- 속성 or 속성에 대한 속성값 --%>
		<%-- 장점 : 1. 값을 좀더 쉽게 표현하게 해줌
		2. 값이 잘못되거나 없을 경우에는 출력을 안해줌 - null이 출력될 필요가 없다. --%>
		<%-- 속성값이 문자열이 아니라 인스턴스라면 두번째 변수가 필요한데 - 내일(08.25) 진행 --%>
	<p>이름 = ${pageName }</p>

</body>
</html>