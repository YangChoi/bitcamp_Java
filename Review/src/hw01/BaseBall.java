package hw01;

import java.io.IOException;
import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int choice;
		int strike, ball;

		// �� �迭
		int[] com = new int[3];
		int[] user = new int[3];

		do {
			System.out.print("������ �����Ͻðڽ��ϱ�? (y/n) ");
			choice = System.in.read(); // �� ���ڸ� �޴´�.
			System.in.read(); // int�� ���� (�ƽ�Ű�ڵ�)
			System.in.read(); // ���� ó�����־����

		} while (choice != 'y' && choice != 'Y' && choice != 'n' && choice != 'N');
		// y�� n�� �ƴ� ���� do while�� ��� ���ư���
		// ���� y�� n�� �ԷµǸ� do while�� �������� �Ʒ��� �ڵ带 �����Ѵ�.
		if (choice == 'y' || choice == 'Y') {
			// �����߻�
			for (int i = 0; i < com.length; i++) {
				com[i] = (int) (Math.random() * 9) + 1; // 1���� 9����
				// �ߺ�üũ
				for (int k = 0; k < i; k++) {
					if (com[i] == com[k]) {
						// �ߺ���
						i--; // �ٽ� ���ư��� �ش� �ε������� ���� �̱�
						break;
					}
				} // for k
			} // for i
			
			// ���ӽ���
			while(true) {
				System.out.println("���� 3�� �Է�");
				for(int i = 0; i < user.length; i++) {
					user[i] = System.in.read() - '0';
					// ���� 0�� ���־�� ���ڸ� ���ڷ� �ٲ��� �� �ִ�. 
					// ���� 0�� ���� 0�� �ƽ�Ű�ڵ尡 �� 48���̰� ���� ����.
					// 48�� ���� ���ڿ��� ���ڷ� �ٲ��� �� �ִ�. 
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
				System.out.println(strike + "��Ʈ����ũ  " + ball + "��");
				if(strike == 3) {
					System.out.println("����. ���� ��");
					break;
				}
			}// while
		}
		System.out.println("���α׷� ���� ");

	}

}
