package homework;

import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String choice; // ���� ���� ���� ����
		int input; // �Է¹޴� ����
		int strike; // ��Ʈ����ũ ��
		int ball; // �� ��

		int[] com = new int[3]; // ��ǻ�� ����
		int[] you = new int[3]; // �� ����

		// ��ǻ�� ���� ���� �ֱ� ( �ߺ�����)
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 9) + 1;
			for (int k = 0; k < i; k++) {
				if (com[i] == com[k]) {
					i--;
					break;
				}
			}
		}
		// �̷��� �ؼ� com�� ���� 3���� ��

		// ���� ���� ���� ����
		// ��, Ʋ�� ����� ���� ��쿡�� ��� ����
		while (true) {
			System.out.println("������ �����ϰڽ��ϱ�? (y/n)");
			choice = scan.nextLine();


			if (choice.equalsIgnoreCase("y")) {
				System.out.println("������ �����մϴ�");

				while (true) {
					
					// �������� ���� �Է¹ޱ�
					System.out.print("���� 3�� �Է� : ");
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
					System.out.println(strike + "��Ʈ����ũ" + ball + "��");
					if(strike == 3) {
						System.out.println("����! ���� �� ");
						break; // ���� while�� ���� 
					}
					
				} // ���� while��
				break; // �ٱ� while�� ����
			} else if (choice.equalsIgnoreCase("n")) {
				System.out.println("���ӿ��� �����ϴ�");
				break;
			} else {
				// �ٽ� ���� ���� ���� ����
			}

		}

	}

}
