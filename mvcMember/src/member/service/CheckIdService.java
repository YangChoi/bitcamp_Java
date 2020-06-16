package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("id");

		MemberDAO memberDAO = new MemberDAO();
		boolean exist = memberDAO.isExistId(id);

		// 아이디가 있으면
		if (exist == true) {
			return "/member/checkIdOk.jsp";
		} else {

			// 아이디가 없으면
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);

			return "/member/checkIdFail.jsp";
		}

	}

}
