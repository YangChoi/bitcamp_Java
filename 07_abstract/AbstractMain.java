class AbstractMain extends AbstractTest{
	// ����� �ɾ��ְ� AbstarctMain�� �������̵带 ���־���Ѵ�. 
	// AbstractMain���� �߻��� �ɾ��ָ� ���� �ڽĵ鵵 �׷���. 
	// �׷��� �׳� �������̵带 �ɾ��ش�. 
	@Override
	public void setName(String name){
	
	}
	public static void main(String[] args) {
		//AbstractTest ab = new AbstractTest();
		// �߻� Ŭ������ ��ü������ new�� �� �� ���� 
		// ��, ��ü������ �޸� ������ �ȵȴ�. 
		AbstractTest am = new AbstractMain();
		// ������ �ڽİɷ�, ������ �θ�ɷ� 
	}
}
// ��� Ŭ������ new�� ���ϴ� �� �ƴϴ�. 
// �Ʒ��� �͵�ε� ���� 
// - �ڽ�
// - �޼ҵ�