import java.io.IOException;
import java.util.Scanner;

class BaseBall {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int com[] = new int[3];
		int user[] = new int[3];
		int choice;
		int strike, ball;

		// 게임 실행 여부 묻기
		do{
			System.out.print("게임을 실행하겠습니까? (y/n) : ");
			choice = System.in.read();
			System.in.read();
			System.in.read();
		}while(choice!='Y' && choice!='y' && choice!='N'&& choice!='n');

		if(choice=='Y' || choice=='y'){
			//난수 발생
			for (int i=0; i<com.length; i++) {
				com[i] = (int)(Math.random() * 9) + 1;

				//중복 체크
				for (int k=0; k<i; k++) {
					if (com[i] == com[k]) {
						i--;
						break;
					}
				}//for k
			}//for i
			//System.out.println(com[0]+","+com[1]+","+com[2]);
			
			//게임 시작
			while(true){
				System.out.print("숫자 3개 입력 : ");
				for(int i=0; i<user.length; i++){
					user[i] = System.in.read()-'0';
				}//for i
				System.in.read();
				System.in.read();
				
				strike = ball = 0;
				for (int i = 0; i < com.length; i++) {
					for (int k = 0; k < user.length; k++) {
						if(com[i] == user[k]){
							if(i == k) strike++;
							else ball++;
						}
					}
				}
				System.out.println(strike + "스트라이크   " + ball + "볼");
				if(strike == 3) {
					System.out.println("삼진! 게임 끝 ");
					break; // while문 나감 
				}

			}//while

		}

		System.out.println("프로그램을 종료합니다");

	}
}
