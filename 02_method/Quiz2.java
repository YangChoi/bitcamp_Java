/*
���� 10���� 99������ ������ 2�� �߻��Ͽ� ���� ���ߴ� ���� 

*/
import java.util.Scanner;
class Quiz2 {
	public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	int a,b;
	int user; 
	int count = 0;

	System.out.println("������ ���� ���߾�� ");
	// 5���� ������ 
	for(int i = 1; i <=5; i++){
		a = (int)(Math.random()*90)+10; // 10���� 99���� 
		b = (int)(Math.random()*90)+10;
		
		for(int k = 1; k <= 2; k++){ // Ʋ���� �� 1�� �� ��ȸ 

		System.out.print("["+ i + "]" + a + "+" + b + "=");
		user = scan.nextInt();
		
		if(user == (a+b)) {
			
			System.out.println("�� ���߾��");
			count++;
			break; // k for�� ���� 
		
		}else{
			if(k == 1){	
				System.out.println("�ٽ� �ѹ� �� ");

			}else {
				System.out.println("Ʋ�Ƚ��ϴ�. ������" + (a+b) + "�Դϴ�. ");			
					}
				} 
			}// for k 
		}// for i 
		System.out.println("����� ������ "+ count + "���� ���缭 " + (count*20) + "�� �Դϴ�");
		
		}
	}
