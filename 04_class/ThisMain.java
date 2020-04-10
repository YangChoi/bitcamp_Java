class ThisTest{
	private int a; 
	
	// set
	public void setA(int a){
		//a; // 클래스가 생성이 될 때 살고 , 끝날 때까지 먹힘 
		// 내 구역에서 a는 메소드의 매개변수로 있는 int a이다. 
		// 하지만 private int a를 a라고 하고 싶기때문에...
		System.out.println("this = "+this);
		this.a = a; // a 자신 
	}

	// get
	public static getA(){
		return a; // 필드의 a (this.a가 생략된 형태)
	}
}

class ThisMain{
	public static void main(String[] args){
		
		ThisTest aa = new ThisTest();
		System.out.println("aa = " + aa);
		aa.setA(10);

		ThisTest bb = new ThisTest();
		System.out.println("bb = " + bb);
		bb.setA(20);
	}
}