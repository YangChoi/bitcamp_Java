package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;


@WebServlet("/GuestbookServlet")
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		
		// 시스템에서 가져오는 seq와 date 는 따로 dao에서 가져온다. 
		int seq = guestbookDAO.getSeq();
	
		// 데이터 얻어오기 
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		GuestbookDTO guestbookDTO = new GuestbookDTO();
		guestbookDTO.setSeq(seq);
		guestbookDTO.setName(name);
		guestbookDTO.setEmail(email);
		guestbookDTO.setHomepage(homepage);
		guestbookDTO.setSubject(subject);
		guestbookDTO.setContent(content);
		
		
		// db 보관
		
		int su = guestbookDAO.writeGuestbook(guestbookDTO);
		System.out.println(su + "행 저장 ");
		
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>글 목록</title>");
		out.println("<body>");
		if(su == 1) {
			out.print("글 생성 성공");
			out.print("<input type='button' value='글목록' onclick=location.href='/guestbookServlet/GuestbookListServlet'>");
		}else {
			out.print("글 생성 실패 ");
		}
		out.println("<body>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
