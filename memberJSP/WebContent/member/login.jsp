<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.dao.MemberDAO"
%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="java.net.URLEncoder"%>

<%
//데이터 받기 

MemberDAO memberDAO = MemberDAO.getInstance();
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String email = request.getParameter("email");


MemberDTO memberDTO = memberDAO.loginMember(id, pwd);
System.out.println(id + "," + pwd);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
* {
	font-family: 'Jeju Gothic', sans-serif;
}

#button, #logoutBtn, #modifyBtn{
	background-color: white;
	color: black;
	border: 2px solid #3385ff;
}

#button:hover {
	background-color: #3385ff;
	color: white;
}
#logoutBtn:hover {
	background-color: #3385ff;
	color: white;
}
#modifyBtn:hover {
	background-color: #3385ff;
	color: white;
}
</style>
<title>로그인 성공</title>
<link href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" rel="stylesheet">
</head>
<body>
<!-- 회원정보 수정의 경우엔 get 방식으로 주소에 id 값 공개적으로 보여주면 안된다. 
 그랬다간, id 값 변경해서 다른 id의 정보를 수정할 수 있게 된다.  -->
 
<%if(memberDTO == null){ 
	// 페이지 이동
	response.sendRedirect("loginFail.jsp");	
	// 로그인 실패시엔 세션과 쿠키는 의미 없음 (생성안함) 
}else { 
	/*
	// 쿠키 생성
	// 쿠키는 해킹당할 위험이 있어서 세션을 좀 더 선호한다 
	//Cookie cookie = new Cookie("쿠키명", "값");
	Cookie cookie = new Cookie("memName", name);
	cookie.setMaxAge(30*60); // 초단위 
	response.addCookie(cookie);// 클라이언트에게 보내기 
	
	Cookie cookie2 = new Cookie("memId", id);
	cookie2.setMaxAge(30*60); // 초단위  (60 곱해서 30분 살아있게 만든다)
	// 이런 경우 30분 동안 새로고침해도 새로운 정보 뜨지 않는다. 
	response.addCookie(cookie2);// 클라이언트에게 보내기 
	*/
	
	// 세션 생성
	// 세션은 인터페이스이다. 
	
	//HttpSession session = request.getSession();
	// 내장객체 중에 session이 있기 때문에 변수명 session하면 중복걸린다. 
	// 세션 부여 
	session.setAttribute("memName", memberDTO.getName()); 
	session.setAttribute("memId", id); 
	session.setAttribute("memEmail", memberDTO.getEmail1() + "@" + memberDTO.getEmail2());
	
	session.setAttribute("memDTO", memberDTO); // 받아올 값이 너무 많으니까 아예 memberDTO(클래스객체)로 받아줄 수도 있다. 
	
	
	// 페이지 이동
	// request로 보내면 안보내지므로 주소에 담아서 보내는 수 밖에 없다
	// request.setAttribute("id", id); 안된다....
	//response.sendRedirect("loginOk.jsp?name="+ URLEncoder.encode(name,"UTF-8") +"&id="+id);
	response.sendRedirect("loginOk.jsp");
} %>

	
</body>
</html>