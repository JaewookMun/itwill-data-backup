<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL-Map</h1>
	<hr>
	<p>과일-1 = ${fruitsMap.one }</p>
	<p>과일-2 = ${fruitsMap.two }</p>
	<p>과일-3 = ${fruitsMap.three }</p>
	<p>선택 = ${choice }</p>
	<hr>
	<h3>좋아하는 과일 = ${fruitsMap.two }</h3>
	<h3>좋아하는 과일 = ${fruitsMap["two"] }</h3>
		<%-- .연산자 & []연산자 - 같은 결과 --%>
	<%-- EL 표현식에서 다른 스코프 객체의 속성값을 이용할 경우 [] 연산자 안에 표현하여 출력 가능 --%>	
		<%-- 이때, .을 사용할 수 없고 []를 사용해줘야한다. --%>
	<h3>좋아하는 과일 = ${fruitsMap[choice] }</h3>
		<%-- 잘 사용되지 않는다. --%>
</body>
</html>