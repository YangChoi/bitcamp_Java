class AA {
	public int a = 3; 
	public void disp(){
		a += 5;
		System.out.print("AA :" + a + " ");
	}
}

class BB extends AA{
	public int a = 8; 
	// 변수에 대해서는 오버라이딩 없음
	// 오버라이딩은 메소드에 대해서만
	public void disp(){
		this.a += 5;
		System.out.print("BB : " + a + " ");
	}
}

class TestMain2{
	public static void main(String[] args){
		BB bb = new BB();
		bb.disp(); // BB : 13
		System.out.println(bb.a + " "); // 13

		AA aa = new BB();
		aa.disp(); // BB : 13
		System.out.println(aa.a + " ");  //3
		// 변수는 오버라이드 없다 
		// 메소드는 뭘 가리켜도 오버라이드 되어서 자식 것을 실행 
		// 변수는 그렇지 않다. 가리키는대로 실행된다. 

		BB bb2 = (BB)aa; // 불가능 
		// 부모는 자식을 참조할 수 있다. 
		// 하지만 자식은 부모를 참조할 수 없다. 
		// 반드시 다운 캐스팅을 해주어야한다. 
		System.out.println(bb2.a + " "); //13
		

	}
}