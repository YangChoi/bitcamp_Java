package day04;

import java.util.Scanner;

/*
 * 별찍어주는 프로그램
 * 사용자가 몇번을 선택하냐에 따라서 
 * 실행되는 메소드가 달라지게 만들어 보자 
 */
public class StarPrinterEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("별 찍어주는 프로그램");
		
		System.out.print("출력할 별의 번호를 입력해주세요 : ");
		int choice = scan.nextInt();
		
		System.out.print("출력할 줄의 수를 입력해주세요 : ");
		int lineNumber = scan.nextInt();
		StarPrinter sp = new StarPrinter();
		//sp.starPrinter1();
		// private이기 때문에 메소드가 없다. 
		sp.selectNumber(choice, lineNumber);
		// selectNumber로 넘어가서 choice와 lineNumber를 받아 그 쪽 클래스 안의 starPrint1을 실행하게 된다. 
		
		scan.close();

	}

}
