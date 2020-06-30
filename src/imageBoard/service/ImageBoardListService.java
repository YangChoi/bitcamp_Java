package imageBoard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageBoard.bean.ImageBoardPaging;
import imageBoard.dao.ImageBoardDAO;

public class ImageBoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));

		// db
		ImageBoardDAO imageBoardDAO = ImageBoardDAO.getInstance();

		// 1페이지당 3개씩
		int endNum = pg * 3;
		int startNum = endNum - 2;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		List<ImageBoardDAO> list = imageBoardDAO.imageBoardList(map);

		// 페이징 처리
		// 총 글 수
		int totalA = imageBoardDAO.getToTalA();
		ImageBoardPaging imageBoardPaging = new ImageBoardPaging();
		imageBoardPaging.setCurrentPage(pg);
		imageBoardPaging.setPageBlock(3);
		imageBoardPaging.setPageSize(3);
		imageBoardPaging.setTotalA(totalA);
		imageBoardPaging.makePagingHTML();

		// 응답
		request.setAttribute("pg", pg);
		request.setAttribute("list", list);
		request.setAttribute("imageBoardPaging", imageBoardPaging);
		request.setAttribute("display", "/imageBoard/imageBoardList.jsp");

		return "/main/index.jsp";

	}

}
