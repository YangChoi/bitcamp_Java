class Final{
	public final String FRUIT = "���";
	public final String FRUIT2;
	
	public static final String ANIMAL = "����";
	public static final String ANIMAL2;
	
	static {
		ANIMAL2 = "�⸰";
	}
	
	public Final(){
		// �����ڴ� �ʱ�ȭ�� ���� �� 
		// ����� �����ڿ��� �ʱ�ȭ�� �Ѵ� 
		FRUIT2 = "����";
		// �����ڴ� new ���� �� ��������� ��
		// static�� �����԰� ���ÿ� �޸𸮿� �ö󰣴� 
		// �׷� ��쿣 �����ڿ��� �ʱ�ȭ�� �� �� ����. 
		// (ANIMAL�� static�̹Ƿ� �������ڸ��� �޸𸮿� �ö󰣴�.) 
		// static�� �ʱ�ȭ ������ ���� ���������� 
	}
}

class FinalMain {
	public static void main(String[] args){
		final int AGE = 10;
		System.out.println("��� AGE = " + AGE);
		// AGE = 30; // ����Ұ�, �ʱⰪ�� �̹� 10 �ֱ� ����
		//AGE++; // ����, ����̱� ������ �� ���� �Ұ� 

		final int AGE2; 
		AGE2 = 20; // �����, �ʱⰪ�� ���� �����̱� ���� 
		System.out.println("��� AGE2 = " + AGE2);

		Final f = new Final();
		// FRUIT�� ����ִ��� �˷�����Ѵ�. (static����)
		// FRUIT�� ���� Final class�� �����Ƿ� Final Ŭ���� ��ü�� ����� ��ġ�� �˷��ش�. 
		
		System.out.println("��� FRUIT = " + f.FRUIT);
		System.out.println("��� FRUIT2 = " + f.FRUIT2);
		System.out.println("��� ANIMAL = " + Final.ANIMAL); // f.ANIMAL�� ������
		System.out.println("��� ANIMAL2 = " + Final.ANIMAL2);
	}
}