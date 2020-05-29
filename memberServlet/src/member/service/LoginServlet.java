package member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 데이터 얻기 
		// 있는거 그냥 가져오면 된다..
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// write처럼 DTO로 묶을 필요가 없다 (적으니까, 한 4개부터 묶어주도록 한다)
		// db 불러오기 위해서 memberDAO 가져오기(싱글톤)
		MemberDAO memberDAO = MemberDAO.getInstance();
		String name = memberDAO.loginMember(id, pwd); // return 값 name 
		
		// 응답 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>로그인</title>");
		out.println("</html>");
		out.println("<body>");
		
		if(name == null) {
			out.println("로그인 실패"); // 그런데 실패할 일은 거의 없다.
		}else {
			out.println(name + "님 환영합니다!");
		}
		
		out.println("</body>");
		out.println("</html>");
	}

}
