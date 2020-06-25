package member.service;

import java.util.HashMap;
import java.util.Map;

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

		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO memberDTO = memberDAO.login(id, pwd);
		// 1. ojdbc8.java
		// 2. Connection pool

		// 응답
		String loginFail = null;
		if (memberDTO == null) {
			loginFail = "fail";

		} else {
			// 세션
			HttpSession session = request.getSession(); // 세션 생성
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", memberDTO.getEmail1() + "@" + memberDTO.getEmail2());
		}

		request.setAttribute("loginFail", loginFail);
		request.setAttribute("display", "/template/body.jsp");
		return "/main/index.jsp";

	}

}
