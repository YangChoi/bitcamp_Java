package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();

		List<GuestbookDTO> list = guestbookDAO.getGuestbook();

		// 데이터 얻어오기

		// 응답
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>글 목록</title>");

		out.println("<body>");
		for (GuestbookDTO dto : list) {
			  out.println("<table border=1>");
		      out.println("<tr>");
		      out.println("<td width='100'>");
		      out.println("작성자");
		      out.println("</td>");
		      out.println("<td width='150'>");
		      out.println(dto.getName());
		      out.println("</td>");
		      out.println("<td width='100'>");
		      out.println("작성일");
		      out.println("</td>");
		      out.println("<td width='150'>");
		      out.println(dto.getLogtime().substring(0, 10).replaceAll("-", "."));
		      out.println("</td>");
		      out.println("</tr>");
		      out.println("<tr>");
		      out.println("<td>");
		      out.println("이메일");
		      out.println("</td>");
		      out.println("<td colspan='3'>");
		      out.println(dto.getEmail());
		      out.println("</td>");
		      out.println("</tr>");
		      out.println("<tr>");
		      out.println("<td>");
		      out.println("홈페이지");
		      out.println("</td>");
		      out.println("<td colspan='3'>");
		      out.println(dto.getHomepage());
		      out.println("</td>");
		      out.println("</tr>");
		      out.println("<tr>");
		      out.println("<td>");
		      out.println("제목");
		      out.println("</td>");
		      out.println("<td colspan='3'>");
		      out.println(dto.getSubject());
		      out.println("</td>");
		      out.println("</tr>");
		      out.println("<tr>");
		      out.println("<td>");
		      out.println("내용");
		      out.println("</td>");
		      out.println("<td colspan='4' height='150'>");
		      out.println(dto.getContent().replaceAll("\r\n", "<br>"));
		      out.println("</td>");
		      out.println("</tr>");
		      out.println("</table>");

		}

		out.println("</body>");
		out.println("</html>");

	}

}
