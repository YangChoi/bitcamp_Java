import java.util.Stack;
import static java.lang.System.out; // System ��ſ� import (��õ�� ���� ����..) 

// First in last out 
class StackTest {
	public static void main(String[] args) {
		String[] groupA = {"���Ű��ź", "�����Ʈ", "����", "���ѹα�"};
		Stack<String> stack = new Stack<String>();

		for(int i = 0; i < groupA.length; i++){
			stack.push(groupA[i]); // �ϳ��� ���ÿ� �ִ´� 
		}

		while(!stack.isEmpty()){ // ������ ���� ���� ���� 
			out.println(stack.pop()); // ������ ������. 
			// �� �� ���Ű��ź ���� ������ ���� ���� ���ѹα� ���� ������ ���� stack 
		}
		
	}
}
