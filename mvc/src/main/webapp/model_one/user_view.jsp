<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 USERINFO 테이블에 저장된 해당 아이디의 회원정보를 검색하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => 로그인 사용자만 요청 가능 --%>
<%-- => [수정]을 클릭한 경우 회원정보 변경 입력페이지(user_modify.jsp)로 이동 - 아이디 전달 : 관리자만 요청 가능 --%>
<%-- => [삭제]을 클릭한 경우 회원정보 삭제 처리페이지(user_remove_action.jsp)로 이동 - 아이디 전달 : 관리자만 요청 가능 --%>
<%-- => [목록]을 클릭한 경우 회원정보 출력페이지(user_list.jsp)로 이동 - 아이디 전달 --%>
<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	if(loginUserinfo==null){ // 비로그인 사용자인 경우
		response.sendRedirect("user_error.jsp");
		return;
	}
	String userid=request.getParameter("userid");
	
	UserinfoDTO userinfo=UserinfoModelOneDAO.getDAO().selectUserinfo(userid);
	
	if(userinfo==null) { // 검색된 회원정보가 없는 경우
		response.sendRedirect("user_error.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MVC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/user.css" type="text/css">
<script language="JavaScript">
function userRemove(userid) {
	if (confirm("정말로 삭제 하시겠습니까?") ) {
		location.href='user_remove_action.jsp?userid='+userid;
	}
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>회원관리 - 상세정보</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">아이디</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				<%=userinfo.getUserid()%>
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				<%=userinfo.getName()%>
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이메일</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
			<% if(userinfo.getEmail()!=null) { %>	
				<%=userinfo.getEmail()%>
			<% } %>	
			</td>
		  </tr>		  
	  </table>
	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<% if(loginUserinfo.getStatus()==9) { %>
				<input type="button" value="수정" onClick="location.href='user_modify.jsp?userid=<%=userinfo.getUserid()%>';">
				<input type="button" value="삭제" onClick="userRemove('<%=userinfo.getUserid()%>');">
			<% } %>
				<%-- 관리자일 때만 수정과 삭제버튼이 보일 수 있도록 처리 --%>
			<input type="button" value="목록" onClick="location.href='user_list.jsp';"> 
			</td>
		  </tr>
	  </table>

	  </td>
	</tr>
</table>  
</body>
</html>