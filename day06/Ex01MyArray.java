package day06;

import util.MyArray;

public class Ex01MyArray {

	public static void main(String[] args) {
//		int[] arr = new int[0];
//		System.out.println("==== arr에 10 추가 ====");
//		arr = MyArray.add(arr, 10); // arr에 10 값 추가
//		
//		System.out.println("==== arr 길이 확인 ====");
//		System.out.println(arr.length);
//		
//		System.out.println("==== arr의 0번째 확인 ====");
//		System.out.println(arr[0]); // arr 0번째 index 확인 : 10 들어가 있음 
//		
//		System.out.println("==== arr에 10 어디있니? ====");
//		System.out.println(MyArray.indexOf(arr, 10)); // arr에 10이 어딨는지 알려줘! > 0에 있어 
//		
//		System.out.println("==== arr에 20 어디있니  ====");
//		System.out.println(MyArray.indexOf(arr, 20)); // arr에 20이 어딨는지 알려줘! > 없어! -1
//		
//		System.out.println("==== arr에 20 추가 ====");
//		arr = MyArray.add(arr, 20); // arr에 20 추가
//		
//		System.out.println("==== arr에 20 있니없니  ====");
//		System.out.println(MyArray.contains(arr, 20)); // arr에 20 어딨는지 알려줘! > 1에 있어 
//		
//		System.out.println("==== arr에 20 제거====");
//		arr = MyArray.remove(arr, 20); // arr에 20 없애줘 
//		
//		System.out.println("==== arr에 20 있니없니 ====");
//		System.out.println(MyArray.contains(arr, 20)); // 20 어딨니? > 없어
//
//		System.out.println("==== arr에 인덱스 0 제거 ====");
//		arr = MyArray.removeByIndex(arr, 0); // 0번째 값 없애줘 
//		
//		System.out.println("==== arr에 인덱스 0 어딨니 ====");
//		System.out.println(MyArray.indexOf(arr, 0));
//		
//		System.out.println("==== arr에 최종 길이 확인 ====");
//		System.out.println(arr.length);
		
		// 배열을 특정 값이 들어가 있게 초기화 할때는
		// {}을 쓰고 그 안에 값을 넣어주면 된다. 
		int[] arr = {1, 2, 3, 4};
		// 3 어딨니? 
		System.out.println(MyArray.indexOf(arr, 3));
		
		// double, long. float, char, byte, short 어떡하지..
		// 내가 클래스를 만들면? 
		// 그 클래스로도 배열을 만들 수 있다. 
		// 그럼 그 클래스는 어떡하지 
		// 예시 : 회원클래스(Member.java)
		//		상품클래스(Product.java)
		//		게시글클래스(Board.java)
		// 왜 우리가 굳이 이런걸 만들어야하나 
		// 다른 사람에게 부탁해
		// 누구한테? java의 ArrayList한테!!!!!
		
		// 우리가 MyArray를 만든 이유 
		// 1. ArrayList가 어떻게 돌아가는지 한 번 보려고 
		// 2. 배열의 불편함을 느껴보자 
		//		배열의 가장 나쁜 점. 처음에 크기를 고정시켜야한다. 
		
		
		// 우리가 만든 MyArray를 이용해서 
		// 크기가 좀 자유로운 배열을 만들었지만
		// 만약 배열의 크기가 10000 인데 추가로 입력을 하면? 
		
	}

}
