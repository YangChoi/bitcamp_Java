<%@ page contentType="text/html;charset=UTF-8" %>
<%
int x = Integer.parseInt(request.getParameter("x"));
int y = Integer.parseInt(request.getParameter("y"));

%>
<html>
<head>
	<title>Result</title>
</head>
<!-- X���� Y���� <%!�� ������ �ȵȴ�. <%!�� SERVLET���� ġ�� INIT() �̴�
��, �� �� ���� ����ȴٴ� ���̴�. 
X�� Y�� REQUEST�� �޾ƾ��ϴµ� REQUEST�� SERVLET���� ġ�� SERVICE()���� �����Ѵ�..
-->
<body>

	<%=x%> + <%=y%> = <%=x+y%><br>
	<%=x%> - <%=y%> = <%=x-y%><br>
	<%=x%> * <%=y%> = <%=x*y%><br>
	<%=x%> / <%=y%> = <%=(double)x/y%><br>
</body>
</html>