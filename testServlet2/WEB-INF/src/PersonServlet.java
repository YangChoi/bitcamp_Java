package com.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class PersonServlet extends HttpServlet{
	public void init(){}
	
	// Ŭ���̾�Ʈ�� get ������� ��û�ϹǷ� doGet()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// ��û
		// ������ ������ 
		String name = request.getParameter("name");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String hobby = request.getParameter("hobby");
		String color = request.getParameter("color");
		String subject = request.getParameter("subject");


		// ����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>"); // �ش� ���ڿ��� ������ ���� �ȴ�
		out.println("<head>");
		out.println("<title>Person Homework �׷��� ������ ���� �ʴ�</title>");
		out.println("<body>");

		out.println("�̸�" + name +"<br>");
		out.println("����" + gender +"<br>");
		out.println("���" + hobby +"<br>");
		out.println("����" + color +"<br>");
		out.println("����" + subject +"<br>");

	

		
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}

	public void destroy(){
	
	}
}
