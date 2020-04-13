// 배열 문제 
import java.io.IOException;
import java.util.Scanner;

class BaseBall{
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		
		int com[] = new int[3];
		int user[] = new int[3];
		
		int choice; 
		int strike, ball;

		// 게임 실행 여부 묻기 
		do {
			System.out.print("게임을 실행하겠습니까? (y/n)");
			choice = System.in.read(); // 딱 한 글자 들어옴 
			// System.in.read 하면 int 형 나옴 
			// 따라서 choice를 int로 선언해주어야함 
			// 그런데 또 에러 : 컴파일 에러 >> 입출력 예외처리 하라... throw IOException
			System.in.read();
			System.in.read(); // 플러시 처리 (줄바꿈, 첫줄로 가기 먹기

		}while(choice != 'Y' && choice != 'y' && choice != 'N' && choice != 'n');
			// y나 n입력시 실행 
			if(choice == 'Y' || choice == 'y'){
				// 게임 실행
				// 난수발생 
				for (int i = 0; i < com.length; i++) {
					com[i] = (int) (Math.random() * 9) + 1;
					// 중복 체크 
					for (int k = 0; k < i; k++) {
						if (com[i] == com[k]) {
							i--; // 같은 숫자가 나오면, i를 빼고 나가서 다시 난수 발생 
							break;
					}
				}// for k 
			}// for i

			// 게임 시작
			while(true){
				System.out.print("숫자를 세개 입력해주세요 : ");
				for(int i = 0; i < user.length; i++){
					user[i] = System.in.read()-'0';
					// System.in.read로 인해서 숫자를 문자로 입력해서 아스키값이 출력이 된다. 
					// 0를 왜 빼는거라고??????

				} // for i 
				System.in.read();
				System.in.read(); // 엔터처리
				
				strike = 0;
				ball = 0;
				for(int i = 0; i < com.length; i++){
					for(int k = 0; k < user.length; k++){
						if(com[i] == user[k]){
							if(i == k){
								// 요소같고 인덱스 같으면 스트라이크
								strike++;
							}else{
								// 요소 같고 인덱스 다르면 볼 
								ball++;
							}
						}
					}
					System.out.println(strike+ "스트라이크" + ball + "볼");
					
					if(strike == 3){
						System.out.println("삼진! 게임 끝");
						break; // while 나감
					}
				}

			} // while
		
		}
			System.out.println("프로그램을 종료합니다");
	}
}