package boardProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import util.MyArray;
import util.MyScanner;

/*
 * Board 구조체와 관련된 메소드를 모아둔
 * BoardUtil
 */
public class BoardUtil {

	// 글 번호, 제목, 작성자, 작성일을 한 줄에 보여주는
	// 리스트 라는 메소드
	public static void list(Board[] boardArr, Member[] memberArr) {
		// 그런데 우리가 게시판 같은 걸 보면?
		// 최신글이 제일 위로 온다.
		// 그럼 for문의 i는 무엇으로 초기화 해야할까? >> 거꾸로 나열하면 된다.
		for (int i = boardArr.length - 1; i >= 0; i--) {
			Board b = boardArr[i];
			System.out.println(b.id + " " + b.title + " " + MemberUtil.showNickName(memberArr, b.writerId) + " " + b.writtenDate);
		}
	}

	public static Board[] write(Board[] boardArr, Scanner scan) {
		Board b = new Board();
		// 이 메소드를 boardArr의 길이가 유동적이기 때문에
		// 우리는 boardArr의 길이가 0이 아니면
		// 가장 마지막 요소를 찾아서
		// 그 요소의 id 번호를 가지고 올 수 있다.
		b.id = 1;
		if (boardArr.length != 0) {
			// 배열의 가장 마지막 요소의 index는 얼마인가?
			// length -1
			// 그럼 해당 위치에 있는 board 구조체의
			// id + 1 한 값이 우리의 입력할 id가 된다.
			b.id = boardArr[boardArr.length - 1].id + 1;
			// 이 부분 스스로 돌아보기....
		}

		System.out.print("제목 : ");
		b.title = scan.nextLine();
		System.out.print("글 내용 : ");
		b.content = scan.nextLine();

		b.writerId = 1;

		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		b.writtenDate = sdf.format(c.getTime());

		boardArr = MyArray.add(boardArr, b);

		return boardArr;
	}

	// 사용자가 int와 Board배열을 주면
	// 해당 Board 배열에서 id가 int와 일치하는
	// Board변수를 리턴하는 메소드
	private static Board selectOne(Board[] boardArr, int id) {
		for (int i = 0; i < boardArr.length; i++) {
			if (boardArr[i].id == id) {
				return boardArr[i];
			}
		}
		return null;
	}

	public static Board[] showOne(Board[] boardArr, Scanner scan, Member member, Member[] memberArr) {
		System.out.print("개별보기할 글 번호를 입력해주세요 : ");
		int id = MyScanner.nextInt(scan);
		Board b = selectOne(boardArr, id);
		if (b == null) {
			System.out.println("존재하지 않는 글 번호입니다. ");
		} else {
			System.out.println("제목 : " + b.title);
			System.out.println("작성자 : " + MemberUtil.showNickName(memberArr, b.writerId));
			System.out.println("작성일 : " + b.writtenDate);
			System.out.println("글 내용 : " + b.content);
			// 그런데 수정, 삭제는 글 쓴 회원만 해야한다.
			// 그럼 회원 정보를 담당할 Member 구조체를 따로 만들어야한다.
			if (member.id == b.writerId) {
				System.out.println("1. 수정  2. 삭제  3. 뒤로");
				int userChoice = scan.nextInt();
				if(userChoice == 1) {
					// 수정하는 메소드 호출 
					// scan, boardArr, board를 보내서 
					// 수정한 것을 해당 위치와 교체한다. 
					
				}else if(userChoice == 2) {
					// 삭제하는 메소드 호출
					// MyArray를 이용해서 boardArr에서 board 삭제 
					boardArr = MyArray.remove(boardArr, b);
				}else if(userChoice == 3){
					// 글 목록보기로 돌아간다. 
					list(boardArr, memberArr);
				}
			}
		}
		return boardArr;
	}
}
