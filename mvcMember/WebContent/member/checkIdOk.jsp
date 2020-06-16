<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 사용가능</title>
</head>
<body>
${memId} 는 사용 가능한 아이디 입니다. 
<input type="button" value="사용하기" onclick="checkIdClose('${memId}')">
</body>
</html>