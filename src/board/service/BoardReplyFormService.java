package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardReplyFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터 
		int pseq = Integer.parseInt(request.getParameter("pseq")); // 원글번호
		int pg = Integer.parseInt(request.getParameter("pg")); // 원글이 있는 페이지 번호 
		// 원글 - 1페이지의 첫번째 줄로 들어간다 
		// 답글 - 원글이 있는 페이지에 원글의 밑
		
		// 원글ref = seq
		// 답글ref = 원글ref
		
		// 원글 lev = 0 (내가 첫단계)
		// 답글lev = 원글lev + 1
		
		// 원글 step = 0 (내가 첫번째)
		// 답글step = 원글 step + 1
		
		
		// 응답
		request.setAttribute("pseq", pseq);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardReplyForm.jsp");
		
		
		return "/main/index.jsp";
	}

}
