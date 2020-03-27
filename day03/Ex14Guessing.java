package day03;

import java.util.Random;
import java.util.Scanner;

/*
 * 숫자 맞추기 게임
 * 자바에 기본적으로 랜덤한 숫자를 만들어주는 
 * java.util.Random 클래스로 
 * 랜덤한 숫자를 하나 만들어서 
 * 사용자가 그 숫자를 맞추는 게임을 만들어봅시다. 
 * 만약 컴퓨터가 15라는 숫자를 뽑아냈고 
 * 사용자가 20이라고 입력하면 DOWN이라는 글자가 뜨고 
 * 
 * Count는 1늘어나서 
 * 사용자가 계속 입력하다가 15라는 숫자를 맞추면 성공! 하며 count(= 점수) 보여주는 게임 
 */
public class Ex14Guessing {
	private static final int MAX = 100;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int highScore = 0;
		
		
		while(true) {
			System.out.println("숫자 맞추기 게임 ");
			System.out.println("1. 새로하기   2. 최고점수 보기   3. 종료");
			System.out.print(">>");
			int choice = scan.nextInt();
			
			if(choice == 1 ) {
				// 게임 
				
				// random을 이용해서 숫자 하나 만들어준다. 
				// 근데 1~2^31-1까지이면? 맞추기 어렵다. 
				// 따라서 한계값을 정해준다. 
				// 한계값을 정해줄땐 
				// random의 해당 데이터타입 next메소드를 실행하면서 
				// 괄호 안의 최대값을 적어주면 
				// 0~ 최대값-1까지의 값이 하나 랜덤하게 나온다. 
				// 그럼 우리가 무슨 값이 나올지 모르지만 
				// 나온 값 +1 하면 1~100 사이의 숫자가 나오지 않을까?
				int computerNumber = random.nextInt(MAX)+1; // 랜덤한 수 
				int score = 1; 
				int userNumber = -1; // -1을 누르면 종료시킬 것이기 때문 
				// 왜 -1인가..
				while(userNumber != computerNumber) {
					System.out.println("숫자를 입력하세요 (-1은 종료) ");
					System.out.print(">>");
					userNumber = scan.nextInt();
					
					if(userNumber == -1) {
						break; 
					}
					if(userNumber > computerNumber) {
						System.out.println("DOWN");
					}else if(userNumber < computerNumber) {
						System.out.println("UP");
					}else if(userNumber == computerNumber) {
						System.out.println("정답!");
						System.out.println("점수 : " + score);
						if(score > highScore || highScore == 0) {
							highScore = score;
						}
					
					}
					score++;
				}

			}else if(choice == 2) {
				// highScore 출력

				if(highScore == 0) {
					System.out.println("아직 플레이 기록이 없습니다.");
				}else {
					System.out.println("최고 점수 : " + highScore);
				}
				
			}else if(choice == 3) {
				System.out.println("종료");
				break;
			}
			
		}

		scan.close();
	}

}
