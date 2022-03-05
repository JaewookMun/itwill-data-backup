<%@page import="xyz.itwill.dto.MyCommentUser1"%>
<%@page import="xyz.itwill.dao.MyCommentDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MyCommentUser1> commentList=MyCommentDAO.getDAO().selectCommentUserList1();
		// 검색이 되지만 매핑되지 않기 때문에 null이 저장된다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
	text-align: center;
	padding: 3px;
}

.no {width:100px;}
.name {width:150px;}
.content {width:250px;}
.date {width:200px;}

</style>
</head>
<body>
	<h1>게시글 목록</h1>
	<hr>
	<table>
		<tr>
			<td class="no">게시글 번호</td>
			<td class="name">게시글 작성자</td>
			<td class="content">게시글 내용</td>
			<td class="date">게시글 작성일</td>
		</tr>
		<% for(MyCommentUser1 commentUser:commentList) { %>
		<tr>
			<td class="no"><%=commentUser.getCommentNo()%></td>
			<%-- <td class="name"><%=commentUser.getUserName()%>(<%=commentUser.getCommentId()%>)</td> --%>
			<td class="name"><%=commentUser.getUserName()%>(<%=commentUser.getUserId()%>)</td>
			<td class="content"><%=commentUser.getCommentContent()%></td>
			<td class="date"><%=commentUser.getCommentDate()%></td>
		</tr>
		<% } %>
	</table>
</body>
</html>