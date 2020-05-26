package com.param;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class ParamServlet extends HttpServlet {
// ���� �����ϱ� ���ؼ��� public ���� ���־���Ѵ� �ƴϸ� 500�� ���� ����. 	
// void main �ʿ� ���� �ٷ� init()���� ���� (Servlet�� �⺻����) 
	public void init(){}
	
	// Ŭ���̾�Ʈ�� get ������� ��û�ϹǷ� doGet()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// ��û
		// ������ ������ 
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		// ����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>"); // �ش� ���ڿ��� ������ ���� �ȴ�
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("<body>");

		out.println(name + "���� ���̴�	" +age+"�� �̹Ƿ�");
		if(age >= 19) out.println("�����Դϴ�.");
		else out.println("û�ҳ��Դϴ�");
		
		out.println("<br>");
		out.println("<br>");

		out.println("<input type=button value=�ڷ� onclick=javascript:location.href='http://localhost:8080/parameter.html'>");
		out.println("<input type=button value=�ڷ� onclick=javascript:history.go(-1)>");
		
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}

	public void destroy(){
	
	}
}
