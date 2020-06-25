<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<link rel="stylesheet" href="../css/writeFormCss.css">
</head>
<body>
<form name="modifyForm" method="post" action="/miniProject/member/modify.do">
		<table>
			<tr width="200">
				<td>이름</td>
				<td><input type="text" name="name" id="name"
					size=10 value="${memberDTO.name}"></td>
				
			</tr>

			<tr width="200">
				<td>아이디</td>
				<td><input type="text" name="id" placeholder="아이디입력" size=15 value="${memberDTO.id}" readonly>
					<input type="button" id="button0" value="중복체크" onclick="checkId()" disabled></td>
					<input type="hidden" name="idDuplicationCheck" value="">
			</tr>
			<tr width="200">
				<td>비밀번호</td>
				<td><input type="password" name="pwd" ></td>
			</tr>
			<tr width="200">
				<td>비밀번호 재확인</td>
				<td><input type="password" name="repwd"></td>
			</tr>
			<tr width="200">
				<td>성별</td>
				<td>
				<input type="radio" name="gender" value="0">남자
				 <input type="radio" name="gender" value="1">여자</td>
			</tr>
			<tr width="200">
				<td>이메일</td>
				<td><input type="text" name="email1" value="${memberDTO.email1}"> @ <input
					type="text" name="email2" id="email2" size="12" list="defaultEmails"
					placeholder="직접입력"> <datalist id="defaultEmails">
						<option value="gmail">
						<option value="naver">
					</datalist></td>
			
			</tr>
			<tr>
				<td>핸드폰</td>
				<td><select name="tel1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="019">019</option>
				</select> - <input type="text" name="tel2" value="${memberDTO.tel2}" size=5> - <input
					type="text" name="tel3" value="${memberDTO.tel3}" size=5></td>
			</tr>
			<tr>
				<td>주소</td>

				<td><input type="text" name="zipcode" id="zipcode" value="${memberDTO.zipcode}" size=7 readonly>
					<input type="button" id="button3" value="우편주소검색" onclick="checkPost()"><br> 
					<input type="text" name="addr1" id="addr1" size=50 value="${memberDTO.addr1}" readonly><br> 
					<input type="text" name="addr2" id="addr2" size=50 value="${memberDTO.addr2}" ></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<input type="button" id = "button1" value="회원정보수정" onclick="checkModifyForm()">&emsp; 
					<input type="reset" id = "button2" value="다시작성"></td>

			</tr>
		</table>

	</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
<script type="text/javascript">
window.onload=function(){
	document.modifyForm.gender["${memberDTO.gender}"].checked=true;
	document.getElementById("email2").value="${memberDTO.email2}";
	document.getElementById("tel1").value="${memberDTO.tel1}";
}
</script>
</html>