<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그아웃 처리(세션에 속성값으로 저장된 권한 관련 정보 제거) 후 입력페이지
(login_form.jsp)로 이동하는 JSP 문서 --%>

<% 
	// session.removeAttribute("loginId");
	session.invalidate(); // 바인딩된 세션을 언바인딩 처리하고 제거하는 메소드
		// 위의 것은 권한에 관련된 정보만 제거, 아래 것은 세션에 저장된 모든 정보를 제거
		// 상황에 따라 다르다.
		// 세션은 제거된 이후 WAS에 의해 다시 생성됨. (session 속성값은 기본 true)
	response.sendRedirect("login_form.jsp");



%>