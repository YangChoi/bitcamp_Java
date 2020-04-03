package boardProject;

import java.util.Scanner;

import util.MyArray;
import util.MyScanner;

public class BoardEx2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 5로 지정했다가 0으로 초기화 했다.
		// 이제 add메소드가 알아서 해줄 것이기 때문
		Board[] boardArr = new Board[0];
		Member member = new Member();
		member.nickName = "admin"; // 임시로 
		member.id = 1; // 임시로 
		
		Member[] memberArr = new Member[0];
		memberArr = MyArray.add(memberArr, member);
//		
//		for (int i = 0; i < boardArr.length; i++) {
//
//			boardArr[i] = new Board(); // 초기화 해주는 코드
//		}
		while (true) {
			System.out.println("게시판");
			System.out.println("1. 글 목록 보기   2. 새로 작성하기   3. 종료");
			System.out.print(">");

			int userChoice = MyScanner.nextInt(scan);
			if (userChoice == 1) {
				// 글 목록 보기
				BoardUtil.list(boardArr, memberArr);
				if (boardArr.length > 0) {
					System.out.println("1. 글 개별 보기   2. 뒤로가기 ");
					System.out.print(">>");

					userChoice = MyScanner.nextInt(scan);
					if (userChoice == 1) {
						// 글 개별 보기
						boardArr = BoardUtil.showOne(boardArr, scan, member, memberArr);
					}
				}

			} else if (userChoice == 2) {
				// 게시물 작성
				// 작성한 것은 boardArr에 다시 넣어준다..
				boardArr = BoardUtil.write(boardArr, scan);

			} else if (userChoice == 3) {
				// 종료
				System.out.println("종료");
				break;
			}
		}

		scan.close();

	}

}
