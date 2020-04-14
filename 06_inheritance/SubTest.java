class SubTest extends SuperTest{
	private String name; 
	private int age; 

	public SubTest(String name, int age, double weight, double height){
		// 매개변수에 부모것도 불러와도 사용할 수 있다(상속)
		System.out.println("SubTest 생성자");
		this.name = name; 
		this.age = age; 
		super.weight = weight; 
		super.height = height; 
		// weight, height는 먼저 내 클래스 안에서 찾다가 없으니 
		// extends SuperTest를 통해서 SuperTest 클래스로 찾아가 weight, height를 찾아낸다. 
		// 우선순위는 일단 내 클래스 인것. 
		// 쭉 찾다가 Object까지 갈 수도 있다. (최상위 클래스)
		
		// 또, weight , height는 사실 this를 써주어도 되지만 
		// super클래스의 필드이기 때문에 super를 써주어도 된다. 
	}

	// 여기까지 하면 기본생성자를 요구하는 에러가 뜬다. 
	// 아래의 이유로 SuperTest 클래스에 기본생성자를 만든다 

	public void output(){
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		//System.out.println("몸무게 = " + weight);
		//System.out.println("키 = " + height);
		// 위의 두개는 SuperTest에도 있는 것이기 때문에 SuperTest 것을 부르면 된다. 
		// super.disp();
		disp(); 
		//super를 붙여도 붙이지 않아도 super로 타고 올라가서 찾아준다. 
	}

	public static void main(String[] args){
		SubTest aa = new SubTest("양아무개", 25, 70.2, 164.4);
		// 자식은 부모것 까지 쓸 수 있다. 
		// 그렇기 때문에 메모리를 만들 때 자기자신 것 뿐만아라 부모의 것도 만들어야한다. (new를 통해)
		// new를 통해 생성을 하기 때문에 생성자가 필요하다. 
		// 따라서 자기자신의 생성자, 부모의 기본생성자 이 두개가 필요하다. 
		aa.output();
		System.out.println("--------------------");
		aa.disp(); // 부모것도 내거, 내것도 부모거 
		// 위의 결과는 부모거, 아래 결과는 내것 
		System.out.println("*******************");
		
		SuperTest bb = new SubTest("김아무개", 13, 40.3, 153.8);
		// bb.output(); >> super값을 참조하고 있기 떄문에 sub의 output()을 부를 수 없다. 
		bb.disp();
	}
}