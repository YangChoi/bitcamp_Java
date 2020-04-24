import java.util.Scanner;

class ATMTest implements Runnable{
	private long depositeMoney = 100000; // �ܾ� 
	private long balance; // ã�����ϴ� �ݾ� 

	public static void main(String[] args) {
		ATMTest atm = new ATMTest();
		// ������ �Ƶ� ������ ���� 
		Thread mom = new Thread(atm, "����"); //ATMTest�� ������� ������� �ϱ� ������ 
		Thread son = new Thread(atm, "�Ƶ�"); //ATMTest�� ��Ī�ؾ��Ѵ�. 
											//��, static�̱� ������ this�� �ȵȴ�. 
		// �׷��� �츮�� �����带 ���� atm ��ü �ϳ��� ���� �����̱� ������ new �������� ���� atm�� ��������.
		
		// ������ �ΰ� run
		mom.start();
		son.start();
	}

	@Override
	public synchronized void run(){
		System.out.println(Thread.currentThread().getName() + "�� �ȳ��ϼ���."); // ���ù��� ���� �����带 �����´�
		// getName() : �������� �̸��� ������ 

		// ��ã�� 
		Scanner scan = new Scanner(System.in);
		System.out.print("ã���� �ݾ��� �Է����ּ��� : ");
		balance = scan.nextLong();
		// ������� ���� ���ÿ� ������ �� ó���Ǿ 
		// ������ �Ƶ鿡�� ���ÿ� �ݾ��� ����� �ȴ�. 
		// �׷��� ������ synchronized�� �ɾ ���� ���� ����� ����ǰ� �Ѵ�. (����ȭ)
		// �� ���� �ϳ��� 

		withDraw();
		// ������ �ִٸ� 
		// ??? = withDraw() �� �� ��. 
		// Ȥ��
		// System.out.println(withDraw());
		// ������ �ִٸ� �ݵ�� ���𰡸� �޾��� ���� �־���Ѵ�.
	}

	public void withDraw(){
		if(depositeMoney >= balance){ // ���� ã�� �� �ִ� ���� 
			if(balance%10000 == 0){ // ����� ���������� 
				depositeMoney = depositeMoney-balance;
				System.out.println("�ܾ��� " +depositeMoney + "�Դϴ�");
			}else {
				System.out.println("���� ������ �Է��ϼ���");
			}
		}else {
			System.out.println("�ܾ� �ʰ�");
		}
	}
}
