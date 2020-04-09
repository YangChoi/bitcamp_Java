class PersonTest{
	/*
	사람 - 가상화 
	이름, 나이, 성별, 키, ......
	*/
	private String name; // 필드 >> 초기화가 끝난 애들. 말을 안해도 null과 0 값을 가지고 있음 
	private int age; // 이 속성들은 메모리에 잡힌 것이 아니고 그냥 이런 것들이 있다고 알려만 준 것 ...
	// private : 내 클래스 안에서만 사용 가능 ( PersonTest 안에서만)
	
	// private이 붙어 데이터를 줄 수가 없다. 
	// 그럼 어떻게 줄까? 
	// 이름을 받는 메소드를 구현해본다..
	
	// private 필드를 만들 때는 set/get 메소드로 주고받기 가능 
	public void setName(String n){
		name = n; // 밑에서 받은 이름을 받는다. 
	}

	public void setAge(int a){
		age = a; // 밑에서 받은 나이를 받는다. 
	}

	public void setData(String n, int a){
		name = n;
		age = a;
	}

	public void setData(){}
	// 받은게 없어서 할 일도 없는 메서드 


	// 데이터를 반환
	public String getName(){
		return name; // name에 들어있는 값 반환 
	}
	public int getAge() {
		return age; 
	}
	


}

// main이 집주인이기 때문에..
// 클래스명은 main 따라간다. 
// main이 없는 경우에는 앞에 public을 붙혀 주인을 알려준다.  
public class PersonMain {
	public static void main(String[] args){
		PersonTest aa = new PersonTest(); // 객체 생성 
		// 우리가 만든 객체의 주소 가지고 있음.
		System.out.println("aa = " + aa); // aa가 가진 주소 확인 

		//aa.name = "양아무개"; // aa를 붙혀주지 않으면 main 메소드 안에서만 찾고 있음 : 에러 
		//aa.age = 23;
		// 필드에 private을 붙이며 사용할 수 없게 된 코드들

		// 호출 
		aa.setName("양아무개"); // setName에 이름 보낸다. 
		aa.setAge(25);
		
		//System.out.println("이름 = " + aa.name + "  나이 = " + aa.age);
		System.out.println("이름 = " + aa.getName() + "  나이 = " + aa.getAge());
		
		PersonTest bb = new PersonTest(); // 객체 생성 
		
		System.out.println("bb = " + bb);
		bb.setName("코난");
		bb.setAge(13);
		System.out.println("이름 = " + bb.getName() + "  나이 = " + bb.getAge());


		PersonTest cc = new PersonTest(); // 객체 생성 
		
		System.out.println("cc = " + cc);
		cc.setData("도치",100);
		System.out.println("이름 = " + cc.getName() + "  나이 = " + cc.getAge());

		PersonTest dd = new PersonTest();
		dd.setData(); // 부를 수 없음... 에러 안나게 아무것도 안받아도 괜찮은 똑같은 메서드 또 만들어야. 
		System.out.println("이름 = " + dd.getName() + "  나이 = " + dd.getAge());


	}
}