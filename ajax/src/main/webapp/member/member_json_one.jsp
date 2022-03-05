<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/log.js"></script>
</head>
<body>
	<h1>회원목록</h1>
	<hr>
	<div id="log"></div>
	
	<script type="text/javascript">
	new xyz.itwill.Ajax("GET", "member_json_two.jsp", null, function(xhr){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var result=JSON.parse(xhr.responseText);
					// JSON.parse()를 통해 JS의 객체가 된다.
				
				if(result.code=="success") {
					var memberList=result.data;
				
					for(i=0; i<memberList.length; i++) {
						var id=memberList[i].id;
						var name=memberList[i].name;
						log("아이디 = "+id+", 이름 = "+name);
					}
				} else {
					log("검색된 회원정보가 존재하지 않습니다.")
				}
			} else {
				log("에러코드 = "+xhr.status);				
			}
		}
	});
		// 
		/*
			JSON의 단점 - 대량의 데이터 전송에 부적합
			하이브리드앱(모바일) - 전송되는 데이터가 크지는 않음.
			XML - 중복되는 엘리먼트가 많음.
			-> 두개를 섞어 사용하는 경우도 존재
		
		*/
	</script>
</body>
</html>