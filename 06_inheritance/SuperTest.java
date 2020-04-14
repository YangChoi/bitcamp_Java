class SuperTest{
	protected double weight, height; 

	// 생성자를 통해서 데이터 초기화 

	public SuperTest(double weight, double height){
	// 매개변수는 1:1로 선언해준다 
	// double weight, height 불가
		System.out.println("SuperTest 생성자");
		this.weight = weight; 
		this.height = height; 
	}

	// 위의 생성자는 기본 생성자가 아니기 때문에 별도로 만들어야한다. 
	public SuperTest(){
		System.out.println("SuperTest 기본 생성자");
	}

	public void disp(){
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);
	}

}

