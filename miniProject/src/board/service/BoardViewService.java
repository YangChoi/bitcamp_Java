package board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {


		// boardList로부터 데이터 가져오기, SEQ, PG
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		//DB
		//저 둘의 값으로 글을 가져와야한다. 
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		// 조회수 
		Cookie[] arr = request.getCookies(); //모든 쿠키 얻어오기 
		if(arr != null) {
			// 아무것도 없다면 처리할 필요가 없다
			for(int i = 0; i < arr.length; i++) {
				// arr 돌면서 쿠키 찾기 
				if(arr[i].getName().equals("memHit")) {
					// 쿠키 찾았으면 조회수 증가시킨다 
					boardDAO.hitUpdate(seq); // 조회수 증가 
					// 조회수 증가 시켰다면 쿠키를 죽인다 
					arr[i].setMaxAge(0);// 쿠키 삭제 
					response.addCookie(arr[i]); // 클라이언트에게 이 사실을 알린다 
				}// if
			}// for
		}
		
	
		BoardDTO boardDTO = boardDAO.getBoard(seq);
		
		// 응답
		request.setAttribute("pg", pg);
		request.setAttribute("boardDTO", boardDTO);
		request.setAttribute("display", "/board/boardView.jsp");
		return "/main/index.jsp";
	}

}
