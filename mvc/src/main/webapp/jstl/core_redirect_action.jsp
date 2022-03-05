<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 인코딩 필터가 동작될 경우 리퀘스트 메세지의 캐릭터셋 변경 생략 가능  --%>
	<%-- 모든 웹프로그램에서 아래 코드를 뺄 수 있도록 처리가능 --%>
	<%-- 필터가 동작되면 이제 아래 코드는 작성할 필요가 없다. (Model 클래스 역시) --%>
<%-- request.setCharacterEncoding("utf-8"); --%>
	<%-- EL과 JSTL을 배우는 이유가 jsp문서에서 java코드를 없애기 위함이다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - URL 관리 태그</h1>
	<hr>
	<c:choose>
		<c:when test="${!empty(param.name) }">
			<p>${param.name }님, 안녕하세요</p>
		</c:when>
		<c:otherwise>
			<%-- redirect 태그 : 클라이언트에게 URL 주소를 전달하여 재요청 하도록 하는 태그 --%>
			<%-- url 속성 : 클라이언트가 재요청할 웹프로그램의 URL 주소를 속성값으로 설정 --%>
			<c:redirect url="core_redirect_form.jsp"/>
		</c:otherwise>
	</c:choose>

</body>
</html>