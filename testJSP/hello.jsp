<%@ page contentType="text/html;charset=UTF-8" %>
<%!
// 전역변수 - 딱 한 번 만 수행
String name = "양아무개";
int age = 25;
%>

<%
// 지역변수 - 요청시 마다 수행
age++;
%>
<html>
<head>
	<title>JSP</title>
</head>
<body>
<!--Hello JSP!<br> -->
<%--졸리네요ㅠㅠ 
잠도 잘 잤는데 왜이리 피곤할까요 <br> --%>

나의 이름은 <%= name%> 입니다 <br>
<!-- 나의 나이는 <%= age%> 입니다 <br> -->
<%-- <% out.println("내 나이는 " + age + "살 입니다"); %> --%>
</body>
</html>
