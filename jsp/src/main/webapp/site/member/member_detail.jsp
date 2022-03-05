<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 현재 로그인 사용자의 회원정보를 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => 비로그인 사용자가 요청한 경우 에러페이지 이동 - 비정상적 요청 --%>
<%-- => [회원정보변경]을 클릭한 경우 비밀번호 입력페이지(password_confirm.jsp)로 이동 - 액션페이지 정보 전달 --%>
<%-- => [회원탈퇴]를 클릭한 경우 비밀번호 입력페이지(password_confirm.jsp)로 이동 - 액션페이지 정보 전달 --%>
<%-- 
	// 세션에 저장된 권한 관련 정보를 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
	
	if(loginMember==null){ // 비로그인 사용자인 경우
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=error&work=error400'");
		out.println("</script>");
		return;
	}
--%>
<%-- 외부파일(login_check.jspf)의 코드(Java 명령)를 포함하여 처리 --%>
<%-- include 디렉티브에서는 컨텍스트 디렉토리를 최상위 디렉토리로 처리 --%>
<%@ include file="/site/security/login_check.jspf"%>
	<%-- 변수 loginMember를 사용하기 위해 include directive 사용 - 외부파일의 코드를 포함시키기 때문에 --%>
<style type="text/css">
#detail {
	width: 400px;
	margin: 0 auto;
	text-align: left;
}

#mypage{
	font-size: 1.1em;
}

#mypage a:hover {
	color: orange;
}

</style>
<h1>회원상세정보</h1>
<div id="detail">
	<ul>
			<%-- directive는 코드를 가져오기 때문에 login_check.jspf 파일의 변수를 사용할 수 있다. --%>
		<li>아이디 = <%=loginMember.getId() %></li>
		<li>이름 = <%=loginMember.getName() %></li>
		<li>이메일 = <%=loginMember.getEmail() %></li>
		<li>전화번호 = <%=loginMember.getMobile() %></li>
		<li>우편번호 = <%=loginMember.getZipcode() %></li>
		<li>기본주소 = <%=loginMember.getAddress1() %></li>
		<li>상세주소 = <%=loginMember.getAddress2() %></li>
		<li>회원가입날짜 = <%=loginMember.getJoinDate() %></li>
		<li>마지막 로그인 날짜 = <%=loginMember.getLastLogin() %></li>
	</ul>
</div>

<div id="mypage">
	<a href="<%= request.getContextPath() %>/site/index.jsp?workgroup=member&work=password_confirm&action=modify">[회원정보변경]</a>&nbsp;&nbsp;
	<a href="<%= request.getContextPath() %>/site/index.jsp?workgroup=member&work=password_confirm&action=remove">[회원탈퇴]</a>&nbsp;&nbsp;
		<%-- 회원정보 변경, 회원 탈퇴 시 비밀번호를 확인 --%>
		<%-- jsp 파일을 2개 만들 수 있지만 하나만 생성하여 처리, query string action --%>
</div>
