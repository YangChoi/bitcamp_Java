class SnackTest extends Thread{
	// �ϳ��� ������ �ٸ� �ϳ��� ó���ϴ� ���� �ƴϰ� 
	// �ϳ��� �ϴٰ��� �ٸ� ���� �ϰ� ������ ���� ��. 
	// � ���ڸ� �Դٰ� �ٸ� ���ڸ� �԰�, �� �� ���ڸ� �Դٰ� �ٸ� ���ڸ� �Դ� �� 
	
	// ä�� ���α׷����� ���� ����. 
	// �帧�� ���� �� ������ ��Ȯ�� ����� ������ �� ����. 
	
	public String str; 

	public SnackTest(String str){
		this.str = str;
	}

	public void run(){
		for(int i = 1; i <= 5; i++){
			System.out.println(str + "\t i = "+ i+ "\t" + Thread.currentThread());
			// ���� �����尡 ������ ����϶� 
			// �������� ���ÿ� ó����
		
		}
	}

	public static void main(String[] args) { 
		// ������ ���� 
		SnackTest aa = new SnackTest("�����");
		SnackTest bb = new SnackTest("��īĨ");
		SnackTest cc = new SnackTest("����Ĩ");
		
		// �����忡 �̸� �ο� 
		aa.setName("�����");
		bb.setName("��īĨ");
		cc.setName("����Ĩ");

		// �켱���� 1_~10
		aa.setPriority(Thread.NORM_PRIORITY); // �⺻�� 5
		bb.setPriority(Thread.MIN_PRIORITY); //1
		cc.setPriority(Thread.MAX_PRIORITY); // 10
		
		// ������ ���� - ������ ���� (�ü���� ���ؼ� ó�� : run() ��)
		aa.start(); 
		try{
			aa.join(); // ����� �׷��� ������ aa�� ���� �� �����ϰ� �ٸ� ������� �����Ѵ�. 
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		bb.start(); 
		cc.start();
		// ������ �� �ٸ��� ����ȴ�..
	}
}
