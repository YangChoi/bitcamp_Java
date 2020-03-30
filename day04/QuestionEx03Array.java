package day04;

import java.util.Scanner;

public class QuestionEx03Array {
	
	private static final int SIZE = 5; 
	private static final String EMPTY_STRING = "";
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] array = new String[SIZE];
		
		
		init(array); // String array를 빈값으로 채워주는 메소드 
		//printAll(array); // 전부 다 출력해주는 메소드 

		
		// 인덱스 채워보기 
		for(int i = 0; i < array.length; i++) {
			System.out.print("문자를 입력하라 : ");
			String userString = scan.next();
			add(array, userString);
		}
		System.out.println("====입력한 값====");
		printAll(array);
		
		// 비교할 array의 input 값
		System.out.println("====가는 여기에 있다.====");
		System.out.println(indexOf(array, "가"));
		
		// remove 값을 없앤다 
		remove(array, "가");
		System.out.println("====가를 없앤 값====");
		printAll(array);
		
		System.out.println("==== contain 돌아가는거 확인 ====");
		contains(array, "가");
		printAll(array);
		
		// 닫아주기 
		scan.close();
	}
	
	// 빈공간 확인하는 메소드 
	private static boolean contains(String[] array, String keyword) {
		for(int i = 0; i < array.length; i++) {
			if(array[i].equals(keyword)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	// 내가 준 String 값'가'와 똑같은 곳의 index를 return하는 메소드 
	// 단 array에 사용자가 입력한 input과 같은 String이 없을 경우 -1 return 
	private static int indexOf(String[] array, String input) {
		for(int i = 0; i < array.length; i++) {
			if(array[i].equals(input)) {
				return i;
			}
		}
		return -1;
	}
	
	// 전부 출력
	private static void printAll(String[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	// 배열을 String 공간으로 초기화하는 메소드 
	private static void init(String[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = new String();
		}
	}
	// 요소 추가해주는 메소드 
	// 해당 메소드를 호출하면 NULL값이 없어진다. 
	private static void add(String[] array, String input) {
		int index = indexOf(array, input);
		for(int i = 0; i < array.length; i++) {
			if(array[i].equals(EMPTY_STRING)) { // 비어있으면 
				array[i] = input; // input으로 채워넣는다. 
				break;
			}
		}
	}
	
	// 해당 스트링 제거 
	private static void remove(String[] array, String keyword) {
		int index = indexOf(array, keyword); 
		if(index != -1) {
			array[index] = new String();
			
		}else {
			System.out.println("해당 keyword는 존재하지 않습니다.");
		}
	}
	
	

}
