<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form Screen</title> 
</head>
<body>
 <h3>로그인</h3>
  <form name="loginForm" method="post" action="/mvcMember/member/login.do">
   <table border="1" cellspacing="0" cellpadding="3">
   
    <tr>
     <td width="100" align="center">아이디</td>
     <td><input type="text" name="id" placeholder="아이디입력"></td>
    </tr>
    
    <tr>
     <td width="100" align="center">비밀번호</td>
     <td><input type="text" name="pwd" placeholder="비밀번호입력"></td>
    </tr>   
    
    <tr> 
     <td colspan="2" align="center">
	 <input type="button" onclick="checkLoginForm()" value="로그인"> &emsp; 
	 <input type="button" onclick="location.href='writeForm.jsp'" value="회원가입" ></td>
    </tr>

   </table> 
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>












