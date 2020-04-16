abstract class AbstractTest{ // POJO 형식 (Plain Old Java Object)
	protected String name; 
	
	public abstract void setName(String name); // 세미콜론으로 끝 : 추상메소드 
	// 이런 메소드가 만들어질 것이라고 미리 알리는 것
	// 추상메소드의 경우엔 추상이라는 키워드를 붙여줘야한다. abstract 
	// 또한 추상메소드를 가지고 있는 클래스는 클래스 역시 추상클래스여야한다. 
	
	//public void setName(String name){
	//	this.name = name; 
	//}
	public String getName(){ // 구현 (메소드의 괄호 : 메소드의 바디)
		// 구현을 했으면 호출을 해야한다 
		return name;
	}
}
