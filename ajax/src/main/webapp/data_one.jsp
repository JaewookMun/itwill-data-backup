<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
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
	<h1>AJAX - 값 전달</h1>
	<hr>
	<div id="display">요청 웹프로그램의 응답결과 출력</div>
	<div>
		이름 : <input type="text" id="name">
		<button type="button" id="getBtn">GET</button>
		<button type="button" id="postBtn">POST</button>
			<%-- AJAX를 이용하면 form태그가 없어도 POST 방식으로 값전달 가능 --%>
	</div>
	
	<script type="text/javascript">
		// 비동기식 통신을 위한 XMLHttpRequest 객체(Ajax Engine)를 저장하기 위한 전역변수
		var xhr=null;
		
		function getXMLHttpRequest(){
			if(window.ActiveXObject){ // IE4 ~ IE6
				try{
					return new ActiveXObject("msxml12.XMLHTTP"); // IE5~IE6
				} catch(e) {
					try {
						return new ActiveXObject("Microsoft.XMLHTTP"); // IE4
					} catch (e)	{
						return null;
					}
				}
			} else if(window.XMLHttpRequest){ // IE7 이상 또는 기타 웹브라우저
				return new XMLHttpRequest();
			} else {
				return null;
			}
		}
	
		document.getElementById("getBtn").onclick=function(){
			// 입력태그의 입력값을 반환받아 저장
			var name=document.getElementById("name").value;
			
			// 입력값 검증
			if(name==""){
				document.getElementById("display").innerHTML="이름을 입력해 주세요.";
				return;
			}
			
			// 입력태그 초기화
			document.getElementById("name").value="";
			
			// XMLHttpRequest 객체를 반환받아 저장
			xhr=getXMLHttpRequest();
			xhr.onreadystatechange=viewMessage;
			
			// XMLHttpRequest 객체를 이용하여 웹프로그램 요청
			// GET 방식으로 웹프로그램을 요청한 경우 QueryString을 사용하여 값 전달
			// 문제점) 전달값이 URL 주소로 표현할 수 없는 문자값이 존재할 경우 응답결과로 400 에러코드 발생
			// 해결법) 전달값을 URL 주소로 표현할 수 없는 문자값이 존재할 경우 부호화 변환하여 전달
				// GET 방식은 send() 메소드로 값을 전달하는 것이 아니라 쿼리스트링을 이용하여 전달
				// 영어는 가능하나 한글은 url로 사용 불가능하다.
			name=encodeURIComponent(name);
				// 입력값 부호화 처리
			xhr.open("GET", "data_two.jsp?name="+name);
			xhr.send(null);
		
		}
		
		document.getElementById("postBtn").onclick=function(){
			// 입력태그의 입력값을 반환받아 저장
			var name=document.getElementById("name").value;
			
			// 입력값 검증
			if(name==""){
				document.getElementById("display").innerHTML="이름을 입력해 주세요.";
				return;
			}
			
			// 입력태그 초기화
			document.getElementById("name").value="";
			
			// XMLHttpRequest 객체를 반환받아 저장
			xhr=getXMLHttpRequest();
			xhr.onreadystatechange=viewMessage;
			
			// POST 방식으로 웹프로그램을 요청한 경우 send() 메소드의 매개변수를 이용하여 값 전달
			// 문제점) send() 메소드를 이용하여 값을 전달할 경우 "multipart/form-data" 형식으로 전달
			// => 요청 웹프로그램에서는 request.getParameter() 메소드로 전달값 반환 불가능
			// 해결법) "application/x-www-form-urlencoded" 형식으로 값이 전달되도록 RequestHeader 정보 변경
			xhr.open("POST", "data_two.jsp");
			// XMLHttpRequest.setRequestHeader(header, value) : 리퀘스트 메세지의 헤더정보를 변경
			// => open() 메소드 사용 후 호출 가능
				// send() 메소드 사용전에 호출.
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send("name="+name);
		}
		
			// 전달값이 적거나 url 주소의 형식을 벗어나지 않는다면 GET 방식
			// 전달값이 많거나 url 주소의 형식을 벗어나면 POST 방식 - 일반적으로 post 방식 권장
		
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