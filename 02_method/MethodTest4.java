class MethodTest4{
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]); // �������� ���ڿ��� 10������ ���������� �ٲ��� 
		double b = Double.parseDouble(args[1]); // ���ڿ��� �Ǽ������� �ٲ���
		
		System.out.println(a+ " + " + b +" = " + (a+b));
	}
}


// ����ȯ Casting 
// �⺻���� �⺻������, ��ü���� ��ü�������� ����.. 
// �⺻���� int�� ��ü���� String���� ����ȯ �Ұ� 