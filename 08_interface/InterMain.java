//class InterMain implements InterA, InterB {
class InterMain implements InterC { // 위와 같이 된다. 
		// InterC는 결국 InterA, InterB를 받고 있기 때문 

	// implements를 한 클래스는 반드시 추상메소드를 override해주어야한다. 
	// interface는 여러개 쓸 수 있다. 그런 대신 또 override 해주어야한다.

	// 클래스 앞에 abstract를 붙이면 내가 안하고 나 다음 세대에게 미루는 것 
	// 이렇게 하면 InterMain은 절대 new 할 수 없다. 
	
	// InterA에 대한 오버라이드 
	public void aa(){}
	public void bb(){}

	// InterB에 대한 오버라이드 
	public void cc(){}
	public void dd(){}
	
	public static void main(String[] args) {
		
	}
}
