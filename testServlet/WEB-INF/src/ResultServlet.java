package com.calc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class ResultServlet extends HttpServlet{
	public void init(){}
	
	// 클라이언트가 get 방식으로 요청하므로 doGet()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 요청
		// 데이터 얻어오기 
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));

		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>"); // 해당 문자열이 웹으로 가게 된다
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("<body>");

		out.println("x + y"+ " = "+ (x+y)+"<br>");

		out.println("x - y"+ " = "+ (x-y)+"<br>");
	
		out.println("x * y"+ " = "+ (x*y)+"<br>");
		
		out.println("x / y"+ " = "+ (x/y)+"<br>");

		
		
		out.println("<br>");
		out.println("<br>");

		out.println("<input type=button value=뒤로 onclick=javascript:location.href='http://localhost:8080/testServlet/input.html'>");
		out.println("<input type=button value=뒤로 onclick=javascript:history.go(-1)>");
		
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}

	public void destroy(){
	
	}
}
