class PersonTest{
	/*
	��� - ����ȭ 
	�̸�, ����, ����, Ű, ......
	*/
	private String name; // �ʵ� >> �ʱ�ȭ�� ���� �ֵ�. ���� ���ص� null�� 0 ���� ������ ���� 
	private int age; // �� �Ӽ����� �޸𸮿� ���� ���� �ƴϰ� �׳� �̷� �͵��� �ִٰ� �˷��� �� �� ...
	// private : �� Ŭ���� �ȿ����� ��� ���� ( PersonTest �ȿ�����)
	
	// private�� �پ� �����͸� �� ���� ����. 
	// �׷� ��� �ٱ�? 
	// �̸��� �޴� �޼ҵ带 �����غ���..
	
	// private �ʵ带 ���� ���� set/get �޼ҵ�� �ְ�ޱ� ���� 
	public void setName(String n){
		name = n; // �ؿ��� ���� �̸��� �޴´�. 
	}

	public void setAge(int a){
		age = a; // �ؿ��� ���� ���̸� �޴´�. 
	}

	public void setData(String n, int a){
		name = n;
		age = a;
	}

	public void setData(){}
	// ������ ��� �� �ϵ� ���� �޼��� 


	// �����͸� ��ȯ
	public String getName(){
		return name; // name�� ����ִ� �� ��ȯ 
	}
	public int getAge() {
		return age; 
	}
	


}

// main�� �������̱� ������..
// Ŭ�������� main ���󰣴�. 
// main�� ���� ��쿡�� �տ� public�� ���� ������ �˷��ش�.  
public class PersonMain {
	public static void main(String[] args){
		PersonTest aa = new PersonTest(); // ��ü ���� 
		// �츮�� ���� ��ü�� �ּ� ������ ����.
		System.out.println("aa = " + aa); // aa�� ���� �ּ� Ȯ�� 

		//aa.name = "��ƹ���"; // aa�� �������� ������ main �޼ҵ� �ȿ����� ã�� ���� : ���� 
		//aa.age = 23;
		// �ʵ忡 private�� ���̸� ����� �� ���� �� �ڵ��

		// ȣ�� 
		aa.setName("��ƹ���"); // setName�� �̸� ������. 
		aa.setAge(25);
		
		//System.out.println("�̸� = " + aa.name + "  ���� = " + aa.age);
		System.out.println("�̸� = " + aa.getName() + "  ���� = " + aa.getAge());
		
		PersonTest bb = new PersonTest(); // ��ü ���� 
		
		System.out.println("bb = " + bb);
		bb.setName("�ڳ�");
		bb.setAge(13);
		System.out.println("�̸� = " + bb.getName() + "  ���� = " + bb.getAge());


		PersonTest cc = new PersonTest(); // ��ü ���� 
		
		System.out.println("cc = " + cc);
		cc.setData("��ġ",100);
		System.out.println("�̸� = " + cc.getName() + "  ���� = " + cc.getAge());

		PersonTest dd = new PersonTest();
		dd.setData(); // �θ� �� ����... ���� �ȳ��� �ƹ��͵� �ȹ޾Ƶ� ������ �Ȱ��� �޼��� �� ������. 
		System.out.println("�̸� = " + dd.getName() + "  ���� = " + dd.getAge());


	}
}