<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 OK</title>
</head>
<body>
	<%-- ${sessionScope.memName } --%> ${memName } 님이 로그인 하셨습니다
	<br><br>
	<input type="button" value="로그아웃" 
	onclick="location.href='/mvcMember/member/logout.do'"> &emsp;
	<input type="button" value="회원정보수정" onclick="location.href=''">
</body>
</html>













