class PersonDTO implements Comparable<PersonDTO>{ // ���̿� �̸��� �Բ� ���� �����̰� ���ִ� comparable<������ ���� ������ :PersonDTO���� ���� ���̴�.  >
// 1�κ��� �����͸� ������ �ִ� DTO
// ���� ���� ������ Ŭ���� 
	private String name; 
	private int age; 

	// �����ڷ� ������ �ޱ� 
	public PersonDTO(String name, int age){
		this.name = name; 
		this.age = age; 
	}

	public String getName(){
		return name; 
	}
	
	public int getAge(){
		return age; 
	}

	@Override 
	// �ּҰ� �� ������ toString�� �������̵� �ؼ� 
	// ���� �Է��� �̸��� ���̰� �������� �Ѵ� 
	public String toString(){
		return "�̸� = " + name + "\t ���� ="+ age;
	} 


	// ���� ���� 
	@Override
	public int compareTo(PersonDTO o){ // ������ ���� ������ ���־���Ѵ�. ���� 
		/*
		if(this.age < o.age){
			return -1;
		}else if(this.age > o.age){
			return 0; 
		}else {
			return 1; 
		}
		*/

		// ���� ������ 
		// ���� ? �� : ����; 
		//return this.age < o.age ? -1 : 1; // ���� �� �������� 
		// ���� ��(0)�� �Ű�Ⱦ��� �� 
		return this.age < o.age ? 1 : -1; // �������� 
	}
	// ���� ������ ���� �ȵ�� �ٸ� �������� �ٲٰ� ���� �� 
	// Comparator


}
