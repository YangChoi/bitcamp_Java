package imageBoard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageBoard.dao.ImageBoardDAO;

public class ImageBoardChoiceDeleteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String seq = request.getParameter("seq");

		
		ImageBoardDAO imageBoardDAO = ImageBoardDAO.getInstance();
		imageBoardDAO.imageBoardChoiceDelete(seq);
		
		request.setAttribute("display", "/imageBoard/imageBoardChoiceDelete.jsp");
		return "/main/index.jsp";
	}

}
