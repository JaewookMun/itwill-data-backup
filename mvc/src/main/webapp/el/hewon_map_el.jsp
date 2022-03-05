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
	<%-- 스코프 객체에 속성값으로 저장된 Map 인스턴스의 맵키가 EL 표현식으로 사용하기
	부적절한 경우 . 연산자를 사용하여 출력 불가능 --%>
	<%-- => Map 인스턴스의 맵키가 EL 표현식으로 사용하기 부적절한 경우 [] 연산자 안에
	맵키를 사용하여 맵값 출력 가능 --%>
	<%-- <p>이름-1=${hewonMap.first.name }, 이름-2=${hewonMap.second.name }</p> --%>
		<%-- 첫번째 변수 - 속성명, 두번째 변수 - Map key --%>
		<%-- first.name은 [.]이 있기 때문에 두번째 변수로 사용할 수 없다. --%>
	<p>이름-1 = ${hewonMap["first.name"] }, 이름-2 = ${hewonMap["second.name"] }</p>	
		<%-- 숫자가 아니기 때문에 더블쿼테이션 사용 --%>
</body>
</html>