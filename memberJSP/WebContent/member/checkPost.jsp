<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호</title>
<style type="text/css">
	td{
		font-size : 13px;
		background: #c2c2d6
	}
	th {
	background: #c2c2d6;
	}
</style>
</head>
<body>
<form>
	<table border="1" width="100%" cellspacing="0" cellpadding="3">
		<tr>
			<th align="center">시도</th>
			<td>
				<select name="sido">
					<option value="">시도선택</option>
					<option value="서울">서울</option>
					<option value="인천">인천</option>
					<option value="대구">대구</option>
					<option value="울산">울산</option>
					<option value="세종">세종</option>
					<option value="광주">광주</option>
					<option value="경기">경기</option>
					<option value="강원">강원</option>
					<option value="전남">전남</option>
					<option value="전북">전북</option>
					<option value="경님">경님</option>
					<option value="경북">경북</option>
					<option value="충남">충남</option>
					<option value="충북">충북</option>
					<option value="부산">부산</option>
					<option value="제주">제주</option>
				</select>
			</td>
			<th align="center"> 시 , 군, 구 </th>
			<td><input type="text" name="sigungu"></td>
	
		</tr>
		<tr>
			<th align="center"> 도로명</th>
			<td colspan="3"><input type="text" name="roadname" size="35">
			<input type="submit" value="검색" >
			</td>
		
		</tr>
		<tr>
			<th align="center">우편번호</th>
			<td colspan="3" align="center">주소</td>
		</tr>
	</table>
</form>
</body>
</html>