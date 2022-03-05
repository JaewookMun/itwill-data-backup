<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- books.jsp 문서를 AJAX 기능으로 요청하여 실행결과를 XML 텍스트 데이터로 응답받아 HTML로
변환하여 클라이언트에게 전달하는 JSP 문서 --%>
<%-- => books.xsl 문서를 이용하여 XML 텍스트 데이터를 HTML 태그로 변환 --%>
<%-- => xhr.js 모듈 사용 : 전역변수와 함수를 사용하여 AJAX 기능 제공 --%>
	<%-- xml 텍스트 데이터를 받아서 DOM parsing 하는 것이 아니라 xsl 파싱방식 이용 --%>
	
<%-- XSLT 문서를 이용한 XML 텍스트 데이터 파싱 방법 --%>	
<%-- 1. JSP 문서(XML)와 XSL 문서(XSLT)를 AJAX 요청하여 두 문서의 응답결과를 반환받아 저장 --%>
<%-- 2. XSL 문서의 응답결과(XSLT)를 이용하여 JSP 문서의 응답결과(XML)를 변환(HTML)하여 저장 --%>
<%-- 3. 변환된 결과를 이용하여 페이지의 박스모델 변경 - DHTML --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/xhr.js"></script>
</head>
<body>
	<h1>교재목록</h1>
	<hr>
	<div id="books"></div>
	
	<script type="text/javascript">
	var xmlDoc=null; // JSP 문서의 응답결과(XML)를 저장하기 위한 전역변수
	var xslDoc=null; // XSL 문서의 응답결과(XSLT)를 저장하기 위한 전역변수
	
	// 문제점) AJAX 기능을 제공하는 XMLHttpRequest 객체가 하나만 존재하므로 여러 개의
	// 웹프로그램을 동시에 요청하여 처리 불가능
	// 해결법) 웹프로그램을 동기식으로 요청하여 응답결과를 받기 전까지 다른 웹프로그램을
	// 요청할 수 없도록 프로그램 작성
	
	
	// books.jsp 문서를 AJAX 기능으로 요청하여 응답결과(XML)를 제공받아 처리하는 함수
	function loadBooksXML(){
		sendRequest("GET", "books.jsp", null, function() {
			if(xhr.readyState==4){
				if(xhr.status==200){
					xmlDoc=xhr.responseXML;
					// doXSLT();
					loadBooksXSL();
						// 2개를 동시에 요청하는 것이 아니라 1개를 받고 두번쨰것을 실행 - not like AJAX
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		})
	}
	
	// books.xsl 문서를 AJAX 기능으로 요청하여 응답결과(XSLT)를 제공받아 처리하는 함수
	function loadBooksXSL(){
		sendRequest("GET", "books.xsl", null, function() {
			if(xhr.readyState==4){
				if(xhr.status==200){
					xslDoc=xhr.responseXML;
					doXSLT();
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		})
	}
	
	loadBooksXML();
	// loadBooksXSL();
	
	// XSL 문서의 응답결과(XSLT)를 이용하여 JSP 문서의 응답결과(XML)를 변환하여 박스모델을 변경하는 함수
	function doXSLT(){
		// alert("xmlDoc = "+xmlDoc+", xslDoc = "+xslDoc);
		
		var books=document.getElementById("books");
		
		// XSLTProcessor 객체(XSLT를 이용하여 XML를 변환하는 객체) 생성
		var xsltProcessor=new XSLTProcessor();
		
		// XSLTProcessor.importStylesheet(xslt) : XSLTProcessor 객체에 변환정보(XSLT)를 변경하는 메소드
		xsltProcessor.importStylesheet(xslDoc);
		
		// XSLTProcessor.transformToFragment(xml, document) : XSLTProdcessor 객체에 저장된
		// 변환정보를 이용하여 XML 텍스트 데이터를 변환하여 Element 객체로 반환하는 메소드
		var fragment=xsltProcessor.transformToFragment(xmlDoc, document);
		
		// 반환받은 Element 객체를 원하는 박스모델의 자식 엘리먼트로 추가
		books.appendChild(fragment);
	}
	
		// 하나의 Ajax 엔진으로 두개의 문서(jsp, xsl)를 요청 - 두개다 가져올 수 는 없음. 둘중 하나만 받을 수 있다. 엔진이 하나밖에 없기 때문에
		// xhr.js 안에는 xhr 전역변수 하나만 존재(하나의  객체)
		// Ajax가 추구하는 완전한 비동기식 방식의 프로그램이라 볼 수 없다.
	
	</script>
</body>
</html>