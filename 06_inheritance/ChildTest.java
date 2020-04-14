class ChildTest extends SuperTest{
	private String name; 
	private int age; 

	public ChildTest(String name, int age, double weight, double height){
		System.out.println("ChildTest ������");
		this.name = name; 
		this.age = age; 
		super.weight = weight; 
		super.height = height; 
	}

	public void disp(){
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
		//disp(); // �������̵� 
		// �������̵� �� : �켱���� �ڽĿ��� .. 
		// ���� �� disp()�� ChildTest�� disp�� ���Ѵ�.  
		// �θ��� disp�� ���� �ʹٸ� �տ� super�� ���ش� 
		super.disp();
		System.out.println("*******************");
	}

	public static void main(String[] args) {
		ChildTest aa = new ChildTest("��ƹ���", 25, 70.2, 164.4);
		aa.disp();	
		System.out.println("*******************");
		SuperTest bb = new ChildTest("��ƹ���", 13, 40.3, 153.8);
		bb.disp(); // �θ���� �ƴ� �ڽ� disp ȣ�� 
	}
}
