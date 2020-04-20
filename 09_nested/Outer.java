class Outer{
	// 파일명 저장은 main이 없어도 바깥 class 명으로 : Outer.java
	//										Outer.class
	//										Outer$Inner.class (바깥클래스$이너클래스)
	private String name; 
	
	public void output(){
		// System.out.println("이름 = " + name + "\t 나이=" + age);
		// 이너클래스는 바깥 클래스의 필드를 사용할 수 있지만
		// 바깥클래스는 이너 클래스의 필드를 사용할 수 없다. : 에러 
		// 사용하려면 이너클래스으 객체를 생성해야한다.
		Inner in = new Inner();
		System.out.println("이름 = " + name + "\t 나이=" + in.age); // this가 빠진 name
		// setter/ getter를 사용하지 않아도 되는 것이 장점 


		}

		class Inner {
			private int age;
			
			public void disp(){
			System.out.println("이름 = " + name + "\t 나이=" + age); // this가 빠진 age, name은 this가 아니다. (Outer.this.name의 생략이다)
			// 이너클래스는 바깥 클래스의 필드 사용 가능 
		}
		
	} // class Inner
	public static void main(String[] args) {
		Outer outer = new Outer();
		//Inner는 따로 만들지 않는다( 상속과 다른 점 ) 
		// 클래스 중첩이 일어날 뿐, 같은 것은 아니다. 
		// 같은 공간에 묶어놨기 때문에 아는 사이지 가족관계는 아니라는 것 
		outer.name = "양아무개"; // 중첩클래스와 상관없이 가능 
		
		// Inner in2 = new Inner(); // 불가능 (독립된 자신만의 class가 아니므로 Outer 안으로 들어가야한다)
		Outer.Inner in2 = outer.new Inner(); // 이너를 부를시 반드시 소속 명시 
		in2.age = 25;
		in2.disp();

		Outer.Inner in3 = outer.new Inner(); // 이너 클래스 또 생성 가능 
		in3.age = 30;
		in3.disp();

		Outer.Inner in4 = new Outer().new Inner(); // 새로운 Outer 만듦.. in4 때문에 겉치레로 따라온 것 (?)
		// in4.name = "김아무개"; // 안됨... 이건 클래스 안에서만 가능. 같은 영역이 아니기 때문에 접근 불가 
		in4.age = 50; // 나이는 본인 것이기 때문에 가능 
		in4.disp(); 
	}
}// class Outer
