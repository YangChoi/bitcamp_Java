abstract class AA {
	public abstract void sub();
	// ���� �������� �ʱ� ������ ������ ���� �����ݷ�
	
	public final void disp(){}
	// final �ɸ� override ���� �ϸ� �ȵ�
}

class BB extends AA {
// �θ�Ŭ������ �߻�Ŭ�����̸� �ڽ� Ŭ������ �ݵ�� �������̵� ������Ѵ�. 
	public void sub(){} // �ݵ�� override
	public void disp(){} // override �ϸ� �ȵ� - final �ɾ��� 
}

// override�� final�� ���ݴ� ���� 

// �߻�Ŭ���� ����ü �� ����?
// >> 






