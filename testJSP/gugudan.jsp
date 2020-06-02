<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>JSP</title>
</head>
<body>
	<table>
	
	<% for(int i = 1; i <= 9; i++){ %>
	<tr>	
		<% for(int j = 2; j <= 9; j++){ %>
			<td><%= j %> * <%=i %> = <%= i*j %> </td>
			<% }// for j %>
	</tr>
	
	<% } // for i%> 
	
	</table>
</body>
</html>