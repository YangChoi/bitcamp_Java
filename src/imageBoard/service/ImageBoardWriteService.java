package imageBoard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import imageBoard.bean.ImageBoardDTO;
import imageBoard.bean.ImageBoardPaging;
import imageBoard.dao.ImageBoardDAO;

public class ImageBoardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 실제 폴더 
		String realFolder = request.getServletContext().getRealPath("/storage");
		// 파일 업로드
		MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024, "UTF-8");
		String path = "C:/Users/yangh/Desktop/Algorithm/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/miniProject"; // 파일 업로드 경로 
		
		// 데이터 얻어오기 
		String imageId = multi.getParameter("imageId");
		String imageName = multi.getParameter("imageName");
		int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
		int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
		String imageContent = multi.getParameter("imageContent");
		String image1 = multi.getOriginalFileName("image1");

		ImageBoardDTO imageBoardDTO = new ImageBoardDTO();
		imageBoardDTO.setImageId(imageId);
		imageBoardDTO.setImageName(imageName);
		imageBoardDTO.setImagePrice(imagePrice);
		imageBoardDTO.setImageQty(imageQty);
		imageBoardDTO.setImageContent(imageContent);
		imageBoardDTO.setImage1(image1);
		
				
		
		ImageBoardDAO imageBoardDAO = ImageBoardDAO.getInstance();
		imageBoardDAO.imageBoardWrite(imageBoardDTO);
		
		
		
		// 응답 
		request.setAttribute("display", "/imageBoard/imageBoardWrite.jsp");
		
		
		
		return "/main/index.jsp";
	}

}
