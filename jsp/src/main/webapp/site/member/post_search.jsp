<%@page import="java.util.List"%>
<%@page import="xyz.itwill.dto.ZipDTO"%>
<%@page import="xyz.itwill.dao.ZipDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 동이름을 입력하여 전달받아 ZIP 테이블에 저장된 우편번호 정보를 검색하여 클라이언트에게 전달하는 JSP 문서 --%>
<% 
	// POST 방식으로 요청하여 전달된 값에 대한 캐릭터셋 변경
	request.setCharacterEncoding("UTF-8");
	
	List<ZipDTO> zipList=null;
	if(request.getParameter("dong")!=null){// 전달값이 있는 경우
		// 전달된 동이름을 반환받아 ZIP 테이블에 저장된 해당 동이름의 우편번호정보를 검색하여
		// 반환하는 DAO 클래스의 메소드 호출
		zipList=ZipDAO.getDAO().selectZipList(request.getParameter("dong"));
		
	}
	// 전달된 동이름을 반환받아 ZIP 테이블에 저장된 우편번호정보를 검색하여 반환하는 DAO 클래스의 메소드 호출
		// 지속적으로 우편번호를 관리하는 것보다는 다음에서 제공하는 open api를 사용하는 것이 더 효율적
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
	#search {
		width: 500px;
		margin: 0 auto;
		text-align: center;
	}
	
	table {
		border: 1px solid black;
		border-collapse: collapse;
		margin: 10px auto;
		font-size: 14px;
	}
	
	td {
		border: 1px solid black;
	}
	
	.zip { width: 100px; }
	
	.address {
		width: 400px;
		text-align: left;
		padding-left: 2px;
	}
</style>
</head>
<body>
	<div id="search">
			<%-- action이 없으면 자기자신을 재요청한다. --%>
		<form method="post" name="postForm">
			동이름 : <input type="text" name="dong">
			<button type="button" id="searchBtn">주소검색</button>	
		</form>
	</div>
	
	<%-- 반환받은 검색결과를 클라이언트에게 전달 --%>
	
	<% if(zipList!=null) { // 검색결과가 있는 경우 %>
		<table>
			<tr>
				<td class="zipcode">우편번호</td>
				<td class="address" style="text-align: center;">기본주소</td>
			</tr>
			
			<% for(ZipDTO zip : zipList) { %>
			<tr>
				<td class="zipcode"><%= zip.getZipcode() %></td>
				<td class="address">
					<%-- a 태그의 href 속성값으로 자바스크립트 명령을 사용할 경우
					반드시 javascript 네임스페이스(접두사) 사용 --%>
					<a href="javascript:searchClose('<%= zip.getZipcode() %>','<%= zip.getAddress() %>');">
						<%= zip.getAddress() %></a>
				</td>
			</tr>
			<% } %>
		</table>
	<% } %>
	
	<script type="text/javascript">
		postForm.dong.focus();
		
		document.getElementById("searchBtn").onclick=function() {
			if(postForm.dong.value==""){
				postForm.dong.focus();
				return;
			}
			
			postForm.submit();
		}
		
		function searchClose(code, addr){
			opener.joinForm.zipcode.value=code;
			opener.joinForm.address1.value=addr.trim();
			window.close();
				// opener 객체는 자기 자신을 연 기존 창의 window 객체를 참조
		}
	</script>
</body>
</html>