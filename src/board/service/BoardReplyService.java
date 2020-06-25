package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardReplyService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 제목, 내용, pg, pseq 가진다 
		int pseq = Integer.parseInt(request.getParameter("pseq")); // 원글번호
		int pg = Integer.parseInt(request.getParameter("pg")); // 원글이 있는 페이지 번호 
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// 세션 (누가 쓴 글인지 알아야하기 때문)
		HttpSession session = request.getSession(); // 세션 생성
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");
		String email = (String) session.getAttribute("memEmail");
		
		// map에다 실어주기 
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id); // 변수명, 값
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		map.put("pseq", pseq+""); // 원글번호
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardReply(map);
		
		// 응답 
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardReply.jsp");
		return "/main/index.jsp";
	}

}
