class ConstructorTest{
	private String name; 
	private int age;

	// 생성자 
	public ConstructorTest(){
		System.out.println("default 생성자");
	}

	public ConstructorTest(String name){
		this();
		this.name = name; // this.name : 클래스 꺼 
		// 그냥 name 내 매개변수 
	}

	public ConstructorTest(int age){
		this(); // 첫번째 생성자 호출
		//this("스트링 생성자 호출"); // 두번째 생성자 호출 
		this.age = age;  // 아래 정수 값 매개변수를 가진 cc가 여기로 온다. 
		// 다른 생성자 호출해보면..
		// 오류... 
		// 다른 생성자를 호출할 떄에는 첫번째 줄에 위치시켜야 함. 
	}
	// 위의 세 메소드는 오버로드(생성자 오버로딩) 
	// 생성자는 강제호출이 불가하며 클래스를 new할때만 부를 수 있지만 
	// 생성자끼리는 call할 수 있다. 
	

	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
}

class ConstructorMain{
	public static void main(String[] args){
		
		// 생성자 부르기, 빈 매개변수를 보고 default 생성자로 갔다 온다  
		ConstructorTest aa = new ConstructorTest();
		System.out.println("이름 = " + aa.getName() + "  나이 = " + aa.getAge());

		ConstructorTest bb= new ConstructorTest("홍길동");
		System.out.println("이름 =" + bb.getName() + "   나이 = " + bb.getAge());
		
		ConstructorTest cc = new ConstructorTest(25);
		System.out.println("이름 =" + cc.getName() + "   나이 = " + cc.getAge());

	}
}