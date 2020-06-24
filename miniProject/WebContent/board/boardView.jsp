<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<table border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows" width="600" style="table-layout:fixed;">
		<tr>
			<td colspan="3"><h3>${boardDTO.subject }</h3></td>	
		</tr>
		<tr colspan="3">
			<td width="100">글번호 : ${boardDTO.seq }</td>
		<td width="200">작성자 : ${boardDTO.id }</td>
		<td width="100">조회수 : ${boardDTO.hit }</td>	
		</tr>
		<tr>
		<td colspan="3" valign=top height="200" 
		style="white-space: pre-wrap; word-break: break-all; overflow: auto;">${boardDTO.content }</td>	
		</tr>
	</table>
	<input type="button" id="button4" value="목록" onclick="location.href='boardList.do?pg=${pg}'">

	
	<c:if test="${boardDTO.id == memId }">
	<input type="button" id="button5" value="글수정" onclick="location.href='boardModifyForm.do?seq=${boardDTO.seq }&pg=${pg }'">
	<input type="button" id="button6" value="글삭제" onclick="$"> 
	</c:if>
