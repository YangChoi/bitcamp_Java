class AbstractMain { //extends AbstractTest{
	// �߻� Ŭ���� �� �߻�޼ҵ� Override
	//@Override
	//public void setName(String name){
	//	this.name = name; 
		AbstractTest at = new AbstractTest(){
			@Override
			public void setName(String name){
				this.name = name; 
			}
		}; // �߰�ȣ : ���� ����ؼ� ���ִ� ��  (�� �ȿ��� Override���ش�) 
		// �� �߻�޼ҵ带 ��� Override ���� �� (��� ��ſ� �ϴ� �� ) 
		// �޼ҵ��� �����θ� ���� �� �ִ� ���� Ŭ���� �� 
		// ��, �߰�ȣ ���δ� �޼ҵ� �����ζ�� �� ��, at�� Ŭ������� �� 
		// �׷��� �� Ŭ������ class Ŭ���� ���� �̸��� ����. (�͸�Ŭ����) 
		// Ŭ���� ���� Ŭ���� (�͸�Ŭ����) 

		// AbstractMain.java
		// AbstractMain.class
		// AbstractMain$1.class (�̸��� ��� 1�� ǥ����) 

		InterA bb = new InterA(){ //Interface�� new�Ѱ��� �ƴϰ� �͸��� �ο��� �� 
			public void aa(){} // �͸��� �ο��߰� �׿� ���� �������̵带 ���� 
			public void bb(){}
		}; // �ѹ� ���� ������ �� 

		// AbstractExam cc = new AbstractExam(); // �̷��� ���� �Ұ� : �߻��̱� ������ 
		// ���� �͸� ����
		AbstractExam cc = new AbstractExam(){}; // ���⿡ �������̵鸣 ���൵ �ǰ� �����൵ �Ǵ� ��. 

}
	//public static void main(String[] args) {
		// �߻�Ŭ������ ��ü���� new�� �ȵ� ��. 
		//AbstractTest at = new AbstractTest();
		// ���� ��ӽ����ش�. 
		// ��ӽ����ָ� �ڽ�Ŭ������ �ݵ�� �߻�Ŭ���� ���� �߻�޼ҵ带 Override���־���Ѵ�.
		
		// Override �� �ڽ�Ŭ������ �����Ѵ�. 
		//AbstractTest at = new AbstractMain(); 
		
	//}

