<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/ckeditor/ckeditor.js"></script>
	<title>新增公佈欄訊息</title>

</head>
<body>
		<h1>新增公佈欄</h1>
    	<form:form action="insert" method="POST" modelAttribute="billboardVO">
<%-- 		<form:errors path="*" cssClass="errorblock" element="div" /> --%>
		<table>

			<tr>
				<td width="10%">標題:<font color=red><b>*</b></font></td>
				<td width="35%"><form:input type="text" path="bill_title" id="bill_title"	size="45"/></td>
				<td width="55%"><font color="red"><form:errors path="bill_title" cssClass="error"/></font></td>
			</tr>
			<tr>
				<td>發布者:<font color=red><b>*</b></font></td>
				<td><form:input type="text" path="bill_name" id="bill_name" size="45"/></td>
				<td><font color="red"><form:errors path="bill_name" cssClass="error" /></font></td>
			</tr>
			<tr>
				<td>開始日期:<font color=red><b>*</b></font></td>
				<td><form:input type="date" path="bill_start" id="bill_start" size="40"/> 
				<td><font color="red"><form:errors path="bill_start" cssClass="error"/></font></td>
			</tr>
			<tr>
				<td>結束日期:<font color=red><b>*</b></font></td>
				<td><form:input type="date" path="bill_end" id="bill_end" size="40"/> 
				<td><font color="red"><form:errors path="bill_end" cssClass="error"/></font></td>
			</tr>
			<tr>
				<td>內容:<font color=red><b>*</b></font></td>
				<td><form:textarea path="bill_content" id="bill_content" rows="10" cols="80"/></td>
				<script type="text/javascript">
			        CKEDITOR.replace( 'bill_content' );
			    </script>
				<td><font color="red"><form:errors path="bill_content" cssClass="error"/></font></td>
			</tr>
		</table><br>
		
		 <button type="submit" class="btn btn-primary">發布</button>
	</form:form>
				

</body>

</html>
