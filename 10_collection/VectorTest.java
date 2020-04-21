import java.util.Vector;

class VectorTest {
	public static void main(String[] args){
		Vector<String> v = new Vector<String>(); // �⺻ �뷮 10�� , 10���� ���� 
		System.out.println("���� ũ�� = " + v.size()); // 0
		System.out.println("���� �뷮 = " + v.capacity()); // �⺻ �뷮 10�� 
		System.out.println();

		System.out.println("�׸� �߰�");
		for(int i = 1; i <= 10; i++){
			v.add(i +"");
		}

		System.out.println("���� ũ�� = " + v.size()); // 10
		System.out.println("���� �뷮 = " + v.capacity()); // 10 : ���簪�� �ʰ����� �ʱ� ������ 10�� �״�� 
		System.out.println();

		
		// ũ�Ⱑ �뷮�� �ʰ����� �� 
		// �뷮�� 10�� �þ �� 20���� �ȴ�. 
		System.out.println("�׸� �ʰ�");
		v.addElement(5+""); // �ߺ����, ���� 
		System.out.println("���� ũ�� = " + v.size()); // 11
		System.out.println("���� �뷮 = " + v.capacity()); // 20
		System.out.println();
	

		// ������ �ּҰ���? 
		System.out.println(v); // �� ������� ������ �ߺ��� ����ϴ� ���� Ȯ�� 
		

		System.out.println("�׸� ����");
		v.remove(10); // �ε��� 10��° �� ���� 
		System.out.println(v);

	}
}
