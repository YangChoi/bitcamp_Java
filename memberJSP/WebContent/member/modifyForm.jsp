<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.dao.MemberDAO"
    import="member.bean.MemberDTO"
%>
    
<%
// 데이터 
//String id = request.getParameter("id");
// 데이터가 주소가 아닌 세션을 타고 옴
String id = (String)session.getAttribute("memId");
// db
MemberDAO memberDAO = MemberDAO.getInstance();
MemberDTO memberDTO = memberDAO.getMember(id);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<!-- <link href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" rel="stylesheet"> -->
<link rel="stylesheet" href="../css/writeFormCss.css">
</head>
<body onresize="parent.resizeTo(646,435)" onload="parent.resizeTo(646,435)">

	<form name="modifyForm" method="post" action="modify.jsp">
		<table>
			<tr width="70">
				<td>이름</td>
				<td><input type="text" name="name" id="name" placeholder="이름입력"
					size=10 value="<%=memberDTO.getName() %>"></td>
				
			</tr>

			<tr width="70">
				<td>아이디</td>
				<td><input type="text" name="id" placeholder="아이디입력" size=15 value="<%=memberDTO.getId() %>" readonly>
					<input type="button" id="button0" value="중복체크" onclick="checkId()" disabled></td>
					<input type="hidden" name="idDuplicationCheck" value="">
			</tr>
			<tr width="70">
				<td>비밀번호</td>
				<td><input type="password" name="pwd" ></td>
			</tr>
			<tr width="70">
				<td>비밀번호 재확인</td>
				<td><input type="password" name="repwd"></td>
			</tr>
			<tr width="70">
				<td>성별</td>
				<td>
				<input type="radio" name="gender" value="0">남자
				 <input type="radio" name="gender" value="1">여자</td>
			</tr>
			<tr width="70">
				<td>이메일</td>
				<td><input type="text" name="email1" value="<%=memberDTO.getEmail1()%>"> @ <input
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
				</select> - <input type="text" name="tel2" value="<%=memberDTO.getTel2()%>" size=5> - <input
					type="text" name="tel3" value="<%=memberDTO.getTel3()%>" size=5></td>
			</tr>
			<tr>
				<td>주소</td>

				<td><input type="text" name="zipcode" id="zipcode" value="<%=memberDTO.getZipcode()%>" size=7 >
					<input type="button" id="button3" value="우편주소검색" onclick="checkPost()"><br> 
					<input type="text" name="addr1" id="addr1" size=50 value="<%=memberDTO.getAddr1()%>" placeholder="주소입력"><br> 
					<input type="text" name="addr2" id="addr2" size=50 value="<%=memberDTO.getAddr2()%>" placeholder="상세주소입력"></td>
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
// 윈도우가 로드되면 수행할 function
window.onload=function(){
	document.modifyForm.gender['<%=memberDTO.getGender()%>'].checked = true;  
	// radiobutton은 배열값이다. 
	
	document.modifyForm.email2.value = '<%=memberDTO.getEmail2()%>';
	// document.getElementById('email1').value='';
	document.modifyForm.tel1.value = '<%=memberDTO.getTel1()%>';
}
</script>
</html>