import java.util.LinkedList;
import static java.lang.System.out;

// First in First out
class QueueTest {
	public static void main(String[] args) {
		String[] item = {"�ҳ�Ÿ", "������", "��Ծ�"};
		LinkedList<String> q = new LinkedList<String>();

		for(String n : item){ // item�� n�� �ְ� 
			q.offer(n); // ��� �߰� // �װ��� q���� �ִ´�. 
		}

		out.println("q�� ũ�� : " + q.size() + "\n");
		String data = "";

		while((data = q.poll()) != null){ // data�� �����´�. null �� �ƴϸ� (�����Ͱ� ������)
			out.println(data + "����!"); // �����Ѵ� 
			out.println("q�� ũ�� : " + q.size() + "\n"); // �� ť�� ũ�⸦ ��� 
		}// data�� �� �� ���� while �� ��� 
	}
}
