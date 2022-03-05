<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="join" method="post">
		<%-- 입력페이지와 처리페이지가 같을 경우 action 속성을 생략해도 된다. --%>
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${mem.id }"></td>
		</tr>		
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd"></td>
		</tr>		
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${mem.name }"></td>
		</tr>		
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="${mem.email }"></td>
		</tr>		
		<tr>
			<td colspan="2"><button type="submit">회원가입</button></td>
		</tr>
	</table>
	</form>
	<p style="color: red;">${message }</p>
</body>
</html>