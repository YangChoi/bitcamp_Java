package day03;

import java.util.Scanner;

/*
 * 이번엔 의도적으로 break를 생략해서 
 * 내가 원하는 값이 나오게 코딩해보자 
 */
public class Ex02Switch02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("월을 입력해주세요 ");
		int month = scan.nextInt();
		scan.close();
		
		switch(month) {
	
		case 2:
			System.out.println("28일까지입니다");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30일까지 입니다");
			break;
			default:
				System.out.println("31일까지 입니다");
			
		}

	}

}
