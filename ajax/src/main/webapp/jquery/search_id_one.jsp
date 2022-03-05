<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이름과 이메일을 입력받아 해당 회원의 아이디를 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => 이름과 이메일을 전달받아 AJAX_MEMBER 테이블에 저장된 해당 회원의 아이디를 검색하여
응답하는 웹프로그램(search_id_two.jsp)를 AJAX 기능으로 요청하여 처리 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>아이디 찾기</h1>
	<hr>
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" id="email"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" id="btn">아이디 찾기</button></td>
		</tr>
	</table>
	<hr>
	<div id="result"><%-- 홍길동님의 아이디는 [abc123]입니다. --%></div>
	
	<script type="text/javascript">
	$("#btn").click(function(){
		var name=$("#name").val();
		if(name==""){
			$("#result").html("이름을 입력해 주세요.");
			$("#name").focus();
			return;
		}
		
		var email=$("#email").val();
		if(email==""){
			$("#result").html("이메일을 입력해 주세요.");
			$("#email").focus();
		}
		$("#name").val("");
		$("#email").val("");
		
		$.ajax({
			type: "post",
				// 한글이 들어갈 경우 post방식으로 요청하는 것을 권장 - 숫자등 간단한 방식은 GET, 복잡하고 URL에 표시할 수 없으면 POST
			url: "search_id_two.jsp",
			// data: "name="+name+"&email="+email,
			// 전달값은 Object 객체 형태로 표현 가능
			data: {"name": name, "email": email},
			dataType: "xml",
				// data 전달 시 작성방식은 쿼리스트링과 똑같음. ajax로 데이터를 받을 시 기본이 xml 형태이다.
			success: function(xml){
				var code=$(xml).find("code").text();
				if(code=="ok"){
					var id=$(xml).find("id").text();
					$("#result").html("<b>"+name+"</b>님의 아이디는 ["+id+"]입니다.")
				} else {
					$("#result").html("<b>"+name+"</b>님의 아이디는 존재하지 않습니다.")
				}
			},
			error: function(xhr){
				alert("에러코드 = "+xhr.status);
			}
			
		});
		
	});
	</script>
</body>
</html>