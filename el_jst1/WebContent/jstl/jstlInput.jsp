<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="jstlResult.jsp">
<table border="1">
 <tr>
  <td width="70" align="center">이 름</td>
  <td>
   <input type="text" name="name">
  </td>
 </tr>

 <tr>
  <td width="70" align="center">나 이</td>
  <td>
   <input type="text" name="age">
  </td>
 </tr>

 <tr>
  <td width="70" align="center">색 깔</td>
  <td>
   <select name="color" style="width: 100px;">
    <option value="red">빨 강</option>
    <option value="green">초 록</option>
    <option value="blue">파 랑</option>
    <option value="magenta">보 라</option>
    <option value="cyan">하 늘</option>
   </select>
  </td>
 </tr>

 <tr>
  <td width="70" align="center">취 미</td>
  <td>
   <input type="checkbox" name="hobby" value="독서">독서 &emsp;
   <input type="checkbox" name="hobby" value="음악">음악 &emsp; 
   <input type="checkbox" name="hobby" value="게임">게임 &emsp; 
   <input type="checkbox" name="hobby" value="운동">운동 &emsp; 
   <input type="checkbox" name="hobby" value="영화">영화 &emsp;
  </td>
 </tr>
 
 <tr>
  <td colspan="2" align="center">
   <input type="submit" value="SEND">
   <input type="reset" value="CANCEL">
  </td>
 </tr>

</table>
</form>
</body>
</html>










