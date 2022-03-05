<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- RSS 서비스를 제공하는 웹프로그램을 AJAX 기능으로 요청하여 응답결과를 제공받아
클라이언트에게 전달하는 JSP 문서 --%>
<%-- RSS(Really Simple Syndication 또는 Rich Site Summary) : 실시간으로 변경되는 정보를
제공하기 위한 웹프로그램의 종류  --%>
	<%-- e.g. 뉴스 - 언론사 사이트에 가보면 대부분 실시간으로 변경되는 정보를 제공해주는 웹프로그램 존재 --%>
	<%-- RSS 프로그램 결과를 읽어 들여서 출력하는 프로그램을 RSS Reader라고한다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>RSS Reader</h1>
	<hr>
	<div id="display"></div>
	
	<script type="text/javascript">
	$.ajax({
		type: "get",
		// url: "https://www.khan.co.kr/rss/rssdata/economy_news.xml",
		url: "rss_proxy.jsp",
			// 같은 서버에 있는 프로그램이기 때문에 요청 가능
		dataType: "xml",
		success: function(xml){
			var channelTitle=$(xml).find("channel").children("title").text();
			
			var html="<h2>"+channelTitle+"</h2>";
			html+="<ul>";
			$(xml).find("item").each(function(){
				var title=$(this).find("title").text();
				var link=$(this).find("link").text();
				var date;
				if($(this).find("pubDate").length!=0){
					date=$(this).find("pubDate").text();
				} else {
					date=$(this).find("dc\\:date").text();
				}
				html+="<li><a href='"+link+"'>"+title+"["+date+"]</a></li>";
			});
			html+="</ul>";
			
			$("#display").html(html);
		},
		error: function(){
			alert("에러코드 = "+xhr.status);
		}
	});
	
		// Ajax를 통해서 요청할 수 있는 리소스는 같은 서버에 있는 웹프로그램만 요청가능하다.
		// => 다른 서버에 있는 웹문서 or 웹프로그램은 요청할 수 없다.
		// 때문에, 다른 웹서버에 있는 RSS를 요청하면 요청을 보낼 수 없기 때문에 0 에러코드가 발생한다.
		// proxy 프로그램을 통해 우회하면, 받은 rss 프로그램을 파싱하여 처리할 수 있다.
	
	</script>
</body>
</html>