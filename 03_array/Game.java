/*
���� 
���������� ���� 
����(1)
����(2)
��(3)
��ǻ�ʹ� 1���� 3������ ������ �߻��մϴ�.
���� 1000������ ���� 

[������]
***********************
1. ����  2. ����  3.�� 
***********************
��ȣ �Է� : 2

���� �ݾ� : 200

����� ������ Enter�� �������� 
��ǻ�� : ����   �� : ����
You win! ����� �ݾ��� 1200���Դϴ�. 
You lose 
(������� �������������� �ݺ��ε�... �׳� 1������) 

*/
import java.util.Scanner;

class Game {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int betting = 0;
		int money = 1000; // �⺻ �ݾ� ( ���⼭ ������� ���� �ݾ��� ������)
		int gameMoney = money + betting; // �⺻ �ݾ� + ���õ�
//
//		System.out.println("����� ������ Enter�� �Է��ϼ��� ");
//		String enter = scan.nextLine();
//		
//		if (enter.equals(null)) {
//	

		System.out.println("***********************");
		System.out.println("1. ����  2. ����  3. �� ");
		System.out.println("***********************");
		System.out.print("��ȣ �Է� : ");
		int you = scan.nextInt();

		System.out.print("���� �ݾ� : ");
		betting = scan.nextInt();

		int com = (int) (Math.random() * 3) + 1; // 1���� 3���� ���� �߻� (��ǻ�� �� ����������)

		if (you == 1) { // ����� ������ �� ���
			if (com == 1) { // ��ǻ�Ͱ� ����
				System.out.println("��ǻ�� : ����   �� : ���� ");
				System.out.println("�����ϴ�.");
			} else if (com == 2) { // ��ǻ�Ͱ� ����
				System.out.println("��ǻ�� : ����   �� : ���� ");
				System.out.println("�����ϴ�.");
				gameMoney -= betting;
			} else if (com == 3) {
				System.out.println("��ǻ�� : ��    �� : ���� ");
				System.out.println("�̰���ϴ�. ����� " + gameMoney + " �� �Դϴ�. ");
			}

		} else if (you == 2) { // ����� ������ �� ���
			if (com == 1) { // ��ǻ�Ͱ� ����
				System.out.println("��ǻ�� : ����   �� : ���� ");
				System.out.println("�̰���ϴ�. ����� " + gameMoney + " �� �Դϴ�. ");
			} else if (com == 2) { // ��ǻ�Ͱ� ����
				System.out.println("��ǻ�� : ����   �� : ���� ");
				System.out.println("�����ϴ�.");
			} else if (com == 3) { // ��ǻ�Ͱ� ��
				System.out.println("��ǻ�� : ��   �� : ���� ");
				System.out.println("�����ϴ�.");
				gameMoney -= batting;
			}

		} else if (you == 3) { // ����� ���� �� ���
			if (com == 1) { // ��ǻ�Ͱ� ����
				System.out.println("��ǻ�� : ����   �� : �� ");
				System.out.println("�����ϴ�.");
				gameMoney -= batting;
			} else if (com == 2) { // ��ǻ�Ͱ� ����
				System.out.println("��ǻ�� : ����   �� : �� ");
				System.out.println("�̰���ϴ�. ����� " + gameMoney + " �� �Դϴ�. ");
			} else if (com == 3) { // ��ǻ�Ͱ� ��
				System.out.println("��ǻ�� : ��   �� : �� ");
				System.out.println("�����ϴ�.");
			}
		}
	}

}
