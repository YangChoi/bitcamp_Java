import java.util.Map;
import java.util.HashMap;
import java.util.Scanner; 

class MapTest {
	public static void main(String[] args) {
		// Map<Key,Value> : 제네릭 기호가 2개 
		Map<String,String> map = new HashMap<String,String>();
		
		//String name = "양아무개"; 
		map.put("book101", "백설공주");
		map.put("book201", "인어공주");
		map.put("book102", "백설공주"); // Value 중복허용 
		map.put("book301", "피오나");
		map.put("book101", "엄지공주"); // Key 중복허용
		// book101은 원래 백설공주였지만, 마지막에 엄지공주가 덮어서 
		// 출력하면 엄지공주가 나온다. 
		// add 대신 put

		System.out.println(map.get("book101")); // 백설공주가 아닌 엄지공주가 나온다. 

		Scanner scan = new Scanner(System.in);
		System.out.print("코드 입력 : ");
		String key = scan.next();

		//if(map.get(key) == null){
		if(!map.containsKey(key)){ // 현재 키값을 가지고 있으면 true, 아님 false 이걸 부정으로 
			System.out.println("없는 key값입니다");
		}else {
			System.out.println(map.get(key)); // 값을 꺼내와라 
		}

	
	}
}
