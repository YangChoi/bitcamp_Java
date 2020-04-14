class ChildTest extends SuperTest{
	private String name; 
	private int age; 

	public ChildTest(String name, int age, double weight, double height){
		System.out.println("ChildTest 생성자");
		this.name = name; 
		this.age = age; 
		super.weight = weight; 
		super.height = height; 
	}

	public void disp(){
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		//disp(); // 오버라이드 
		// 오버라이드 시 : 우선권은 자식에게 .. 
		// 따라서 이 disp()는 ChildTest의 disp로 향한다.  
		// 부모의 disp에 가고 싶다면 앞에 super를 써준다 
		super.disp();
		System.out.println("*******************");
	}

	public static void main(String[] args) {
		ChildTest aa = new ChildTest("양아무개", 25, 70.2, 164.4);
		aa.disp();	
		System.out.println("*******************");
		SuperTest bb = new ChildTest("김아무개", 13, 40.3, 153.8);
		bb.disp(); // 부모것이 아닌 자식 disp 호출 
	}
}
