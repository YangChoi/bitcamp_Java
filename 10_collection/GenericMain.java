class GenericTest<T>{
	private T a; //a�� � Ÿ���� ���� �𸣱� ������ ���׸� <T>�� 
	
	public void setA(T a){
		this.a = a; 
	}

	public T getA(){
		return a; 	
	}
}

class GenericMain{
	public static void main(String[] args) {
		GenericTest<String> aa = new GenericTest<String>();
		// ���� �� Ÿ�� ���� (String Ÿ��)
		aa.setA("��ƹ���");
		//aa.setA(25);
		System.out.println("�̸� : " + aa.getA());
		
		// Ÿ���� ��ü���� ���´�(int �ȵ�)
		GenericTest<Integer> bb = new GenericTest<Integer>();
		bb.setA(30);
		System.out.println("���� : " + bb.getA());
	}
}
