class Test{
	// default : ���� ���丮�� Ŭ������ ��� ���� �ᵵ �� 
	int a, b;
}

//------------
class TestMain {
	public static void main(String[] args){
		Test aa = new Test();
		Test bb = aa; 
		// aa �� �ּҰ��� bb���� �ش�. 

		aa.a = 10; // ���� 
		aa.b = 20;
		System.out.println(aa.a+"\t"+aa.b); // 10 20 
		System.out.println(bb.a+"\t"+bb.b); // 10 20 
		
		bb.a = 30; 
		bb.b = 40; 
		// bb�� ����Ű�� a, b ���� 30, 40���� ���� 
		System.out.println(aa.a+"\t"+aa.b); // 30 40 
		System.out.println(bb.a+"\t"+bb.b); // 30 40 

		bb = new Test(); // Ŭ������ �� ���� �� 
		// ���ο� �ּ� 
		bb.a = 50; 
		bb.b = 60;
		System.out.println(aa.a+"\t"+aa.b); // 30 40 
		System.out.println(bb.a+"\t"+bb.b); // 50 60 
	
	}
}