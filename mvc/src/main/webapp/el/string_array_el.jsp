<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - Array</h1>
	<hr>
	<ul>
		<%-- 스코프 객체의 속성값이 배열인 경우 EL 표현식에서 . 연산자로 첨자를 표현하여
		배열 요소에 접근할 경우 ELException --%>
		<%-- ELException : EL 표현식이 잘못된 경우 발생되는 예외 --%>
		<%-- <li>${nameArray.0 }</li> --%>
		<%-- 스코프 객체의 속성값이 배열인 경우 EL 표현식에는 [] 연산자 안에 첨자를 사용하여
		배열 요소값을 출력 --%>
		<%-- <li>${nameArray["0"] }</li> --%>
		<li>${nameArray[0] }</li>
			<%-- 더블쿼테이션을 사용해도 같은결과가 나오지만 일반적으로 정수는 숫자만 표기 --%>
		<li>${nameArray[1] }</li>
		<li>${nameArray[2] }</li>
		<li>${nameArray[3] }</li>
		<li>${nameArray[4] }</li>
		<%-- 배열 요소의 첨자가 범위를 벗어난 경우 EL 미실행  --%>		
		<li>${nameArray[5] }</li>
	</ul>
</body>
</html>