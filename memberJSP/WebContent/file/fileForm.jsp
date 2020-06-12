<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일폼</title>
<style>

</style>
</head>
<body>
<!-- 파일 업로드는 무조건 post 방식 -->
<!-- MIME 타입 설정 -->
<form method="post" enctype="multipart/form-data" action="fileUpload.jsp">
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
		
		<tr>
			<td colspan="2">
			<input type="file" name="upload1" size="50">
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="file" name="upload2" size="50">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="파일업로드">
			</td>
		</tr>
	</table>
</form>
</body>
</html>