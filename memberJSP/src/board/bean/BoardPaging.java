package board.bean;

import lombok.Data;

@Data
public class BoardPaging {
	private int currentPage; // 현재 페이지 
	private int pageBlock; // [이전][1][2][3][다음]
	private int pageSize; // 1페이지당 5개씩
	private int totalA; // 총 글수 
	private StringBuffer pagingHTML; 
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		int totalP = (totalA + pageSize-1) / pageSize;// 총 페이지 수 (한 페이지당 글 5개)
		
		int startPage = (currentPage -1)/pageBlock*pageBlock +1;
		int endPage = startPage +  pageBlock -1;
		if(endPage > totalA) endPage = totalP;
		/*
		// 1 페이지당 5개씩
		int totalA = (totalA + 4)/5;
		// 한페이지당 10개씩
		int totalA = (totalA + 9)/10;
		*/
		
		if(currentPage > pageBlock)
			pagingHTML.append("[<a id='paging' href='boardList.jsp?pg="+(startPage-1)+"'>이전</a>]");
		for(int i = startPage; i <=endPage; i++) {
			if(i == currentPage)
				pagingHTML.append("[<a id='currentPaging' href='boardList.jsp?pg="+i+"'>" + i+ "</a>]");
			else 
				pagingHTML.append("[<a id='paging' href='boardList.jsp?pg="+i+"'>" + i+ "</a>]");
			
		}
		
		if(endPage < totalA)
			pagingHTML.append("[<a id='paging' href='boardList.jsp?pg="+(endPage+1)+"'>다음</a>]");

	}
}
