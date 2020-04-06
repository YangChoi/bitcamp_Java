package boardProject;

import java.util.Scanner;

import util.MyArray;
import util.MyScanner;

public class MemberUtil {
	// 로그인 만들기
	// 로그인은 사용자가 아이디와 비번을 입력했을 때
	// 배열에서 해당 아이디를 찾고 만약 존재한다면
	// 해당 비번이 맞는지 확인
	// 즉 아이디 체크 후 비번 체크
	// 두개 다 true가 나오면 null인 Member 변수와
	// 해당 배열의 요소와 연결 시켜서 리턴

	public static String showNickName(Member[] memberArr, int id) {
		for (int i = 0; i < memberArr.length; i++) {
			if (memberArr[i].id == id) {
				return memberArr[i].nickName;

			}
		}
		return null;
	}

	// 로그인 만들기
	private static Member logIn(Member[] memberArr, Member logInTry) {
		// 누가 파라미터에 메소드를 부르니 그냥 이름이다 이름

		Member m = null;
		// 먼저 index가 존재하는지 찾는다.
		int index = MyArray.indexOf(memberArr, logInTry.userName);

		if (index != -1) { // 일치하는 id를 가진 member를 찾으면
			if (logInTry.password.equals(memberArr[index].password)) {
				m = memberArr[index];
			}
		}
		return m;
	}

	public static Member logInPrint(Member[] arr, Scanner scan) {
		// 체크해서 맞는게 나올 때 까지
		Member logIn = new Member();
		System.out.print("ID를 입력해 주세요 : ");
		logIn.userName = scan.nextLine();
		System.out.print("비밀 번호를 입력해주세요 ");
		logIn.password = scan.nextLine();

		logIn = MemberUtil.logIn(arr, logIn);

		// 얘가 null이 되면 다시 아이디와 비번 입력을 받는다.
		while (logIn == null) {
			System.out.println("잘못 입력하셨습니다. ");
			logIn = new Member(); // 로그인 초기화

			System.out.print("ID를 입력해 주세요 : ");
			logIn.userName = scan.nextLine();
			System.out.print("비밀 번호를 입력해주세요 ");
			logIn.password = scan.nextLine();
			logIn = MemberUtil.logIn(arr, logIn); // 틀리면 다시 입력받기

		}
		// 일치하는 애를 찾아서 while문을 빠져나왔다!
		return logIn;
	}

	// 회원가입을 시켜주자
	// index라는 메소드를 만들어서
	// 게시판에 오신걸 환영합니다.
	// 1. 로그인 2. 회원가입 3. 종료
	// 위와 같이 만들어서
	// 사용자가 아이디, 비번 등등을 입력해서
	// 각자가 아이디를 따로 만들 수 있게 만들어보자 .

	// 나 아직도 뭘 리턴타입으로 해야할지 모른다. ....
	public static Member[] index(Scanner scan, Member[] memberArr, BoardReplyWrapper wrapper) {
		while (true) {
			System.out.println("게시판");
			System.out.println("1. 로그인  2. 회원가입  3. 종료 ");
			System.out.print("> ");
			int choice = MyScanner.nextInt(scan);

			if (choice == 1) {
				// 로그인
				Member logInUser = logInPrint(memberArr, scan); // 로그인
				showMenu(scan, memberArr, wrapper, logInUser);
				// 이 배열들은 메인메소드에서 만들어서 우리한테 보내주기로 한 애들
				break;

			} else if (choice == 2) {
				// 회원가입
				memberArr = register(scan, memberArr);

			} else if (choice == 3) {
				System.out.println("종료 ");
				break;
			}
		}

		return memberArr;

	}

	// 회원가입 메소드
	private static Member[] register(Scanner scan, Member[] arr) {
		Member m = new Member();

		System.out.print("사용할 ID를 적어주세요 : ");
		m.userName = scan.nextLine();
		// 유효성 검사
		// 해당 userName이 존재하는지부터 체크
		// indexOf의 결과값이 -1이 아니면
		// 계속 돌아가게 만듦
		while (MyArray.indexOf(arr, m.userName) != -1) {
			System.out.println("이미 존재하는 아이디 입니다. ");
			System.out.print("사용할 ID를 적어주세요 : ");
			m.userName = scan.nextLine();
		}

		System.out.println("사용할 비밀 번호를 입력해주세요 ");
		m.password = scan.nextLine();
		System.out.println("사용할 닉네임을 적어주세요 ");
		m.nickName = scan.nextLine();
		m.id = 1;
		// id값은 BoardUtil.write() 메소드가 알아서 해주는 부분

		if (arr.length != 0) {
			m.id = arr[arr.length - 1].id + 1; // 배열이 존재하면.. id값 이렇게 준다.
		}
		arr = MyArray.add(arr, m);
		// 결과값을 다시 arr에 넣어야한다.

		return arr;
	}

	private static void showMenu(Scanner scan, Member[] memberArr, BoardReplyWrapper wrapper, Member member) {
		// 파라미터 설명
		// scanner : 입력에 필요
		// Member[] memberArr : 회원 모아놓은 배열
		// Board[] boardArr : 게시글 모아놓은 배열
		// Reply[] replyArr : 댓글 모아놓은 배열
		// Member[] member : 로그인한 유저
		// BoardReplyWrapper wrapper : Board[] Reply[] 묶어놓은 포장 클래스

		while (true) {
			System.out.println("게시판");
			System.out.println("1. 글 목록 보기   2. 새로 작성하기   3. 로그아웃   4. 종료 ");
			System.out.print(">");

			int userChoice = MyScanner.nextInt(scan);
			if (userChoice == 1) {
				// 글 목록 보기
				BoardUtil.list(wrapper, memberArr);
				if (wrapper.boardArr.length > 0) {
					System.out.println("1. 글 개별 보기   2. 뒤로가기 ");
					System.out.print(">>");

					userChoice = MyScanner.nextInt(scan);
					if (userChoice == 1) {
						// 글 개별 보기
						wrapper = BoardUtil.showOne(wrapper, scan, member, memberArr);
					}
				}

			} else if (userChoice == 2) {
				// 게시물 작성
				// 작성한 것은 boardArr에 다시 넣어준다..
				wrapper.boardArr = BoardUtil.write(wrapper.boardArr, scan, member);

			} else if (userChoice == 3) {
				// 로그아웃
				// 로그아웃 된 상태에서 회원가입도 가능하게
				member = null;
				while (member == null) {
					System.out.println("1. 회원가입  2. 로그인  3. 종료 ");
					userChoice = MyScanner.nextInt(scan);
					if (userChoice == 1) {
						// 회원가입
						memberArr = register(scan, memberArr);

					} else if (userChoice == 2) {
						// 로그인
						member = logInPrint(memberArr, scan);

					} else if (userChoice == 3) {
						// 종료
						// break를 두 번하는 방법
						break;
					}
				}

			}
			// 여기서 userChoice가 얼마인지 출력해보면
			// 우리가 마지막으로 선택한 값들이 남아있다.
			// 그런데 만약 userChoice가 3이면?
			// >> 사용자가 종료를 골랐다는 것

			if (userChoice == 3) {
				// 종료
				System.out.println("로그아웃 후 종료되었습니다. ");
				break;
			}
		}
	}
}
