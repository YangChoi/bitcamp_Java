<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="inputForm" method="get" action="sum.jsp">
	<table border="1">
		<tr>
			<td>X</td>
			<td>
			<input type="text" name="x" size = "15">
			</td>
		</tr>
		
		<tr>
			<td>Y</td>
			<td>
			<input type="text" name="y" size = "15">
			</td>
		</tr>
		
		<tr colspan="2">
			<td>
			<input type="submit" value="합하기">
			</td>
			<td>
			<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>