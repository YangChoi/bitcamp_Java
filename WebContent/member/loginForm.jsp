<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
<style>
* {
	font-family: 'Jeju Gothic', sans-serif;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

#button, #button2 {
	background-color: white;
	color: black;
	border: 2px solid #3385ff;
}

#button:hover {
	background-color: #3385ff;
	color: white;
}

#button2:hover {
	background-color: #3385ff;
	color: white;

	
}
</style>
</head>
<body>
	<form name="loginForm" method="post" action="/miniProject/member/login.do">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" placeholder="아이디입력" size=15>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" placeholder="비밀번호 입력 "
					size=15></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					 <input type="button" onclick="checkLoginForm()" value="로그인"> &emsp; 
					 <input type="button" onclick="location.href='/miniProject/member/writeForm.do'" value="회원가입" ></td>
				<td>
			</tr>
		</table>

	</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>