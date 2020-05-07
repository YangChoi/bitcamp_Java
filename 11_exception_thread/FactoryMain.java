class Factory{
	private int product;
	
	// 동기화 했기 때문에 둘다 동시에 돌 수 없다 
	// 생산만 하는 쪽
	public synchronized void produce(){
		if(product > 4){
			// 생산이 충분히 물건이 쌓였다면 sell을 불러 소비 촉진 
			System.out.println("생산 중단 :" + product);
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			 
		}
		product++; // 물건을 계속 만든다 
		System.out.println("생산 : " + product); // 물건 많아진다. 
		notifyAll(); //모든 스레드를 깨운다 (소비할 준비를 해라)
	}

	// 소비만 하는 쪽 
	public synchronized void sell(){
		// 소비할 물건이 없으면 produce 깨워서 물건 만듦
		if(product < 1){
			// 물건이 없다면 
			System.out.println("소비 중단 :" + product);
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
		product--;
		System.out.println("소비 : " + product);
		notifyAll(); // 상대 스레드를 깨운다 (생산할 준비를 하라)
	}
}

// 물건을 만들 사람
class Worker extends Thread{
	private Factory factory; // Factory 값 가져온다 
	
	// 생성자 통해 factory 값 가져온다 
	public Worker(Factory factory){
		this.factory = factory;
	}

	public void run(){
		for(int i = 0; i < 12; i++){
			factory.produce();
		}
	}
}

// 물건을 소비할 사람
class Buyer extends Thread{
	private Factory factory;
	
	public Buyer(Factory factory){
		this.factory = factory;
	}

	public void run(){
		for(int i = 0; i < 12; i++){
			factory.sell();
		}
	}
}


class FactoryMain {
	public static void main(String[] args) {
		Factory f = new Factory();
		// 스레드 생성 
		Worker t = new Worker(f);
		Buyer b = new Buyer(f);
		// 둘 다 상속을 받아 그 자체로 thread가 되었기 때문에 위와 같이 생성 가능 
		// 단 factory에서 값을 받고 있기 때문에 factory 값을 같이 넘겨준다. 
		// 스레드 시작
		t.start();
		b.start();
	}
}

// 일정량이 생산되면
// 소비 촉진됨 
// 일정한 조건으로 스레드를 번갈아 가며 움직일 수 있다. 
