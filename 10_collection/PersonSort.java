import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.Comparator;

class PersonSort{
	public static void main(String[] args){
		String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};
		System.out.print("���� �� = ");
		
		for(String data : ar){
			System.out.print(data + " ");
		}
		System.out.println();

		Arrays.sort(ar); // sort ��Ű�� 

		System.out.print("���� �� = ");
		
		for(String data : ar){
			System.out.print(data + " ");
		}
		System.out.println();

		System.out.println("PersonDTO�� ���� ������ ����");
		PersonDTO aa = new PersonDTO("ȫ�浿", 25);
		PersonDTO bb = new PersonDTO("��ġ", 40);
		PersonDTO cc = new PersonDTO("�����", 30);
		
		// ���̷� �����ϴµ� �̸��� ���� ���������Ѵ�. 
		// Comparable ��� 

		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		// ����Ʈ �ȿ� ����ش�. 

		System.out.println("���� �� : " + list); // Ŭ������ @ 16���� �ּҰ�
		// list�� �ּҰ��� �ȳ��´�. �׸��� �����ش�. 

		// ���� �迭 �ƴϴϱ� Arrays.sort ���� ����...
		Collections.sort(list); 
		System.out.println("���� �� : " + list); 




		System.out.println("PersonDTO�� �̸� ������ ����");
		Comparator<PersonDTO> com = new Comparator<PersonDTO>(){
			@Override 
			public int compare(PersonDTO o1, PersonDTO o2){
				//return o1.getName().compareTo(o2.getName()); // -1 0 1 �������� 
					// getName �ҷ��� ��� ���ڿ� : ũ�� �۴� ���� �� �����Ƿ� compareTo 
					//compareTo�� �տ��� �������̵� �� �� �ҷ��� �� 
					// �������� �� ũ�� -1
					// ������ �� ũ�� 0
					// ������ 1
				// ��������
				//return o2.getName().compareTo(o1.getName()); // -1 0 1
				return o1.getName().compareTo(o2.getName())*-1; // 1 0 -1 

			}   
		}; // ���ο� ������ ���� �� Comparator, �͸� ����ؾ���  

		Collections.sort(list, com); // list �� ���� ���ϸ� ���̷� ������ �ȴ�. , com���� �ؼ� com�� �������� ������ �ǵ��� �Ѵ� 
		System.out.println("���� �� = " + list);
	}
}
