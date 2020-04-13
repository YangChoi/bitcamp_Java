class StaticTest {
	private int a; // �ʵ�, �ν��Ͻ� ����  
	private static int b;  // �ʵ�, Ŭ���� ���� 
	
	// static �� �ʱ�ȭ���� 
	static{
		// ������ �������� ���� ȣ��� 
		System.out.println("�ʱ�ȭ ����");
		b = 3; 
	}

	public StaticTest(){
		// new ���� �� ���� 
		System.out.println("�⺻������");
		b = 3; 
		// ������ : Ŭ���� ��ü(�ʵ�)�� �ʱ�ȭ 
	}

	public void calc(){
		a++;
		b++;
	}

	public void disp(){
		System.out.println("a=" + a+ "\t b = " + b);
	}

	public static void output(){
		System.out.println("static method");
		// System.out.println("a=" + this.a+ "\t b = " + StaticTest.b);
		// >> ���� 
	}

	public static void main(String[] args){
		StaticTest aa = new StaticTest();
		aa.calc();
		aa.disp();
		System.out.println();
		// System.out.println("b = " + StaticTest.b);

		StaticTest bb = new StaticTest();
		bb.calc();
		bb.disp();
		System.out.println();

		StaticTest cc = new StaticTest();
		cc.calc();
		cc.disp();
		System.out.println();

		StaticTest.output(); // static�̱⶧���� new�ʿ���� �ٷ� ȣ�� ���� 
		output(); // �׳� �޼ҵ�� �����൵ ȣ�� ���� 
		aa.output(); // ��ü������ �����ؼ� ȣ�� ����
		// static�� ��𿡼��� ���� ���� 


	}
}