class MethodTest {
//메소드는 메소드 안에 쓰면 안된다. 
	public void disp() { // 구현
		System.out.println("non-static 메소드");
	}
	public static void print() { // 구현
		System.out.println("static 메소드");
	}

	public static void main(String[] args) {
		// 구현한 것을 호출 
		// new MethodTest().disp();
		MethodTest.print();

		MethodTest aa = new MethodTest(); // 객체 
		System.out.println("객체 aa = " + aa); // aa의 참조값 
		System.out.println("객체 aa = " + aa.toString()); // 현재 주소를 문자열로 바꿔서 찍어라 
		System.out.println("객체 aa = " + aa.hashCode()); // 주소를 10진수로
		
		aa.disp();

		// int aa; 정수형 변수 
		// double aa; 실수형 변수 
		// char aa; 문자형 변수 
	}
}

/*
메소드() 
- 명령어들의 집합 
- 
*/