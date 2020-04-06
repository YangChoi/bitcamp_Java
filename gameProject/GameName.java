package gameProject;

import java.util.Random;
import java.util.Scanner;

import util.MyScanner;

public class GameName {
	public static void main(String[] args) {
		// 먼저 랜덤 변수 만들기
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		Character myChar = new Character();

		System.out.println("이름을 넣어주세요 ");
		myChar.name = scan.nextLine();
		System.out.println("직업을 선택해주세요 ");
		System.out.println("1. 전사   2. 마법사   3. 궁수");
		myChar.job = MyScanner.nextInt(scan);

		myChar.hp = 10; // 피 10
		int kill = 0; // 쓰러트린 적의 수

		// 적 생성
		Character enemy = new Character(); // 적캐
		enemy.hp = 10;
		enemy.name = "적";
		enemy.job = myChar.job;

		while (myChar.hp > 0) {
			// 내 직업 == 적 직업
			// 75% 확률로 서로 데미지
			if (myChar.job == enemy.job) {
				System.out.println("주사위 굴려주세요 : y");
				String attack = scan.nextLine();

				if (attack.equalsIgnoreCase("y")) {
					int chance = random.nextInt(100); // 0부터 99까지
					if (chance >= 75) {
						System.out.println("공격 실패 ");
					} else {
						System.out.println("공격 성공 ");
						enemy.hp--; // 적 hp 깜
						System.out.println("적의 남은 hp : " + enemy.hp);

					}
				}
				// 내가 공격당할 경우
				int chance = random.nextInt(100); // 0부터 99까지
				if (chance >= 75) {
					System.out.println("공격 실패 ");
				} else {
					System.out.println("공격 성공 ");
					myChar.hp--; // 내 hp 깜
					System.out.println("내 남은 hp : " + myChar.hp);
				}

			}

			if (enemy.hp == 0) {
				// 적의 피가 없어지면
				kill++; // 적 한 번 죽임
				System.out.println("회복하시겠습니까?  y/n");
				String agree = scan.nextLine();

				if (agree.equalsIgnoreCase("y")) {
					// 회복
					// 적캐 다시 생성
					enemy.hp = 10;
					enemy.name = "적";
					enemy.job = myChar.job;

					// 나 회복
					myChar.hp = 10;

				} else if (agree.equalsIgnoreCase("n")) {
					System.out.println("게임 끝!");
				}
			} else if (myChar.hp == 0) {
				System.out.println("게임오버");
				System.out.println("쓰러트린 적의 수 : " + kill);
			}
		}

		scan.close();
	}
}
