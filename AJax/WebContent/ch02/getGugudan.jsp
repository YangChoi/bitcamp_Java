<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int dan = Integer.parseInt(request.getParameter("dan"));

	for(int i = 1; i < 10; i++){
		out.println(dan +"*" + i +"="+ dan*i+"<br>");
	}
%>