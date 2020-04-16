import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

class NumberTest {
	public static void main(String[] args) {
		//NumberFormat nf = new NumberFormat();
		// ���� - NumberFormat�� �߻��̱⶧���� new�� ���� �Ұ� 
		
		NumberFormat nf = new DecimalFormat();
		// sub class �̿��ؼ� numberFormat ����
		
		// �ڽ��� new�� ���ش�. 
		// 10���� ���� 
		// 3�ڸ����� ��ǥ�� ����. �Ҽ� ���� 3°�ڸ�
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		// �Ҽ����� ������ ǥ�� ������ 
		System.out.println();

		NumberFormat nf2 = new DecimalFormat("#,###.#��");
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678)); 
		System.out.println();

		
		NumberFormat nf3 = new DecimalFormat("#,###.00��");
		// 0 ����ǥ�� 
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678)); 
		System.out.println();

		//NumberFormat nf4 = NumberFormat.getInstance(); 
		// getInstance �ȿ��� NumbeFormat�� ���� ������ �ִ� �� 
		// �޼ҵ带 �̿��ؼ� ���� 
		// �� �ȿ��� Ŭ������ new ���Ѽ� �ִ� �� 

		NumberFormat nf4 = NumberFormat.getCurrencyInstance(); //����ǥ�ã� 
		nf4.setMaximumFractionDigits(2);
		// �ִ� �Ҽ� ��°���� ǥ��	
		nf4.setMinimumFractionDigits(2);
		// �Ҽ� ���ϰ��� ��� 0�� ���� ǥ�� 
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678)); 
		System.out.println();


		// �޷�ǥ�� 
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US); 
		nf5.setMaximumFractionDigits(2);
		nf5.setMinimumFractionDigits(2);
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678)); 
		System.out.println();

	}
}

/*
	Ŭ���� aa = new Ŭ����();
	Ŭ aa = new �ڽ�();
	// ��� Ŭ������ new�θ� �����Ǵ°� �ƴϴ� 
	// �޼ҵ�� 


*/
