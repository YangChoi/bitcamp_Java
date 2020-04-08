/*
1부터 100 중에서 난수를 하나 발생해 맞추는 게임 

[실행결과] 
1 ~ 100 사이에 난수가 발생하였습니다. ( 예 : 85)  
숫자 입력 : 50 
50보다 큽니다.

숫자 입력 : 90
90보다 작습니다. 
...

정답입니다!
xxx 번 맞추셨습니다. 
*/
import java.util.Scanner;

class Quiz {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int num = (int)(Math.random()*100)+1;  // 1부터 100까지 
		// int num = (int)(Math.random()*(끝값 - 시작값 +1))+시작값;
		int answer; // 입력받을 답
		System.out.println("1과 100 사이에 난수가 발생하였습니다. " );
		
		int count = 0; 
		while(true){
			System.out.print("숫자 입력 : ");
			answer = scan.nextInt();

			if(answer > num) {
				System.out.println(answer + "보다 작습니다.");
				count++;
			}else if (answer < num) {
				System.out.println(answer + "보다 큽니다");
				count++;
			}else if(answer == num) {
				// 정답		
				break;
			}
		}
		System.out.println("정답입니다");
		System.out.println(count + "번 맞추셨습니다");
	}
}