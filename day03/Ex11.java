package day03;

import java.util.Scanner;

/*
 * 사용자로부터 점수를 입력받아서 
 * A B C D F가 뜨는 프로그램을 작성하시오 
 * 단, 사용자가 올바르지 않은 점수를 입력하면 
 * 올바른 점수를 입력할 때까지 계속 입력을 받으세요 
 */
public class Ex11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		

		System.out.print("점수를 입력해주세요 ");
		int score = scan.nextInt();
		
		while(score <= 0 || score >= 100) {
			// score가 0보다 작거나(or) 100보다 크면 올바르지 않음. 
			System.out.println("점수가 올바르지 않습니다. 다시 입력해주세요 ");
			score = scan.nextInt();
		}
		
		if(score >= 90) {
			System.out.println('A');
		}else if(score >= 80) {
			System.out.println('B');
		}else if(score >= 70) {
			System.out.println('C');
		}else if(score >= 60) {
			System.out.println('D');
		}else {
			System.out.println('F');
		}
		
		

	}

}
