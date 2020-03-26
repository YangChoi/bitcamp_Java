package day02;

import java.util.Scanner;
/*
 * if문 조건식은 최종 결과값이 true 혹은 false가 나오기만 하면 된다. 
 * 즉, 여러 조건식을 묶어서 논리연산자로 묶어서 그 최종값에 따라 실행할지 말지를 정해주게 할 수도 있다. 
 */
public class Ex07 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("0부터 10사이의 숫자를 입력해주세요 : ");
		int number = scan.nextInt();
		scan.close();
		
		if(number >= 0 && number <= 10) {
			System.out.println("올바른 숫자를 입력하셨습니다.");
		}else {
			System.out.println("범위를 벗어난 숫자입니다.");
		}
		
		
	}

}
