class Test {
	@Override
	public String toString(){
		return getClass() + "@�ȳ�";
		// �������̵�� ���� �ּҰ��� �ȳ����� �ٲ� 
	}
}

class Sample{
	
}

class ObjectMain{
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("��ü t = " + t); // ��ü t = Test@15db9742
		//t�� Ŭ������@16���� 
		System.out.println("��ü t = " + t.toString()); // �Ʒ��� �޼ҵ带 ����ϸ� ���� �Ȱ��� ���´�. 

		Sample s = new Sample();
		System.out.println("��ü s = " + s); // ��ü s = Sample@15db9742
		System.out.println("��ü s = " + s.toString()); 
		System.out.println("��ü s = " + s.hashCode()); // ��ü �ּҰ� 16������ 10������ ����  
		System.out.println();

		String str = "apple";
		System.out.println("��ü str = " + str);
		// �̰� �� ���� ó�� ��ü�� �ּҰ��� ��µ��� �ʰ� apple�� ��µɱ�? 
		// �������̵� �����̴�. 
		// Object�� �ּҰ��� ������ toString�� String Ŭ�������� ���ڿ��� ������ �������̵� �߱� ���� 
		System.out.println("��ü str = " + str.hashCode()); // ������ �ȵ� 
		System.out.println();

		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc == dd : " + (cc == dd) ); //f
		System.out.println("cc.equals(dd) : " + cc.equals(dd)); //f - ������ �� 
		System.out.println();

		Object ee = new String("apple");
		Object ff = new String("apple");
		System.out.println("ee==ff : " + (ee == ff)); // f
		System.out.println("ee.equals(ff) : " + ee.equals(ff)); // t - ���ڿ� �� 
		System.out.println();
		// ����� ��� �������̵�� �޼ҵ�� �� �ߵ��� �켱���� �ڽ�(�ڱ��ڽ�)�� ������ �ȴ�. 
		// ���� ee�� ff�� �ڱ� �ڽ�(String)�� �޼ҵ带 �ߵ��Ѵ�. 

	}
}


/*
class Object {
	public String toString(){} >> Ŭ������@16���� �� �����ִ� Ŭ���� 
	public int hashCode(){} // 10������ ���� 
	public boolean equals(Object ){} // ������(�ּҰ�) �� 
}

class String extends Object{
	public String toString(){} // �ּҰ��� �ƴ� ���ڿ��� �������̵� �� �� 
	public int hashCode(){} // ���ڿ��� 10������ �ٲٴ°� (���� Object�� 16������ 10������ �ٲ� ���̶� �ŷڰ���) 
	// �׷��� ���� hashCode�� ���ڿ��� 10������ ��ȯ�� ��, 
	// ���ڿ��� ���� ���� >> ���� ���ڿ��� 10������ ��ȯ�� �� ���� (int ���� 21�ﰳ�� �Ѱ�, 4����Ʈ)
	// �׳� �ִ°Ŵ�.. String Ŭ������ hashCode() �� ���� �� ��.. 
	public boolean equals(Object ){} // ���ڿ� �� (Object�� �Ű������� ���� ���� ���� ���͵� �ȴٴ� ��)
}
*/