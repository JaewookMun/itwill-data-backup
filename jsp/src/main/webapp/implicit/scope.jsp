<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>인스턴스 사용범위</h1>
	<hr>
	<p>사용범위(Scope) : WAS에 의해 관리되는 JSP 문서의 내장객체를 이용하여 인스턴스를
	속성값으로 저장하고 반환받아 사용할 수 있는 범위 - 내장객체에 따라 속성값으로 저장된 
	인스턴스의 사용범위가 다르게 설정된다.</p>
	<hr>
		<%-- 8개 중 4개만 속성값으로 인스턴스를 저장할 수 있다. --%>
	<ul>
		<li>page Scope : PageContext 내장객체를 이용하여 인스턴스를 속성값으로 저장
		- 인스턴스를 속성값으로 저장한 JSP문서에서만 속성값을 반환받아 사용</li> 
			<%-- JSP문서마다 pageContext라는 내장객체를 따로 가지고 있다.
			다른 JSP 문서에서 pageContext 객체 사용 불가능 --%>
		<li>request Scope : request 내장객체를 이용하여 인스턴스를 속성값으로 저장	
		- 인스턴스를 속성값으로 저장한 JSP 문서와 스레드가 이동된 JSP 문서에서 속성값을 반환받아 사용</li>
			<%-- JSP간 스레드 이동방법 
			1. include action 태그
			2. forward action 태그 
			--%>
		<li>session Scope : session 내장객체를 이용하여 인스턴스를 속성값으로 저장	
		- 컨텍스트에 존재하는 모든 JSP 문서에서 속성값을 반환받아 사용(바인딩된 세션 사용)</li>
			<%-- 
				JSP 문서는 session을 바인딩하여 사용가능 -> 세션은 여러개 존재.
				바인딩 된 세션에서 사용가능
			--%>
		<li>application Scope : application 내장객체를 이용하여 인스턴스를 속성값으로 저장
		- 컨텍스트에 존재하는 모든 JSP 문서에서 속성값을 반환받아 사용(컨텍스트 사용)</li>
		
	</ul>
	<hr>
	<ul>
		<li>내장객체에 인스턴스를 속성값으로 저장(변경)하는 메소드
		- 내장객체.setAttribute(String attributeName, Object attributeValue)</li>
		<li>내장객체에 속성값으로 저장된 인스턴스를 반환하는 메소드
		- 내장객체.getAttribute(String attributeName)</li>
			<%-- Object type -> 강제형변환 필요 --%>
		<li>내장객체에 속성값으로 저장된 인스턴스를 제거하는 메소드
		- 내장객체.removeAttribute(String attributeName)</li>
	</ul>
		<%-- 
			WAS(jsp1, jsp2, jsp3, ...) 
			> jsp 1,2,3 각각 pageContext 존재 - pageContext에 인스턴스를 저장하면 해당 jsp만 사용가능
			> request 역시 jsp마다 존재 - 기본적으로 다른 jsp 에서 사용 불가능
									 - 하지만, 스레드가 이동하면 다른 jsp의 리퀘스트와 같아질 수 있다.
									 - 이동하지 않으면 사용 불가능
			WAS(session1, session2, session3, ...)
			> session은 WAS가 관리하는 메모리에 별도 존재 
			> session과 바인딩 되어있으면 jsp는 세션에 속성값으로 저장된 인스턴스를 사용할 수 있다.
			> 바인딩 유무가 중요
			
			WAS(application)
			> 하나만 존재 // in case of Servlet, getServletContext() 
			> application에 저장되면 모든 JSP에서 사용 가능	
			
			// session 브라우저가 종료되면 언바인딩 되지만 application은 서버가 종료되기 전까지 유지된다.
		--%>


	
</body>
</html>