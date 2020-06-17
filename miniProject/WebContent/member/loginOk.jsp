<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인성공</title>
</head>
<body>
	<%-- ${sessionScope.memName} 옆과 같이 입력해도 된다. 없으면 session까지 올라가기 때문--%> ${memName} 님 환영합니다. <br><br>
	<input type = "button" id="" value="메인화면" onclick="location.href=''">
	<input type = "button" id="logoutBtn" value="로그아웃" onclick="location.href='/miniProject/member/logout.do'">
	<input type = "submit" id="modifyBtn" value="회원정보수정" onclick="location.href=''">
</body>
</html>