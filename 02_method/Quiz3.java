import java.util.Scanner;

/*
�л��� �̸��� ������� �Է¹޾Ƽ� ������ ���Ͻÿ� 

�̸� �Է� : ȫ�浿
����� �Է�: 12313
charAt���� �ѱ��� �ѱ��� ������ 
�̸�  1 2 3 4 5 ���� 
ȫ�浿 O X X O X 40
*/
class Quiz3 {
	public static final String ANSWER = "11111"; // ���ȭ 
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		String name; //�̸�
		String input; // �л��� ��
		int score; // ���� 
		char[] ox = new char[ANSWER.length()]; // ������ �ƴ��� 

		System.out.println("�̸��� �Է��Ͻÿ�");
		name = scan.nextLine();

		System.out.println("�� 5���� �Է��Ͻÿ�");
		input = scan.nextLine();
		
		// answer�� input�� ���ؾ��Ѵ�. 
		// �׸��� ��ġ�ϴ� ������ count�ؼ� ���
		score = 0;
		for(int i = 0; i < 5; i++){
			if(input.charAt(i) == ANSWER.charAt(i)){
				ox[i] = 'O';
				score++;
			}else {
				ox[i] = 'X';

			}
		}
		System.out.println("�̸�\t1\t2\t3\t4\t5\t����");
		System.out.println(name+"\t"+
							ox[0]+"\t"+
							ox[1]+"\t"+
							ox[2]+"\t"+
							ox[3]+"\t"+
							ox[4]+"\t"+
							(score*20));
	}
}