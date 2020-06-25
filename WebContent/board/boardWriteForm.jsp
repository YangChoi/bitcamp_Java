<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form name="boardWriteForm" method="post" action="/miniProject/board/boardWrite.do">
	<table border="1" cellspacing="0" cellpadding="3">
		<tr>
			 <td width="100" align="center"> 제목 </td>
			 <td><input type="text" size="50" name="subject" id="subject" placeholder="제목 입력"></td>
		</tr>
		
		<tr>
			 <td width="100" align="center"> 내용 </td>
			<td><textarea name="content" id="content" rows="15" cols="50"  style="resize:none;" placeholder="내용을 입력"></textarea></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">		
			<input type="button" value="글쓰기" onclick="checkBoardWriteForm()"> 
			<input type="reset" value="다시작성 ">
			
			</td>
				
		</tr>
			
	</table>
</form>
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
