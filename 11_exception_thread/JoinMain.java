class JoinTest implements Runnable{
	// JoinMain�� �����尡 �ƴϰ�, �����尡 �ǰ���� �� 
	// implements�� ������ִ°� �ƴϰ� �׷��� �䳻���� ��
	@Override
	public void run(){ // ���⿡ throws �� �Ǵ�. (�������̵�� �޼��忡�� �ȸ���)
		for(int i = 1; i <= 5; i++){
			System.out.println(i);

			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}

		}
	}
}

class JoinMain {
	public static void main(String[] args) throws InterruptedException{
		JoinTest jt = new JoinTest();
		Thread t = new Thread(jt); 
		// ��ȣ�� ���� ������ �����ϸ� �ȵ� 
		// ���������� Ʋ���� ������, 
		// ���� �����尡 �ǰ� ���� ���� JoinTest �̴�. 
		// ��ȣ �ȿ� jt�� �־� �����尡 �ǰ��� �ϴ� ���� ����ؾ��Ѵ�. 
		
		System.out.println("������ ����");
		t.start(); // ������ ����

		t.join(); // �����带 ���� (����ó�� �Ұ�) 

		System.out.println("������ ����");
		
	}
}
