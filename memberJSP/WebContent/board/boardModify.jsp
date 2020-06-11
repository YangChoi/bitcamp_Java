<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%
response.setContentType("text/html;charset=UTF-8");

//데이터
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));

String subject = request.getParameter("subject");
String content = request.getParameter("content");

//DB
BoardDAO boardDAO = BoardDAO.getInstance();
boardDAO.boardModify(seq, subject, content);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 성공</title>
</head>
<body>
<script type="text/javascript">
window.onload=function(){
	alert("글 수정 완료");
	location.href="../board/boardList.jsp?pg=<%=pg%>";
	// pg 값을 가져가야한다. 
}
</script>
</body>
</html>