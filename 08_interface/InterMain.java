//class InterMain implements InterA, InterB {
class InterMain implements InterC { // ���� ���� �ȴ�. 
		// InterC�� �ᱹ InterA, InterB�� �ް� �ֱ� ���� 

	// implements�� �� Ŭ������ �ݵ�� �߻�޼ҵ带 override���־���Ѵ�. 
	// interface�� ������ �� �� �ִ�. �׷� ��� �� override ���־���Ѵ�.

	// Ŭ���� �տ� abstract�� ���̸� ���� ���ϰ� �� ���� ���뿡�� �̷�� �� 
	// �̷��� �ϸ� InterMain�� ���� new �� �� ����. 
	
	// InterA�� ���� �������̵� 
	public void aa(){}
	public void bb(){}

	// InterB�� ���� �������̵� 
	public void cc(){}
	public void dd(){}
	
	public static void main(String[] args) {
		
	}
}
