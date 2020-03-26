package day02;

import java.util.Scanner;

/*
 * 사용자가 숫자를 입력하면 홀수인지 짝수인지 
 * 보여주는 프로그램
 */
public class Ex06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자를 입력하시오 :  ");
		int input = scan.nextInt();
		
		scan.close();
		
		if(input%2 == 0) {
			if(input == 0) {
				System.out.println("0이다");
			}else {
				System.out.println("짝수이다");
			}
		}
		
		if(input%2 == 1){
			System.out.println("홀수이다. ");
		}

	}

}
