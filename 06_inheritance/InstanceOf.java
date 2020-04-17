class AA {}
class BB extends AA{}

class InstanceOf {
	public static void main(String[] args){
		AA aa = new AA();
		BB bb = new BB();
		AA aa2 = new BB(); 

		AA aa3 = aa; // aa�� Ŭ���� Ÿ���� ���� AA�̹Ƿ� ���� 
		if(aa instanceof AA){
			// aa�� casting �ȴ� 
			// aa�� �⸮Ű�� ������ AAŸ���� Ŭ������ �ִ�. 
			System.out.println("1. TRUE");
		}else {
			System.out.println("1. FALSE");
		}//TRUE

		AA aa4 = bb; // �θ� = �ڽ� (����)
		// bb �ȿ��� AA�� �ִ�. BB�� AA���� ��ӹ��� 
		if(bb instanceof AA){ 
			System.out.println("2. TRUE");
		}else {
			System.out.println("2. FALSE");
		}//TRUE

		BB bb2 = (BB)aa2;
		// BB�� �ڽ�. 
		// �׷��� �θ��� ���� �ڽ� ���� �������� ��
		// �ڽ� = �θ� 
		// �Ұ��� 
		// ���� �ڽ� = (�ڽ�)�θ� �� �ٿ�ĳ�����ؾ��� 
		if(aa2 instanceof BB){ 
			System.out.println("3. TRUE");
		}else {
			System.out.println("3. FALSE");
		}// TRUE

		//BB bb3 = (BB)aa;
		if(aa instanceof BB){ 
			System.out.println("4. TRUE");
		}else {
			System.out.println("4. FALSE");
		}// ���� 
		// ĳ���� �ȵ� 
		// aa�� AA �ּҰ��� �̹� ������ �ִ� 
		// ��ü������ BB�� ����������� ����. 
		// ���� ĳ���� �Ұ� 
		// �����ϰ� AA�� ����Ű�� ����
		

	}
}