class MethodTest2 {
	int a; 

	public static void main(String[] args) {
		MethodTest2 mt = new MethodTest2();
		System.out.println("합 = " + mt.sum(25,36)); // 호출 
		System.out.println("차 = " + mt.sub(25,36));
		System.out.println("곱 = " + mt.mul(25,36));
		System.out.println("몫 = " + mt.div(25,36));
	}
	// 구현
	public int sum(int a, int b) {
		return a + b; // 반환 
	}

	public int sub(int a, int b){
		return a-b;
	}

	public int mul(int a, int b) {
		return a * b; 
	}

	public double div(int a, int b) {
		return (double)a/b;
		// 오버로딩 때문에 매개변수에 double 적어주지말고 
		// return 받는 값을 형변환 시켜주자
	}
}