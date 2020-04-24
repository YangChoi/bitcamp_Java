class Synchronized extends Thread{
	private static int count = 0; 
	
	public static void main(String[] args) {
		Synchronized aa = new Synchronized(); // 스레드 생성
		Synchronized bb = new Synchronized(); 
		Synchronized cc = new Synchronized();
		
		// 스레드에 이름 부여 
		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		// 스레드시작 - 스레드 실행 
		aa.start();
		bb.start();
		cc.start();

	}
	/*
	@Override
	public void run(){ // 동기화가 안됨
		for(int i = 0; i < 5; i++){
			count++; // count를 static으로 잡았기 떄문에 
			// count를 aa,bb,cc 들이 각자 잡는것이 아니고 같이 한번에 잡는다. 
			// 따라서 0부터 15까지 감 
			System.out.println(Thread.currentThread() + "count = " + count); // 현재 들어온 스레드 출력 
			// 동기화가 안되어서 겹치는 숫자들이 보인다. 

		}
	}*/
	/*
	@Override - 동기화 안됨 
	public synchronized void run(){ // 동기화가 안됨 >> this값이(클래스가) 다 달라서 막을 수가 없다. 
		for(int i = 0; i < 5; i++){
			count++; // count를 static으로 잡았기 떄문에 
			// count를 aa,bb,cc 들이 각자 잡는것이 아니고 같이 한번에 잡는다. 
			// 따라서 0부터 15까지 감 
			System.out.println(Thread.currentThread().getName() + " count = " + count); // 현재 들어온 스레드 출력 
			// 동기화가 안되어서 겹치는 숫자들이 보인다. 

		}
	}
	*/
	// 동기화 걸린다. 
	public void run(){
		//synchronized(Synchronized.class){ // 동기화 됨 >> class 이렇게 생긴 애들을 다 막겠다고 표시한 것이므로 확실이 막을 수 있음
		synchronized(this){ // 동기화 안됨 // this는 class 마다 갖고 있는 값을 쥐고 있는 것, this 세개가 다 다르므로 막을 수가 없다. 그래서 누구 것을 막을지 모르기 때문에  
		// 따라서 막을 때 막을 것의 공통의 값을 넣어줘야한다. 
			for(int i = 1; i <= 5; i++){
				count++;
				System.out.println(Thread.currentThread().getName() + " count = " + count); 
			}
		}
	}

}
