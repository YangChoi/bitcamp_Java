abstract class AbstractTest{ // POJO ���� (Plain Old Java Object)
	protected String name; 
	
	public abstract void setName(String name); // �����ݷ����� �� : �߻�޼ҵ� 
	// �̷� �޼ҵ尡 ������� ���̶�� �̸� �˸��� ��
	// �߻�޼ҵ��� ��쿣 �߻��̶�� Ű���带 �ٿ�����Ѵ�. abstract 
	// ���� �߻�޼ҵ带 ������ �ִ� Ŭ������ Ŭ���� ���� �߻�Ŭ���������Ѵ�. 
	
	//public void setName(String name){
	//	this.name = name; 
	//}
	public String getName(){ // ���� (�޼ҵ��� ��ȣ : �޼ҵ��� �ٵ�)
		// ������ ������ ȣ���� �ؾ��Ѵ� 
		return name;
	}
}
