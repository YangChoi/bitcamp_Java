package com.param;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class ParamServlet extends HttpServlet {
// 웹에 접근하기 위해서는 public 으로 해주어야한다 아니면 500번 에러 난다. 	
// void main 필요 없이 바로 init()으로 들어간다 (Servlet의 기본구조) 
	public void init(){}
	
	// 클라이언트가 get 방식으로 요청하므로 doGet()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 요청
		// 데이터 얻어오기 
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>"); // 해당 문자열이 웹으로 가게 된다
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("<body>");

		out.println(name + "님의 나이는	" +age+"살 이므로");
		if(age >= 19) out.println("성인입니다.");
		else out.println("청소년입니다");
		
		out.println("<br>");
		out.println("<br>");

		out.println("<input type=button value=뒤로 onclick=javascript:location.href='http://localhost:8080/parameter.html'>");
		out.println("<input type=button value=뒤로 onclick=javascript:history.go(-1)>");
		
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}

	public void destroy(){
	
	}
}
