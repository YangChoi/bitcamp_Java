class AbstractMain { //extends AbstractTest{
	// 추상 클래스 안 추상메소드 Override
	//@Override
	//public void setName(String name){
	//	this.name = name; 
		AbstractTest at = new AbstractTest(){
			@Override
			public void setName(String name){
				this.name = name; 
			}
		}; // 중괄호 : 나를 대신해서 해주는 것  (이 안에서 Override해준다) 
		// 내 추상메소드를 대신 Override 해준 것 (상속 대신에 하는 것 ) 
		// 메소드의 구현부를 가질 수 있는 것은 클래스 뿐 
		// 즉, 중괄호 내부는 메소드 구현부라는 것 즉, at는 클래스라는 것 
		// 그런데 이 클래스는 class 클래스 같은 이름이 없다. (익명클래스) 
		// 클래스 안의 클래스 (익명클래스) 

		// AbstractMain.java
		// AbstractMain.class
		// AbstractMain$1.class (이름이 없어서 1로 표현됨) 

		InterA bb = new InterA(){ //Interface를 new한것이 아니고 익명을 부여한 것 
			public void aa(){} // 익명을 부여했고 그에 따라 오버라이드를 해줌 
			public void bb(){}
		}; // 한번 쓰고 버리는 용 

		// AbstractExam cc = new AbstractExam(); // 이렇게 생성 불가 : 추상이기 때문에 
		// 따라서 익명 붙임
		AbstractExam cc = new AbstractExam(){}; // 여기에 오버라이들르 해줘도 되고 안해줘도 되는 것. 

}
	//public static void main(String[] args) {
		// 추상클래스는 자체적인 new가 안된 다. 
		//AbstractTest at = new AbstractTest();
		// 따라서 상속시켜준다. 
		// 상속시켜주면 자식클래스는 반드시 추상클래스 안의 추상메소드를 Override해주어야한다.
		
		// Override 후 자식클래스로 생성한다. 
		//AbstractTest at = new AbstractMain(); 
		
	//}

