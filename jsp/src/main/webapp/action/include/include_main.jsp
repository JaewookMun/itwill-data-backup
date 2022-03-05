<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	
	request.setCharacterEncoding("utf-8");
	
	// 현재 JSP 문서 요청시 전달되는 값을 반환받아 저장
	String category=request.getParameter("category");
	if(category==null){// 전달값이 없는 경우
		category="main";
	}

	String headerFileName="";
	String master="";
	
	// 전달값에 따라 JSP 파일 변경
	if(category.equals("main")){
		headerFileName="header_main.jsp";
		master="홍길동(hong@itwill.xyz)";
	} else if (category.equals("blog")){
		headerFileName="header_blog.jsp";
		master="임꺽정(lim@itwill.xyz)";
	} else if (category.equals("cafe")){
		headerFileName="header_cafe.jsp";
		master="전우치(jwc@itwill.xyz)";
	} else { // 비정상적인 요청
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<%-- Header 영역 --%>
	<%-- 
	<h1>메인페이지</h1>
	<a href="include_main.jsp?category=main">메인</a>&nbsp;&nbsp;
	<a href="include_main.jsp?category=blog">블로그</a>&nbsp;&nbsp;
	<a href="include_main.jsp?category=cafe">카페</a>&nbsp;&nbsp;
	<hr>
	--%>
		<%-- 전달되는 값만 바뀔 뿐이지 실제 요청문서는 include_main.jsp로 같다. --%>
	
	<%-- include 지시어(Directive) : 외부파일(JSPF)의 코드(HTML 태그, Java 명령 등) 포함 --%>	
	<%-- => JSP 문서에 외부파일의 코드를 포함하여 페이지 구현 --%>
	<%-- => 외부파일의 코드가 변경될 경우 JSP 문서가 변경된 것과 동일하므로 서블릿 변환 발생 --%>
	<%-- => file 속성값으로 표현식(Expression) 사용 불가능 - 설정된 파일만 포함 가능(정적 포함) --%>
		<%-- url경로를 저장한 참조변수 사용 불가능 --%>
	<%-- <%@ include file="header.jspf" %> --%>
		<%-- 바꿨을 때 안되는 경우가 존재. 이럴경우 work 디렉토리를 지워주면 됨. 'clean'사용 --%>
		<%-- jspf 파일은 jsp파일이 아니라 text파일과 같다고 볼 수 있다. (code의 container) --%>
	
	
	<%-- include ActionTag : JSP 문서의 실행결과(HTML, CSS, JavaScript) 포함 --%>
	<%-- 형식) <jsp:include page="JSP"/> 또는 <jsp:include page="JSP"></jsp:include> --%>
	<%-- => 현재 JSP 문서에서 page 속성값으로 설정된 JSP 문서로 스레드를 이동하여 실행
	결과를 가져와 현재 JSP 문서에 포함하여 페이지 구현 --%>
	<%-- => page 속성값으로 설정된 JSP 문서가 변경되도 현재 JSP 문서에는 미영향 --%>
	<%-- => page 속성값으로 표현식 사용 가능 - 상태에 따라 다른 JSP 문서의 실행 결과 포함(동적 포함) --%>
	<%-- <jsp:include page="header.jsp"></jsp:include> --%>
	<jsp:include page="<%= headerFileName %>"></jsp:include>
		<%-- include action 태그는 java 명령은 포함하지 못한다. --%>
		<%-- 코드를 포함하는 것이 아니라 문서의 실행결과를 포함시킨다. --%>
		<%-- include directive - 코드 / include actionTag - 문서결과 --%>
		<%-- directive는 java 코드를 포함시킬 수 있다는 점이 장점이지만 가독성 측면에서
		action 태그를 사용하는 것이 권장된다.
		 --%>

		<%-- 
		include directive, include actionTag 둘다 사용됨 프로그래머에 따라 다름.
		가독성적 측면이랑 동적포함이라는 점을 고려하면 include ActionTag가 더 효율적이다. --%>


	<%-- Content 영역 --%>
	<ul>
		<li>요청에 대한 처리 결과</li>
		<li>요청에 대한 처리 결과</li>
		<li>요청에 대한 처리 결과</li>
		<li>요청에 대한 처리 결과</li>
		<li>요청에 대한 처리 결과</li>
	</ul>

	<%-- Footer 영역 --%>
	<%--  
	<hr>
	<p>Copyright © itwill Corp. All rights reserved.</p>
	<p>관리자 : 홍길동(hong@itwill.xyz)</p>
	<p>관리자 : <%= master %></p>
	--%>
	
	<%-- param 태그 : 스레드가 이동하는 JSP 문서에 값을 전달하는 태그 --%>
	<%-- => 리퀘스트 메세지 바디에 값을 저장하여 전달 - POST 방식과 유사 --%>
		<%-- 리퀘스트 바디에 담기는 언어는 읽을 때 서유럽어로 읽어들인다. --%>
	<jsp:include page="footer.jsp">
		<jsp:param value="<%= master %>" name="master"/>
	</jsp:include>
	
</body>
</html>