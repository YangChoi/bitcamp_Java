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
	public static void list(BoardReplyWrapper wrapper, Member[] memberArr) {
		// 그런데 우리가 게시판 같은 걸 보면?
		// 최신글이 제일 위로 온다.
		// 그럼 for문의 i는 무엇으로 초기화 해야할까? >> 거꾸로 나열하면 된다.
		for (int i = wrapper.boardArr.length - 1; i >= 0; i--) {
			Board b = wrapper.boardArr[i];
			
			// 댓글 갯수 세기 
			int count = ReplyUtil.countReply(b.id, wrapper.replyArr);
			String message = b.id + " " + b.title + " ";
			if(count != 0) {
				message += "[" + count + "]";
			}
			message += MemberUtil.showNickName(memberArr, b.writerId) + " " + b.writtenDate;
			System.out.println(message);
		}
	}

	public static Board[] write(Board[] boardArr, Scanner scan, Member member) {
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

			// id 값은 본 메소드가 알아서 찾아주는 것..
		}

		System.out.print("제목 : ");
		b.title = scan.nextLine();
		System.out.print("글 내용 : ");
		b.content = scan.nextLine();

		b.writerId = member.id; // 이젠 1이 아니라 member의 id

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

	public static BoardReplyWrapper showOne(BoardReplyWrapper wrapper, Scanner scan, Member member, Member[] memberArr) {
		// 글 리스트 한번 띄우고 개별 글번호 입력 받기 
		list(wrapper, memberArr);
		System.out.print("개별보기할 글 번호를 입력해주세요 : ");
		int id = MyScanner.nextInt(scan);
		Board b = selectOne(wrapper.boardArr, id);
		if (b == null) {
			System.out.println("존재하지 않는 글 번호입니다. ");
		} else {
			System.out.println("제목 : " + b.title);
			System.out.println("작성자 : " + MemberUtil.showNickName(memberArr, b.writerId));
			System.out.println("작성일 : " + b.writtenDate);
			System.out.println("글 내용 : " + b.content);
			System.out.println("======================================================");
			ReplyUtil.list(wrapper.replyArr, b.id, memberArr);
			// b.id가 boardId이다...

			// 그런데 수정, 삭제는 글 쓴 회원만 해야한다.
			// 그럼 회원 정보를 담당할 Member 구조체를 따로 만들어야한다.
			if (member.id == b.writerId) {
				System.out.println("1. 수정  2. 삭제  3. 뒤로");
				int userChoice = MyScanner.nextInt(scan);
				if (userChoice == 1) {
					// 수정하는 메소드 호출
					// scan, boardArr, board를 보내서
					// 수정한 것을 해당 위치와 교체한다.
					// 수정에 필요한 재료 : 현재 보여지는 글 
					System.out.println("==== 글 수정 ====");
					System.out.println("제목 : ");
					b.title = scan.nextLine();
					System.out.println("글 내용 : ");
					b.content = scan.nextLine();
					// 이 b가 위치한 index를 찾는다 
					// 마침 MyArray에 indexOf가 있다. 
					int index = MyArray.indexOf(wrapper.boardArr, b);
					wrapper.boardArr[index] = b; // index 번호 업데이트 
					System.out.println("수정 완료");
					
				} else if (userChoice == 2) {
					// 삭제하는 메소드 호출
					// MyArray를 이용해서 boardArr에서 board 삭제
					wrapper.boardArr = MyArray.remove(wrapper.boardArr, b);
					System.out.println("삭제 완료");
					list(wrapper, memberArr); // 삭제후 글 목록 다시 보여줌 
					
				} else if (userChoice == 3) {
					// 글 목록보기로 돌아간다.
					list(wrapper, memberArr);
				}

			} else {
				// 현재 문제 : 댓글 입력, 수정, 삭제는 이 글을 벗어나면 사라진다 
				// 그럼 어떻게 해결할 수 있을까? 
				// 그러면 2가지 배열(boardArr와 replyArr)을 
				// 통쨰로 가지고 있는 친구가 하나 있으면 그 친구로 왔다갔다 할 수 있지 않을까 
				
				
				// 멤버아이디와 글쓴이 아이디가 다르면 댓글달기
				System.out.println("1. 댓글 달기  2. 댓글 수정  3. 댓글 삭제  4. 뒤로");
				System.out.print("> ");
				int userChoice = MyScanner.nextInt(scan);

				if (userChoice == 1) {
					// 댓글달기
					Reply r = new Reply();
					r.memberId = member.id;
					r.boardId = b.id;
					System.out.println("댓글 내용을 입력해주세요 ");
					System.out.print("> ");
					r.content = scan.nextLine();
					wrapper.replyArr = ReplyUtil.insert(wrapper.replyArr, r);
					// 댓글입력 끝
					// 댓글의 id를 선택하고
					// 해당 댓글을 쓴 사람이 로그인 했는지 체크하고
					// 둘다 가능한거면 삭제

					// 아닐 시에는 경고 메세지 출력
					showOne(wrapper, scan, member, memberArr);
					// 댓글 보여주기

				} else if (userChoice == 2) {
					// 댓글 수정
					System.out.println("수정할 댓글의 번호를 입력해주세요 ");
					Reply r = new Reply();
					r.id = MyScanner.nextInt(scan);
					
					int index = MyArray.indexOf(wrapper.replyArr, r);
					if(index != -1) {
						// 해당 댓글을 쓴 사람과 로그인한 유저가 동일인물인지 확인 
						r = wrapper.replyArr[index]; // index가져온다 
						if(r.memberId == member.id) {
							// 동일인물이므로 수정 시작
							System.out.println("댓글 내용  : ");
							r.content = scan.nextLine();
							wrapper.replyArr[index] = r; // 덮는다. 
							// 굳이 삭제 하고 추가하지 않아도 마지막에 초기화(덮음)하면 되는구나...
							
						}else {
							// 다른 사람이 쓴 댓글이니 경고 메세지 출력
							System.out.println("권한이 없습니다. ");
							
						}
					}else {
						System.out.println("존재하지 않는 번호입니다. ");

					}
				} else if (userChoice == 3) {
					// 댓글 삭제
					System.out.print("삭제할 댓글의 번호를 입력해주세요 : ");
					Reply r = new Reply();
					r.id = MyScanner.nextInt(scan);

					if (MyArray.indexOf(wrapper.replyArr, r) != -1) {
						r = wrapper.replyArr[MyArray.indexOf(wrapper.replyArr, r)];
						// 해당 위치에 r초기화
						if (r.memberId == member.id) {
							// 마지막으로 한번 더 물어보고 사용자가 Y라고 입력하면 삭제
							System.out.println("정말 삭제 하시겠습니까? 1. Y(네)  2. N(아니오)");
							String agree = scan.nextLine();
							if (agree.equalsIgnoreCase("y")) {
								// IgnoreCase : 대소문자 무시
								// 댓글 삭제
								wrapper.replyArr = ReplyUtil.delete(wrapper.replyArr, r);
								System.out.println("댓글이 삭제되었습니다 ");

							}
						} else {	
							// r.memberId != member.id 이면  댓글 작성자가 아니다 
							System.out.println("권한이 없습니다. ");
						}
						// 해당하는 id를 가진 reply가 존재
						// 이제 그 친구를 배열에서 가져와서
						// memberId와 member.id를 비교해서
						// 같으면 마지막으로 정말 삭제할지 물어보고
						// 아니면 그냥 끝
					} else {
						// -1 : 없는 댓글  
						System.out.println(" 없는 댓글 번호 입니다. ");
						// 글 보여주기 
						showOne(wrapper, scan, member, memberArr);
					}
				} else if (userChoice == 4) {
					// 뒤로
					list(wrapper, memberArr);
				}
			}
		}
		return wrapper;
	}
}
