package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class ModifyFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터 
		HttpSession session = request.getSession(); // 세션 생성 
		String id = (String)session.getAttribute("memId");
		
		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO memberDTO = memberDAO.getMember(id);
		
		// 응답 
		request.setAttribute("memberDTO", memberDTO);
		// request에 dto실어서 보내준다. 
		
		request.setAttribute("display", "/member/modifyForm.jsp");
		return "/main/index.jsp";
	}

}
