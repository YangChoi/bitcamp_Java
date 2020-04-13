class MemberDTO{ // DTO / VO/ Bean 
	private String name; 
	private int age; 
	private String phone, address; 
	

	// int a; // �ʵ� - �ν��Ͻ� ����(new �ؼ� ���� �ֵ�)
	// static int b; // �ʵ� - Ŭ���� ���� (new ���ϰ� ���� �ֵ�) 

	public MemberDTO() {
	}
	// ������ ���� - ��ü �ʱ�ȭ 
	// ������ �̹� �ΰ��� ������ �ִ� ���� (���� ��ü �ʱ�ȭ�� ������ �ƴϴ�)
	// private���� �ɷ��ֱ� �ֱ� ������ �ܺο��� ���� �� 
	// setter ��ſ� ����Ѵ�. 
	// �� �����ڸ� ���� ���� ���� �� �� �� �ۿ� ����� �� ����. 
	// setter�� ��쿡�� �����͸� ������ ��� ���� ����� 

	// ������ �����ε�, ������ �ޱ�
	public MemberDTO(String name, int age, String phone, String address) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	// getter
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}
	
	// setter��  ����� ���� �ְ� �����ڸ� ����� ���� �ֱ� ������ 
	// �ΰ� �� �������� ����..
	public void setName(String name) {
		this.name = name; 
	}

	public void setAge(int age) {
		this.age = age; 
	}

	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setAddress(String address){
		this.address = address;
	}


}
