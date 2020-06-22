package user.main;

import java.util.Scanner;

import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSearchService;
import user.service.UserSelectService;
import user.service.UserService;
import user.service.UserUpdateService;

public class UserMain {
	public void menu() {
		Scanner scan = new Scanner(System.in);
		UserService userService = null;
		
		while (true) {
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 검색");
			System.out.println("6. 끝");
			System.out.print("번호를 입력하세요 : ");
			int input = scan.nextInt();
			
			if (input == 6) {
				break;
			}

			if (input == 1) {
				System.out.println("====입력====");
				userService = new UserInsertService();
				userService.execute();
				
			} else if (input == 2) {
				System.out.println("====출력====");
				userService = new UserSelectService();
				userService.execute();
			} else if (input == 3) {
				System.out.println("====수정====");
				userService = new UserUpdateService();
				userService.execute();
			} else if (input == 4) {
				System.out.println("====삭제====");
				userService = new UserDeleteService();
				userService.execute();
			} else if (input == 5) {
				System.out.println("====검색====");
				userService = new UserSearchService();
				userService.execute();
				
			}
		} // while
	}

	public static void main(String[] args) {
		UserMain userMain = new UserMain();

		userMain.menu();
		System.out.println("종료합니다");

	}

}
