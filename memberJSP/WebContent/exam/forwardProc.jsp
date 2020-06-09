<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setAttribute("apple", "사과");

// 페이지 이동
RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp"); // 상대번지 
dispatcher.forward(request, response); // 제어권 넘기기 
%>
<%--아래의 jsp:forward나 위의 dispatcher나 똑같은 기능이나 위의 코드를 더 많이 쓴다.  --%>
<%-- <jsp:forward page="forwardResult.jsp" /> --%>


<%-- 절대번지 : http://localhost:8080/memberJSP/exam/forwardResult.jsp--%>