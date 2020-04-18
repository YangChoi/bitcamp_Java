package hw01;

import java.io.IOException;
import java.util.Scanner;

public class BaseBallAgain {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int choice;
		int strike, ball;

		int[] com = new int[3];
		int[] user = new int[3];

		do {
			System.out.println("게임을 실행하시겠습니까? (y/n)");
			choice = System.in.read();
			System.in.read();
			System.in.read();

		} while (choice != 'y' && choice != 'Y' && choice != 'n' && choice != 'N');
		if (choice == 'Y' || choice == 'y') {
			System.out.println("게임을 실행합니다. ");

			// 난수 생성
			for (int i = 0; i < com.length; i++) {
				com[i] = (int)(Math.random() * 9) + 1; // 1부터 9까지
				// 중복 제거
				for (int k = 0; k < i; k++) {
					if (com[i] == com[k]) {
						i--;
						break;
					}
				}// for k 
			}// for i

			while (true) {
				// 게임 시작
				System.out.println("숫자 3개를 입력해주세요 ");
				for (int i = 0; i < user.length; i++) {
					user[i] = System.in.read()-'0';
				}
				System.in.read();
				System.in.read();

				strike = 0;
				ball = 0;

				for (int i = 0; i < com.length; i++) {
					for (int k = 0; k < user.length; k++) {
						if (com[i] == user[k]) {
							if (i == k) {
								strike++;
							} else {
								ball++;
							}
						}
					} // for k
				} // for i
				System.out.println(strike + "스트라이크" + ball + "볼");
				if (strike == 3) {
					System.out.println("삼진 게임 끝");
					break;
				}

			} // while

		} else {
			System.out.println("게임을 종료합니다.");
		}

	}

}
