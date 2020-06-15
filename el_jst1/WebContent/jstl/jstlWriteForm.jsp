<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
	text-align:center;
}
</style>
<body>
<form method="post" action="jstlWrite.jsp">
<table border="1">
	<tr width="70">
		<td>아이디</td>
		<td><input type="text" name="id" size=10></td>
	</tr>
	<tr width="70">
		<td>이름</td>
		<td><input type="text" name="name" size=10></td>
	</tr>
	<tr width="70">
		<td>비밀번호</td>
		<td><input type="password" name="pwd" size=10></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="저장">
		<input type="button" value="목록">
		<input type="reset" value="취소">
		</td>
	
	</tr>
	

</table>
</form>
</body>
</html>