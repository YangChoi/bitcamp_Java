class InputTest {
	public static void main(String[] args) { 
	// JVM�� ���� main �޼ҵ� (�ݹ� �޼ҵ�)  : ������ �� jvm�̳� �ü���� ���ؼ� �ҷ����� �� 
	// �������� ���� main�� �� ã�´� 
	// ��, ����� �� main�� ã�´�.	

	// ���� main �޼ҵ�� �ּҸ� ������ �ִ�. 
	System.out.println("�迭�� args = " + args);
	for(int i = 0; i < args.length; i++){
		System.out.println("args["+i+"] = " + args[i]);

		// �迭�� ���ڼ� 
		// �迭�� �ϳ��� (�� �ϳ���) ����� ���ڼ��� � �ִ��� 
		System.out.println("���ڼ� = " + args[i].length());

		// �迭 �� ��� ���� ù���� ���� 
		System.out.println("ù ���� = " + args[i].charAt(0));
	} // for �� 

	// ������ : �ּ��� �� ���� 

	System.out.println("==== Ȯ���� for ====" ); 
	for(String data : args) {
		System.out.println(data);
	}
	
	//System.out.println("args[1] = " + args[1]);
	}
}

/*
** ����			** �迭 
 �ڷ��� ������		�ڷ���[] �迭�� = {��, ��, ��};
 
** �޼ҵ�()


*/