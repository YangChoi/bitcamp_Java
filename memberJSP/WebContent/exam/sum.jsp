<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.IOException" %>
<jsp:useBean id="dataDTO" class="exam.bean.DataDTO" scope="session" />
<jsp:setProperty name="dataDTO" property="x"/>
<jsp:setProperty name="dataDTO" property="y"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>합하기</title>
</head>
<body>
	<form method="get" action="mul.jsp">
	<jsp:setProperty property="x" name="dataDTO"/> 
	<jsp:setProperty property="y" name="dataDTO"/>
		둘의 합 <br>
		<%=dataDTO.getX() + dataDTO.getY() %><br>
		<input type="Button" value="곱구하기" onclick="location.href='mul.jsp'">
		<input type="submit" value="곱구하기">
	</form>
</body>
</html>