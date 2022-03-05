<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->

<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- contentType이 없으면 서유럽파일로 만들어지기 때문에 읽을 수 없다. 
    만들때 utf-8로 설정되어 출력됨 --%>
    <%-- 속성과 속성값들은 정해져 있다. --%>
    <%-- 
    	contentType="application/vns.ms-excel;
    	실행결과를 ms-excel로 만들어서 달라는 의미
    	mimetype은 정해져있다.
     --%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		border: 1px solid black;
		border-collapse: collapse;
	}
	
	td {
		border: 1px solid black;
		text-align: center;
		width: 200px;
		padding: 2px;
	}
	
</style>
</head>
<body>
	<h1>page Directive - contentType 속성</h1>
	<hr>
	<p>JSP 문서를 요청하여 응답받을 수 있는 문서(파일)의 유형(MimeType)과
	캐릭터셋(Charset - encoding)을 제공하기 위한 속성</p>
	<hr>
	<table>
		<tr>
			<td>학번</td><td>이름</td><td>주소</td>
		</tr>	
		<tr>
			<td>1000</td><td>홍길동</td><td>서울시 강남구 역삼동</td>
		</tr>	
		<tr>
			<td>2000</td><td>임꺽정</td><td>인천시 월미구 성당동</td>
		</tr>	
		<tr>
			<td>3000</td><td>전우치</td><td>수원시 팔달구 구래동</td>
		</tr>	
	</table>

</body>
</html>