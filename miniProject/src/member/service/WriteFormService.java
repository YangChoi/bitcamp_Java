package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class WriteFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("display", "/member/writeForm.jsp");
		// writeForm은 db 연결 이런 거 필요 없기 때문에 writeForm으로 바로 연결 
		return "/member/writeForm.jsp";
	}

}
