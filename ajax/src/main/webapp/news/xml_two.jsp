<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%-- xml을 선언할 때 맨위에 위처럼 xml선언문을 넣어야함 - version : 1.o --%>   
	<!-- jsp 문서를 XML 파일로 출력하기 위해서 1. 맨위에 xml 선언문 작성 2. contentType을 xml로 변경 -->
	
<%-- 최신 뉴스목록을 XML 형식의 텍스트 데이터로 응답하는 JSP 문서 --%>
	<!-- root element가 존재해야함 -->
	<!-- 비구조화된 텍스트 문서를 xml을 통해 구조화 시켜서 표현 -->
	<!-- html - for 출력 // xml - for 값을 전달 -->
<newslist>
	<news>
		<headline><![CDATA['임단협 갈등' 금호타이어노조, 광주공장 점거 농성]]></headline>
		<publisher>연합뉴스</publisher>
			<!-- headline에 CDATA를 쓴이유는 특수문자 때문 -->
	</news>
	<news>
		<headline><![CDATA[출사표 던진 홍준표 "절박한 심정으로 마지막 정치 도전"]]></headline>
		<publisher>쿠키뉴스</publisher>
	</news>
	<news>
		<headline><![CDATA[아프간 대사관 전원 철수..공관원 3명·교민 1명 출국]]></headline>
		<publisher>뉴시스</publisher>
	</news>
	<news>
		<headline><![CDATA[신규확진 1천373명, 2주만에 1천400명 아래..42일째 네 자릿수]]></headline>
		<publisher>연합뉴스</publisher>
	</news>
	<news>
		<headline><![CDATA[군, 부교 설치시간 단축 자주도하장비 2027년 전력화]]></headline>
		<publisher>연합뉴스</publisher>
	</news>
	<news>
		<headline><![CDATA[정부 "모더나 미공급 물량 9월 초까지", 모더나 "최선 다하겠다"]]></headline>
		<publisher>뉴스1</publisher>
	</news>
</newslist>

		<!-- 브라우저에는 DOM parser가 존재 - DOM parser를 이용해 HTML문서로 파싱처리 -->
		<!-- XML은 여러가지 문제점 존재 - 불필요한 엘리먼트(태그) 설정 등 > JSON 등장 -->
		<!-- 불필요한 엘리먼트 -> 데이터가 많아지는 것이 단점 -->







