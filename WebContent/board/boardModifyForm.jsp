<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
<link rel="stylesheet" href="../css/writeForm.css">
</head>
<body>
<form name="boardModifyForm" method="post" action="boardModify.do">
	<input type="hidden" name="seq" value="${boardDTO.seq}">
	<input type="hidden" name="pg" value="${pg }">

	<table border="1" cellspacing="0" cellpadding="3">
		<tr>
			<td width="100" align="center">제목</td>
			<td><input type="text" name ="subject" id="subject" value="${boardDTO.subject}"></td>
		</tr>
		
		<tr>
			<td width="100" align="center">내용</td>
			<td>
			  <textarea rows="15" cols="50" name="content" style="resize: none;">${boardDTO.content }</textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">		
			<input type="button" value="글수정" onclick="checkBoardModifyForm()"> 
			<input type="reset" value="다시작성 ">
			
			</td>
				
		</tr>
			
	</table>
</form>
</body>
<script type="text/javascript">
function checkBoardModifyForm(){

	if(document.getElementById("subject").value ==""){
		alert("제목을 입력하세요. ");

	}else if(document.getElementById("content").value ==""){
		alert("내용을 입력하세요.");
	
	}else {
		document.boardModifyForm.submit();
	}
	
}
</script>
</html>