<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="">
	<head>
		<title>公布欄資料</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/ckeditor/ckeditor.js"></script>
	</head>
	<body >	
		<h1><a href="<%=request.getContextPath()%>/billboard/listAllBillboard.jsp">公佈欄資料:</a></h1>
			<form:form action="update" method="POST" modelAttribute="billboardVO">
		<table>
			<tr>
				<td width="10%">標題:<font color=red><b></b></font></td>
				<td width="90%"><form:input type="text" path="bill_title" id="bill_title" value="${billboardVO.bill_title}" readonly="true" size="45"/></td>
			</tr>
			<tr>
				<td>發布者:<font color=red><b></b></font></td>
				<td><form:input type="text" path="bill_name" id="bill_name" value="${billboardVO.bill_name}" readonly="true" size="45"/></td>
			</tr>
			<tr>
				<td>開始日期:<font color=red><b></b></font></td>
				<td><form:input type="date" path="bill_start" id="bill_start" value="${billboardVO.bill_start}" readonly="true" size="40"/> 
			</tr>
			<tr>
				<td>結束日期:<font color=red><b></b></font></td>
				<td><form:input type="date" path="bill_end" id="bill_end" value="${billboardVO.bill_end}" readonly="true" size="40"/> 
			</tr>
			<tr>
				<td>內容:<font color=red><b></b></font></td>
				<td><form:textarea path="bill_content" id="bill_content" value="${billboardVO.bill_content}" readonly="true" rows="30" cols="80"/></td>
				<script type="text/javascript">
  			        CKEDITOR.replace( 'bill_content', { height: '550px', width: '90%' });
			    </script>
				<td><font color="red"><form:errors path="bill_content" cssClass="error"/></font></td>
			</tr>
		</table><br>
	</form:form>
	</body>
</html>