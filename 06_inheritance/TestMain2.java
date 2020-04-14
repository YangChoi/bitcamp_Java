class AA {
	public int a = 3; 
	public void disp(){
		a += 5;
		System.out.print("AA :" + a + " ");
	}
}

class BB extends AA{
	public int a = 8; 
	// ������ ���ؼ��� �������̵� ����
	// �������̵��� �޼ҵ忡 ���ؼ���
	public void disp(){
		this.a += 5;
		System.out.print("BB : " + a + " ");
	}
}

class TestMain2{
	public static void main(String[] args){
		BB bb = new BB();
		bb.disp(); // BB : 13
		System.out.println(bb.a + " "); // 13

		AA aa = new BB();
		aa.disp(); // BB : 13
		System.out.println(aa.a + " ");  //3
		// ������ �������̵� ���� 
		// �޼ҵ�� �� �����ѵ� �������̵� �Ǿ �ڽ� ���� ���� 
		// ������ �׷��� �ʴ�. ����Ű�´�� ����ȴ�. 

		BB bb2 = (BB)aa; // �Ұ��� 
		// �θ�� �ڽ��� ������ �� �ִ�. 
		// ������ �ڽ��� �θ� ������ �� ����. 
		// �ݵ�� �ٿ� ĳ������ ���־���Ѵ�. 
		System.out.println(bb2.a + " "); //13
		

	}
}