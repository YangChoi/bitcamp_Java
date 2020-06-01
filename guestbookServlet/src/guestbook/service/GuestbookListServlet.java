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
	private List<GuestbookDTO> list;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 글 목록은 가져올 데이터가 없다.. 그러므로 바로 db 실행하면 된다 .

		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));// pg를 받는다.
		// 주소로 넘어오는 데이터는 String 타입이므로 int 형으로 변환해준다.

	

		// 페이징 처리
		// 아래의 list는 모든 데이터를 다 가져오는 형태이다.
		// 그러나 ㅇ제 페이징처리를 해서 1페이지당 2개씩만 꺼내오도록 한다.
		int endNum = pg * 2;
		int startNum = endNum - 1;
		// 위에서 가져온 pg 값에 의해 적용된다

		// List<GuestbookDTO> list = guestbookDAO.getGuestbookList();
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		list = guestbookDAO.getGuestbookList(startNum, endNum);

		// 총 글 수
		int totalA = guestbookDAO.getTotalA();
		// 총페이지 수
		int totalP = (totalA + 1) / 2;
		// 한 페이지당 글 2개

		// 응답
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>글 목록</title>");
		out.println("<style>");
		out.println("#currentPaging {color : red; text-decoration:underline;}");
		out.println("#paging {color : black; text-decoration: none;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		if (list != null) {
			// 글 수를 여기다 뿌려준다
			for (int i = 1; i <= totalP; i++) {
				if (i == pg) {
					// 현재 페이지라면 빨강색
					 out.println("[<a id=currentPage href='/guestbookServlet/GuestbookListServlet?pg=" + i + "'>" + i + "</a>]");

				} else {
					out.println("[<a id=paging href='/guestbookServlet/GuestbookListServlet?pg=" + i + "'>" + i + "</a>]");

				}

			}
	         out.println("<br>");
	         out.println("<br>");

			for (GuestbookDTO dto : list) {

				out.println("<table border='3' width='450' style='table-layout:fixed'>");

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
				out.println("<td valign=top colspan='4' height='150'>");
				out.println("<pre>" + dto.getContent() + "</pre>");
				// pre 태그 : 입력한 형태 그대로 표시된다.
				//  out.println("<td colspan='4' valign = 'top' height='150' style='word-break:break-all'>" + dto.getContent().replaceAll("\r\n", "<br>") + "</td>"); 
				out.println("</td>");
				out.println("</tr>");
				out.println("</table>");
			} // for
		} // if

		out.println("</body>");
		out.println("</html>");

	}

}
