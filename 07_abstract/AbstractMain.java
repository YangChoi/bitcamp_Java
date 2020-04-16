class AbstractMain extends AbstractTest{
	// 상속을 걸어주고 AbstarctMain이 오버라이드를 해주어야한다. 
	// AbstractMain에게 추상을 걸어주면 밑의 자식들도 그렇다. 
	// 그래서 그냥 오버라이드를 걸어준다. 
	@Override
	public void setName(String name){
	
	}
	public static void main(String[] args) {
		//AbstractTest ab = new AbstractTest();
		// 추상 클래스는 자체적으로 new를 할 수 없다 
		// 즉, 자체적으로 메모리 생성이 안된다. 
		AbstractTest am = new AbstractMain();
		// 생성은 자식걸로, 접근은 부모걸로 
	}
}
// 모든 클래스가 new를 통하는 건 아니다. 
// 아래의 것들로도 가능 
// - 자식
// - 메소드