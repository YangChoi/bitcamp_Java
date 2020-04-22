import java.io.IOException;

class ExceptionTest2 {
	private int dan;
	
	// �Է�
	public void input() throws IOException{ // ������ 
		System.out.print("�� : ");	
		dan = System.in.read()-'0'; // 1���� ���ڷ� �Է¹��� ex> A : 65 a : 97
		// ���ڿ��� ���������� �ٲ��ֱ� ���� -'0'
	}
	// ���
	public void output(){
		if(dan >= 2 && dan <= 9){
			for(int i = 1; i <= 9; i++){
			System.out.println(dan + "*" + i + "=" + dan*i);	
			}// for
		}else{
			//System.out.println("���ڴ� 2���� 9������ ����");
		
			try{
				// Exception �߻� 
				// ���� ���ϴ� �������� �����..
				// throws�ʹ� �ٸ�.. : ��� (��� ��)
				// throw : ���̷��� (��Ʈ��) ������ �߻���Ű�� �ֵ� 
				//throw new Exception("���ڴ� 2���� 9������ ����" );
				
				// MakeException ���� ���� ����
				throw new MakeException("���ڴ� 2���� 9������ ����" );
			}catch(Exception e){
				e.printStackTrace(); // �����޽����� ������. 
			}
		
		}
			
	}
	public static void main(String[] args) throws IOException {
		ExceptionTest2 et = new ExceptionTest2();
		et.input(); // ȣ�� 
		// throws�� ȣ��/���� �Ѵ� �����Ǿ���Ѵ�.
		// �׷��� ���� java�� ��ü������ ���� ���� �������̵� �� ��쿡�� 
		// �װ��� ������ ã�� ���� ���ܸ� �ɾ��� �� ����. 
		// �׷��� ������ �ڹٰ� �����ϴ� Override�� �޼ҵ忡�� throws�� ����ؼ� �ȵȴ�. 
		// 
		et.output();
	}
}
