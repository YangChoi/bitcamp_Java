package com.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class PersonServlet extends HttpServlet{
	public void init(){}
	
	// 클라이언트가 get 방식으로 요청하므로 doGet()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 요청
		// 데이터 얻어오기 
		String name = request.getParameter("name");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String hobby = request.getParameter("hobby");
		String color = request.getParameter("color");
		String subject = request.getParameter("subject");


		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>"); // 해당 문자열이 웹으로 가게 된다
		out.println("<head>");
		out.println("<title>Person Homework 그러나 집에서 하지 않는</title>");
		out.println("<body>");

		out.println("이름" + name +"<br>");
		out.println("성별" + gender +"<br>");
		out.println("취미" + hobby +"<br>");
		out.println("색깔" + color +"<br>");
		out.println("과목" + subject +"<br>");

	

		
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}

	public void destroy(){
	
	}
}
