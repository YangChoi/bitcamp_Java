import java.util.Scanner;

class Assert{
	private int x, y; 
	int result;

	
	// x�� y�� �Է¹޴� input
	public void input(){
		Scanner scan = new Scanner(System.in);
		System.out.print("x�� �Է��Ͻÿ� : ");
		x = scan.nextInt();
		System.out.print("y�� �Է��Ͻÿ� : ");
		y = scan.nextInt();

	}
	// x^y�� ���ϰ� ����ϴ� output
	public void output(){
		assert y >= 0 : "y�� 0���� ũ�ų� ���ƾ��Ѵ�"; // Ʋ���� ���߰� ������ ������ ������ 
		// : ���� �޼��� �ֱ� 
		result = 1;
		for(int i = 1; i <= y; i++){
			result *= x;
		}
		System.out.println(result);
	}

	public static void main(String[] args){
		Assert as = new Assert();
		as.input();
		as.output();
	}
}