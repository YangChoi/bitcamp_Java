<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<style>
* {
	font-family: 'Jeju Gothic', sans-serif;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

#button, #reset {
	background-color: white;
	color: black;
	border: 2px solid #3385ff;
}

#button:hover {
	background-color: #3385ff;
	color: white;
}

#reset:hover {
	background-color: #3385ff;
	color: white;
}
</style>
<body>
	<form name="loginForm" method="post" action="login.jsp">
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
				<td>
					<input type="button" id="button" value="로그인" onclick="checkLoginForm()"> 
					<input type="reset" id="reset" value="취소">
				<td>
			</tr>
		</table>

	</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>