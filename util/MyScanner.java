package util;
/*
 * 버퍼 메모리 지운다고 매번 썼던 scanner.nextLine();을 해주는 클래스 만듦
 */
import java.util.Scanner;

public class MyScanner {
	
	public static int nextInt(Scanner scanner) {
		int userNumber = scanner.nextInt();
		scanner.nextLine();
		return userNumber;

	}

}
