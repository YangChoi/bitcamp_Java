<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
</head>
<body>
	아이디 또는 비밀번호가 틀리셨습니다.
	<br><br>
	<input type="button" value="로그인" 
	onclick="location.href='/mvcMember/member/loginForm.do'"> &emsp;
	<input type="button" value="회원가입" 
	onclick="location.href='/mvcMember/member/writeForm.do'">
</body>
</html>