<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// Java 명령 작성
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 HH시 mm분 ss초");
	String displayNow = dateFormat.format(now);
		// Java 영역 - 위치는 상관 없음.
		// 스클립트릿 안에 자바명령 작성가능
		// 웹문서의 형태를 가지고 있는 웹프로그램
		// JavaScript는 클라이언트에서 실행되기 때문에 클라이언트마다 결과가 다르지만
		// 웹프로그램은 서버에서 실행되기 떄문에 동일한 결과를 클라이언트에게 전달할 수 있다.
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
#display {
	width: 600px;
	margin: 0 auto;
	padding: 30px;
	font-size: 2em;
	font-weight: bold;
	text-align: center;
	border: 1px solid black;
}

</style>
</head>
<body>
	<h1>Hello, JSP!!!</h1>
	<hr>
	<!-- HTML 주석문 : 클라이언트 전달 - 소스보기 가능(웹디자이너) -->
	<%-- JSP 주석문 : 클라이언트 미전달 - 소스보기 불가능(웹프로그래머) --%>
	<p></p>JSP(Java Server Page) : 서블릿보다 쉽게 웹프로그램을 작성하기 위한 기술
	- 스크립팅 요소(Scripting Element), 지시어(Directive), 표준 액션 태그(Standard Action Tag)
	<hr>
	<p id="display"><%=displayNow %></p>
	
	<script type="text/javascript">
		setInterval(function(){
			location.reload();
		}, 1000);
	</script>
</body>
</html>