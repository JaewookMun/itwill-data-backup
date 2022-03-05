<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Core - 흐름 제어 태그</h1>
	<hr>
	<%-- if 태그 : 조건에 따라 태그내용의 출력을 선택하는 태그 - else 기능 미존재 --%>
	<%-- test 속성 : false 또는 true 중 하나를 속성값으로 설정 --%>
	<%-- => 속성값이 거짓(false)인 경우 태그내용을 출력하지 않고 참(true)인 경우 태그내용 출력 --%>
	<c:if test="true">
		<p>test 속성값이 true인 경우 태그 내용 출력-1</p>
	</c:if>
	
	<c:if test="false">
		<p>test 속성값이 true인 경우 태그 내용 출력-2</p>
	</c:if>
	
	<c:set var="sw" value="true"/>
	<c:if test="${sw }">
		<p>test 속성값이 true인 경우 태그 내용 출력-3</p>
	</c:if>
	<hr>
	<c:set var="num" value="11"/>
	<%--  
	<c:if test="${num%2!=0 }">${num } = 홀수 </c:if>
	<c:if test="${num%2==0 }">${num } = 짝수 </c:if>
	--%>
	<c:if test="${num mod 2 ne 0 }">${num } = 홀수 </c:if>
	<c:if test="${num mod 2 eq 0 }">${num } = 짝수 </c:if>
	<hr>
	<c:set var="score" value="80"/>
	<%--  
	<c:if test="${score>=0 && score <=100 }">${score }점은 정상적인 점수입니다.</c:if>
	<c:if test="${score<0 || score >100 }">${score }점은 비정상적인 점수입니다.</c:if>
	--%>
	<c:if test="${score ge 0 and score le 100 }">${score }점은 정상적인 점수입니다.</c:if>
	<c:if test="${score lt 0 or score gt 100 }">${score }점은 비정상적인 점수입니다.</c:if>
		<%-- el 연산자는 jsp와 더 많이 사용된다. --%>
	<hr>
	<c:if test="${empty(name) }">
			<%-- 속성명 or 속성값이 없을 때 참이된다. --%>
			<%-- if태그는 empty연산자와 많이 사용된다. --%>
		<p>name 속성명으로 저장된 속성값이 없습니다.</p>
	</c:if>	
	
	<c:set var="name" value="홍길동"/>
	<c:if test="${!empty(name) }">
		<p>name 속성명으로 저장된 속성값은 ${name } 입니다. </p> 
	</c:if>
		<%-- else 가 없기 때문에 switch와 if else를 함친얘가 존재 --%>
	
</body>
</html>