<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.dao.MemberDAO"%>

<%
// 데이터 받기 
String id = request.getParameter("id");

// DB에 간다 
// 싱글톤
MemberDAO memberDAO = MemberDAO.getInstance();
// 위의 <%@에서 IMPORT 해주면 된다 
boolean exist = memberDAO.isExistId(id);

// 아이디가 있으면 
if (exist == true) {
	exist = true;
} else if (exist == false) {
	// 아이디가 없으면 
	exist = false;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="checkId.jsp">
		<%
			if (exist) {
		%>
		<%=id%>
		는 사용 불가한 아이디입니다.<br> <br>
		아이디 <input type="text" name="id">
		<input type="submit" value="검색">
		<%
			} else {
		%>
		<%=id%>
		는 사용 가능한 아이디입니다. <br><br>
		<input type="button" value="사용하기" onclick="checkIdClose('<%=id%>')">
		<%
			}
		%>
	</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>