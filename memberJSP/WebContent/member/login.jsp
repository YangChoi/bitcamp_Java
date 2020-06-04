<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.dao.MemberDAO"
%>

<%
//데이터 받기 

MemberDTO memberdto = new MemberDTO();

MemberDAO memberDAO = MemberDAO.getInstance();
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");


String name = memberDAO.loginMember(id, pwd);
System.out.println(id + "," + pwd);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<form method="get" action="modifyForm.jsp">
	
		<%=name%> 님 환영합니다. <br>
		
		<input type = "button" id="logoutBtn" value="로그아웃">
		<input type = "submit" id="modifyBtn" value="회원정보수정">
		
	</form>	
</body>
</html>