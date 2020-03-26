package day02;

import java.util.Scanner;

/*
 * 점수를 입력받아서 
 * ABCDF를 보여주는 프로그램을 만들되 
 * 만약 1의 자리가 0~3이면 -
 * 			  4~6 이면 0
 *            7~9이면 +
 *            100점이면 A+이 뜨는 프로그램을 작성
 * 예시) 점수를 입력하세요 : 78
 * 		C+
 */
public class Ex12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수를 입력하시오 ");
		int score = scan.nextInt();
		if (score >= 0 && score <= 100) {
			if (score == 100) {
				System.out.println("A+");

			} else if (score > 59) {
				if (score >= 90) {
					System.out.print("A");
				} else if (score >= 80) {
					System.out.print("B");
				} else if (score >= 70) {
					System.out.print("C");
				} else if (score >= 60) {
					System.out.print("D");
				}
				
				// 10의 자리 수 이기 때문에 10을 나누면 1의 자리 수가 되므로 그것을 이용한 것 
				
				if (score % 10 >= 7) {
					System.out.println("+");
				} else if (score % 10 >= 4) {
					System.out.println("0");
				} else {
					System.out.println("-");
				}

			} else {
				// 점수가 올바른 형태이고
				// 59점 작거나 같을 때
				System.out.println("F");
			}

		} else {
			System.out.println("올바른 점수를 입력해주세요 ");

		}
		scan.close();

	}

}
