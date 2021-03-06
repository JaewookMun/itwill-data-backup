<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>JSTL(Java Standard Tag Library)</h1>
	<hr>
	<p>JSTL : 개발자가 많이 사용하는 EL 함수와 커스텀 태그를 제공하는 라이브러리</p>
	<p>JSP 문서에서 JSTL의 EL 함수와 커스텀 태그를 사용하기 위해서는 라이브러리 파일을
	다운로드 받아 프로젝트에 빌드 처리 - https://tomcat.apache.org</p> 
		<%-- 아파치 톰캣에서 다운받아서 다른 라이브러리처럼 빌드시켜주면 된다. --%>
	<hr>
	<ul>
		<li>Core : EL 지원, 프로그램의 흐름 제어, URL 관리 등의 태그 제공</li>
		<li>Formatter : 숫자, 날짜, 시간 형식 변경, 국제화, 다국어 지원 등의 태그 제공</li>
		<li>Database : 테이블의 행에 대한 삽입,삭제,변경,검색 기능의 태그를 제공</li>
		<li>XML : XML 문서에 대한 처리 기능의 태그 제공</li>
		<li>Functions : 문자열 처리 기능의 EL 함수 제공</li>
			<%-- Database, XML은 굳이 사용할 일이 없음. --%>
			<%-- 
				Functions - String 클래스의 메소드들과 유사
				Core, Formatter, Functions 정도 알고있으면 좋음.
			--%>
	</ul>
</body>
</html>