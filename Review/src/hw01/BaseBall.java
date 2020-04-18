package hw01;

import java.io.IOException;
import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int choice;
		int strike, ball;

		// 각 배열
		int[] com = new int[3];
		int[] user = new int[3];

		do {
			System.out.print("게임을 실행하시겠습니까? (y/n) ");
			choice = System.in.read(); // 딱 한자만 받는다.
			System.in.read(); // int로 받음 (아스키코드)
			System.in.read(); // 예외 처리해주어야함

		} while (choice != 'y' && choice != 'Y' && choice != 'n' && choice != 'N');
		// y나 n이 아닌 동안 do while이 계속 돌아간다
		// 만약 y나 n이 입력되면 do while을 빠져나와 아래의 코드를 실행한다.
		if (choice == 'y' || choice == 'Y') {
			// 난수발생
			for (int i = 0; i < com.length; i++) {
				com[i] = (int) (Math.random() * 9) + 1; // 1부터 9까지
				// 중복체크
				for (int k = 0; k < i; k++) {
					if (com[i] == com[k]) {
						// 중복됨
						i--; // 다시 돌아가서 해당 인덱스에서 난수 뽑기
						break;
					}
				} // for k
			} // for i
			
			// 게임시작
			while(true) {
				System.out.println("숫자 3개 입력");
				for(int i = 0; i < user.length; i++) {
					user[i] = System.in.read() - '0';
					// 문자 0을 빼주어야 문자를 숫자로 바꿔줄 수 있다. 
					// 문자 0과 숫자 0의 아스키코드가 딱 48차이가 나기 때문.
					// 48을 빼면 문자에서 숫자로 바꿔줄 수 있다. 
				}// for i 
				System.in.read();
				System.in.read();
				
				strike = 0; 
				ball = 0; 
				for(int i = 0; i < com.length; i++) {
					for(int k = 0; k < user.length; k++) {
						if(com[i] == user[k]) {
							if(i == k ) {
								strike++;
							}else {
								ball++;
							}
						}
					}// for k
				}// for i
				System.out.println(strike + "스트라이크  " + ball + "볼");
				if(strike == 3) {
					System.out.println("삼진. 게임 끝");
					break;
				}
			}// while
		}
		System.out.println("프로그램 종료 ");

	}

}
