class Final{
	public final String FRUIT = "사과";
	public final String FRUIT2;
	
	public static final String ANIMAL = "사자";
	public static final String ANIMAL2;
	
	static {
		ANIMAL2 = "기린";
	}
	
	public Final(){
		// 생성자는 초기화를 위한 것 
		// 상수는 생성자에서 초기화를 한다 
		FRUIT2 = "딸기";
		// 생성자는 new 했을 때 만들어지는 것
		// static은 시작함과 동시에 메모리에 올라간다 
		// 그런 경우엔 생성자에서 초기화를 할 수 없다. 
		// (ANIMAL은 static이므로 생성하자마자 메모리에 올라간다.) 
		// static의 초기화 구역을 따로 만들어줘야함 
	}
}

class FinalMain {
	public static void main(String[] args){
		final int AGE = 10;
		System.out.println("상수 AGE = " + AGE);
		// AGE = 30; // 적용불가, 초기값이 이미 10 있기 때문
		//AGE++; // 에러, 상수이기 때문에 값 변경 불가 

		final int AGE2; 
		AGE2 = 20; // 적용됨, 초기값이 없는 상태이기 때문 
		System.out.println("상수 AGE2 = " + AGE2);

		Final f = new Final();
		// FRUIT가 어디있는지 알려줘야한다. (static없음)
		// FRUIT는 현재 Final class에 있으므로 Final 클래스 객체를 만들어 위치를 알려준다. 
		
		System.out.println("상수 FRUIT = " + f.FRUIT);
		System.out.println("상수 FRUIT2 = " + f.FRUIT2);
		System.out.println("상수 ANIMAL = " + Final.ANIMAL); // f.ANIMAL도 먹힌다
		System.out.println("상수 ANIMAL2 = " + Final.ANIMAL2);
	}
}