<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="js/xhr.js"></script>
	<%-- 전역변수와 함수를 가지고 있는 AJAX 모듈 --%>
<style type="text/css">
#display {
	width: 50%;
	padding: 5px;
	margin: 10px;
	font-size: 30px; 
	border: 1px solid red;
}
</style>
</head>
<body>
	<h1>Ajax Module</h1>
		<%-- 범용적 기능을 라이브러리가 제공해 준다면 module은 단일 기능을 제공한다고 보면 된다. (라이브러리가 범위가 넓음) --%>
		<%-- 모듈 - 단일/단위 프로그램(원하는 기능 제공) --%>
		<%-- 모듈들이 모여있으면 라이브러리라고 부르기도 한다. --%>
	<hr>
	<div id="display">요청 웹프로그램에 대한 응답결과 출력</div>
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" id="id"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" id="btn">요청</button></td>
		</tr>
	</table>
	
	<script type="text/javascript">
		document.getElementById("btn").onclick=function(){
			var id=document.getElementById("id").value;
			if(id==""){
				document.getElementById("display").innerHTML="아이디를 입력해 주세요";
				return;
			}
			
			var name=document.getElementById("name").value;
			if(name==""){
				document.getElementById("display").innerHTML="이름을 입력해 주세요";
				return;
			}
			document.getElementById("id").value=="";
			document.getElementById("name").value=="";
			
			// AJAX 모듈을 이용한 요청과 응답 - sendRequest() 함수 호출
			/*
			id=encodeURIComponent(id);
			name=encodeURIComponent(name);
				// 크롬은 위처럼 부호화 처리하지 않아도 값전달이 잘 되지만 다른 브라우저(인터넷익스플로러)를 사용할 경우 에러 발생
			var param="id="+id+"&name="+name
			sendRequest("GET", "module_two.jsp", param, viewMessage);
			*/
			
			var param="id="+id+"&name="+name
			sendRequest("POST", "module_two.jsp", param, viewMessage);
		}
		
		
		// 요청에 대한 응답결과를 받아 처리하는 콜백함수
		function viewMessage(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.getElementById("display").innerHTML=xhr.responseText;
				} else {
					document.getElementById("display").innerHTML="에러코드 = "+xhr.status;
				}
			}
		}
	
	</script>
</body>
</html>