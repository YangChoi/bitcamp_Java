interface InterA {
	public static final String NAME = "양아무개"; // 인터페이스에는 반드시 상수만 
	int AGE = 25; // 상수임(static final 생략가능) 

	public abstract void aa(); // 추상메소드 
	public void bb(); // 추상매소드(abstract 생략가능) 

	//public void cc(){} 구현부 불가 
}
// 여기까지 틀만 만든 것