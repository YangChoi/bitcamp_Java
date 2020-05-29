package member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

//@WebServlet("/WriteServlet") // web.xml과 같은 코드...
// 두개 다 써주면 톰캣이 안켜진다. 하나만 쓰도록 한다. 
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// POST 방식의 한글 처리 
		request.setCharacterEncoding("UTF-8");
	
		// 데이터 얻어오기 
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setZipcode(zipcode);
		memberDTO.setAddr1(addr1);
		memberDTO.setAddr2(addr2);
		
		// 얻어온 데이터 사라지기 전에 DB에 보관하기
		// DTO로 모은 데이터를 DAO에 INSERT 한다. 
		// 새로운 데이터가 들어올 떄마다 new MemberDAO()가 되는데 굳이 데이터가 INSERT 될 때마다 new 하면 부담이다. 
		// 따라서 메모리에는 딱 하나의 new 만 만들어 놓고 가져다 쓴다 : 싱글톤 
		MemberDAO memberDAO = MemberDAO.getInstance();
		int su = memberDAO.writeMember(memberDTO); // 데이터를 memberDTO에 다 넣었기 때문에 dto를 가지고 간다 
		
		// 회원가입에 대한 응답하기 (회원가입 성공, 실패) 
		
		// 응답 
		response.setContentType("text/html;charset=UTF-8");
		// 여기은 UTF-8은 응답에 대한 한글 처리이다. 
		// 따라서 여기만 한글 처리 해주면 DB에는 한글이 다 깨져서 나온다. 
		// 한글 처리를 해줘야하는 것은 NAME, ID 와 같은 것.
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>회원가입</title>");
		out.println("</html>");
		out.println("<body>");
		
		if(su == 1) {
			out.println("회원가입 성공!");
			out.println("<br><br>");
			out.println("<input type='button' value='로그인' onclick=location.href='http://localhost:8080/memberServlet/member/loginForm.html'>");
			// 회원가입이 된 상태에서 새로고침하면 저장된 데이터를 또 저장하려고 하기 때문에 중복된 코드를 저장하려해서 무결성 제약조건 에러가 발생한다. ㄴ
			
		}else {
			out.println("회원가입 실패"); // 그런데 실패할 일은 거의 없다. 
		}
		
		out.println("</body>");
		out.println("</html>");
		
	}

}
