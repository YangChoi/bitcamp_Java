<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/template.css">

<h3><img src="../image/rick.png" width="50" height="50" 
onclick="location.href='/miniProject/main/index.do'" style="cursor: pointer;"> MVC기반의 미니 프로젝트</h3>

<c:if test="${sessionScope.memId == null }">    
	
</c:if>

<c:if test="${memId != null }">
	<a href="../board/boardWriteForm.do">글쓰기</a> &emsp;
</c:if>

<a href="../board/boardList.do?pg=1">목록</a> &emsp;
