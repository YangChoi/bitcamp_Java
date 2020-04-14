class SubTest extends SuperTest{
	private String name; 
	private int age; 

	public SubTest(String name, int age, double weight, double height){
		// �Ű������� �θ�͵� �ҷ��͵� ����� �� �ִ�(���)
		System.out.println("SubTest ������");
		this.name = name; 
		this.age = age; 
		super.weight = weight; 
		super.height = height; 
		// weight, height�� ���� �� Ŭ���� �ȿ��� ã�ٰ� ������ 
		// extends SuperTest�� ���ؼ� SuperTest Ŭ������ ã�ư� weight, height�� ã�Ƴ���. 
		// �켱������ �ϴ� �� Ŭ���� �ΰ�. 
		// �� ã�ٰ� Object���� �� ���� �ִ�. (�ֻ��� Ŭ����)
		
		// ��, weight , height�� ��� this�� ���־ ������ 
		// superŬ������ �ʵ��̱� ������ super�� ���־ �ȴ�. 
	}

	// ������� �ϸ� �⺻�����ڸ� �䱸�ϴ� ������ ���. 
	// �Ʒ��� ������ SuperTest Ŭ������ �⺻�����ڸ� ����� 

	public void output(){
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
		//System.out.println("������ = " + weight);
		//System.out.println("Ű = " + height);
		// ���� �ΰ��� SuperTest���� �ִ� ���̱� ������ SuperTest ���� �θ��� �ȴ�. 
		// super.disp();
		disp(); 
		//super�� �ٿ��� ������ �ʾƵ� super�� Ÿ�� �ö󰡼� ã���ش�. 
	}

	public static void main(String[] args){
		SubTest aa = new SubTest("��ƹ���", 25, 70.2, 164.4);
		// �ڽ��� �θ�� ���� �� �� �ִ�. 
		// �׷��� ������ �޸𸮸� ���� �� �ڱ��ڽ� �� �Ӹ��ƶ� �θ��� �͵� �������Ѵ�. (new�� ����)
		// new�� ���� ������ �ϱ� ������ �����ڰ� �ʿ��ϴ�. 
		// ���� �ڱ��ڽ��� ������, �θ��� �⺻������ �� �ΰ��� �ʿ��ϴ�. 
		aa.output();
		System.out.println("--------------------");
		aa.disp(); // �θ�͵� ����, ���͵� �θ�� 
		// ���� ����� �θ��, �Ʒ� ����� ���� 
		System.out.println("*******************");
		
		SuperTest bb = new SubTest("��ƹ���", 13, 40.3, 153.8);
		// bb.output(); >> super���� �����ϰ� �ֱ� ������ sub�� output()�� �θ� �� ����. 
		bb.disp();
	}
}