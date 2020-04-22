class SnackTest extends Thread{
	// 하나가 끝나고 다른 하나를 처리하는 것이 아니고 
	// 하나를 하다가도 다른 것을 하고 절차가 없는 것. 
	// 어떤 과자를 먹다가 다른 과자를 먹고, 또 그 과자를 먹다가 다른 과자를 먹는 꼴 
	
	// 채팅 프로그램에서 많이 쓴다. 
	// 흐름은 잡을 수 있지만 정확한 결과를 예측할 수 없다. 
	
	public String str; 

	public SnackTest(String str){
		this.str = str;
	}

	public void run(){
		for(int i = 1; i <= 5; i++){
			System.out.println(str + "\t i = "+ i+ "\t" + Thread.currentThread());
			// 현재 스레드가 누군지 출력하라 
			// 세가지가 동시에 처리됨
		
		}
	}

	public static void main(String[] args) { 
		// 스레드 생성 
		SnackTest aa = new SnackTest("새우깡");
		SnackTest bb = new SnackTest("포카칩");
		SnackTest cc = new SnackTest("꼬북칩");
		
		// 스레드에 이름 부여 
		aa.setName("새우깡");
		bb.setName("포카칩");
		cc.setName("꼬북칩");

		// 우선순위 1_~10
		aa.setPriority(Thread.NORM_PRIORITY); // 기본값 5
		bb.setPriority(Thread.MIN_PRIORITY); //1
		cc.setPriority(Thread.MAX_PRIORITY); // 10
		
		// 스레드 시작 - 스레드 실행 (운영체제에 의해서 처리 : run() 콜)
		aa.start(); 
		try{
			aa.join(); // 멈춘다 그렇기 떄문에 aa를 전부 다 실행하고 다른 스레드로 가야한다. 
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		bb.start(); 
		cc.start();
		// 순서가 다 다르게 실행된다..
	}
}
