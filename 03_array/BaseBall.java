// �迭 ���� 
import java.io.IOException;
import java.util.Scanner;

class BaseBall{
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		
		int com[] = new int[3];
		int user[] = new int[3];
		
		int choice; 
		int strike, ball;

		// ���� ���� ���� ���� 
		do {
			System.out.print("������ �����ϰڽ��ϱ�? (y/n)");
			choice = System.in.read(); // �� �� ���� ���� 
			// System.in.read �ϸ� int �� ���� 
			// ���� choice�� int�� �������־���� 
			// �׷��� �� ���� : ������ ���� >> ����� ����ó�� �϶�... throw IOException
			System.in.read();
			System.in.read(); // �÷��� ó�� (�ٹٲ�, ù�ٷ� ���� �Ա�

		}while(choice != 'Y' && choice != 'y' && choice != 'N' && choice != 'n');
			// y�� n�Է½� ���� 
			if(choice == 'Y' || choice == 'y'){
				// ���� ����
				// �����߻� 
				for (int i = 0; i < com.length; i++) {
					com[i] = (int) (Math.random() * 9) + 1;
					// �ߺ� üũ 
					for (int k = 0; k < i; k++) {
						if (com[i] == com[k]) {
							i--; // ���� ���ڰ� ������, i�� ���� ������ �ٽ� ���� �߻� 
							break;
					}
				}// for k 
			}// for i

			// ���� ����
			while(true){
				System.out.print("���ڸ� ���� �Է����ּ��� : ");
				for(int i = 0; i < user.length; i++){
					user[i] = System.in.read()-'0';
					// System.in.read�� ���ؼ� ���ڸ� ���ڷ� �Է��ؼ� �ƽ�Ű���� ����� �ȴ�. 
					// 0�� �� ���°Ŷ��??????

				} // for i 
				System.in.read();
				System.in.read(); // ����ó��
				
				strike = 0;
				ball = 0;
				for(int i = 0; i < com.length; i++){
					for(int k = 0; k < user.length; k++){
						if(com[i] == user[k]){
							if(i == k){
								// ��Ұ��� �ε��� ������ ��Ʈ����ũ
								strike++;
							}else{
								// ��� ���� �ε��� �ٸ��� �� 
								ball++;
							}
						}
					}
					System.out.println(strike+ "��Ʈ����ũ" + ball + "��");
					
					if(strike == 3){
						System.out.println("����! ���� ��");
						break; // while ����
					}
				}

			} // while
		
		}
			System.out.println("���α׷��� �����մϴ�");
	}
}