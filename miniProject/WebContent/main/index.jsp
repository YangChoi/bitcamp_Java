<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
<form>
<table width="600" height="600">
	<tr>
		<td colspan="2">
			<jsp:include page ="../template/top.jsp" />
		</td>
	</tr>
	
	<tr>
		<td width="250" height="300" valign="top">	<jsp:include page ="../template/left.jsp" /></td>
		<td>	<jsp:include page ="${display}" /></td>
	
	</tr>
	
	<tr>
		<td colspan="2">	<jsp:include page ="../template/bottom.jsp" /></td>
	</tr>
</table>

</form>

</body>
</html>