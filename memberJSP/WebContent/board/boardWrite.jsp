<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>


<%

 request.setCharacterEncoding("UTF-8");

 // 데이터 얻어오기 
String subject = request.getParameter("subject");
String content = request.getParameter("content");

BoardDTO boardDTO = new BoardDTO();

/*
String id = "yang"; // 원래는 세션으로 해결할 일인데 오늘은 일단 이걸로 
String name = "양아무개";
String email = "yang@java.com";
*/


// 세션값 얻기 
String id = (String)session.getAttribute("memId");
String name = (String)session.getAttribute("memName");
String email = (String)session.getAttribute("memEmail");
// 만약에 dto를 받았다하면 dto 전체를 받아도 된다. 


// 이메일 세션 만들어주기



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