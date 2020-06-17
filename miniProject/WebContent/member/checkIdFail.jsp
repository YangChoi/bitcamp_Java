<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 사용 불가 </title>
</head>
<body>
<form method="post" action="/miniProject/member/checkId.do">
	${requestScope.id} 는 사용 불가한 아이디 입니다.
	<br><br>  
	아이디 <input type="text" name="id">
	<input type="submit" value="검색">
</form>
</body>
</html>