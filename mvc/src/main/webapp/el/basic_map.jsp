<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// HashMap(Map) 인스턴스를 생성하여 저장
	Map<String, String> carMap=new HashMap<String, String>();
	
	// HashMap(Map) 인스턴스에 엔트리(Entry) 추가
	carMap.put("modelName", "싼타페");
	carMap.put("carColor", "하얀색");
	
	pageContext.setAttribute("car", carMap);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<h2>EL 미사용</h2>
	<%
		@SuppressWarnings("unchecked")
		Map<String, String> car=(Map<String, String>)pageContext.getAttribute("car");
			// 원래는 가져오는 요소가 모두 String인지 확인을 해줘야하는데 이 작업을 안해서 경고 발생
	%>
	<%-- HashMap(Map) 인스턴스에 저장된 엔트리에서 키를 이용하여 값을 반환받아 출력 --%>
	<p>자동차 모델명 = <%=car.get("modelName")%></p>
	<p>자동차 색상 = <%=car.get("carColor")%></p>
	<hr>
	<h2>EL 사용</h2>
	<%-- EL 표현식으로 제공되는 속성명의 속성값이 Map 인스턴스인 경우 ${속성명.맵키} 형식으로
	Map 인스턴스의 맵값을 제공받아 출력 --%>
	<p>자동차 모델명 = ${car.modelName }</p>
	<p>자동차 색상 = ${car.carColor }</p>
		<%-- get 메소드를 호출하지 않아도 값을 받아 출력가능 --%>	
		<%-- 
			클래스(VO, DTO, JavaBean)를 생성해서 사용할 수도 있겠지만
			Map을 활용하면 클래스를 굳이 만들 필요 없음. 
		--%>
</body>
</html>