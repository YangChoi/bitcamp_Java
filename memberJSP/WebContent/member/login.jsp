<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.dao.MemberDAO"
%>

<%
//데이터 받기 

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
<style>
* {
	font-family: 'Jeju Gothic', sans-serif;
}
#button, #logoutBtn, #modifyBtn{
	background-color: white;
	color: black;
	border: 2px solid #3385ff;
}

#button:hover {
	background-color: #3385ff;
	color: white;
}
#logoutBtn:hover {
	background-color: #3385ff;
	color: white;
}
#modifyBtn:hover {
	background-color: #3385ff;
	color: white;
}
</style>
<title>로그인 성공</title>
<link href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" rel="stylesheet">
</head>
<body>
<!-- 회원정보 수정의 경우엔 get 방식으로 주소에 id 값 공개적으로 보여주면 안된다. 
 그랬다간, id 값 변경해서 다른 id의 정보를 수정할 수 있게 된다.  -->
 
<%if(name == null){ %>
	아이디 또는 비밀번호가 맞지 않습니다. 
	<input type="button" id="button" value="회원가입" onclick="location.href='writeForm.jsp'">
	<br><br>
<%}else { %>
		<%=name%> 님 환영합니다. <br><br>
		<input type = "button" id="logoutBtn" value="로그아웃">
		<input type = "submit" id="modifyBtn" value="회원정보수정" onclick="location.href='modifyForm.jsp?id=<%=id%>'">
<%} %>

	
</body>
</html>