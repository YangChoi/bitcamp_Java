package com.hello;
// 톰캣 서버 안에 저장하도록 한다. 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class HelloServlet extends HttpServlet{
	public void init(){
	// 톰캣으로 인해 콜백으로 init이 움직여짐
		System.out.println("init()...");

	}
	/*
	public static void main(String[] args) {
		new HelloServelt 
	}
	void main 안씀
	new 안함 : 전부 톰캣이란 서버에 의해서 움직여지기 때문 
	*/

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("doGet()...");

		// 응답페이지 만들기 
		resp.setContentType("text/html;charset=UTF-8"); // java 내에 html 코드 넣기 
		PrintWriter out = resp.getWriter(); // 웹으로 가게 한다 
		out.println("<html>"); // 해당 문자열이 웹으로 가게 된다
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("<body>");
		out.println("Hello Servlet!<br>");
		out.println("안녕하세요 서블릿<br>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}
	public void destroy(){
		System.out.println("destroy()....");
	}
}
