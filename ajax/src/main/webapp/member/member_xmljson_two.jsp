<?xml version="1.0" encoding="utf-8"?> 
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%-- 대용량전달 -> xml --%>
<result>
	<code>success</code>
		<%-- CDATA는 무조건 옆에 써줘야 한다. 엔터-인식 --%>
	<data><![CDATA[
		[{"id":"aaa", "name":"홍길동"},
		{"id":"bbb", "name":"임꺽정"},
		{"id":"ccc", "name":"전우치"},
		{"id":"ddd", "name":"일지매"},
		{"id":"eee", "name":"장길산"}]
	]]>
	</data>
</result>