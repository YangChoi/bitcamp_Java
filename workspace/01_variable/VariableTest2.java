class VariableTest2 {
	int a; // �ʵ�, �ʱ�ȭ �Ϸ�(0����) 
	static int b; // �ʵ�, �ʱ�ȭ 

	public static void main(String[] args) {
		int a = 10;  // local variable(��������), garbage(�����Ⱚ)
		System.out.println("a =" + a);
		
		// �ʵ� a�� �θ��� 
		// �ʵ尪���� new�� ������ְ� ����Ѵ�. 
		// static�� ��쿣 �̸� ������� new�� �� �ʿ䰡 ������ �ʵ� ������ �׷��� �ʴ�. static�� ����. 
		System.out.println("�ʵ� a =" + new VariableTest2().a);
		// �ʵ� b�� �θ��� 
		// b�� ��쿣 static�� �ֱ� ������ new ���� �ҼӸ� �˷��ָ� �ȴ�. 
		System.out.println("�ʵ� b = " + VariableTest2.b);
		// �Ҽ��� �˷����� �ʾƵ� ���� ������ ���� �̹� VariableTest2 ���� �ȿ� �ֱ� ������ �ƹ� ���� ���� �ν��� �����ϱ� ���� 
	}
}