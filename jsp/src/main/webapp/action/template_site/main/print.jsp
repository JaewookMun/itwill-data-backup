<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>메인페이지</h1>
<%-- 상대경로 표현방법 : 클라이언트의 요청 JSP 문서를 기준으로 리소스 파일의 경로 표현 --%>
<%-- => 템플릿 페이지를 이용한 사이트에서는 리소스를 상대경로로 표현한 경우 404 에러코드 발생 --%>

<%-- 템플릿 페이지의 JSP 문서(index.jsp)를 기준으로 리소스 파일의 경로를 표현 --%>
<%-- => 템플릿 페이지의 JSP 문서가 아닌 Content 영역에 포함될 JSP 문서를 요청한 경우 404 에러코드 발생  --%>
<%-- <img src="images/Koala.jpg" width="300"> --%>

<%-- Content 영역에 포함될 JSP 문서(print.jsp)를 기준으로 리소스 파일의 경로를 표현 --%>
<%-- => Content 영역에 포함될 JSP 문서가 아닌 템플릿 페이지의 JSP 문서에서 요청한 경우 404 에러코드 발생  --%>
<%-- <img src="../images/Koala.jpg" width="300"> --%>

	<%-- 절대경로사용 권장 --%>
<%-- 템플릿 페이지를 이용한 사이트에서는 요청하는 JSP 문서와 응답하는 JSP 문서의 경로가 
다르므로 리소스를 상대경로로 표현한 경우 404 에러코드 발생 --%>	
<%-- => 리소스는 절대경로로 표현하는 것을 권장 --%>

<%-- 절대경로 표현방법 : 최상위 디렉토리(Root Directory)를 기준으로 리소스 파일의 경로를 표현 --%>	
<%-- => HTML, CSS, JavaScript는 서버 디렉토리를 최상위 디렉토리 표현 --%>
<%-- <img src="/jsp/action/template_site/images/Koala.jpg" width="300"> --%>

<%-- 프로젝트에 대한 컨텍스트 경로가 변경된 경우 리소스 파일의 경로도 변경되므로 404 에러 코드  --%>
<%-- => 프로젝트에 대한 컨텍스트 경로가 변경가 변경되면 리소스 파일의 경로도 변경되도록 설정 --%>
<%-- request.getContextPath() : 컨텍스트 경로를 반환하는 메소드 --%>
<img src="<%= request.getContextPath() %>/action/template_site/images/Koala.jpg" width="300">
	<%-- server overview 탭 옆의 module 탭 참고 .
	/ 프로젝트 이름은 server에서 module로 표기 --%>
	<%-- 위처럼 표기하면 context 경로가 바뀌어도 jsp를 수정(리소스파일의 경로)할 필요가 없다. --%>
	
	