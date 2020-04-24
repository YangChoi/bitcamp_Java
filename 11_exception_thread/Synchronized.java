class Synchronized extends Thread{
	private static int count = 0; 
	
	public static void main(String[] args) {
		Synchronized aa = new Synchronized(); // ������ ����
		Synchronized bb = new Synchronized(); 
		Synchronized cc = new Synchronized();
		
		// �����忡 �̸� �ο� 
		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		// ��������� - ������ ���� 
		aa.start();
		bb.start();
		cc.start();

	}
	/*
	@Override
	public void run(){ // ����ȭ�� �ȵ�
		for(int i = 0; i < 5; i++){
			count++; // count�� static���� ��ұ� ������ 
			// count�� aa,bb,cc ���� ���� ��°��� �ƴϰ� ���� �ѹ��� ��´�. 
			// ���� 0���� 15���� �� 
			System.out.println(Thread.currentThread() + "count = " + count); // ���� ���� ������ ��� 
			// ����ȭ�� �ȵǾ ��ġ�� ���ڵ��� ���δ�. 

		}
	}*/
	/*
	@Override - ����ȭ �ȵ� 
	public synchronized void run(){ // ����ȭ�� �ȵ� >> this����(Ŭ������) �� �޶� ���� ���� ����. 
		for(int i = 0; i < 5; i++){
			count++; // count�� static���� ��ұ� ������ 
			// count�� aa,bb,cc ���� ���� ��°��� �ƴϰ� ���� �ѹ��� ��´�. 
			// ���� 0���� 15���� �� 
			System.out.println(Thread.currentThread().getName() + " count = " + count); // ���� ���� ������ ��� 
			// ����ȭ�� �ȵǾ ��ġ�� ���ڵ��� ���δ�. 

		}
	}
	*/
	// ����ȭ �ɸ���. 
	public void run(){
		//synchronized(Synchronized.class){ // ����ȭ �� >> class �̷��� ���� �ֵ��� �� ���ڴٰ� ǥ���� ���̹Ƿ� Ȯ���� ���� �� ����
		synchronized(this){ // ����ȭ �ȵ� // this�� class ���� ���� �ִ� ���� ��� �ִ� ��, this ������ �� �ٸ��Ƿ� ���� ���� ����. �׷��� ���� ���� ������ �𸣱� ������  
		// ���� ���� �� ���� ���� ������ ���� �־�����Ѵ�. 
			for(int i = 1; i <= 5; i++){
				count++;
				System.out.println(Thread.currentThread().getName() + " count = " + count); 
			}
		}
	}

}
