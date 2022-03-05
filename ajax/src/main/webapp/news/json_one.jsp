<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- json_two.jsp 문서를 AJAX 기능으로 요청하여 최신 뉴스목록을 JSON 형식의 텍스트 데이터로 
응답받아 클라이언트에게 전달하는 JSP 문서 --%>
<%-- JSON : 자바스크립트 객체 표기법을 이용하여 값을 구분하는 구조적인 데이터 표현 방법 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/xhr.js"></script>
<style type="text/css">
#newsList {
	width: 50%;
	margin: 0 auto;
}

#newsHead {
	padding: 5px;
	text-align: center;
	font-size: x-large;
	border: 2px solid black;
}

#newsContent {
	padding: 5px;
	font-size: medium;
	border: 2px dashed black;
	display: none;
}
</style>
</head>
<body>
	<h1>헤드라인 뉴스(JSON)</h1>
	<hr>
	<div id="newsList">
		<div id="newsHead">헤드라인 뉴스</div>
		<div id="newsContent">
			<%--  
			<ul>
				<li>뉴스제목-1[언론사-1]</li>
				<li>뉴스제목-2[언론사-2]</li>
				<li>뉴스제목-3[언론사-3]</li>
				<li>뉴스제목-4[언론사-4]</li>
				<li>뉴스제목-5[언론사-5]</li>
			</ul>
			--%>
		</div>
	</div>
	<script type="text/javascript">
	document.getElementById("newsList").onmouseover=function(){
		sendRequest("GET", "json_two.jsp", null, displayNewsList);
		document.getElementById("newsContent").style.display="block";
	}
	
	document.getElementById("newsList").onmouseout=function(){
		document.getElementById("newsContent").style.display="none";
	}
	
	function displayNewsList(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var json=xhr.responseText;
				// alert(json);
				
				// 응답받은 JSON 형식의 텍스트 데이터를 자바스크립트 객체로 변환하여 저장
				// 1. eval(text) : 문자값을 자바스크립트 명령으로 변환하는 함수
				// var newsArray=eval("("+json+")");
				// 2. JSON.parse(text) : JSON 형식의 텍스트 데이터를 자바스크립트 객체로 변환하여 반환하는 메소드
				var newsArray=JSON.parse(json);
				// alert(newsArray);
				// alert(newsArray.length);
					// JSON.parse()는 옛날 브라우저에는 존재하지 않음.
					// eval()은 과거에 많이 사용. 최근에는 JSON.parse를 많이 사용
				
				var html="<ol>";
				for(i=0; i<newsArray.length; i++){
					// Object 객체의 속성값을 제공받아 변수에 저장
					var headline=newsArray[i].headline;
					var publisher=newsArray[i].publisher;
					
					html+="<li>"+headline+"["+publisher+"]</li>";
					
				}
				html+="</ol>";
					// parsing이 쉽다는 것이 장점 - 표현하기 어려운 문자가 존재하는 것은 단점
					// 현재는 xml보다는 JSON을 더 많이 사용
				
				document.getElementById("newsContent").innerHTML=html;
			} else {
				document.getElementById("newsContent").innerHTML="에러코드 = "+xhr.status;
					// 400 or 500일 때 출력
			}
		}
	}
	</script>
</body>
</html>