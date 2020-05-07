class Factory{
	private int product;
	
	// ����ȭ �߱� ������ �Ѵ� ���ÿ� �� �� ���� 
	// ���길 �ϴ� ��
	public synchronized void produce(){
		if(product > 4){
			// ������ ����� ������ �׿��ٸ� sell�� �ҷ� �Һ� ���� 
			System.out.println("���� �ߴ� :" + product);
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			 
		}
		product++; // ������ ��� ����� 
		System.out.println("���� : " + product); // ���� ��������. 
		notifyAll(); //��� �����带 ����� (�Һ��� �غ� �ض�)
	}

	// �Һ� �ϴ� �� 
	public synchronized void sell(){
		// �Һ��� ������ ������ produce ������ ���� ����
		if(product < 1){
			// ������ ���ٸ� 
			System.out.println("�Һ� �ߴ� :" + product);
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
		product--;
		System.out.println("�Һ� : " + product);
		notifyAll(); // ��� �����带 ����� (������ �غ� �϶�)
	}
}

// ������ ���� ���
class Worker extends Thread{
	private Factory factory; // Factory �� �����´� 
	
	// ������ ���� factory �� �����´� 
	public Worker(Factory factory){
		this.factory = factory;
	}

	public void run(){
		for(int i = 0; i < 12; i++){
			factory.produce();
		}
	}
}

// ������ �Һ��� ���
class Buyer extends Thread{
	private Factory factory;
	
	public Buyer(Factory factory){
		this.factory = factory;
	}

	public void run(){
		for(int i = 0; i < 12; i++){
			factory.sell();
		}
	}
}


class FactoryMain {
	public static void main(String[] args) {
		Factory f = new Factory();
		// ������ ���� 
		Worker t = new Worker(f);
		Buyer b = new Buyer(f);
		// �� �� ����� �޾� �� ��ü�� thread�� �Ǿ��� ������ ���� ���� ���� ���� 
		// �� factory���� ���� �ް� �ֱ� ������ factory ���� ���� �Ѱ��ش�. 
		// ������ ����
		t.start();
		b.start();
	}
}

// �������� ����Ǹ�
// �Һ� ������ 
// ������ �������� �����带 ������ ���� ������ �� �ִ�. 
