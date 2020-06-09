<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>


<%

 request.setCharacterEncoding("UTF-8");

 // 데이터 얻어오기 
String subject = request.getParameter("subject");
String content = request.getParameter("content");

BoardDTO boardDTO = new BoardDTO();

String id = "yang"; // 원래는 세션으로 해결할 일인데 오늘은 일단 이걸로 
String name = "양아무개";
String email = "yang@java.com";

Map<String, String> map = new HashMap<String, String>();
map.put("id", id); // 변수명, 값
map.put("name", name); 
map.put("email", email);
map.put("subject", subject);
map.put("content", content); 

BoardDAO boardDAO = BoardDAO.getInstance();
boardDAO.writeBoard(map);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 생성</title>
</head>
<body>

</body>
<script type="text/javascript">
window.onload=function(){
	alert("글 생성 성공");
	location.href="../main/index.jsp"
}
</script>
</html>