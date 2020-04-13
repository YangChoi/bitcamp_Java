/*
숙제 
가위바위보 게임 
가위(1)
바위(2)
보(3)
컴퓨터는 1부터 3사이의 난수를 발생합니다.
돈은 1000원으로 시작 

[실행결과]
***********************
1. 가위  2. 바위  3.보 
***********************
번호 입력 : 2

배팅 금액 : 200

결과를 보려면 Enter를 누르세요 
컴퓨터 : 가위   나 : 바위
You win! 당신의 금액은 1200원입니다. 
You lose 
(원래라면 돈떨어질때까지 반복인데... 그냥 1번만해) 

*/
import java.util.Scanner;

class Game {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int betting = 0;
		int money = 1000; // 기본 금액 ( 여기서 사용자의 배팅 금액이 합쳐짐)
		int gameMoney = money + betting; // 기본 금액 + 배팅돈
//
//		System.out.println("결과를 보려면 Enter를 입력하세요 ");
//		String enter = scan.nextLine();
//		
//		if (enter.equals(null)) {
//	

		System.out.println("***********************");
		System.out.println("1. 가위  2. 바위  3. 보 ");
		System.out.println("***********************");
		System.out.print("번호 입력 : ");
		int you = scan.nextInt();

		System.out.print("배팅 금액 : ");
		betting = scan.nextInt();

		int com = (int) (Math.random() * 3) + 1; // 1에서 3까지 난수 발생 (컴퓨터 쪽 가위바위보)

		if (you == 1) { // 당신이 가위를 낸 경우
			if (com == 1) { // 컴퓨터가 가위
				System.out.println("컴퓨터 : 가위   나 : 가위 ");
				System.out.println("비겼습니다.");
			} else if (com == 2) { // 컴퓨터가 바위
				System.out.println("컴퓨터 : 바위   나 : 가위 ");
				System.out.println("졌습니다.");
				gameMoney -= betting;
			} else if (com == 3) {
				System.out.println("컴퓨터 : 보    나 : 가위 ");
				System.out.println("이겼습니다. 상금은 " + gameMoney + " 원 입니다. ");
			}

		} else if (you == 2) { // 당신이 바위를 낸 경우
			if (com == 1) { // 컴퓨터가 가위
				System.out.println("컴퓨터 : 가위   나 : 바위 ");
				System.out.println("이겼습니다. 상금은 " + gameMoney + " 원 입니다. ");
			} else if (com == 2) { // 컴퓨터가 바위
				System.out.println("컴퓨터 : 바위   나 : 바위 ");
				System.out.println("비겼습니다.");
			} else if (com == 3) { // 컴퓨터가 보
				System.out.println("컴퓨터 : 보   나 : 바위 ");
				System.out.println("졌습니다.");
				gameMoney -= batting;
			}

		} else if (you == 3) { // 당신이 보를 낸 경우
			if (com == 1) { // 컴퓨터가 가위
				System.out.println("컴퓨터 : 가위   나 : 보 ");
				System.out.println("졌습니다.");
				gameMoney -= batting;
			} else if (com == 2) { // 컴퓨터가 바위
				System.out.println("컴퓨터 : 바위   나 : 보 ");
				System.out.println("이겼습니다. 상금은 " + gameMoney + " 원 입니다. ");
			} else if (com == 3) { // 컴퓨터가 보
				System.out.println("컴퓨터 : 보   나 : 보 ");
				System.out.println("비겼습니다.");
			}
		}
	}

}
