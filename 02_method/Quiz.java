/*
1���� 100 �߿��� ������ �ϳ� �߻��� ���ߴ� ���� 

[������] 
1 ~ 100 ���̿� ������ �߻��Ͽ����ϴ�. ( �� : 85)  
���� �Է� : 50 
50���� Ů�ϴ�.

���� �Է� : 90
90���� �۽��ϴ�. 
...

�����Դϴ�!
xxx �� ���߼̽��ϴ�. 
*/
import java.util.Scanner;

class Quiz {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int num = (int)(Math.random()*100)+1;  // 1���� 100���� 
		// int num = (int)(Math.random()*(���� - ���۰� +1))+���۰�;
		int answer; // �Է¹��� ��
		System.out.println("1�� 100 ���̿� ������ �߻��Ͽ����ϴ�. " );
		
		int count = 0; 
		while(true){
			System.out.print("���� �Է� : ");
			answer = scan.nextInt();

			if(answer > num) {
				System.out.println(answer + "���� �۽��ϴ�.");
				count++;
			}else if (answer < num) {
				System.out.println(answer + "���� Ů�ϴ�");
				count++;
			}else if(answer == num) {
				// ����		
				break;
			}
		}
		System.out.println("�����Դϴ�");
		System.out.println(count + "�� ���߼̽��ϴ�");
	}
}