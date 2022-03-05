<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
<%--  
<style type="text/css">
.text { color: red; }
</style>
--%>
<%-- <link rel="stylesheet" href="<c:url value="/css/style.css"/>" type="text/css"> --%>
</head>
<body>
	<h1 class="text">리소스 파일</h1>
	<hr>
	<%-- 리소스 파일 : JSP 문서에서 사용하는 멀티미디어 파일, CSS 파일, JavaScript Source 파일 등 --%>
	<%-- => HTML 태그를 이용하여 리소스 파일 사용 --%>
		<%-- webapp의 WEB-INF에 WAS는 접근할 수 없다. - 이미지 파일이 있으면 사용할 수 없다. > webapp/resources 폴더에 접근 --%>
		<%-- web-inf는 private 폴더이기 때문에 WAS가 직접 접근할 수 없다. - 존재하되 접근할 수 없는 폴더(Servlet은 접근가능) --%>
		<%-- jsp 문서를 WEB-INF에 넣는 이유 : jsp 문서에 직접 접근하지 못하게 만들기 위하여.  --%>
		<%-- resources 폴더는 WEB-INF 외부에 존재 --%>
		<%-- resources 폴더 외부에 리소스파일을 위치시키면 404 에러 발생 --%>
		
	<%-- SpringMVC에서는 클라이언트의 모든 요청을 Front Controller에 의해 처리 --%>
	<%-- 문제점) 리소스 파일을 Front Controller에게 요청할 경우 에러 코드(404) 발생 --%>	
	<%-- 해결법) 리소스 파일은 Front Controller를 이용하지 않고 직접 요청을 받아 응답되도록 설정 --%>
	<%-- => Front Controller의 Bean Configuration File(servlet-context.xml)에서 resources
	엘리먼트를 이용하여 직접 요청하여 응답되도록 설정 --%>
	<%-- <img alt="" src="resources/images/Koala.jpg" width="200"> --%>
	<img src="images/Koala.jpg" width="200">	
	
	<%-- 리소스 파일은 절대경로로 표현하여 요청하는 것을 권장 --%>
	<%-- => 요청 URL 주소의 경로와 응답 JSP 문서의 경로가 서로 다르므로 절대경로로 표현 --%>
	<img src="/spring/images/Koala.jpg" width="200">	
	
	<%-- 컨텍스트 경로가 변경될 수 있으므로 메소드를 호출하여 컨텍스트 경로를 반환받아 표현 --%>
	<img src="<%=request.getContextPath() %>/images/Koala.jpg" width="200">
	
	<%-- 컨텍스트 경로는 EL 내장객체를 이용하여 표현 --%>
	<img src="${pageContext.request.contextPath }/images/Koala.jpg" width="200">
	
	<%-- Core 태그 라이브러리의 url 태그를 사용하여 리소스 경로를 절대경로를 표현 --%>
	<%-- => 컨텍스트 경로가 자동으로 포함되어 표현 --%>
	<img src="<c:url value="/images/Koala.jpg"/>" width="200">

	<%-- Spring 태그 라이브러리의 url 태그를 사용하여 리소스 경로를 절대경로를 표현 --%>
	<%-- => 컨텍스트 경로가 자동으로 포함되어 표현 --%>
	<img src="<spring:url value="/images/Koala.jpg"/>" width="200">
	
		<%-- Core 태그 라이브러리와 Spring 태그 라이브러리는  context 경로를 표기하지 않아도 된다. --%>
		<%-- el, core, spring 셋 중 하나 사용 --%>
	
</body>
</html>