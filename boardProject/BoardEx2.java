package boardProject;

import java.util.Scanner;

import util.MyArray;

public class BoardEx2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 5로 지정했다가 0으로 초기화 했다.
		// 이제 add메소드가 알아서 해줄 것이기 때문
		Board[] boardArr = new Board[0];
		Reply[] replyArr = new Reply[0];
		BoardReplyWrapper wrapper = new BoardReplyWrapper();
		wrapper.boardArr = boardArr;
		wrapper.replyArr = replyArr;
		
		Member member = new Member();
		member.nickName = "영자"; // 임시로 
		member.id = 1; // 임시로 
		member.userName = "admin";
		member.password = "1111";
		
		Board b = new Board();
		b.id = 1; 
		b.title = "test title";
		b.content = "test content";
		b.writerId = 1;
		wrapper.boardArr = MyArray.add(boardArr, b);
		// boardArr에 해당 내용을 추가..
		
		
		Member[] memberArr = new Member[0];
		memberArr = MyArray.add(memberArr, member);
		
		// 로그인 메소드 
		//Member logIn = MemberUtil.logInPrint(memberArr, scan);
		// 로그인과 회원가입 다 들어간 index 메소드 
		MemberUtil.index(scan, memberArr, wrapper);

//		
//		for (int i = 0; i < boardArr.length; i++) {
//
//			boardArr[i] = new Board(); // 초기화 해주는 코드
//		}
		
		

		scan.close();

	}

}
