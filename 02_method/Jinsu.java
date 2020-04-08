// 10 진수를 입력받아서 2진수, 8진수, 16진수로 출력하기 
// Integer class에 변환시켜주는 메소드 찾기 
import java.util.Scanner;

class Jinsu {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("10진수 입력 :" );
	int n = scan.nextInt();

	String binary = Integer.toBinaryString(n);
	String oct = Integer.toOctalString(n);
	String hexa = Integer.toHexString(n);

	System.out.println("2진수 = " + binary);
	System.out.println("8진수 = " + oct);
	System.out.println("16진수 = " + hexa);

	
	}
}