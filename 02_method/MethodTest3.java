import java.util.Random;

class MethodTest3 {
	public static void main(String[] args) {
		System.out.println("ū �� :: " + Math.max(25, 36));

		// 2�� 5�� ��� : 32
		double power = Math.pow(2, 5);
		System.out.println("���� :: " + (int)power);

		// ���� > ��ǻ�Ͱ� �ұ�Ģ�ϰ� �߻��ϴ� ��, 0 < ���� <= 1
		int a;
		a = (int)(Math.random() * 100); // 0 ~ 99.xxx 
		// ���� +1 �ϸ� 1���� 100���� ���´�. 
		System.out.println(a);
		// ����ȯ�� ���ʿ� �Ұ� : a�� �Ұ� 
		// ����ȯ�� �����ʿ� 

		Random random = new Random();
		double b; 
		b = random.nextDouble();
		System.out.println(b);
				
	}
}