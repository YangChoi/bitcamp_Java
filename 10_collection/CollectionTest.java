import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class CollectionTest{
	public static void main(String[] args) {
		//Collection coll = new Collection(){
		//	�߻�޼ҵ� Override }; // �������̽��� ���� �ȵǹǷ� �͸� ���δ�. 
		// �׷��� �ᱹ implements�� ���� �߻�޼ҵ带 Override������Ѵ�.. 
		// ���� ���� Collection �� ArrayList �� ���� �ʹ�. 
		// Api�� ã�ƺ��� ArrayList �� �Ϲ� Ŭ����. ���� ���� ������ �ʿ� ������. 
		Collection<String> coll = new ArrayList<String>(); // ArrayList�� ���� �Ϲ� class (�߻�Ŭ���� �ƴ�) >> �͸� ���� �ʿ� ����
		coll.add("ȣ����");
		coll.add("����");
		coll.add("ȣ����"); // �ߺ����, ���� 
		//coll.add(25);
		//coll.add(43.8);
		coll.add("�⸰");
		coll.add("�ڳ���");
		//ArrayList �ȿ� �����͸� ��� ��Ҵµ� ���� ����ִ��� �𸥴ٴ� �޼����� ���. : <String>���� Ÿ�� �˷��ش�. 
		
		// �迭.length
		// ���ڿ�.length

		System.out.println("ũ�� = " + coll.size());
		Iterator it = coll.iterator(); // ���� 
		// Collection �ȿ� Iterator ������ �������� ��. 
		
		// it.hasNext : ���� �׸� �� �ֳ�? - True
		// it.next() : �׸� �� ������ �������� �̵� - ȣ���� �������� ���ڷ� ���� 
		// ... ���̻� ���� ���� ���� ������ �ݺ� 
		// While ��, ������ false�� �� ���߸� �Ǵϱ�. 
		
		// �� �������� 
		while(it.hasNext()){
			// �׸��� ���� ������ (������ false �̸� while�� ����) 
			System.out.println(it.next()); // �������� �������� �Ѿ�� 
			// �ߺ����, �� ������� ������. 
		}

	}
}

/*
interface 
- implements, �߻�޼ҵ� Override
- �͸� Inner Class 
- �������� implements ���� Ŭ���� (WindowAdapter ����) 
*/

/*


class  {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.get(0); // ���Ѵ�. 
		// coll �� Collection�� ����Ű�� �ִ�. 
		// �׷��� Collection�� Array �ȿ� �־ �������̵� ��Ģ�� ���ؼ� 
		// �ڽ��� Array�� �޼ҵ���� �ߵ��Ѵ�. 
		// �׷��� Collection ���� get �޼ҵ尡 ����. 

	}
}

*/