<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>

<%
response.setContentType("text/html;charset=UTF-8");

// 세션값
String memId = (String)session.getAttribute("memId");

// boardList로부터 데이터 가져오기, SEQ, PG
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));

//DB
//저 둘의 값으로 글을 가져와야한다. 
BoardDAO boardDAO = BoardDAO.getInstance();
BoardDTO boardDTO = boardDAO.boardView(seq);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글</title>
</head>
<body>
	<table border="1" cellspacing="0" cellpadding="3" frame="hsides" rules="rows">
		<tr>
			<th colspan="3"><%=boardDTO.getSubject() %></th>
		</tr>
		<tr colspan="3">
			<td width="150">글번호 : <%=boardDTO.getSeq() %></td>
			<td>작성자 : <%=boardDTO.getName() %></td>
			<td>조회수 : <%=boardDTO.getHit() %></td>
		</tr>
		<tr>
		<td colspan="3" height="200" valign="top"><%=boardDTO.getContent() %></td>
		</tr>
	</table>
	<input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%=pg %>'">
	<!-- pg 값도 꼭 함께 넘겨줘야한다  -->
	
	<!--(memId.equals(boardDTO.getId())) --> 
	<% if(boardDTO.getId().equals(session.getAttribute("memId"))) { %>
	<input type="button" value="글수정" onclick="location.href='boardModifyForm.jsp?seq=<%=seq%>&pg=<%=pg%>'">
	<input type="button" value="글삭제" onclick=""> 
	<%  } %>
</body>
</html>
