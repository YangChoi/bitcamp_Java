package day03;

import java.util.Scanner;

/*
 * 사용자가 값을 2개 입력하면 
 * 그 숫자들 사이의 모든 수의 합을 구해주는 프로그램 
 * 만약 1, 5라고 입력하면 
 * 1+ 2+ 3+ 4+ 5 =  15
 */
public class Ex05For {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하라 : ");
		int num1 = scan.nextInt();
		
		System.out.print("두번째 숫자를 입력하라 : ");
		int num2 = scan.nextInt();
		int sum = 0; // for문 밖에 선언해서 for문 밖에서도 사용할 수 있게 하자 
		
		// 만약 사용자가 첫번째 숫자를 더 큰 값을 넣으면 
		// for 문 자체가 실행되지 않는다. 
		// 따라서 첫번째 숫자와 두번째 숫자를 비교해서 
		// 만약에 첫번째 숫자가 더 크면 두개의 순서를 바꿔주면 된다. 
		
		if(num1 > num2) {
			// 프로그래밍에서 두 숫자의 값을 교환하려면 
			// 중간에 값을 임시로 저장해야한다. 
			int temp = num1;
			num1 = num2; 
			num2 = temp;
//			num1 = num2; 
//			num2 = num1; // 안되는 코드 
		}
		for(int i = num1; i <= num2; i++) {
			sum += i; // sum = sum + i
		}
		System.out.println(sum);
		scan.close();
	}

}
