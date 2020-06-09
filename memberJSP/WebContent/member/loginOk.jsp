<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");    
String id = request.getParameter("id");    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인성공</title>
</head>
<body>
	<img src = "../image/pickleRick.jpg" width=250 height=200 onclick="location.href='../main/index.jsp'" style="cursor:pointer;"><br>
	<%=name%> 님 환영합니다. <br><br>
	<input type = "button" id="logoutBtn" value="로그아웃">
	<input type = "submit" id="modifyBtn" value="회원정보수정" onclick="location.href='modifyForm.jsp?id=<%=id%>'">
</body>
</html>