import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class SetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("호랑이");
		set.add("사자");
		set.add("호랑이");// 중복 불가, 순서 없음 (중복은 아예 못들어감) 
		set.add("기린");
		set.add("코끼리");
	

		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}
}

// collection은 중복허용, 순서 지킴 
// set은 중복불허, 순서지키지 않음 