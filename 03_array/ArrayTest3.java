// ������ ���� 
// 1. ���� 
// 2. ���� 
// 3. ��� (���� ��� �ֳ�)
// 4. ��


// ��ȣ : 

import java.util.Scanner;
class ArrayTest3{
	public static void main(String[] args){
		// ���� ������ t/ ������ f
		// �� 5�븸 ������ �� �ִ� ���� : �迭 
		boolean[] car = new boolean[5]; // �� 5�� 
		Scanner scan = new Scanner(System.in);
		// �迭�� GARBAGE�� �ȵ�� ����
		// �׷��� ������ �ʱⰪ���� FALSE�� ����ִ�. 
	
		// �迭���� 0��°�� ������� 1��°�̴�.
		// �׷��� ������ ������� ���� ���� INDEX+1 �Ǿ���� 
		while(true){
			System.out.println("1. ����  2. ����  3. ���  4. ��");
			int input = scan.nextInt();

			if(input == 1){
				//����
				System.out.println("������ ��ġ�� �Է����ּ��� ");
				int in = scan.nextInt();
				
				if(car[in-1] == true){ // if���� ����ֱ� ������ car[in-1] ��ü�� �� ������ �� �� �־ == true �Ƚᵵ �ȴ�. 
					System.out.println(in + "��° ��ġ�� ���� �Ұ��մϴ�.");
				}else {
					System.out.println(in + "��° ��ġ�� �����Ͽ����ϴ�. ");	
					car[in-1] = true; // ������ 
				}
				

			}else if(input == 2 ) {
				// ����
				System.out.println("������ ��ġ�� �Է��ϼ���");
				int out = scan.nextInt();

					if(car[out-1]){
						car[out-1] = false; // ���� 
						System.out.println((out-1) + "��ġ�� ���� �����մϴ�");
					}else {
						System.out.println("�ش� �ڸ��� �����Ǿ����� �ʽ��ϴ�. ");
					}
			
				

			}else if(input == 3) {
				// ���
				System.out.println("����Դϴ�");
				for(int i = 0; i < car.length; i++){
					System.out.println((i+1) + "��° ��ġ : " + car[i]);
				} // for

			}else if(input == 4){
				// ��
				break;
			}
		}
	}
}
