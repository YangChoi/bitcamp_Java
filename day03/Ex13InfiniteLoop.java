package day03;

import java.util.Scanner;

/*
 * 무한 루프를 만들어서 메뉴를 만들어 보자 
 */
public class Ex13InfiniteLoop {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("=============");
			System.out.println("성적 관리 프로그램");
			System.out.println("=============");
			System.out.println("1. 입력   2. 출력   3. 종료");
			System.out.print(">>");
			
			int choice = scan.nextInt();
			if(choice == 1) {
				// 성적을 입력하는 코드를 여기에 구현
				
			}else if(choice == 2) {
				// 성적을 출력하는 코드를 여기에 구현
			}else if(choice == 3) {
				System.out.println("나감");
				break;
			}else {
				System.out.println("잘못 입력");
			}
		}
		scan.close();

	}

}
