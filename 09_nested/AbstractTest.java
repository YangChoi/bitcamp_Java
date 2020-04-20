abstract class AbstractTest {
// 추상클래스일 떄 추상메소드는 있을 떄도 없을 떄도 있다 
// 역은 성립하지 않는다. (추상메소드가 있다면 해당 클래스는 반드시 추상클래스여야한다)
	String name; 
	
	public abstract void setName(String name); // 추상메소드 
	// 인터페이스는 abstract 안써줘도 된다

	public String getName(){ // 구현
		return name;
	}

}
