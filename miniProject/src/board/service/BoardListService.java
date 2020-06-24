package board.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 페이지 얻어오기 
//		HttpSession session = request.getSession(); // 세션 생성
//		
//		String memId = (String)session.getAttribute("memId");
		
		// 데이터 
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		int endNum = pg*5; // pg * 페이지 내 글 수  
		int startNum = endNum-4; // endNum - (페이지 내 글 수 -1)
		
		List<BoardDTO> list = boardDAO.getBoardList(startNum, endNum);
		
		// 페이징 처리 
		BoardPaging boardPaging = new BoardPaging();
		int totalA = boardDAO.getTotalA(); // 총글수 
		boardPaging.setCurrentPage(pg); //pg가 현재 페이지 가지고 있음 
		boardPaging.setPageBlock(3); // 3개씩 끊는다. 
		boardPaging.setPageSize(5); // 한 페이짇 ㅏㅇ 글 5개 
		boardPaging.setTotalA(totalA); // 총 페이지 
		
		boardPaging.makePagingHTML();// 페이지 넘기는 링크를 띄워준다 
		
		// 조회수 증가 방지 (페이징 처리) - 쿠키생성 
		HttpSession session = request.getSession(); // 세션객체 생성 
		if(session.getAttribute("memId") != null) {
			//session이 없으면 쿠키고 뭐고 필요없는 상황(들어갈 필요가 없다)
			Cookie cookie = new Cookie("memHit", "ok");
			cookie.setMaxAge(30*60); //30분
			// 클라이언트에게 보내기 
			response.addCookie(cookie);// 쿠기 보내기 
		}
		
		
		
		// 응답
		request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		request.setAttribute("pg", pg);
		request.setAttribute("list", list);
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("display", "/board/boardList.jsp");
		
		return "/main/index.jsp";
	}

}
