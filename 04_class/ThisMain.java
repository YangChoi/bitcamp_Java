class ThisTest{
	private int a; 
	
	// set
	public void setA(int a){
		//a; // Ŭ������ ������ �� �� ��� , ���� ������ ���� 
		// �� �������� a�� �޼ҵ��� �Ű������� �ִ� int a�̴�. 
		// ������ private int a�� a��� �ϰ� �ͱ⶧����...
		System.out.println("this = "+this);
		this.a = a; // a �ڽ� 
	}

	// get
	public static getA(){
		return a; // �ʵ��� a (this.a�� ������ ����)
	}
}

class ThisMain{
	public static void main(String[] args){
		
		ThisTest aa = new ThisTest();
		System.out.println("aa = " + aa);
		aa.setA(10);

		ThisTest bb = new ThisTest();
		System.out.println("bb = " + bb);
		bb.setA(20);
	}
}