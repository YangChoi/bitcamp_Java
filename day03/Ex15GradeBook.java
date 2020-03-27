package day03;

import java.util.Scanner;

/*
 * 성적관리 프로그램 무한루프 버전 
 * 사용자가 점수 입력하면 가지고 있다가 
 * 출력할 때 printf를 통해서 출력한다. 
 * 
 * 조건 1. 만약 시작하자마자 출력누르면 정보가 입력되지 않았습니다. 라고 출력되게 
 * 조건 2. 만약 올바르지 않은 형태의 점수가 들어오면 다시 입력해주세요 가 출력되게 
 * 조건 3. 메뉴에서 3을 누르면 프로그램 종료 
 * 
 */
public class Ex15GradeBook {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int korean = -1;
		int math = -1; 
		int english = -1; 
		// 이 3줄이 while 문 안에 있는 순간, -1로 다시 초기화 
		// 그렇기 때문에 while 문 밖에 있어야한다. 
		String name = "";
		
		
		while(true) {
			System.out.println("1. 입력   2. 출력   3. 종료");
			System.out.print(">>");
			int choice = scan.nextInt();
		
			int score = 0;	// 입력한 성적
			int grade = 0;  // 저장된 성적
			
			if(choice == 1) {
				// 성적을 입력하는 코드를 여기에 구현
				System.out.print("이름 : ");
				scan.nextLine();
				// 들어오기 전에 1 을 눌렀기 때문에 엔터키가 들어가 있어 버퍼를 비워줘야한다. 
				name = scan.nextLine();
				
				System.out.print("국어 : ");
				korean = scan.nextInt();
				while(Ex16Method.validate(korean)) {
					System.out.println("잘못된 점수 입니다. ");
					System.out.print("국어 : ");
					korean = scan.nextInt();
				}
				System.out.print("수학 : ");
				math = scan.nextInt();
				while(Ex16Method.validate(math)) {
					System.out.println("잘못된 점수 입니다. ");
					System.out.print("수학 : ");
					math = scan.nextInt();
				}
				
				System.out.print("영어 : ");
				english = scan.nextInt();
				while(Ex16Method.validate(english)) {
					System.out.println("잘못된 점수 입니다. ");
					System.out.print("영어 : ");
					english = scan.nextInt();
				}
		
			}else if(choice == 2) {
				// 성적을 출력하는 코드를 여기에 구현
				if(korean == -1) {
					// -1은 불가능한 점수 
					System.out.println("입력된 정보가 없습니다. ");
				}else {
					int total = korean + math + english;
					double average = total/3.0;
					System.out.printf("이름 :%s, 국어 : %3d점 , 수학 : %3d점, 영어 : %3d점, "
							+ "총점 : %3d점, 평균 : %.3f점\n",
							name, korean, math, english, total, average);
				}
	
			}else if(choice == 3) {
				System.out.println("나감");
				break;
			}else {
				System.out.println("잘못 입력");
			}
		}
		scan.close();
	}
	

}
