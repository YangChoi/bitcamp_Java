import java.util.Scanner;
import java.io.*;

class GameAgain{
	public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(System.in);
	int money = 1000;
	int com, user; 
	int bettingMoney; 
	String yn; // �� ���� ���� �ǹ��� 

	while(true){ // for(;;){}
		com = (int) (Math.random() * 3) + 1; // 1���� 3���� ���� �߻� (��ǻ�� �� ����������)

		System.out.println("***********************");
		System.out.println("1. ����  2. ����  3. �� ");
		System.out.println("***********************");
		System.out.print("��ȣ �Է� : ");
		user = scan.nextInt();

		System.out.println("���� �ݾ���" + money + "�Դϴ�");
		System.out.print("���� �ݾ� : ");
		bettingMoney = scan.nextInt();
		scan.nextLine(); 
		

		// int aa = System.in.read(); // Ű����� ���� ���� �Է��� ��� ���� 
		// read�� �Է¹��� ���� ���������� �����ϱ� ������ int aa
		// �� �Ѱ��� ���ڸ� �ν� 
		// ABC�� �Է��ص� A�� �ν� 
		System.out.print("����� ������ Enter�� ��������");
		System.in.read(); // �Է¹��� ���� ������
		System.in.read(); // ���� �ڿ� �Էµ� ���Ͱ� \n ������ 
		// ���� System.in.read()�� �ι� ��� scan.nextLine(); ����� ���� �ִ� 

		
		
		//System.out.print("����� ������ Enter�� ��������");
		//int bb = System.in.read(); // Ű����� ���� ���� �Է��� ��� ���� 

		//System.out.println("aa =" + +aa);
		//System.out.println("bb =" + +bb);
		

		// �� 
		if(com == 1){ // ��ǻ�Ͱ� ���� 
			if(user == 1){
				System.out.println("���. �ܿ� �ݾ��� " + money );
			}else if(user == 2){
				money += bettingMoney;
				System.out.println("�̰��. �ܿ� �ݾ��� " + money );
			}else if(user == 3 ){
				System.out.println("����. �ܿ� �ݾ��� " + money);
				money -= bettingMoney;
			}
		}else if(com == 2) { // ��ǻ�Ͱ� ���� 
			if(user == 1){
				System.out.println("����. �ܿ� �ݾ��� " + money);
				money -= bettingMoney;
			}else if(user == 2){
				System.out.println("���. �ܿ� �ݾ��� " + money );
			}else if(user == 3){
				money += bettingMoney;
				System.out.println("�̰��. �ܿ� �ݾ��� " + money );
			}
		}else if(com == 3){ // ��ǻ�Ͱ� ���ڱ� 
			if(user == 1){
				money += bettingMoney;
				System.out.println("�̰��. �ܿ� �ݾ��� " + money );
			}else if(user == 2){
				System.out.println("����. �ܿ� �ݾ��� " + money);
				money -= bettingMoney;
			}else if(user == 3){
				System.out.println("���. �ܿ� �ݾ��� " + money );
			}
		}

		if(money <= 0 ){
			System.out.print("continue(y/n)?");
			yn = scan.next();
			
			if(yn.equals("n") || yn.equals("N")){
				break; // �ݺ��� ���� 
			}else {
				money = 100;
			
		}
	}// while

	System.out.println("GAME OVER");


	}
}


/*
Console - System
�Է� : Ű���� -System.in
��� : ȭ - System.out
*/