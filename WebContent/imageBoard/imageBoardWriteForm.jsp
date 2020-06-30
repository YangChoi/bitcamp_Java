<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 폼</title>
</head>
<body>
<!-- 파일을 업로드 하려면 enctype="multipart/form-data"가 꼭 있어야하는데 이는 post 방식으로만 처리한다  -->
<form name="imageBoardWriteForm" method="post" enctype="multipart/form-data" action="/miniProject/imageBoard/imageBoardWrite.do">
	<table border="1" cellspacing="0" cellpadding="3">
		<tr>
			<td width="100" align="center">상품코드</td>
			<td>
				<input type="text" size="30" name="imageId" id="imageId" value="img_">
			</td>
		</tr>
		<tr>
			<td width="100" align="center">상품명</td>
			<td>
				<input type="text" size="30" name="imageName" id="imageName" placeholder="상품명 입력">
			</td>
		</tr>
		<tr>
			<td width="100" align="center">단가</td>
			<td>
				<input type="text" size="30" name="imagePrice" id="imagePrice" placeholder="단가 입력">
			</td>
		</tr>
		<tr>
			<td width="100" align="center">갯수</td>
			<td>
				<input type="text" size="30" name="imageQty" id="imageQty" placeholder="갯수 입력">
			</td>
		</tr>
		<tr>
			<td width="100" align="center">내용</td>
			<td>
				<textarea name="imageContent" id="imageContent" rows="15" cols="50" style="resize:none;" placeholder="내용입력"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<input type="file" name="image1" size="50">
				
			</td>
		</tr>
		
		
		<tr>
			<td colspan="2" align="center">		
			<input type="button" value="이미지 등록" onclick="checkImageBoardWriteForm()"> 
			<input type="reset" value="다시작성 ">
			
			</td>
				
		</tr>
	
	</table>


</form>
</body>
<script type="text/javascript">
function checkImageBoardWriteForm(){

	if(document.getElementById("imageName").value ==""){
		alert("제품명을 입력하세요. ");

	}else if(document.getElementById("imageContent").value ==""){
		alert("내용을 입력하세요.");
	
	}else {
		document.imageBoardWriteForm.submit();
	}
	
}
</script>

</html>