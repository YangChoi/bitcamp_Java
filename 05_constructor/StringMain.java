class StringMain {
	public static void main(String[] args) {

		// Ŭ������ new�� �����ϴµ� 
		// Ŭ������ String�� �� new �Ⱦ���?
		// String cc = new String(); �� ����
		// >> ���ͷ�literal ���� 

		// ��� Constant 
		// : ������ �ʴ� �� 
		// literal 
		// ���� literal - 2
		// �Ǽ� literal 
		// ���� literal -'A' , '2'
		// ���ڿ� literal - "A" , "2"(�ƽ�Ű�ڵ尡 ���� ���ڿ�)

		String aa = "apple";
		String bb = "apple";
	
		if(aa == bb){
		// �� �ּҰ� ������ 
			System.out.println("a�� b�� �������� ���� ");
		}else {
			System.out.println("a�� b�� �������� �ٸ���  ");
		}

		if(aa.equals(bb)){
			System.out.println("a�� b�� ���ڿ��� ���� ");
		}else {
			System.out.println("a�� b�� ���ڿ��� ���� ");
		}


		

		String cc = new String();
		String dd = new String();
		

		if(cc == dd){
		// �� �ּҰ� ������ 
			System.out.println("c�� d�� �������� ���� "); // new�� �Ἥ ���� ��ü�� ��������� ������ �ּҰ� �ٸ���
		}else {
			System.out.println("c�� c�� �������� �ٸ���  ");
		}

		if(cc.equals(dd)){
			System.out.println("c�� d�� ���ڿ��� ���� "); 
		}else {
			System.out.println("c�� d�� ���ڿ��� ���� ");
		}
	
		String ee = "���� ��¥�� " + 2020 + 4 + 13;

		System.out.println(ee);

		/*  ee�� ���յǴ� ����...
			"���� ��¥�� "
			"���� ��¥�� 2020"
			"���� ��¥�� 20204"

                    012345 ... �ε����� ����
			ee ->> "���� ��¥�� 2020413"
			3���̳� ������� ������ �޸� ���� ���ϴ�. 
			
			���ڿ��� ������ �ȵǹǷ� �޸� 4�� �����ȴ�. 
			JVM�� ���ؼ� ���� �� Garbage Collector�� ������ 
			Garbage Collector�� ����Ǹ� ��ǻ�ʹ� �����. 
		*/

		System.out.println("���ڿ��� ũ�� = " + ee.length()); // ���� ���Ե� 
		System.out.println("���� ���� = " + ee.charAt(4)); // ¥ ����
		System.out.println("���ڿ� ���� = " + ee.substring(7)); // �ε��� 7������ �� ���
		System.out.println("���ڿ� ���� = " + ee.substring(7, 11)); // 2020�� �̾ƿ�. 10�ƴϰ� 11�̴�..
		System.out.println("�빮�� ����  = " + "Hello".toUpperCase());
		System.out.println("�ҹ��� ����  = " + "Hello".toLowerCase());

		System.out.println("���ڿ� �˻� = " + ee.indexOf("¥")); // 4
		System.out.println("���ڿ� �˻� = " + ee.indexOf("��¥")); // 3
		System.out.println("���ڿ� �˻� = " + ee.indexOf("�ȳ�")); // ���� ��� -1 ���

		System.out.println("���ڿ� ġȯ = " + ee.replace("����", "����")); 
		System.out.println("���ڿ� ġȯ = " + ee.replaceAll("����", "����")); 
		
	}
}