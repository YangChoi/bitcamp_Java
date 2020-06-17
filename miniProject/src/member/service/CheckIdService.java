package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		String id = request.getParameter("id");

		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		boolean exist = memberDAO.isExistId(id);

		request.setAttribute("id", id); // 어차피 여기 request, response는 Servlet의 것이기 때문에 
										// 굳이 주소로 보내지 않고, request로 보낸다 
										// 그리고 servlet의 request는 forward 되어 있기 때문에 jsp로까지 연결이 된다 
		// 응답 
		// 아이디가 있으면
		if (exist) { // 사용불가능(현재 exist가 true로 넘어옴)
			return "/member/checkIdFail.jsp";
		} else {
			// 아이디가 없으면
			return "/member/checkIdOk.jsp";
		}

	}

}
