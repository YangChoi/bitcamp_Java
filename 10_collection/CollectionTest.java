import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class CollectionTest{
	public static void main(String[] args) {
		//Collection coll = new Collection(){
		//	추상메소드 Override }; // 인터페이스라 생성 안되므로 익명 붙인다. 
		// 그래도 결국 implements와 같이 추상메소드를 Override해줘야한다.. 
		// 나는 지금 Collection 중 ArrayList 만 쓰고 싶다. 
		// Api를 찾아보니 ArrayList 는 일반 클래스. 위와 같은 과정이 필요 없더라. 
		Collection<String> coll = new ArrayList<String>(); // ArrayList를 보니 일반 class (추상클래스 아님) >> 익명 붙일 필요 없음
		coll.add("호랑이");
		coll.add("사자");
		coll.add("호랑이"); // 중복허용, 순서 
		//coll.add(25);
		//coll.add(43.8);
		coll.add("기린");
		coll.add("코끼리");
		//ArrayList 안에 데이터를 담긴 담았는데 뭐가 들어있는지 모른다는 메세지가 뜬다. : <String>으로 타입 알려준다. 
		
		// 배열.length
		// 문자열.length

		System.out.println("크기 = " + coll.size());
		Iterator it = coll.iterator(); // 생성 
		// Collection 안에 Iterator 지정자 생성해준 것. 
		
		// it.hasNext : 현재 항목에 값 있나? - True
		// it.next() : 항목에 값 꺼내고 다음으로 이동 - 호랑이 꺼내오고 사자로 가기 
		// ... 더이상 꺼낼 것이 없을 때까지 반복 
		// While 문, 조건이 false일 때 멈추면 되니까. 
		
		// 값 꺼내보기 
		while(it.hasNext()){
			// 항목이 없을 때까지 (조건이 false 이면 while문 종료) 
			System.out.println(it.next()); // 꺼내오고 다음으로 넘어가기 
			// 중복허용, 들어간 순서대로 꺼낸다. 
		}

	}
}

/*
interface 
- implements, 추상메소드 Override
- 익명 Inner Class 
- 누군가가 implements 해준 클래스 (WindowAdapter 같은) 
*/

/*


class  {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.get(0); // 못한다. 
		// coll 은 Collection을 가리키고 있다. 
		// 그런데 Collection은 Array 안에 있어서 오버라이드 법칙에 의해서 
		// 자식인 Array의 메소드들을 발동한다. 
		// 그런데 Collection 에는 get 메소드가 없다. 

	}
}

*/