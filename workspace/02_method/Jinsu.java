// 10 ������ �Է¹޾Ƽ� 2����, 8����, 16������ ����ϱ� 
// Integer class�� ��ȯ�����ִ� �޼ҵ� ã�� 
import java.util.Scanner;

class Jinsu {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("10���� �Է� :" );
	int n = scan.nextInt();

	String binary = Integer.toBinaryString(n);
	String oct = Integer.toOctalString(n);
	String hexa = Integer.toHexString(n);

	System.out.println("2���� = " + binary);
	System.out.println("8���� = " + oct);
	System.out.println("16���� = " + hexa);

	
	}
}