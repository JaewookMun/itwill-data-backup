<%@page import="java.io.File"%>
<%@page import="xyz.itwill.dao.ProductDAO"%>
<%@page import="xyz.itwill.dto.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//비정상적인 요청에 대한 처리
	if(request.getParameter("productNum")==null){
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=error&work=error400'");
		out.println("</script>");
		return;
	}
		// 식별자를 전달받아 처리할 경우 식별자가 전달되지 않았을 때 error 페이지로 가는 것이 정석
	
	// 전달값을 반환받아 저장
	int productNum=Integer.parseInt(request.getParameter("productNum"));
	
	// 제품번호를 전달받아 PRODUCT 테이블에 저장된 해당 제품번호의 제품정보를 검색하여
	// 반환하는 DAO 클래스의 메소드 호출
	ProductDTO product = ProductDAO.getDAO().selectNumProduct(productNum);
	
	// 제품번호를 전달받아 PRODUCT 테이블에 저장된 해당 제품번호의 제품정보를 삭제하는 DAO 클래스의 메소드 호출
	ProductDAO.getDAO().deleteProduct(productNum);
	
	// 삭제 처리된 제품에 대한 이미지 파일 삭제
	String saveDirectory=request.getServletContext().getRealPath("/site/product_image");
	new File(saveDirectory, product.getMainImage()).delete();
	
	//제품목록 출력페이지로 이동
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=admin&work=product_manager';");
	out.println("</script>");

		// 
%>

