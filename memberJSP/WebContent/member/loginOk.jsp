<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 이제는 사용자 이름과 아이디가 주소를 통해 넘어오는 게 아닌 
// 쿠키를 통해 넘어오기 때문에 null로 해준다. 
String name = null;
String id = null;
//String name = request.getParameter("name");    
//String id = request.getParameter("id");  

// 쿠키 
// 특정 쿠키를 얻지 못하고 모든 쿠키를 얻어오기 
// 즉, 쿠키를 특정해서 가져올 수 없음
/*
Cookie[] arr = request.getCookies();
if(arr != null){
	// 쿠기가 있을 때 (보관시간 : 3초)
	for(int i = 0; i < arr.length; i++){
		//String cookieName = arr[i].getName(); // 쿠키명
		//String cookieValue = arr[i].getValue(); // 값
		//System.out.println("쿠키명 = " + cookieName + "\t 값=" + cookieValue);
		
		if(arr[i].getName().equals("memName")) name = arr[i].getValue(); // 이름 넣기 
		else if(arr[i].getName().equals("memId")) id = arr[i].getValue(); // 아이디 넣기 
	}// for 
}
*/

// 세션
name = (String)session.getAttribute("memName");
id = (String)session.getAttribute("memId");
			
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인성공</title>
</head>
<body>
	<img src = "../image/pickleRick.jpg" width=250 height=200 onclick="location.href='../main/index.jsp'" style="cursor:pointer;"><br>
	<%=name%> 님 환영합니다. <br><br>
	<input type = "button" id="logoutBtn" value="로그아웃" onclick="location.href='logout.jsp'">
	<input type = "submit" id="modifyBtn" value="회원정보수정" onclick="location.href='modifyForm.jsp'">
</body>
</html>