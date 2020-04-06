package boardProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

// ctrl + shift + o : import 정리해줌 
import util.MyScanner;

public class BoardEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Board[] boardArr = new Board[5];

		for (int i = 0; i < boardArr.length; i++) {
//				Board b = new Board();
//				b.title = "글" + i;
//				b.content = "글 내용" + i;
//				boardArr[i] = b;
			boardArr[i] = new Board(); // 초기화 해주는 코드
		}
		
		Member[] memberArr = new Member[5];
		for(int i = 0; i < memberArr.length; i++) {
			memberArr[i] = new Member();
			
		}
		Member admin = new Member();
		// 혹시 띄어쓰기를 인식안하게 할 순 없을까.....
		
		admin.userName = "admin";
		admin.password = "1111";
		admin.nickName = "영자";
		admin.id = 1;
		memberArr[0] = admin; // 배열 0번째에 admin 정보 넣음 
		
		
		
		while (true) {
			System.out.println("게시판");
			System.out.println("1. 글 목록 보기   2. 새로 작성하기   3. 종료");
			System.out.print(">");

			int userChoice = MyScanner.nextInt(scan);
			if (userChoice == 1) {
				// 글 목록보여주기
				// 글 목록을 보여주려면
				// 여러 글이 들어간 배열이 필요
				// Board[] 을 위에서 만들어준다.
//				for(int i = 0; i < boardArr.length; i++) {
//					System.out.println("제목 : " + boardArr[i].title);
//					System.out.println("내용 : " + boardArr[i].content);	
//				}
				// 위의 코드를 여기에 직접 넣지 말고 배열을 주면 거기서 출력해주는
				// 메소드로 분리한다. (list())
				BoardUtil.list(wrapper, memberArr);
				// 리스트보여주고 나서
				// 해당 글에 들어가게 선택을 받는다.
				System.out.println("1. 글 개별 보기    2. 뒤로");
				userChoice = MyScanner.nextInt(scan);
				if (userChoice == 1) {
					// 글 선택 시
					System.out.println("보실 글의 번호를 입력해 주세요 ");
					System.out.print(">>");
					userChoice = MyScanner.nextInt(scan);

					// 먼저 해당하는 번호가 우리 배열의 각 요소들의 id로
					// 존재하는지 체크하고 존재하면
					// 해당 글 보기로 이동
					// 없으면 없는 글이라고 해주자

					// 글 정보를 불러올 Board 구조체 변수 b
					// 초기화는 null로 해서
					// 만약 불러오기를 못한다면(글 번호가 존재하지 않는다면)
					// null 인지를 체크해서 글 보여주기 or 존재하지 않는 글 번호를 보여준다.
					Board b = null;
					for (int i = 0; i < boardArr.length; i++) {
						if (boardArr[i].id == userChoice) {
							b = boardArr[i];
						}
					}
					if (b == null) {
						System.out.println("존재하지 않는 글 번호 입니다. ");
					} else {
						System.out.println("제목 : " + b.title);
						System.out.println("작성자 : " + b.writerId);
						System.out.println("작성일 : " + b.writtenDate);
						System.out.println("글 내용 : " + b.content);
						System.out.println("1. 수정  2. 삭제  3. 뒤로");
						userChoice = scan.nextInt();

					}

				}

			} else if (userChoice == 2) {
				// 글 작성하기
				// 우리가 실제로 입력하는 것은
				// 글 제목과 내용 밖에 없다.
				// 글쓴 회원 번호는 로그인 하면서 우리가 따로 갖고 오란 말을 하지 않아도
				// 본인이 알아서 관리를 해주고
				// 작성 날짜의 경우에도 자동으로 넣어주고
				// 글 번호의 경우에도 맨 마지막 글 번호 + 1 된 값이 자동으로 들어가야한다.

				// 입력한 데이터를 담아줄
				// Board 구조체의 변수를 하나 만든다.
				Board b = new Board();
//				// 원래대로라면 글 번호는 자동 입력이 되어야하지만
//				// 일단 테스트 용으로
//				// b.id = 1로 지정해 본다.
				b.id = 1;

				// 글 번호를 배열을 돌아다니면서
				// 널이 아닌 곳을 찾아서
				// 그 글의 번호를 자동으로 입력되는 코드
				int index = 1;
				// for문을 이용해서 boardArray 중에서
				// 작성일이 null이 아닌 곳의
				// 위치를 찾아서 그 글의 id + 1을 우리의 index에 넣고
				// index를 b.id에 넣는다.
				// 만약 작성일이 null 이 아닌 곳을 못찾는다 =
				// 쓰여진 글이 하나도 없다는 의미이므로 index는 그대로
				// 1이 될테니까 문제가 없다.

				// 가장 최신의 것을 위로 올려야하기 때문에 역순으로
				for (int i = boardArr.length - 1; i >= 0; i--) {
					if (boardArr[i].writtenDate != null) {
						index = boardArr[i].id + 1;
						break;
					}
				}
				b.id = index;

				System.out.print("제목 : ");
				b.title = scan.nextLine();
				System.out.print("글 내용 : ");
				b.content = scan.nextLine();
//				// 테스트 데이터로서 작성자 회원번호도 일단 1로 초기화
				b.writerId = 1;
//				// 날짜를 우리가 원하는 형식으로 자동 입력하기
				Calendar c = Calendar.getInstance();
//				// 위으 코드로 현재 시간을 c에 저장함
//				// 현재 시간은 1970년 01월 01일 0시 0분 0초 (그리니치 표준시)
//				// 부터 현재 시간을 1/1000 초로 나타낸 것.
//
//				// c에 저장된 시간을 우리가 원하는 형식의 String으로 바꿔주는
//				// SimpleDateFormat이라는 클래스를 이용해서 시간을 String으로 바꿔준다.
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
				b.writtenDate = sdf.format(c.getTime());
//				// 위의 주석을 제외한 세 실제 코드는
//				// 현장에서도 현재 시간을 특정 형식으로 보여줄 때 쓰는 표준과도 같은 코드 (기억해놓을 것)
//
//				// boardArr의 요소와 비교해서 만약 시간이 null인 친구가 있으면?
//				// 그 친구 자리에 넣어주자.
				for (int i = 0; i < boardArr.length; i++) {
					if (boardArr[i].writtenDate == null) {
						boardArr[i] = b;
						break;
					}
				}
				// 작성한 것은 boardArr에 또 넣어줘야한다...
				// boardArr = BoardUtil.write(boardArr, scan);
			} else if (userChoice == 3) {
				// 종료
				System.out.println("종료");
				break;
			}
		}

		scan.close();

	}

}
