class JoinTest implements Runnable{
	// JoinMain은 스레드가 아니고, 스레드가 되고싶은 애 
	// implements는 만들어주는게 아니고 그렇게 흉내내는 꼴
	@Override
	public void run(){ // 여기에 throws 못 건다. (오버라이드된 메서드에선 안먹힘)
		for(int i = 1; i <= 5; i++){
			System.out.println(i);

			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}

		}
	}
}

class JoinMain {
	public static void main(String[] args) throws InterruptedException{
		JoinTest jt = new JoinTest();
		Thread t = new Thread(jt); 
		// 괄호를 비우고 스레드 생성하면 안됨 
		// 문법적으론 틀리지 않으나, 
		// 현재 스레드가 되고 싶은 것은 JoinTest 이다. 
		// 괄호 안에 jt를 넣어 스레드가 되고자 하는 것을 명시해야한다. 
		
		System.out.println("스레드 시작");
		t.start(); // 스레드 시작

		t.join(); // 스레드를 해지 (동시처리 불가) 

		System.out.println("스레드 종료");
		
	}
}
