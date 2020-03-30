package day04;

import java.util.Scanner;

/*
 * String 배열을 만들어서 사람이 값을 입력하고 
 * 배열에 있는 값을 우리가 메소드를 만들어서 컨트롤해보자
 */

/*
 * 메소드 클릭하고 F3 하면 해당 메소드 코드로 가짐 
 */
public class Ex03Array {

	private static final int SIZE = 5;
	private static final String EMPTY_STRING = "";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] array = new String[SIZE];
		// array가 클래스의 배열이므로 초기화를 해주자
		// 초기화도 메소드를 시켜서 코드를 분리하자.
		
		init(array);
		printAll(array);
		// array[0].equals("abc"); // nullpointexception
		// 아파트도 없는 상태
		// System.out.println(EMPTY_STRING.equals("abc")); // 실행가능
		// 위의 얘는 값 만 없을 뿐이지 있을 건 있다.
		// 이 아파트 abc님 꺼세요? >> 아닌데요. 상태
		

		for (int i = 0; i < array.length; i++) {

			System.out.print("문자를 입력해주세요 : ");
			String userString = scan.next();
			
			add(array, userString);

		}
		printAll(array);
		
		System.out.println(indexOf(array, "abc"));
		remove(array, "abc");
		System.out.println(indexOf(array, "cde"));
		
		//System.out.println(indexOf(array, EMPTY_STRING));
		// 그 다음에 사용자가 값을 입력하면
		// 우리가 위치를 지정하지 않고
		// 메소드를 통해서
		// 아무값도 없는 공간에 자동으로 찾아서
		// 그 위치에 사용자가 입력한 값을 넣는 메소드를 만들어보자

		scan.close();

	}

	// 빈공간 확인하는 메소드
	private static boolean contains(String[] array, String keyword) {
		// 배열을 돌면서 keyword와 일치하는 요소가 있으면 true를 리턴하고
		// 없으면 false 리턴.
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(keyword)) {
				return true;
			}
		}
		return false;
	}

	// return이 boolean이 아닌
	// 내가 준 스트링 값과 똑같은 곳의 index를 return하는
	// indexOf(String[] array, String input)을 만들어보기
	// 단 array에 사용자가 입력한 input과 같은 String값이 없을 경우
	// -1을 return 한다

	// >> 리턴 타입 : int

	private static int indexOf(String[] array, String input) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(input)) {
				return i;
			}
		}
		return -1;
	}

	// 전부 출력하는 메소드
	private static void printAll(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	// 배열을 String 공간으로 초기화하는 메소드
	private static void init(String[] array) {
		for (int i = 0; i < array.length; i++) {
			// 배열.length는 해당 배열의 크기를 리턴해준다.
			array[i] = new String();
			// 배열을 String 공간으로 초기화 해준 것
			// 만약 얘를 안하고 출력하면 null이 나옴
		}
	}

	// 요소 추가하는 메소드
	private static void add(String[] array, String input) {
		int index = indexOf(array, EMPTY_STRING);

		if (index != -1) {
			array[index] = input;
//			for (int i = 0; i < array.length; i++) {
//				if (array[i].equals(EMPTY_STRING)) { // array가 비어있으면 
			// 클래스형 변수에는 무슨 값이 있는가?
			// >> 주소값
			// 클래스의 배열 각 위치에 무슨 값이 있는가?
			// >> 주소값
			// 그럼 클래스형 변수.equals()하던것을
			// 배열[위치].equals 할 수도 있다.
//					array[i] = input;
//					break; // break를 하지 않으면 사용자가 입력한 array값까지 빈값으로 돌아다니게 된다.
//				}
//			}
		} else {
			System.out.println("빈공간이 없습니다. ");
		}
	}
	
	// 그럼 스트링 파라미터를 이용해서 
	// 해당 스트링이 존재하면 
	// 그 칸에 new String()을 호출하는 방식으로
	// 해당 스트링을 제거하는 
	// remove(String[] array, String keyword)를 만들어보자 
	
	private static void remove(String[] array, String keyword) {
		 int index = indexOf(array, keyword);
		 if(index != -1) {
			 array[index] = new String();
			 
		 }else {
			 System.out.println("해당 keyword는 존재하지 않습니다. ");
		 }
	}

}
