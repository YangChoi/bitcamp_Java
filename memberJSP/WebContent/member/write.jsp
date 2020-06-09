<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.dao.MemberDAO"
	import="member.bean.MemberDTO"%>

<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="memberDTO" class="member.bean.MemberDTO"/>

<jsp:setProperty name="memberDTO" property="*"/>


<%
MemberDAO memberDAO = MemberDAO.getInstance();
memberDAO.writeMember(memberDTO);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입완료</title>
</head>
<body>
회원가입 완료 
</body>
<script type="text/javascript">
window.onload=function(){
	alert("회원 가입 완료");
	location.href="loginForm.jsp";
}
</script>
</html>