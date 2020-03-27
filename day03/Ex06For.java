package day03;

import java.util.Scanner;

/*
 * 팩토리얼을 구하는 프로그램을 만들자 
 * 팩토리얼이란 1부터 n까지의 곱을 말한다. 
 */
public class Ex06For {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int result = 1;
		// 15!은 int의 범위를 벗어나게 된다.
		// 따라서 15이상의 값을 넣으면 경고 메세지 출력해주자
		if (n < 15) {
			for (int i = 1; i <= n; i++) {
				result *= i;
				System.out.println(result);
			}
		} else {
			System.out.println("범위를 벗어난 숫자입니다. ");

		}
		scan.close();

	}

}
