class Test{
	// default : 같은 디렉토리의 클래스들 모두 같이 써도 됨 
	int a, b;
}

//------------
class TestMain {
	public static void main(String[] args){
		Test aa = new Test();
		Test bb = aa; 
		// aa 의 주소값을 bb에게 준다. 

		aa.a = 10; // 가능 
		aa.b = 20;
		System.out.println(aa.a+"\t"+aa.b); // 10 20 
		System.out.println(bb.a+"\t"+bb.b); // 10 20 
		
		bb.a = 30; 
		bb.b = 40; 
		// bb가 가리키는 a, b 값을 30, 40으로 덮음 
		System.out.println(aa.a+"\t"+aa.b); // 30 40 
		System.out.println(bb.a+"\t"+bb.b); // 30 40 

		bb = new Test(); // 클래스를 또 만든 것 
		// 새로운 주소 
		bb.a = 50; 
		bb.b = 60;
		System.out.println(aa.a+"\t"+aa.b); // 30 40 
		System.out.println(bb.a+"\t"+bb.b); // 50 60 
	
	}
}