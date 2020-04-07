class VariableTest2 {
	int a; // 필드, 초기화 완료(0으로) 
	static int b; // 필드, 초기화 

	public static void main(String[] args) {
		int a = 10;  // local variable(지역변수), garbage(쓰레기값)
		System.out.println("a =" + a);
		
		// 필드 a값 부르기 
		// 필드값들은 new로 만들어주고 써야한다. 
		// static의 경우엔 미리 만들어줘 new를 할 필요가 없지만 필드 값들은 그렇지 않다. static이 없다. 
		System.out.println("필드 a =" + new VariableTest2().a);
		// 필드 b값 부르기 
		// b의 경우엔 static이 있기 때문에 new 없이 소속만 알려주면 된다. 
		System.out.println("필드 b = " + VariableTest2.b);
		// 소속을 알려주지 않아도 답이 나오는 것은 이미 VariableTest2 구역 안에 있기 때문에 아무 문제 없이 인식이 가능하기 때문 
	}
}