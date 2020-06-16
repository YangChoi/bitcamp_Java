package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LogoutService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		// 1. ojdbc8.java
		// 2. Connection pool
		HttpSession session = request.getSession(); // 세션 생성 
		session.removeAttribute("memId");
		session.removeAttribute("memName");
		session.removeAttribute("memEmail");
		
		System.out.println(session.getAttribute("memId"));
		// 응답
		return "/member/loginForm.jsp";
	}

}
