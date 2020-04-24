class SingleTon {
	private int num = 3; 
	private static SingleTon instance; // 메모리에 한번 잡힘 : static
	
	public static SingleTon getInstance() {
		if(instance == null){
			instance = new SingleTon(); //  
		} // SingleTon의 객체 자리가 비었으면 새로 생성해준다. 
		return instance; // 있으면 기존의 instance 리턴 
	}
	// 우리는 한번만 쓸 것이다. 그런데 new 하면 메모리에 새로 들어가게 되므로 다른 방법을 쓴다. 
		// 먼저 필드 설정.. 
	public static void main(String[] args) {
		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = " + aa);
		System.out.println("num = " + aa.num);
		System.out.println();

		SingleTon bb = new SingleTon();
		bb.num++;
		System.out.println("bb = " + bb);
		System.out.println("num = " + bb.num);
		System.out.println();

		//-----------------------

		System.out.println("\n**싱글톤**");
		// SingleTon cc = new SingleTon(); 이렇게 하면 안된다. 
		SingleTon cc = SingleTon.getInstance(); // 생성이 아닌 불러오기를 해야한다. 
		
		cc.num++;
		System.out.println("cc = " + cc);
		System.out.println("num = " + cc.num);
		System.out.println();

		SingleTon dd = SingleTon.getInstance(); // cc로 인해 instance가 null 이 아니다. 
		// cc의 값이 dd에게 넘어온다. 
		dd.num++;
		System.out.println("dd = " + dd);
		System.out.println("num = " + dd.num);
		System.out.println();


	}
}
