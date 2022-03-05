<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 최신 뉴스목록을 JSON 형식의 텍스트 데이터로 응답하는 JSP 문서 --%>
	<%-- newslist라는 배열객체의 이름은 굳이 줄 필요 없다. - 배열이 한개일 경우 --%>
[{"headline":"'임단협 갈등' 금호타이어노조, 광주공장 점거 농성", "publisher":"연합뉴스"}
	,{"headline":"출사표 던진 홍준표 \"절박한 심정으로 마지막 정치 도전\"", "publisher":"쿠키뉴스"}
	,{"headline":"아프간 대사관 전원 철수..공관원 3명·교민 1명 출국", "publisher" :"뉴시스"}
	,{"headline":"신규확진 1천373명, 2주만에 1천400명 아래..42일째 네 자릿수", "publisher":"연합뉴스"}
	,{"headline":"군, 부교 설치시간 단축 자주도하장비 2027년 전력화", "publisher":"연합뉴스"}
	,{"headline":"정부 \"모더나 미공급 물량 9월 초까지\", 모더나 \"최선 다하겠다\"", "publisher":"뉴스1"}]

		<%-- JSON을 parsing 할 수 있는 프로그램이 브라우저에는 존재하지 않음 --%>
		<%-- JSON text 데이터를 전달받았을 때 보기편하게 출력되는 뷰어를 따로 설치. --%>
		<%-- xml보다 JSON이 용량이 적고 간편 --%>