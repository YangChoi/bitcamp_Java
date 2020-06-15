<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	table{
		text-align:center;
	}
</style>
<body>
<table border="1" width="50%">
	<tr>
		<th width="50%">표현식</th>
		<th width="50%">값</th>
	</tr>
	<tr>
		<td>\${25+3}</td>
		<td>${25+3}</td>
	</tr>
	<tr>
		<td>\${25/3}</td>
		<td>${25/3}</td>
		<!-- 웹은 정수, 실수 개념이 없다 -->
	</tr>
	<tr>
		<td>\${25 div 3}</td>
		<td>${25 div 3}</td>
	</tr>
	<tr>
		<td>\${25 mod 3}</td>
		<td>${25 mod 3}</td>
	</tr>
	<tr>
		<td>\${25 < 3}</td>
		<td>${25 < 3}</td>
	</tr>
	<!--  > gt, <lt, >=ge, <=le, ==eq, != ne -->
	<tr>
		<td>\${25 ne 3}</td>
		<td>${25 ne 3}</td>
	</tr>
	<tr>
		<td>\${header['host']} </td>
		<td>${header['host']}</td>
	</tr>
	<tr>
		<td>\${header.host}</td>
		<td>${header.host}</td>
	</tr>
	
</table>
</body>
</html>