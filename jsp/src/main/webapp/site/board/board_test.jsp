<%@page import="xyz.itwill.dao.BoardDAO"%>
<%@page import="xyz.itwill.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- BOARD 테이블에 새글을 500개 저장하는 JSP 문서 - 테스트 프로그램 --%>
	<%-- 페이징 처리를 위해서.. --%>
<%
	for(int i=1; i<=500; i++){
		BoardDTO board=new BoardDTO();
		int num=BoardDAO.getDAO().selectNextNum();
		board.setNum(num);
		board.setId("abc1");
		board.setWriter("홍길동");
		board.setSubject("테스트"+i);
		board.setRef(num);
		board.setContent("게시글 연습 - "+i);
		board.setIp("127.0.0.1");
		BoardDAO.getDAO().insertBoard(board);
	}

%>
<h3>500개의 테스트 게시글을 저장하였습니다.</h3>