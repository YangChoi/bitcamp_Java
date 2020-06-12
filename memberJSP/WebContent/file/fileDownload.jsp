<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
    
<%
// 데이터 
String fileName = request.getParameter("fileName");
// storage 가상 폴더가 아닌 실제폴더에 있는 파일에서 다운을 받아야한다. 

String realFolder = request.getServletContext().getRealPath("/storage"); // 실제폴더 

// 다운로드 받을 파일 생성
File file = new File(realFolder, fileName);
fileName = URLEncoder.encode(fileName, "UTF-8").replace("+", " ");

response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
response.setHeader("Content-Length", file.length()+"");

/*
getOutputStream() has already been called for this response 
JSP에서는 SERVLET으로 변환될 때 내부적으로 out객체가 자동으로 생성하기 때문에 
따라 out객체를 만들면 충돌이 일어나서 위와 같은 에러 메시지가 뜬다. 
그래서 out을 먼저 초기화하고 생성해준다. 

*/
out.clear(); // 기존에 가진 것 clear
out = pageContext.pushBody(); // 새로 생성
		
// 다운로드 
BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
													// 사용자가 파일을 넣기 원하는 곳으로 응답해준다. (response...)
int size = (int)file.length(); // 파일 크기 얻음
byte[] b = new byte[size]; // 파일 크기에 따른 byte 배열 생성 
bis.read(b, 0, size); // 배열 b에 0번째 방부터 size 만큼(전부) 읽어라 
bos.write(b); 

bis.close();
bos.close();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다운로드</title>
</head>
<body>

</body>
</html>