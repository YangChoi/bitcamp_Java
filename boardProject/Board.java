package boardProject;
/*
 * 게시글 구조체 
 * 글번호, 제목, 내용, 작성자 회원번호, 입력날짜 
 */
public class Board {
	// 글 번호, 회원 번호 등 그 구조체에서 특별히 구분되어 지는 
	// int를 우리는 id라고 부른다. 
	public int id;  // 글번호 
	public String title;  // 글제목
	public String content; // 글 내용
	public int writerId; // 작성자 회원번호 
	public String writtenDate; // 입력날짜 
	// >> 이거 나중에 Board 배열로 묶어주면 되는거겠네? 
}
