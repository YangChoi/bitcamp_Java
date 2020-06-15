<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> 변수 설정 </h3>
<c:set var="name" value="양아무개" />
<c:set var="age" >25</c:set>


나의 이름은 <c:out value="${name}" /> 입니다 <br>
내 나이는 ${age} 살 입니다 <br>


<h3> 변수 삭제 </h3>
<c:remove var="name" />
나의 이름은 <c:out value="${name }" /> 입니다
내 나이는 ${age} 살 입니다<br>

<h3> for each </h3>

<c:forEach var="i" begin="1" end="10" step="1">${i }&nbsp;
	<c:set var="sum" value="${sum+i }" />
</c:forEach>

<br>
1~10 합 : ${sum}<br>
<c:forEach var= "i" begin="1" end="10" step="1">${11-i}&nbsp; </c:forEach>

<h3> 문자열 분리 </h3>
<c:forTokens var="car" items="소나타, 아우디, 링컨, 페라리, 벤츠" delims=",">
	${car }<br>
</c:forTokens>

<h3>** jstlExam.jsp에서 넘어온 데이터 출력 **</h3>
<%-- ${requestScope.list } --%>
${list}

<h3> jstlExam.jsp에서 넘어온 데이터 출력</h3>
<%--request.getAttribute*("list") --%>
${list}

<h3> 인덱스 2번째 데이터 출력</h3>
결과 = ${list[2]}
<br><br>
<c:forEach var="data" items="${requestScope.list}">
	${data }<br>
</c:forEach>

<h3> list 2의 모든 데이터 출력</h3>
<c:forEach var="personDTO" items="${requestScope.list2}" varStatus="i">
	index = ${i.index} &emsp; count=${i.count}&emsp;
	이름 = ${personDTO.getName()}&emsp; 나이=${personDTO.getAge()}<br>

</c:forEach>
<c:forEach var="personDTO" items="${list2 }">
		이름 = ${personDTO.name}&emsp; 나이=${personDTO.age}
	<!-- get를 생략해도 된다. 그렇게 되면 name이 getName()을 호출하게 되는 것이지 name 그자체는 아니다.  -->
</c:forEach>
</body>
</html>