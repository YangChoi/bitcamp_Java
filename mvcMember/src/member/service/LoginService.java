package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터 얻어오기 
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// db
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberDAO.login(id, pwd);
		// 1. ojdbc8.java
		// 2. Connection pool
		
		// 응답 
		if(memberDTO == null) {
			return "/member/loginFail.jsp";
		}else {
			HttpSession session = request.getSession(); // 세션 생성 
			
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2()); // 세션 저장 
			
			return "/member/loginOk.jsp";
		}

	}

}
