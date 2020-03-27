package day03;

import java.util.Scanner;

/* 
 * 별을 찍어봅시다 
 */
public class Ex08PrintStar {

	public static void main(String[] args) {
		//전통적으로 for문과 친해지는 예제인 별찍기를 해보자~
		
		Scanner scan = new Scanner(System.in);
		System.out.println("출력할 열의 수를 입력하세요 ");
		int n = scan.nextInt();
		
		System.out.println("==== 별찍기 1번 ====");
		for(int i = 1; i <= n; i++) { // 세로줄

			for(int k = 1; k <= i; k++) { // 가로줄
				System.out.print("*");
			}
			System.out.println(); // 가로줄 for문이 끝나면 다음 줄로 넘어갈 수 있게 
		}
		// 이거 다시 
		System.out.println("==== 별찍기 2번 ====");
		for(int i = 1; i <= n; i++) {
			String stars = "";
			for(int k = i; k <= n; k++) {
				stars += "*";
			}
			System.out.println(stars);
		}
		
		System.out.println("==== 별찍기 3번 ====");
		for(int i = 1; i <= n; i++) {
			String stars = "";
			// 3번 처럼 왼쪽에 공백이 있는 경우엔 
			// width for문 (k)이 height for문(i) 안에 2번 나온다. 
			// 먼저 공백을 넣는 for 문 하나 
			// 그 다음 별을 넣는 for 문 하나 
			for(int k = 1; k <= n-i; k++) {
				stars += " "; 
			}
			for(int k = 1; k <= i; k++) {
				stars += "*";
			}
			System.out.println(stars);
		}
		
		// 이거 다시 
		// number :
		// height :
		// width : 
		// stars : 
		System.out.println("==== 별찍기 4번 ====");
		for(int i = 1; i <= n; i++) {
			String stars = "";
			for(int k = 1; k <= i-1; k++) {
				stars += " ";
			}
			for(int k = i; k <= n; k++) {
				stars += "*";
			}
			System.out.println(stars);
		}
		
		System.out.println("==== 별찍기 5번 ====");
		for(int height = 1; height <= n; height++) {
			String stars = "";
			for(int width = 1; width <= n-height; width++) {
				stars += " ";
			}
			for(int width = 1; width <= 2*height -1; width++) {
				stars += "*";
			}
			System.out.println(stars);
			
		}
		// chojeyungbit@gmail.com으로 6~10 번 완성해서 보내기
		System.out.println("==== 벌찍기 6번 ====");
		// number :5
		// height : 1
		// width : 5
		// stars : ""
		for(int height = 1; height <= n; height++) {
			String stars = "";
			for(int width = 1; width <= n-height; width++) {
				stars += " ";
				
			}
			for(int width = height; width <= 2*n-1; width++) {
				stars += "*";
			}
			System.out.println(stars);
		}
		scan.close();

	}

}
