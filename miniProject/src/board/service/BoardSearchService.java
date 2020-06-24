package board.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardSearchService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		String searchOption = request.getParameter("searchOption");
		String keyword = request.getParameter("keyword");

		// boardList는 pg만 있으면 되지만 BoardSearch는 검색할 단어들(searchOption, keyword)를 가지고 가야한다.

		// DB - 1페이지당 글 5개 
		int endNum = pg * 5; // pg * 페이지 내 글 수
		int startNum = endNum - 4; // endNum - (페이지 내 글 수 -1)
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		List<BoardDTO> list = boardDAO.getBoardSearchList(map);
		
		// 페이징 처리 
		int totalA = boardDAO.getTotalA(); //총글수
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		
				
		// 원하는 단어만 검색하기 때문에 searchOption 과 keyword도 같이 가지고 가야한다. 
		request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		request.setAttribute("pg", pg);
		request.setAttribute("searchOption", searchOption);
		request.setAttribute("keyword", keyword);
		request.setAttribute("list", list);
		//request.setAttribute("boardPaging", boardPaging);
		
		request.setAttribute("display", "/board/boardList.jsp");
		return "/main/index.jsp";
	}

}
