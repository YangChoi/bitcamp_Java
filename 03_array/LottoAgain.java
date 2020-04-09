/*
돈 입력 : 3000
번호 한줄 
한 줄더 
한 줄더 
(1000원 당 한줄)
한장에 5줄 ( 한 칸 띄운다 )
*/
import java.util.Scanner;
import java.util.Arrays;

class LottoAgain{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int[] lotto = new int[6];

		System.out.print(" 돈 입력 : " );
		int money = scan.nextInt();
		int count = money/1000;

		// 금액만큼 출력 
		for(int time = 0; time < count; time++){
			// 난수 1~ 45 까지 발생 & 중복 제거  
			for(int i = 0; i < lotto.length; i++){
				lotto[i] = (int)(Math.random()*45)+1;
				for(int k = 0; k < i; k++){
					if(lotto[i] == lotto[k]){
						i--; // 같은 숫자가 나와서 다시 난수를 발생시키고 싶은데 
						// for문을 나가게 되면 자동적으로 ++이 되기 때문에 
						// 다시 같은 index의 난수를 만드려면 --를 해서 ++ 상쇄시켜줘야함. 
						break; // for k 나감 
					}
				}// for k 
			}// for i 
		 // sort 하기 
		 Arrays.sort(lotto);

		
			// 출력(확장형 for문은 출력위주로) 
			for(int data : lotto){
				System.out.print(String.format("%-5d", data)); // 정수를 5자리의 공간을 잡아 왼쪽정렬(-)해서 출력 
				
			}
			System.out.println();

			// 출력 ( 5줄에 한 장 넘어감 )
			if (time % 5 == 0){
				System.out.println("        ");
			}

	}// for time 
	}
}

/*
정수 %d
실수 %f
*/
