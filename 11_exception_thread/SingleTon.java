class SingleTon {
	private int num = 3; 
	private static SingleTon instance; // �޸𸮿� �ѹ� ���� : static
	
	public static SingleTon getInstance() {
		if(instance == null){
			instance = new SingleTon(); //  
		} // SingleTon�� ��ü �ڸ��� ������� ���� �������ش�. 
		return instance; // ������ ������ instance ���� 
	}
	// �츮�� �ѹ��� �� ���̴�. �׷��� new �ϸ� �޸𸮿� ���� ���� �ǹǷ� �ٸ� ����� ����. 
		// ���� �ʵ� ����.. 
	public static void main(String[] args) {
		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = " + aa);
		System.out.println("num = " + aa.num);
		System.out.println();

		SingleTon bb = new SingleTon();
		bb.num++;
		System.out.println("bb = " + bb);
		System.out.println("num = " + bb.num);
		System.out.println();

		//-----------------------

		System.out.println("\n**�̱���**");
		// SingleTon cc = new SingleTon(); �̷��� �ϸ� �ȵȴ�. 
		SingleTon cc = SingleTon.getInstance(); // ������ �ƴ� �ҷ����⸦ �ؾ��Ѵ�. 
		
		cc.num++;
		System.out.println("cc = " + cc);
		System.out.println("num = " + cc.num);
		System.out.println();

		SingleTon dd = SingleTon.getInstance(); // cc�� ���� instance�� null �� �ƴϴ�. 
		// cc�� ���� dd���� �Ѿ�´�. 
		dd.num++;
		System.out.println("dd = " + dd);
		System.out.println("num = " + dd.num);
		System.out.println();


	}
}
