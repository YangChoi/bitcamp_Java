package homework;

import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String choice; // 게임 실행 여부 묻기
		int input; // 입력받는 정수
		int strike; // 스트라이크 수
		int ball; // 볼 수

		int[] com = new int[3]; // 컴퓨터 숫자
		int[] you = new int[3]; // 내 숫자

		// 컴퓨터 숫자 난수 넣기 ( 중복제거)
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 9) + 1;
			for (int k = 0; k < i; k++) {
				if (com[i] == com[k]) {
					i--;
					break;
				}
			}
		}
		// 이렇게 해서 com에 난수 3개가 들어감

		// 게임 실행 여부 묻기
		// 단, 틀린 대답을 했을 경우에도 계속 묻기
		while (true) {
			System.out.println("게임을 실행하겠습니까? (y/n)");
			choice = scan.nextLine();


			if (choice.equalsIgnoreCase("y")) {
				System.out.println("게임을 시작합니다");

				while (true) {
					
					// 유저에게 숫자 입력받기
					System.out.print("숫자 3개 입력 : ");
					strike = 0;
					ball = 0;
					for (int i = 0; i < you.length; i++) {
						input = scan.nextInt();
						you[i] = input;

					}

					for (int i = 0; i < com.length; i++) {
						for (int k = 0; k < you.length; k++) {
							if (com[i] == you[k] && i == k) {
								strike++;
							} else if (com[i] == you[k] && i != k) {
								ball++;
							}
						}
					}
					System.out.println(strike + "스트라이크" + ball + "볼");
					if(strike == 3) {
						System.out.println("삼진! 게임 끝 ");
						break; // 안쪽 while문 나감 
					}
					
				} // 안쪽 while문
				break; // 바깥 while문 나감
			} else if (choice.equalsIgnoreCase("n")) {
				System.out.println("게임에서 나갑니다");
				break;
			} else {
				// 다시 게임 실행 여부 묻기
			}

		}

	}

}
