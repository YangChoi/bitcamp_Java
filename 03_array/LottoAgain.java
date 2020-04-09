/*
�� �Է� : 3000
��ȣ ���� 
�� �ٴ� 
�� �ٴ� 
(1000�� �� ����)
���忡 5�� ( �� ĭ ���� )
*/
import java.util.Scanner;
import java.util.Arrays;

class LottoAgain{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int[] lotto = new int[6];

		System.out.print(" �� �Է� : " );
		int money = scan.nextInt();
		int count = money/1000;

		// �ݾ׸�ŭ ��� 
		for(int time = 0; time < count; time++){
			// ���� 1~ 45 ���� �߻� & �ߺ� ����  
			for(int i = 0; i < lotto.length; i++){
				lotto[i] = (int)(Math.random()*45)+1;
				for(int k = 0; k < i; k++){
					if(lotto[i] == lotto[k]){
						i--; // ���� ���ڰ� ���ͼ� �ٽ� ������ �߻���Ű�� ������ 
						// for���� ������ �Ǹ� �ڵ������� ++�� �Ǳ� ������ 
						// �ٽ� ���� index�� ������ ������� --�� �ؼ� ++ �����������. 
						break; // for k ���� 
					}
				}// for k 
			}// for i 
		 // sort �ϱ� 
		 Arrays.sort(lotto);

		
			// ���(Ȯ���� for���� ������ַ�) 
			for(int data : lotto){
				System.out.print(String.format("%-5d", data)); // ������ 5�ڸ��� ������ ��� ��������(-)�ؼ� ��� 
				
			}
			System.out.println();

			// ��� ( 5�ٿ� �� �� �Ѿ )
			if (time % 5 == 0){
				System.out.println("        ");
			}

	}// for time 
	}
}

/*
���� %d
�Ǽ� %f
*/
