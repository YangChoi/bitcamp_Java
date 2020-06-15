<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jstl.PersonDTO"%>
<%
// 자바 파일 대신으로 본다 

ArrayList<String> list = new ArrayList<String>();

list.add("호랑이");
list.add("사자");
list.add("기린");
list.add("코끼리");
list.add("타조");

list.add("코알라");
list.add("여우");


PersonDTO aa = new PersonDTO("양아무개", 25);
PersonDTO bb = new PersonDTO("김아무개", 26);
PersonDTO cc = new PersonDTO("박아무개", 30);
ArrayList<PersonDTO> list2 = new ArrayList<PersonDTO>();
list2.add(aa);
list2.add(bb);
list2.add(cc);

// 페이지 이동, jstlTest.jsp로.. (주소를 통해서는 불가능..)
request.setAttribute("list", list); 
//response.sendRedirect("jstlTest.jsp");
request.setAttribute("list2", list2);


RequestDispatcher dispatcher = request.getRequestDispatcher("jstlTest.jsp");
dispatcher.forward(request, response);  // 제어권 넘기기 
%>
<%-- <jsp:forward page="jstlTest.jsp" /> --%>