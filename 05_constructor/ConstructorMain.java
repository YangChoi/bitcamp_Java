class ConstructorTest{
	private String name; 
	private int age;

	// ������ 
	public ConstructorTest(){
		System.out.println("default ������");
	}

	public ConstructorTest(String name){
		this();
		this.name = name; // this.name : Ŭ���� �� 
		// �׳� name �� �Ű����� 
	}

	public ConstructorTest(int age){
		this(); // ù��° ������ ȣ��
		//this("��Ʈ�� ������ ȣ��"); // �ι�° ������ ȣ�� 
		this.age = age;  // �Ʒ� ���� �� �Ű������� ���� cc�� ����� �´�. 
		// �ٸ� ������ ȣ���غ���..
		// ����... 
		// �ٸ� �����ڸ� ȣ���� ������ ù��° �ٿ� ��ġ���Ѿ� ��. 
	}
	// ���� �� �޼ҵ�� �����ε�(������ �����ε�) 
	// �����ڴ� ����ȣ���� �Ұ��ϸ� Ŭ������ new�Ҷ��� �θ� �� ������ 
	// �����ڳ����� call�� �� �ִ�. 
	

	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
}

class ConstructorMain{
	public static void main(String[] args){
		
		// ������ �θ���, �� �Ű������� ���� default �����ڷ� ���� �´�  
		ConstructorTest aa = new ConstructorTest();
		System.out.println("�̸� = " + aa.getName() + "  ���� = " + aa.getAge());

		ConstructorTest bb= new ConstructorTest("ȫ�浿");
		System.out.println("�̸� =" + bb.getName() + "   ���� = " + bb.getAge());
		
		ConstructorTest cc = new ConstructorTest(25);
		System.out.println("�̸� =" + cc.getName() + "   ���� = " + cc.getAge());

	}
}