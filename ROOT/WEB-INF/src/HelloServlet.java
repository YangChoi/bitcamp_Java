package com.hello;
// ��Ĺ ���� �ȿ� �����ϵ��� �Ѵ�. 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class HelloServlet extends HttpServlet{
	public void init(){
	// ��Ĺ���� ���� �ݹ����� init�� ��������
		System.out.println("init()...");

	}
	/*
	public static void main(String[] args) {
		new HelloServelt 
	}
	void main �Ⱦ�
	new ���� : ���� ��Ĺ�̶� ������ ���ؼ� ���������� ���� 
	*/

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("doGet()...");

		// ���������� ����� 
		resp.setContentType("text/html;charset=UTF-8"); // java ���� html �ڵ� �ֱ� 
		PrintWriter out = resp.getWriter(); // ������ ���� �Ѵ� 
		out.println("<html>"); // �ش� ���ڿ��� ������ ���� �ȴ�
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("<body>");
		out.println("Hello Servlet!<br>");
		out.println("�ȳ��ϼ��� ����<br>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}
	public void destroy(){
		System.out.println("destroy()....");
	}
}
