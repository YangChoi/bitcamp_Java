import java.util.Map;
import java.util.HashMap;
import java.util.Scanner; 

class MapTest {
	public static void main(String[] args) {
		// Map<Key,Value> : ���׸� ��ȣ�� 2�� 
		Map<String,String> map = new HashMap<String,String>();
		
		//String name = "��ƹ���"; 
		map.put("book101", "�鼳����");
		map.put("book201", "�ξ����");
		map.put("book102", "�鼳����"); // Value �ߺ���� 
		map.put("book301", "�ǿ���");
		map.put("book101", "��������"); // Key �ߺ����
		// book101�� ���� �鼳���ֿ�����, �������� �������ְ� ��� 
		// ����ϸ� �������ְ� ���´�. 
		// add ��� put

		System.out.println(map.get("book101")); // �鼳���ְ� �ƴ� �������ְ� ���´�. 

		Scanner scan = new Scanner(System.in);
		System.out.print("�ڵ� �Է� : ");
		String key = scan.next();

		//if(map.get(key) == null){
		if(!map.containsKey(key)){ // ���� Ű���� ������ ������ true, �ƴ� false �̰� �������� 
			System.out.println("���� key���Դϴ�");
		}else {
			System.out.println(map.get(key)); // ���� �����Ͷ� 
		}

	
	}
}
