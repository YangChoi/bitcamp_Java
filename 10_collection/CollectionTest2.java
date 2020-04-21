import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class CollectionTest2{
	// 메세지가 나오지않게 막는다(어노테이션 준다) : 억제 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		/*
		제너릭 없을 경우 
		Note: CollectionTest2.java uses unchecked or unsafe operations.
		Note: Recompile with -Xlint:unchecked for details. >> 타입이 없어 불안하다는 메세지 
		
		*/
		ArrayList list = new ArrayList(); // 제너릭 없는 버전 
		list.add("호랑이");
		list.add("사자");
		list.add("호랑이"); 
		list.add(25);
		list.add(43.8);
		list.add("기린");
		list.add("코끼리");

		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		

	}
}

