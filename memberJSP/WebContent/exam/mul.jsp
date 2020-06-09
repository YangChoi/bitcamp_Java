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
<title>Insert title here</title>
</head>
<body>
	둘의 곱 <br>
	<%=dataDTO.getX() * dataDTO.getY() %><br>

</body>
</html>