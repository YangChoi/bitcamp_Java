import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class CollectionTest2{
	// �޼����� �������ʰ� ���´�(������̼� �ش�) : ���� 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		/*
		���ʸ� ���� ��� 
		Note: CollectionTest2.java uses unchecked or unsafe operations.
		Note: Recompile with -Xlint:unchecked for details. >> Ÿ���� ���� �Ҿ��ϴٴ� �޼��� 
		
		*/
		ArrayList list = new ArrayList(); // ���ʸ� ���� ���� 
		list.add("ȣ����");
		list.add("����");
		list.add("ȣ����"); 
		list.add(25);
		list.add(43.8);
		list.add("�⸰");
		list.add("�ڳ���");

		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		

	}
}

