import java.util.Scanner;

class Examination{
	private String name; 
	private String dap;
	private char[] ox;
	private int score; 
	private static final String JUNG = "11111";
	
	// ������ - ������ �Է¹ޱ�
	public Examination(){
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		this.name = scan.next();
		System.out.print("�� �Է� : ");
		this.dap = scan.next(); // this���� ����

		ox = new char[5]; // �迭�� ���⼭ �����ϴ±���..
}
	
	public void compare(){
		for(int i = 0; i < ox.length; i++){ // dap.length()
			if(dap.charAt(i) == JUNG.charAt(i)){
				ox[i] = 'O';
				score += 20; // ���� ������ ���� 20�� �÷��� 
			}else {
				ox[i] = 'X';
			}	
		}
	}

	// getter
	public String getName(){
		return name;
	}

	public char[] getOx(){
		return ox;
	}
	
	public int getScore(){
		return score;
	}

}

class ExaminationMain2{
	public static void main(String[] args){
	Scanner scan = new Scanner(System.in);

	System.out.print("�ο��� �Է� :");
	int count = scan.nextInt();

	Examination[] arr = new Examination[count];
	
		for(int i = 0; i < count; i++){
			arr[i] = new Examination(); // ������ �ް� �� �����
			arr[i].compare();
			System.out.println();
		}
	// ��� 
		System.out.println("�̸�\t1 2 3 4 5\t����");
		for(int i = 0; i < count; i++){
			System.out.print(arr[i].getName()+"\t");
			
			for(int k = 0; k < arr[i].getOx().length; k++){
					System.out.print(arr[i].getOx()[k]+" ");
			}// for k
			System.out.println("\t"+arr[i].getScore()+"\t");
		}// for i
	}
}
