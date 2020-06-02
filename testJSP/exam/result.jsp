<%@ page contentType="text/html;charset=UTF-8" %>
<%
int x = Integer.parseInt(request.getParameter("x"));
int y = Integer.parseInt(request.getParameter("y"));

%>
<html>
<head>
	<title>Result</title>
</head>
<!-- X값과 Y값은 <%!로 받으면 안된다. <%!는 SERVLET으로 치면 INIT() 이다
즉, 단 한 번만 수행된다는 것이다. 
X와 Y는 REQUEST로 받아야하는데 REQUEST는 SERVLET으로 치면 SERVICE()에서 수행한다..
-->
<body>

	<%=x%> + <%=y%> = <%=x+y%><br>
	<%=x%> - <%=y%> = <%=x-y%><br>
	<%=x%> * <%=y%> = <%=x*y%><br>
	<%=x%> / <%=y%> = <%=(double)x/y%><br>
</body>
</html>