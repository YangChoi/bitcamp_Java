import javax.swing.table.*; 

interface Score {
// �߻� �޼��带 ���� Ŭ������ �ݵ�� �߻� Ŭ���������Ѵ�. 
	// �߻�޼��� 
	// ScoreImpl ���� ���� 
	// �̷��͵��� ���ڴٰ� �̸� �˷��� (INTERFACE)
	// �޴� ������ �Ű������� �����ش�. 
	// score�� ���� ���� �ʰ� impl(�ڽ�)���� �޴� ����
	// �θ�(interface)�� �Բ� �޾�����Ѵ�. 
	public void input(ScoreDTO dto);
	public void print(DefaultTableModel model);
	public int search(DefaultTableModel model, String hak);
	public void to_desc();
	public void load();
	public void save();
}
