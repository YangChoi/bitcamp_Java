/*
난수 10부터 99사이의 난수를 2개 발생하여 합을 맞추는 게임 

*/
import java.util.Scanner;
class Quiz2 {
	public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	int a,b;
	int user; 
	int count = 0;

	System.out.println("덧셈의 합을 맞추어라 ");
	// 5문제 나오게 
	for(int i = 1; i <=5; i++){
		a = (int)(Math.random()*90)+10; // 10부터 99사이 
		b = (int)(Math.random()*90)+10;
		
		for(int k = 1; k <= 2; k++){ // 틀렸을 때 1번 더 기회 

		System.out.print("["+ i + "]" + a + "+" + b + "=");
		user = scan.nextInt();
		
		if(user == (a+b)) {
			
			System.out.println("참 잘했어요");
			count++;
			break; // k for문 나감 
		
		}else{
			if(k == 1){	
				System.out.println("다시 한번 더 ");

			}else {
				System.out.println("틀렸습니다. 정답은" + (a+b) + "입니다. ");			
					}
				} 
			}// for k 
		}// for i 
		System.out.println("당신의 점수는 "+ count + "번을 맞춰서 " + (count*20) + "점 입니다");
		
		}
	}
