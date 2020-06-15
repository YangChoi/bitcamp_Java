<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="angel" uri="tld" %>
<%@ taglib prefix="devil" uri="tld2" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바클래스의 메소드를 이용해 계산</title>
</head>
<body>
<h3>자바클래스의 메소드를 이용해 계산</h3>
${param.x} + ${param.y} = ${ angel:sum(param.x,param.y) }<br>
${param.x} * ${param.y} = ${ devil:mul(param.x,param.y) }<br>
</body>
</html>