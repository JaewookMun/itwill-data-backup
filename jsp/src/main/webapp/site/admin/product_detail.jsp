<%@page import="java.text.DecimalFormat"%>
<%@page import="xyz.itwill.dto.ProductDTO"%>
<%@page import="xyz.itwill.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 제품번호를 전달받아 PRODUCT 테이블에 저장된 해당 제품번호의 제품정보를 검색하여
클라이언트에게 전달하는 JSP 문서 --%>
<%-- => 로그인 상태의 관리자만 접근 가능하도록 설정 --%>
<%-- => [제품정보변경]을 클릭한 경우 제품정보 변경 입력페이지(product_modify.jsp)로 이동 - 제품번호 전달 --%>
<%-- => [제품정보삭제]를 클릭한 경우 제품정보 삭제 처리페이지(product_remove_action.jsp)로 이동 - 제품번호 전달 --%>
<%@include file="/site/security/admin_check.jspf" %>
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

%>
<style type="text/css">

table {
	margin: 0 auto;
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
}

.title {
	background: black;
	color: white;
	text-align: center;
	width: 100px;
}

.value {
	padding: 3px;
	text-align: left;
	width: 400px;
}
</style>

<h2>제품상세정보</h2>
<table>
	<tr>
		<td class="title">제품번호</td>
		<td class="value"><%= product.getProductNum() %></td>
	</tr>
	<tr>
		<td class="title">제품코드</td>
		<td class="value"><%= product.getProductCode() %></td>
	</tr>
	<tr>
		<td class="title">제품명</td>
		<td class="value"><%= product.getProductName() %></td>
	</tr>
	<tr>
		<td class="title">제품이미지</td>
		<td class="value"><img src="<%= request.getContextPath() %>/site/product_image/<%=product.getMainImage()%>" width="200">
	</tr>
	<tr>
		<td class="title">상세설명</td>
		<td class="value"><%= product.getProductDetail().replace("\n", "<br>") %></td>
	</tr>
	<tr>
		<td class="title">제품수량</td>
		<td class="value"><%= DecimalFormat.getInstance().format(product.getProductQty()) %></td>
	</tr>
	<tr>
		<td class="title">제품가격</td>
		<td class="value"><%= DecimalFormat.getCurrencyInstance().format(product.getProductPrice()) %></td>
	</tr>
</table>
<p>
	<button type="button" id="modifyBtn">제품정보변경</button>
	<button type="button" id="removeBtn">제품정보삭제</button>
</p>

<script type="text/javascript">
	$("#modifyBtn").click(function(){
		location.href="<%=request.getContextPath()%>/site/index.jsp?workgroup=admin&work=product_modify&productNum=<%=product.getProductNum()%>";
	});
	
	$("#removeBtn").click(function() {
		location.href="<%=request.getContextPath()%>/site/index.jsp?workgroup=admin&work=product_remove_action&productNum=<%=product.getProductNum()%>";
	});
	
</script>	