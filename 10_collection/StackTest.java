import java.util.Stack;
import static java.lang.System.out; // System 대신에 import (추천은 하지 않음..) 

// First in last out 
class StackTest {
	public static void main(String[] args) {
		String[] groupA = {"우즈베키스탄", "쿠웨이트", "사우디", "대한민국"};
		Stack<String> stack = new Stack<String>();

		for(int i = 0; i < groupA.length; i++){
			stack.push(groupA[i]); // 하나씩 스택에 넣는다 
		}

		while(!stack.isEmpty()){ // 스택이 비지 않을 동안 
			out.println(stack.pop()); // 스택을 꺼낸다. 
			// 들어갈 땐 우즈베키스탄 부터 들어가지만 나올 때는 대한민국 부터 나오는 것이 stack 
		}
		
	}
}
