import java.util.Scanner;

class StringMain2 {
	// ���� 
	// indexOf(?, ?) ���� �ΰ� ���� �� ã�Ƽ� ���� 
	public static void main(String[] args){
		// ġȯ : replace
		Scanner scan = new Scanner(System.in);
		
		int index = 0; 
		int count = 0; 
		String str, find, change; 
		String result;
		
		System.out.print("���ڿ� �Է� : ");
		str = scan.next();
		System.out.print("���� ���ڿ� �Է� : ");
		find = scan.next();
		System.out.print("�ٲ� ���ڿ� �Է� : ");
		change = scan.next();
		
		if(str.length() < find.length()){
			System.out.println("�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�");

		}else {
			str = str.toLowerCase(); // �Է¹��� ���ڿ��� �ҹ��ڷ� �ٲٱ� 
			find = find.toLowerCase(); // ���� ���ڿ��� �ҹ��ڷ� 
			
			while((index = str.indexOf(find, index)) != -1){ // ������ ��ġ����(index) ���ڸ� ã�ƶ� 
			// �׸��� ã�� ���� �ٽ� index�� �ش�. 
			// ���� ã�� ���ؼ� -1�� ������ ��찡 �ƴϸ� while���� ���ư��� 
				index += find.length();
				// �ε������� ã�����ϴ� ���ڿ��� ���̸� ���ؼ� �ٽ� �� find�� ã�´� 
				count++;
				// �ѹ� ã�� ������ count�� 1���Ѵ� 
			} // while 

			System.out.println(str.replace(find, change));
			// find�� ã�Ƽ� change�� �ٲ�� 
			System.out.println(count + "ȸ ġȯ " );


		}
	

		 
	}
}