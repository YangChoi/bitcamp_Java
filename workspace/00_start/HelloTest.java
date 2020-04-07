class HelloTest {
	public static void main(String[] args){
		System.out.println("안녕하세요 ");
		System.out.print("안녕하세요\n");
		System.out.println(25+36); // 덧셈
		System.out.println("25"+"36"); // 결합
		System.out.println("25+36");
		System.out.println("25+36 = " + 25+36); // 앞의 더하기가 먼저 
		// 25 앞의 + 가 먼저 실행되어서 결합이 된다. 
		System.out.println("25+36 = " + (25+36));
	}
}