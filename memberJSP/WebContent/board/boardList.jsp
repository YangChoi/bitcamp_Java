<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
    
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="board.dao.BoardDAO"%>

<%
// 페이지 얻어오기 
int pg = Integer.parseInt(request.getParameter("pg"));

int endNum = pg*5; // pg * 페이지 내 글 수  
int startNum = endNum-4; // endNum - (페이지 내 글 수 -1)

BoardDAO boardDAO = BoardDAO.getInstance();

List<BoardDTO> list = boardDAO.getBoardList(startNum, endNum);

int totalA = boardDAO.getTotalA(list);
int totalP = (totalA+1)/5; // 한페이지당 글 5개 

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책목록</title>
</head>
<body>
<table border = "3" cellspacing="0" cellpadding="3" frmae="hsides" rules="rows">
<tr>
	<th width="100">글번호</th>
	<th width="200">제목</th>
	<th width="100">작성자</th>
	<th width="100">작성일</th>
	<th width="100">조회수</th>
	
</tr>
<%if(list != null){ %>
<% for(BoardDTO dto : list){ %>
		<tr>
		<td><%=dto.getSeq() %></td>
		<td><%=dto.getSubject() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getLogtime() %></td>
		<td><%=dto.getHit() %></td>
		</tr>
<%	} %>
<%} %>
</table>
</body>
</html>