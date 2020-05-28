package member.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 데이터 얻기 
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 디비에서 꺼내와서 검사해야하는데?
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.loginMember(id, pwd);
	}

}
