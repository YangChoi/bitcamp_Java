import java.util.Scanner;
import java.io.*;

class GameAgain{
	public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(System.in);
	int money = 1000;
	int com, user; 
	int bettingMoney; 
	String yn; // 더 할지 말지 되묻기 

	while(true){ // for(;;){}
		com = (int) (Math.random() * 3) + 1; // 1에서 3까지 난수 발생 (컴퓨터 쪽 가위바위보)

		System.out.println("***********************");
		System.out.println("1. 가위  2. 바위  3. 보 ");
		System.out.println("***********************");
		System.out.print("번호 입력 : ");
		user = scan.nextInt();

		System.out.println("현재 금액은" + money + "입니다");
		System.out.print("배팅 금액 : ");
		bettingMoney = scan.nextInt();
		scan.nextLine(); 
		

		// int aa = System.in.read(); // 키보드로 부터 받은 입력을 잠시 저장 
		// read가 입력받은 것을 정수형으로 저장하기 때문에 int aa
		// 딱 한개의 문자만 인식 
		// ABC를 입력해도 A만 인식 
		System.out.print("결과를 보려면 Enter를 누르세요");
		System.in.read(); // 입력받은 문자 가져감
		System.in.read(); // 문자 뒤에 입력된 엔터값 \n 가져감 
		// 위의 System.in.read()의 두번 대신 scan.nextLine(); 사용할 수도 있다 

		
		
		//System.out.print("결과를 보려면 Enter를 누르세요");
		//int bb = System.in.read(); // 키보드로 부터 받은 입력을 잠시 저장 

		//System.out.println("aa =" + +aa);
		//System.out.println("bb =" + +bb);
		

		// 비교 
		if(com == 1){ // 컴퓨터가 가위 
			if(user == 1){
				System.out.println("비김. 잔여 금액은 " + money );
			}else if(user == 2){
				money += bettingMoney;
				System.out.println("이겼다. 잔여 금액은 " + money );
			}else if(user == 3 ){
				System.out.println("졌다. 잔여 금액은 " + money);
				money -= bettingMoney;
			}
		}else if(com == 2) { // 컴퓨터가 바위 
			if(user == 1){
				System.out.println("졌다. 잔여 금액은 " + money);
				money -= bettingMoney;
			}else if(user == 2){
				System.out.println("비김. 잔여 금액은 " + money );
			}else if(user == 3){
				money += bettingMoney;
				System.out.println("이겼다. 잔여 금액은 " + money );
			}
		}else if(com == 3){ // 컴퓨터가 보자기 
			if(user == 1){
				money += bettingMoney;
				System.out.println("이겼다. 잔여 금액은 " + money );
			}else if(user == 2){
				System.out.println("졌다. 잔여 금액은 " + money);
				money -= bettingMoney;
			}else if(user == 3){
				System.out.println("비김. 잔여 금액은 " + money );
			}
		}

		if(money <= 0 ){
			System.out.print("continue(y/n)?");
			yn = scan.next();
			
			if(yn.equals("n") || yn.equals("N")){
				break; // 반복문 나감 
			}else {
				money = 100;
			
		}
	}// while

	System.out.println("GAME OVER");


	}
}


/*
Console - System
입력 : 키보드 -System.in
출력 : 화 - System.out
*/