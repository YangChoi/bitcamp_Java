class MethodTest {
//�޼ҵ�� �޼ҵ� �ȿ� ���� �ȵȴ�. 
	public void disp() { // ����
		System.out.println("non-static �޼ҵ�");
	}
	public static void print() { // ����
		System.out.println("static �޼ҵ�");
	}

	public static void main(String[] args) {
		// ������ ���� ȣ�� 
		// new MethodTest().disp();
		MethodTest.print();

		MethodTest aa = new MethodTest(); // ��ü 
		System.out.println("��ü aa = " + aa); // aa�� ������ 
		System.out.println("��ü aa = " + aa.toString()); // ���� �ּҸ� ���ڿ��� �ٲ㼭 ���� 
		System.out.println("��ü aa = " + aa.hashCode()); // �ּҸ� 10������
		
		aa.disp();

		// int aa; ������ ���� 
		// double aa; �Ǽ��� ���� 
		// char aa; ������ ���� 
	}
}

/*
�޼ҵ�() 
- ��ɾ���� ���� 
- 
*/