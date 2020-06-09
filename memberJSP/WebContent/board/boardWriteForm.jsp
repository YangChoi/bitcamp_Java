<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<form name="boardWriteForm" method="post" action="boardWrite.jsp">
	<h3> 글쓰기</h3>
	<table border="3px">
		<tr>
			<td>제목</td>
			<td><input type="text" name ="subject" id="subject"></td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td>
			<textarea name="content" id="content" cols="50" rows="10" style="resize:none;"></textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">		
			<input type="button" value="글쓰기" onclick="checkBoardWriteForm()"> 
			<input type="reset" value="다시작성 ">
			
			</td>
				
		</tr>
			
	</table>
</form>
</body>
<script type="text/javascript">
function checkBoardWriteForm(){

	if(document.getElementById("subject").value ==""){
		alert("제목을 입력하세요. ");

	}else if(document.getElementById("content").value ==""){
		alert("내용을 입력하세요.");
	
	}else {
		document.boardWriteForm.submit();
	}
	
}
</script>

</html>