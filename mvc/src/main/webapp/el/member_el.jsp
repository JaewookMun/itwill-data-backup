<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- member.jsp 문서의 Request Scope 속성값을 제공받아 클라이언트에게 전달하는 JSP 문서 - View --%>
<%-- => member.jsp 문서로 요청을 받아 처리 후 member_el.jsp 문서로 응답 --%>
<%-- => member_el.jsp 문서를 요청한 경우 NullPointerException 미발생 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 사용</h1>
	<hr>
	<%-- <p>회원=${member }</p> --%>
		<%-- getAttribute를 사용하지 않아도 member 이름의 속성값을 받아 저장할 수 있다. --%>
	<p>회원의 이름=${member.name }</p>
		<%-- member 이름으로 저장된 속성값을 가져오고 해당 속성값의 name 필드값을 출력 --%>
	<%-- EL 표현식에서 . 연산자대신 [] 연산자 안에 필드명(맵키)을 사용하여 필드값(맵값)을 제공받아 출력 --%>
	<p>회원의 이름=${member["name"] }</p>
		<%-- .이 더 쉽기 때문에 일반적으로 .연산자를 많이 사용하지만 대괄호를 사용해야할 경우도 존재한다. --%>
		<%-- => 1. List 객체나 배열 객체인 경우는 dot(.) 연산자로 표현이 불가능하므로 반드시 [] 연산자를 이용해야 한다.  --%>
		<%-- => 2. [] 연산자는 “두번째변수”를 사용할 때 자바 이름 규칙을 이용해야 하는데 자바 이름 규칙을 벗어나는 경우에도 사용할 수 있다.  --%>
		<%-- => 3. EL에서 표현식의 “첫번째변수”에 저장된 객체가 자바 빈이거나, 맵 객체인 경우 [] 연산자 안에 문자열이 아닌 경우는 [] 연산자 안에 있는 이름으로 속성 찾아 반환  --%>
		
	<%-- <p>회원의 자동차 = ${member.car }</p> --%>	
	<p>회원의 자동차 모델명 = ${member.car.modelName }</p>	
	<p>회원의 자동차 색상 = ${member.car.carColor }</p>	
		<%-- 장점 1. 코드가 깔끔하다 - 가독성이 좋음.
		2. 해당 문서를 요청한 경우에도 에러자체가 떨어지지 않는다. --%>
</body>
</html>