abstract class AbstractTest {
// �߻�Ŭ������ �� �߻�޼ҵ�� ���� ���� ���� ���� �ִ� 
// ���� �������� �ʴ´�. (�߻�޼ҵ尡 �ִٸ� �ش� Ŭ������ �ݵ�� �߻�Ŭ���������Ѵ�)
	String name; 
	
	public abstract void setName(String name); // �߻�޼ҵ� 
	// �������̽��� abstract �Ƚ��൵ �ȴ�

	public String getName(){ // ����
		return name;
	}

}
