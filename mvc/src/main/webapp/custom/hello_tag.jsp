<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSP 문서에서 커스텀 태그를 사용하고자 할 경우 taglib 디렉티브로 TLD 파일을 제공받아야 사용 가능 --%>
<%-- prefix 속성 : 태그에 대한 접두사(NameSpace)를 속성값으로 설정  --%>
<%-- uri 속성 : TLD 파일의 식별자(uri 엘리먼트값)을 속성값으로 설정 --%>
	<%-- prefix 속성은 꼭 설정해줘야한다. 태그를 구분하는 영역 - 접두사 --%>
	<%-- 생성해서 uri를 설정한 tld의 갯수만큼 자동완성으로 지원됨. --%>
	<%-- 태그이름이 기존 태그와 같을 경우가 있기 때문에 이를 구분하기 위해서 prefix 속성을 표기해준다.
	prefix 속성이 custom태그를 구분시켜 준다고 볼 수 있다. --%>
	<%-- 
		JSP 문서는 뷰의 역할을 수행 - 스크립팅 요소를 통해 자바 코드 사용을 최소화하기(없애기) 위해 EL을 사용 
		if / for 문을 수행해야하는데 이를 위해 만들어진 것이 JSTL이다.
		자바코드를 없애기위한 태그 - 커스텀 태그
	--%>
<%@taglib prefix="simple" uri="http://www.itwill.xyz/mvc/simple" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - NoAttribute and NoBody</h1>
	<hr>
	<%-- 태그내용이 있는 경우 시작태그와 종료태그를 따로 작성 --%>
	<%-- <simple:hello></simple:hello> --%>
	<%-- 태그내용이 없는 경우 시작태그와 종료태그를 같이 작성 --%>
	<simple:hello/>
	<simple:hello/>
	<simple:hello/>
	<simple:hello/>
	<simple:hello/>
		<%-- scriptlet을 없애기 위해 사용 --%>

</body>

</html>