import java.util.ArrayList;

class PersonMain {
	public ArrayList<PersonDTO> init(){
		PersonDTO aa = new PersonDTO("ȫ�浿", 25);
		PersonDTO bb = new PersonDTO("��ġ", 40);
		PersonDTO cc = new PersonDTO("�����", 30);

		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc); // �ּҰ��� ���� ����. 
		// list�� �̵���� �ٸ��� �ڽŸ��� �ּҵ� �� ������ �ִ�. 
		
		//return aa, bb, cc; >> �ڹٿ��� �Ұ��� 
		 
		return list; // aa, bb, cc �� �ּҰ��� ���� ����ִ�. 
		// list�� �ּҰ��� return �Ѵ�. 

	} // �� aa, bb, cc, �� �� �ȿ����� ���� 

	public static void main(String[] args) {
		// System.out.println(aa); >> �� 
		//System.out.println(dto.toString()); // dto�� ���� �ּҰ��� ��µȴ�. 
		
		PersonMain main = new PersonMain();// ȣ��, return �� ������ �� 
		// ������ �� ���� ������ ������ �� ����. 
		// �׷��� ������ ������ ArrayList�� ���´�. 

		ArrayList<PersonDTO> list = main.init(); // ȣ�� 
		// ���� return list�� �� list�� �ٸ� list�̴�. 
		// main.init()�� �������ִ�(�ּҹ���) �� �ٸ� list

		/*
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
			// toString() �������̵� ���� �� 
			// System.out.println(list.get(i).getName() + list.get(i).getAge());
		}
		*/

		// Ȯ���� for�� 
		for(PersonDTO dto : list){ // ����Ʈ�� �������� � Ÿ���� �����͸� �ִ��� �����Ѵ�. 
			System.out.println(dto);
		}
		
	}
}
