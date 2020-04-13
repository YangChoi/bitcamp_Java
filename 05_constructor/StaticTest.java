class StaticTest {
	private int a; // 필드, 인스턴스 변수  
	private static int b;  // 필드, 클래스 변수 
	
	// static 의 초기화영역 
	static{
		// 무조건 실행하자 마자 호출됨 
		System.out.println("초기화 영역");
		b = 3; 
	}

	public StaticTest(){
		// new 했을 때 실행 
		System.out.println("기본생성자");
		b = 3; 
		// 생성자 : 클래스 객체(필드)의 초기화 
	}

	public void calc(){
		a++;
		b++;
	}

	public void disp(){
		System.out.println("a=" + a+ "\t b = " + b);
	}

	public static void output(){
		System.out.println("static method");
		// System.out.println("a=" + this.a+ "\t b = " + StaticTest.b);
		// >> 에러 
	}

	public static void main(String[] args){
		StaticTest aa = new StaticTest();
		aa.calc();
		aa.disp();
		System.out.println();
		// System.out.println("b = " + StaticTest.b);

		StaticTest bb = new StaticTest();
		bb.calc();
		bb.disp();
		System.out.println();

		StaticTest cc = new StaticTest();
		cc.calc();
		cc.disp();
		System.out.println();

		StaticTest.output(); // static이기때문에 new필요없이 바로 호출 가능 
		output(); // 그냥 메소드명만 적어줘도 호출 가능 
		aa.output(); // 객체명으로 접근해서 호출 가능
		// static은 어디에서나 접근 가능 


	}
}