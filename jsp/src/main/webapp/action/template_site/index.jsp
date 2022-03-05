<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 클라이언트의 모든 요청에 대한 응답 결과를 제공하기 위한 JSP 문서 - 템플릿 페이지 --%>
<%-- => Content 영역은 템플릿 페이지(index.jsp) 요청시 전달되는 값에 따라다른 JSP 문서의
실행결과를 동적으로 포함하여 응답 --%>
<% 
	// 템플릿 페이지 요청시 전달된 값을 반환받아 저장
	String group=request.getParameter("group");
	if(group==null){
		group="main";
	}
	
	String work=request.getParameter("work");
	if(work==null){
		work="print";
	}
	
	// 전달값을 이용하여 Content 영역에 포함될 JSP 문서의 경로를 생성하여 저장
	String contentFilePath=group+"/"+work+".jsp";
	System.out.println("contentFilePath = "+contentFilePath);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
div {
	margin: 5px;
	padding: 5px;
}

#header {
	height: 200px;
	border: 1px solid red;
}

#content {
	height: 500px;
	border: 1px solid green;
	text-align: center;
}

#footer {
	height: 150px;
	border: 1px solid blue;
	text-align: center;
	font-size: 1.2em;
}

#header h1 {
	text-align: center;
}	

#menu {
	font-size: 1.5em;
	text-align: right;
}

a, a:visited {
	text-decoration: none;
	color: black;	
}

a:hover {
	color: orange;
}


</style>
</head>
<body>
	<%-- Header 영역 --%>
	<div id="header">
		<h1><a href="index.jsp?group=main&work=print">쇼핑몰</a></h1>
		<div id="menu">
			<a href="index.jsp?group=product&work=new">신상제품</a>&nbsp;&nbsp;
			<a href="index.jsp?group=product&work=best">추천제품</a>&nbsp;&nbsp;
			<a href="index.jsp?group=product&work=sale">할인제품</a>&nbsp;&nbsp;
			<a href="index.jsp?group=board&work=list">게시판</a>&nbsp;&nbsp;
		</div>
	
	</div>
	
	<%-- Content 영역 - 전달값에 의해 생성된 JSP 문서로 스레드를 이동하여 실행 결과를 동적으로 포함 --%>
	<%-- => 스레드가 이동될 JSP문서가 없는 경우 예외 발생(500) --%>
	<div id="content">
		<jsp:include page="<%= contentFilePath %>"></jsp:include>
	</div>
		<%-- JSP에서만 가능한 방법 --%>
	
	<%-- Footer 영역 --%>
	<div id="footer">
		<div>
			<a href="index.jsp?group=main&work=term">이용약관</a>&nbsp;&nbsp;&nbsp;
			<a href="index.jsp?group=main&work=private">개인정보</a>&nbsp;&nbsp;&nbsp;
			<a href="index.jsp?group=main&work=center">고객센터</a>&nbsp;&nbsp;&nbsp;
			<p>Copyright © itwill Corp. All rights reserved.</p>
		</div>
	</div>
	
		<%--
			사이트 구현방식 - header와 footer를 분리시키는 것이 맞음.
			 웹사이트를 만들 때 여러개의 JSP문서가 존재하며 클라이언트가 JSP를 요청하면 응답을 받는 형태
			 > 요청을 처리하고 HTML 문서로 전달해준다.
			
			JSP문서 안에서는 웹사이트를 구성하기 위해 header와 footer가 중복될 수 밖에 없다.
			-> 유지보수가 어려워진다. (변경사항이 있을 시 각각의 jsp문서를 모두 변경해야함.)
			-> header 파일과 footer 파일을 만들어 JSP 문서가 가져다 사용할 수 있도록 처리
			   - 유지보수를 위해 header파일과 footer파일만 변경하면 jsp파일에서 가져다 읽는다.
			-> 1. include directive : 코드를 삽입 (.jspf) / 
			   2. include Action tag : 분리된 파일의 실행결과를 가져온다. (.jsp)
				  
			1. 일반적인 site 형태
			   : 파일을 여러개 만들어서 header와 footer파일을 가져다 사용 
			     - 독립적인 페이지로 구성
				
			2. template page 형태 (jsp만 사용가능)
			   : header, footer는 고정 - content만 바꾸어 포함
			     > jsp 파일의 실행결과를 가져와 포함시킨다.
			     > template page(index.jsp)를 요청할 때 전달되는 값(Query String)을 활용
			       - jsp 페이지가 많이 존재하지만 실제 클라이언트가 요청하는 문서는 index.jsp 파일 하나다.
			         > 클라이언트는 요청하는 문서는 index.jsp 문서 하나
                   - 요청에 대한 응답은 템플릿 페이지가 하지만 실제로 요청을 처리하는 문서는 다르다.
			     > 자원의 경로가 중요 - 절대경로 사용
			     > Context의 경로가 바뀔 수 있기 때문에 getContextPath()를 활용하여 이를 대비할 수 있다.
			
			
			- 어떻게 만들지에 따라 달라진다. 
			  -> 독립적인 형태(다른 JSP 문서를 요청) or 템플릿 페이지에 종속되는 형태
			- Spring 학습 시 template page와 유사한 형태로 웹사이트를 생성하는 방법을 배울 예정
		--%>
</body>
</html>