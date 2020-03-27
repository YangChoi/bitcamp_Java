package day03;
/*
 * 다중 for loop (Nested)
 * for문 안에 for문
 */
public class Ex07NestedForLoop {

	public static void main(String[] args) {
		// 다중 for loop
		for(int i = 1; i <= 5; i++) {
			for(int k = 100; k <= 105; k++) {
				System.out.print("i의 값 : " + i);
				System.out.println(", k의 값 : " + k);
			}
		}

	}

}
