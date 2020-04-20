class Outer{
	// ���ϸ� ������ main�� ��� �ٱ� class ������ : Outer.java
	//										Outer.class
	//										Outer$Inner.class (�ٱ�Ŭ����$�̳�Ŭ����)
	private String name; 
	
	public void output(){
		// System.out.println("�̸� = " + name + "\t ����=" + age);
		// �̳�Ŭ������ �ٱ� Ŭ������ �ʵ带 ����� �� ������
		// �ٱ�Ŭ������ �̳� Ŭ������ �ʵ带 ����� �� ����. : ���� 
		// ����Ϸ��� �̳�Ŭ������ ��ü�� �����ؾ��Ѵ�.
		Inner in = new Inner();
		System.out.println("�̸� = " + name + "\t ����=" + in.age); // this�� ���� name
		// setter/ getter�� ������� �ʾƵ� �Ǵ� ���� ���� 


		}

		class Inner {
			private int age;
			
			public void disp(){
			System.out.println("�̸� = " + name + "\t ����=" + age); // this�� ���� age, name�� this�� �ƴϴ�. (Outer.this.name�� �����̴�)
			// �̳�Ŭ������ �ٱ� Ŭ������ �ʵ� ��� ���� 
		}
		
	} // class Inner
	public static void main(String[] args) {
		Outer outer = new Outer();
		//Inner�� ���� ������ �ʴ´�( ��Ӱ� �ٸ� �� ) 
		// Ŭ���� ��ø�� �Ͼ ��, ���� ���� �ƴϴ�. 
		// ���� ������ ������� ������ �ƴ� ������ ��������� �ƴ϶�� �� 
		outer.name = "��ƹ���"; // ��øŬ������ ������� ���� 
		
		// Inner in2 = new Inner(); // �Ұ��� (������ �ڽŸ��� class�� �ƴϹǷ� Outer ������ �����Ѵ�)
		Outer.Inner in2 = outer.new Inner(); // �̳ʸ� �θ��� �ݵ�� �Ҽ� ��� 
		in2.age = 25;
		in2.disp();

		Outer.Inner in3 = outer.new Inner(); // �̳� Ŭ���� �� ���� ���� 
		in3.age = 30;
		in3.disp();

		Outer.Inner in4 = new Outer().new Inner(); // ���ο� Outer ����.. in4 ������ ��ġ���� ����� �� (?)
		// in4.name = "��ƹ���"; // �ȵ�... �̰� Ŭ���� �ȿ����� ����. ���� ������ �ƴϱ� ������ ���� �Ұ� 
		in4.age = 50; // ���̴� ���� ���̱� ������ ���� 
		in4.disp(); 
	}
}// class Outer
