class MethodTest2 {
	int a; 

	public static void main(String[] args) {
		MethodTest2 mt = new MethodTest2();
		System.out.println("�� = " + mt.sum(25,36)); // ȣ�� 
		System.out.println("�� = " + mt.sub(25,36));
		System.out.println("�� = " + mt.mul(25,36));
		System.out.println("�� = " + mt.div(25,36));
	}
	// ����
	public int sum(int a, int b) {
		return a + b; // ��ȯ 
	}

	public int sub(int a, int b){
		return a-b;
	}

	public int mul(int a, int b) {
		return a * b; 
	}

	public double div(int a, int b) {
		return (double)a/b;
		// �����ε� ������ �Ű������� double ������������ 
		// return �޴� ���� ����ȯ ��������
	}
}