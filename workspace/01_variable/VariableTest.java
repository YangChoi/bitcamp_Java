class VariableTest {
	public static void main(String[] args) {
		boolean a = true; 
		// true�� a�� �־�� (����) 
		// �׻� �����ʿ� �ִ� ���� �������� ���� �� 
		System.out.println("a =	" + a); 

		char b = 'A';
		System.out.println("b =	" + b); 
		
		char c = 65;
		System.out.println("c =	" + c); 
		// 65�� �־����� ������ Ÿ���� char�� �߱� ������ 65�� ���� �ش�Ǵ� ���ڰ� ���´�. 
		// A ���õ� ��ǻ�Ͱ� �б⿣ 2������ �д´�. 
		// 65 �� ��������

		// char�� ���� �� �ִ� �ִ� 
		char d = 65535;
		System.out.println("d =	" + d); 
		// char�� ������ ���� : ����� ?�� ���´�. 
		
		// char�� ������ ���� ���� 
		// char e = 65536;
		// System.out.println("e =	" + e); 
		// imcompatiable ���� 
		// char�� ������ �� �ִ� ������ 65535�����̱� ����

		int e = 65; 
		System.out.println("e =	" + e);
		
		int f = 'A';
		System.out.println("f =	" + f);
		// int���̱� ������ A�� �ƽ�Ű�ڵ��� 65�� ���´�. 

		//float g = 43.8; 
		double g = 43.8;
		System.out.println("g =	" + g); 
		// error 
		// double���� ���ڸ� float�� �� 

		float f = (float)43.8; // ��� ����ȯ
		// float f = 43.8f; // ��ü������ �ٲ� �� 
		System.out.println("f =	" + f); 

		// 25 : int��
		// 25L : long��
	}
}