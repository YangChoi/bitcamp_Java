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
			System.out.println("������ �����Ͻðڽ��ϱ�? (y/n)");
			choice = System.in.read();
			System.in.read();
			System.in.read();

		} while (choice != 'y' && choice != 'Y' && choice != 'n' && choice != 'N');
		if (choice == 'Y' || choice == 'y') {
			System.out.println("������ �����մϴ�. ");

			// ���� ����
			for (int i = 0; i < com.length; i++) {
				com[i] = (int)(Math.random() * 9) + 1; // 1���� 9����
				// �ߺ� ����
				for (int k = 0; k < i; k++) {
					if (com[i] == com[k]) {
						i--;
						break;
					}
				}// for k 
			}// for i

			while (true) {
				// ���� ����
				System.out.println("���� 3���� �Է����ּ��� ");
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
				System.out.println(strike + "��Ʈ����ũ" + ball + "��");
				if (strike == 3) {
					System.out.println("���� ���� ��");
					break;
				}

			} // while

		} else {
			System.out.println("������ �����մϴ�.");
		}

	}

}
