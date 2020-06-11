<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%
//데이터 
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));

//DB
BoardDAO boardDAO = BoardDAO.getInstance();
BoardDTO boardDTO = boardDAO.boardView(seq);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
<form name="boardModifyForm" method="post" action="boardModify.jsp">
	<input type="hidden" name="seq" value="<%=seq%>">
	<input type="hidden" name="pg" value="<%=pg%>">
	
	<h3>글수정</h3>
	<table border="3px">
		<tr>
			<td>제목</td>
			<td><input type="text" name ="subject" id="subject" value="<%=boardDTO.getSubject()%>"></td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td>
			<textarea name="content" id="content" cols="50" rows="10" style="resize:none;" value="<%=boardDTO.getContent()%>"></textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">		
			<input type="button" value="글수정" onclick="checkBoardModifyForm()"> 
			<input type="reset" value="다시작성 ">
			
			</td>
				
		</tr>
			
	</table>
</form>
</body>
<script type="text/javascript">
function checkBoardModifyForm(){

	if(document.getElementById("subject").value ==""){
		alert("제목을 입력하세요. ");

	}else if(document.getElementById("content").value ==""){
		alert("내용을 입력하세요.");
	
	}else {
		document.boardModifyForm.submit();
	}
	
}
</script>
</html>