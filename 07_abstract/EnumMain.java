/*
class EnumColor {
	static final String RED = "����";
	static final String GREEN = "�ʷ�";
	static final String BLUE = "�Ķ�";
	static final String MAGENTA = "����";
}
*/

//enum : Ŭ������ �ƴ� �ڷ��� 
enum EnumColor {
	RED, GREEAN, BLUE, MAGENTA; 
}
class EnumMain{
	String colorName;
	EnumColor color;

	public static void main(String[] args) {
		System.out.println(EnumColor.RED);
		System.out.println();
		// enum�� ��� static���� ������ ������ �Ǿ� �ִٴ� ��. 
		// EnumColor ���� ������ �ϳ��� ����� �ν��� �Ǿ� ���´�. 

		EnumMain em = new EnumMain();
		em.colorName = "����";
		em.color = EnumColor.RED;
		System.out.println(em.colorName + "\t" + em.color);
		// �̷��Ե� ���� 
		
		em.colorName = "����";
		EnumColor VIOLET = EnumColor.MAGENTA;

		// int a = 25; 
		// int b = a; // �̷� �İ� �����.. 
		// MAGENTA�� VIOLET ����� ���ٴ� ������ ǥ�� 
		// Ŭ������ �ڷ����� �ƴ� EnumColor���� �׷��� �� �� �ִ� ��. 

		System.out.println(em.colorName + "\t" + VIOLET);
		System.out.println();
		
		// �ε������� 0���� �����Ѵ�. 
		for(EnumColor data : EnumColor.values()){
			System.out.println(data + "\t" 
								+ data.ordinal() + "\t"
								+ data.valueOf(data + "")); // String���� �ٲ�� 
								// String���� enum���� ã�� valueOf
								// data.valueOf("BLACK"); �� ã�� ���� ���ٴ� ������ �� (�Ʒ� ���� ����)
		}

	}
}
// valueOf()
// String ���� enum���� �������� ���� ������ IllegalArgumentException �߻�
