import java.util.Scanner;

class ATMTest implements Runnable{
	private long depositeMoney = 100000; // 잔액 
	private long balance; // 찾고자하는 금액 

	public static void main(String[] args) {
		ATMTest atm = new ATMTest();
		// 엄마와 아들 스레드 생성 
		Thread mom = new Thread(atm, "엄마"); //ATMTest를 스레드로 만들고자 하기 때문에 
		Thread son = new Thread(atm, "아들"); //ATMTest를 지칭해야한다. 
											//단, static이기 때문에 this는 안된다. 
		// 그런데 우리는 스레드를 통해 atm 객체 하나를 나눠 쓸것이기 때문에 new 하지말고 위의 atm을 나눠쓴다.
		
		// 스레드 두개 run
		mom.start();
		son.start();
	}

	@Override
	public synchronized void run(){
		System.out.println(Thread.currentThread().getName() + "님 안녕하세요."); // 선택받은 현재 스레드를 가져온다
		// getName() : 스레드의 이름만 따오기 

		// 돈찾기 
		Scanner scan = new Scanner(System.in);
		System.out.print("찾으실 금액을 입력해주세요 : ");
		balance = scan.nextLong();
		// 스레드로 거의 동시에 들어오는 것 처럼되어서 
		// 엄마와 아들에게 동시에 금액을 물어보게 된다. 
		// 그렇기 떄문에 synchronized를 걸어서 먼저 들어온 사람만 통과되게 한다. (동기화)
		// 한 번에 하나씩 

		withDraw();
		// 리턴이 있다면 
		// ??? = withDraw() 가 될 것. 
		// 혹은
		// System.out.println(withDraw());
		// 리턴이 있다면 반드시 무언가를 받아줄 곳이 있어야한다.
	}

	public void withDraw(){
		if(depositeMoney >= balance){ // 돈을 찾을 수 있는 상태 
			if(balance%10000 == 0){ // 출금은 만원단위로 
				depositeMoney = depositeMoney-balance;
				System.out.println("잔액은 " +depositeMoney + "입니다");
			}else {
				System.out.println("만원 단위로 입력하세요");
			}
		}else {
			System.out.println("잔액 초과");
		}
	}
}
