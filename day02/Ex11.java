package day02;

import java.util.Scanner;

/*
 * 사용자로부터 점수를 입력받아서 
 * A B C D F 가 뜨는 프로그램을 만드세요 
 */
public class Ex11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수를 입력해주세요 ");
		int score = scan.nextInt();
		scan.close();
		
		if(score >= 0 && score <=100) {
			// 올바른 점수 일 때 
			if(score >= 90) {
				System.out.println("A");
			}else if(score >= 80) {
				System.out.println("B");
			}else if(score >= 70) {
				System.out.println("C");
			}else if(score >= 60) {
				System.out.println("D");
			}else {
				System.out.println("F");
			}
		}else {
			// 잘못된 점수인 경우 
			System.out.println("올바르지 않은 점수입니다 ");
		}

	}
	
	// 사용자가 잘못된 점수를 입력할 수도 있기 때문에 
	// 이를 대비하기 위해 2가지 방법이 가능하다. 
	// 1. 정확한 결과가 나올 수 있도록 범위를 깐깐하게 잡는다. 
	// 2. 중첩 if문을 사용해서 처음부터 잘못된 값이 들어올 수 없게 한다. 
	//		중첩 if문이란 
	//		if 문 안에 if 문 혹은 else 문 안에 if문 넣는 것(위에 내가 한거)
	

}
