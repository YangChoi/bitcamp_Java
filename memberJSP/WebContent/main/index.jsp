<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
ul {
	list-style-type: none;
	padding : 0;
	border : 1px solid #ddd;
}

ul li {
	padding : 8px 16px;
	border-bottom : 1px solid #ddd;
}

ul li : last-childe {
	border-bottom : none;
}

a:hover{
	color : #0066ff;	
}
</style>
</head>
<body>
<h3> ** 메인 화면 ** </h3>
<!-- 만약 세션이 없으면 회원가입, 로그인이 뜨고, 만약 세션이 뜨면 회원정보수정, 로그아웃, 글쓰기, 목록은 있건 없건 뜨게 -->
<!-- 세션이 없느냐 묻는 것이 아닌 세션 안에 있는 값이 없는지 물어봐야한다. session이 내장객체로 잡혀있기 때문 -->
<%if(session.getAttribute("memId") == null){ %>
<ul>
	<li><a href = "http://localhost:8080/memberJSP/member/writeForm.jsp">회원가입</a><br>
	<li><a href = "../member/loginForm.jsp">로그인</a><br>
</ul>
	<%}else { %>
<ul>
	<li><a href = "../member/modifyForm.jsp">회원정보수정</a><br>
	<li><a href = "../member/logout.jsp">로그아웃</a><br>
	<li><a href = "../board/boardWriteForm.jsp">글쓰기</a><br>
	<%} %>
	<li><a href = "../board/boardList.jsp?pg=1">목록</a><br>
</ul>
<!-- 목록은 글 5개당 한페이지로 페이징 처리  -->

</body>
</html>