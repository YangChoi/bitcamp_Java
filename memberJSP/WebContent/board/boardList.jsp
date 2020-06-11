<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
    
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="board.dao.BoardDAO"%>

<%
request.setCharacterEncoding("UTF-8");

// 세션값 얻어오기 (이걸로 로그인 판별하려고 가져옴)
String memId = (String)session.getAttribute("memId");

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
<style type="text/css">
.subjectA:link {
	color:black;
	text-decoration:none;	
}
.subjectA:visited {
	color:black;
	text-decoration:none;	
}
.subjectA:hover{
	color:green;
	text-decoration:underline;	
}
.subjectA:active{
	color:black;
	text-decoration:none;	
}
</style>
<body>
<table border = "3" cellspacing="0" cellpadding="3" frame="hsides" rules="rows">
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
		<!-- js에 session값을 넘겨줘야한다, seq와 pg 값도 함께 넘겨준다 -->
		<td><a class="subjectA" href="#" onclick="isLogin('<%=memId%>',<%=dto.getSeq() %>,<%=pg%>)"><%=dto.getSubject() %></a></td>
		<!-- 보내주는 값에 싱글따옴표를 쳐주었기 때문에 만약 값이 null인 경우 null이라는 값이 넘어오는 것이 아닌 null이라는 문자가 넘어온다  -->
		<td><%=dto.getName() %></td>
		<td><%=dto.getLogtime() %></td>
		<td><%=dto.getHit() %></td>
		</tr>
<%	} %>
<%} %>
</table>
</body>
<script type="text/javascript">
//글 들어갈 때 
function isLogin(memId, seq, pg){
	if(memId == 'null') {
		alert("먼저 로그인하세요");
	// null이라는 글자가 넘어오기 때문에 null에 싱글따옴표를 쳐주어야한다. 
	
	<%--// 밑의 문장의 경우에 js 파일로 따로 뺐을 때 <%가 안먹는 문제가 생겨버린다 
	//if(<%=session.getAttribute("memId") == null %>) alert("먼저 로그인하세요"); --%>
	
	}else{ 
		location.href="boardView.jsp?seq="+seq+"&pg="+pg;
	// boardView로 보내주기 (단, seq와 pg 값도 함께 넘겨준다)
	
	}
}

</script>
</html>