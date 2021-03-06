package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> map = new HashMap<String, Object>();

	public void init(ServletConfig config) {
		String propertyConfig = config.getInitParameter("propertyConfig");
		System.out.println("propertyConfig = " + propertyConfig + "\n");

		FileInputStream fin = null;
		Properties properties = new Properties();

		try {
			fin = new FileInputStream(propertyConfig);
			properties.load(fin);
			System.out.println("properties = " + properties);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println();

		Iterator it = properties.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println("key = " + key);

			String className = properties.getProperty(key);
			System.out.println("className = " + className);

			try {

				Class<?> classType = Class.forName(className);
				Object ob = classType.newInstance();

				System.out.println("ob = " + ob);

				map.put(key, ob);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}

			System.out.println();
		} // while

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get이던 post 던 execute로 가도록 한다.
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);

	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("----------------------------------");

		if (request.getMethod().equals("POST")) {
			// get인지 post인지 알아낸다
			request.setCharacterEncoding("UTF-8");

		}

		// 한글처리
		if (request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}

		// http://localhost:8080/miniproject/main/index.do 요청
		String category = request.getServletPath();
		System.out.println("category = " + category);

		CommandProcess commandProcess = (CommandProcess) map.get(category);
		System.out.println("commandProcess = " + commandProcess);

		String view = null;
		try {
			// service에 request, response를 보내고 그걸 다시 view로서 받는다. 
			// view는 그걸 가지고 아래의 forward로 만든다. (Servlet, Jsp) 
			view = commandProcess.requestPro(request, response); // 요청
		} catch (Throwable e) {
			e.printStackTrace();
		}

		// forward (jsp파일과 공유하겠다)
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);// 상대번지
		dispatcher.forward(request, response);// 제어권 넘기기
	}

}
