<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호확인</title>
<link rel="stylesheet" href="../css/member.css">
</head>
<body>
	<form method="post" action="">

		<table>
			<tr>
				<th align="center">시도</th>
				<td><select name="sido">
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
				</select></td>
				<th align="center">시 , 군, 구</th>
				<td><input type="text" name="sigungu"></td>

			</tr>
			<tr>
				<th align="center">도로명</th>
				<td colspan="3"><input type="text" name="roadname" size="35">
					<input type="submit" id="button1" value="검색"></td>

			</tr>
			<tr>
				<th align="center">우편번호</th>
				<th colspan="3" align="center">주소</th>
			</tr>

			<!-- 검색된 데이터를 뿌려준다 -->
			<c:if test="${requestScope.list != null }">
				<c:forEach var="zipcodeDTO" items="${list}">
					<c:set var="address">
					${zipcodeDTO.sido 
					} ${zipcodeDTO.sigungu
					} ${zipcodeDTO.yubmyundong
					} ${zipcodeDTO.roadname
					} ${zipcodeDTO.buildingname
					}
				</c:set>
					<tr>
						<td>${zipcodeDTO.zipcode}</td>
						<td><a id="addressA" href="#"
							onclick="checkPostClose('${zipcodeDTO.zipcode}', '${address}')">${address}</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>