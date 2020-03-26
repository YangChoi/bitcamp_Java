package day02;

import java.util.Scanner;
/*
 * 사용자로 부터 국영수 점수를 입력받아서 
 * 한개의 과목이라도 60점 미만이거나 총점이 210점 미만이면 탈락 이라고 출력
 */
public class Ex08 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("국어 점수 : ");
		int korean = scan.nextInt();
		
		System.out.print("수학 점수 : ");
		int math = scan.nextInt();
		
		System.out.print("영어 점수 : ");
		int english = scan.nextInt();
		
		scan.close();
		
		int sum = korean + math + english;
		
		if(sum >= 210 && korean >= 60 && math >= 60 && english >= 60) {
			System.out.println("합격!");
		}else {
			System.out.println("불합격");
		}
		
	}

}
