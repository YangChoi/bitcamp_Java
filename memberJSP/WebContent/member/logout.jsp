<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 쿠키를 다 가져온다 
/*
Cookie[] arr = request.getCookies();
if(arr != null){
	for(int i = 0; i < arr.length; i++){
		if(arr[i].getName().equals("memName")){
			arr[i].setMaxAge(0); // 쿠키 삭제 
			response.addCookie(arr[i]); // 클라이언트에게 쿠키 삭제 사실 알리기 
			
		}else if(arr[i].getName().equals("memId")){
			arr[i].setMaxAge(0); // 쿠키 삭제 
			response.addCookie(arr[i]); // 클라이언트에게 쿠키 삭제 사실 알리기 
		}
	}// for
}// if
*/
// 세션 
session.removeAttribute("memName");
session.removeAttribute("memId");
// session.invalidate(); // 무효화(한번에 없애줌)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>

</body>
<script type="text/javascript">
window.onload = function(){
	alert("로그아웃");
	location.href= "../main/index.jsp";
}
</script>
</html>