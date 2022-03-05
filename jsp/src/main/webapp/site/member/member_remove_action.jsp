<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 비밀번호를 전달받아 로그인 사용자의 비밀번호와 비교하여 같은 경우 MEMBER 테이블에
저장된 로그인 사용자의 회원정보를 삭제하고 로그아웃 처리페이지(member_logout_action.jsp)로
이동하는 JSP 문서 --%>
<%-- => 비로그인 사용자가 JSP 문서를 요청한 경우 비정상적인 요청으로 에러페이지 이동 --%>

<%-- => [우편번호 검색]을 클릭한 경우 새창에 우편번호 검색페이지(post_search.jsp)로 이동 --%>
<%-- [회원정보변경]을 클릭한 경우 회원정보 변경 처리페이지(member_modify_action.jsp)로 이동 - 입력값 전달 --%>
<%@ include file="/site/security/login_check.jspf" %>
<%
	//비정상적인 요청에 대한 처리
	if(request.getMethod().equals("GET")){
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=error&work=error400'");
		out.println("</script>");
		return;
	}

	// 전달값을 반환받아 저장
	String passwd=Utility.encrypt(request.getParameter("passwd"));
	
	// 전달받은 비밀번호와 로그인 사용자의 비밀번호를 비교하여 같지 않은 경우
	if(!loginMember.getPasswd().equals(passwd)){
		session.setAttribute("message", "비밀번호가 맞지 않습니다.");
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=member&work=password_confirm&action=modify'");
		// out.println("history.go(-1);") // 이전 페이지 이동
			// history.go(-1)와 위의 코드와 동일한 결과를 생성.
		out.println("</script>");
		return;
	}
	
	// 아이디를 전달받아 MEMBER 테이블에 저장된 해당 아이디의 회원정보를 삭제하는 DAO 클래스의 메소드 호출
	MemberDAO.getDAO().deleteMember(loginMember.getId());
	
	// 로그아웃 처리페이지로 이동
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=member&work=member_logout_action'");
	out.println("</script>");
%>


