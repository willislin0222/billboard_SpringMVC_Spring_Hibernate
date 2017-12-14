<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.billboard.model.*"%>

<%
	BillboardService billboardSvc = new BillboardService();
	List<BillboardVO> list = billboardSvc.getAll();
	pageContext.setAttribute("list",list);
	
%>


<html>
<head>
<title>瀏覽公布事項</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/listAllBillboard.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<c:if test="${empty list}">
		<font color="red">無資料</font><br>
	</c:if>	

<div class="container">

<table width="100%">
	<tr>
		<th class="col1">標題</th>
		<th class="col2">發布日期</th>
		<th class="col3">截止日期</th>
		<th class="col4">修改</th>
		<th class="col5">刪除</th> 
	</tr>
	<%@ include file="pages/page1.file" %>  
	
	<c:forEach var="billboardVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle'>
			<td class="col1"><a href="<%=request.getContextPath()%>/billboard/getOne_For_Display?bill_id=${billboardVO.bill_id}">${billboardVO.bill_title}</a></td>
			<td class="col2">${billboardVO.bill_start}</td>
			<td class="col3">${billboardVO.bill_end}</td>
	
			<td class="col4">
			<form ACTION="<%=request.getContextPath()%>/billboard/getOne_For_Update" method="POST">
				 <button type="submit" class="btn btn-primary">修改</button>   
			     <input type="hidden" name="bill_id" value="${billboardVO.bill_id}">
			     <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			</form>
			</td>
			<td class="col5">
			<form ACTION="<%=request.getContextPath()%>/billboard/delete" method="POST"> 
				 <button type="submit" class="btn btn-primary">刪除</button>
			     <input type="hidden" name="bill_id" value="${billboardVO.bill_id}">
			     <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			</form>
			</td>
		</tr>
	</c:forEach>	
</table>
</div>
<br>

<div class="button">	
			<a href="<%=request.getContextPath()%>/billboard/addBillboard">新增公佈欄</a>
</div>
		
<%@ include file="pages/page4.file" %>

</body>
</html>
