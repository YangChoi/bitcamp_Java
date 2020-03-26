package day02;

import java.util.Scanner;

/*
 * 사용자로 부터 입력을 받아서 printf를 사용해 점수들을 출력해보자 
 * pritnf 코드는 Ex02에서 가져오자 
 */
public class Ex04 {
	
	private final static int NUMBER_OF_SUBJECT = 5;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		// 현재 버퍼메모리가 비어있는 상황이기 때문에 비워줄 필요가 없다. 
		
		System.out.print("나이: ");
		int age = scan.nextInt();
		
		System.out.print("국어 점수: ");		
		int korean = scan.nextInt();
		
		System.out.print("수학 점수: ");
		int math = scan.nextInt();
		
		System.out.print("영어 점수: ");
		int english = scan.nextInt();
		
		System.out.print("역사 점수: ");
		int history = scan.nextInt();
		
		System.out.print("프로그래밍 점수: ");
		int programming = scan.nextInt();
		
		scan.close();
		
		int sum = korean + math + english + history + programming;
		double avg = sum/(NUMBER_OF_SUBJECT*1.0); 
		
		System.out.println("===점수표===");
		System.out.printf("이름: %s, 나이:%02d세 "
				+ "\n국어:%02d점, 영어 :%02d점, 수학:%02d점, 역사: %02d점, 프로그래밍: %02d점 "
				+ "\n총점: %03d점, 평균:%05.2f점",
				name, age, korean, english, math, history, programming, sum, avg);

	}

}
