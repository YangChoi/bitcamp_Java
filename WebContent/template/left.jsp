<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/template.css">

<c:if test="${memId == null}">
	<jsp:include page="../member/loginForm.jsp"/>
</c:if>

<c:if test="${memId != null }">
	<jsp:include page="../member/loginOk.jsp"/>
</c:if>

<!--로그인 실패  -->
<c:if test="${memId == null && loginFail == 'fail' }">
	<jsp:include page="../member/loginFail.jsp"/>
</c:if>

