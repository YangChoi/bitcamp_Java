import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class SetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("ȣ����");
		set.add("����");
		set.add("ȣ����");// �ߺ� �Ұ�, ���� ���� (�ߺ��� �ƿ� ����) 
		set.add("�⸰");
		set.add("�ڳ���");
	

		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}
}

// collection�� �ߺ����, ���� ��Ŵ 
// set�� �ߺ�����, ������Ű�� ���� 