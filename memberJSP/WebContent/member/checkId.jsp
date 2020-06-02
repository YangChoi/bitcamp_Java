<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 데이터 받기 
String id = request.getParameter("id");

// DB에 간다 
// 싱글톤
MemberDAO memberDAO = MemberDAO.getInstance();
boolean exist = memberDAO.isExistId();

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
	<%
		if (exist == true) {
	%>
	<%=id%>
	는 사용 불가한 아이디입니다.
	<%
		} else if (exist == false) {
	%>
	<%=id%>
	는 사용 가능한 아이디입니다.
	<%
		}
	%>
</body>
</html>