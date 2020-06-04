<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="member.dao.MemberDAO" 
    import="member.bean.ZipcodeDTO" 
    import="java.util.List" %>
<%
// 한글처리 
request.setCharacterEncoding("UTF-8");

// 데이터 얻어오기 
String sido = request.getParameter("sido");
String sigungu = request.getParameter("sigungu");
String roadname = request.getParameter("roadname");

System.out.println(sido + "," + sigungu + "," + roadname);
// checkPost.jsp 창을 띄우면 띄우자마자 자동실행이므로 
// 아무값도 없는 상태로 null 이 뜬다. 


// db에서 원하는 데이터 꺼내기 
List<ZipcodeDTO> list = null;
if(sido != null && roadname != null ){
	MemberDAO memberDAO = MemberDAO.getInstance();
	list = memberDAO.getZipcodeList(sido, sigungu, roadname);
}
// 응답 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호</title>
<link href="http://fonts.googleapis.com/earlyaccess/jejugothic.css" rel="stylesheet">
<link rel="stylesheet" href="../css/member.css">

</head>
<body onresize="parent.resizeTo(646,830)" onload="parent.resizeTo(646,830)">
<form method="post" action="checkPost.jsp">
<!-- 데이터를 얻어서 다시 내 자신에게 뿌려줘야하기 때문에 action의 종착지는 나 자신 (checkPost.jsp) -->
	<table >
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
			<input type="submit" id="button1" value="검색">
			</td>
		
		</tr>
		<tr>
			<th align="center">우편번호</th>
			<th colspan="3" align="center">주소</th>
		</tr>
		
		<%if(list != null) {%>
			<%for(ZipcodeDTO dto : list) { 
				String address = dto.getSido() +" "+
				dto.getSigungu() + " "
				+ dto.getYubmyundong() + " " 
				+ dto.getRi() + " " 
				+ dto.getRoadname() + " " 
				+ dto.getBuildingname();
				
			%>
			<tr>
				<td align="center"><%=dto.getZipcode() %></td>
				<td colspan="3">
				<!-- 검색한 주소는 다시 입력창에 옮겨준다 -->
				<a id="addressA" href="#" onclick="checkPostClose('<%=dto.getZipcode() %>', '<%= address%>')"><%=address %></a>
				</td>
			</tr>
			<% } // for %>
		<%} // if %>
	</table>
</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>