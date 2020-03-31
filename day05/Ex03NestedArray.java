package day05;

import java.util.Scanner;

import util.MyScanner;

/*
 * 1. 차량 소유주를 가지고 있는 String 배열 1개 
 * 2. 소유주의 차량이 뭔지를 가지고 있는 String 배열 1개 
 * 3. 연식과 가격을 가지고 있는 인트 2차원 배열 1개 
 * 
 * 만들어서 거기에 값을 입력하는 것 까지 
 * 단, 5명의 정보만 갖도록 > 배열 크기는 5
 * 
 *  출력은 간단하게 
 *  이름 차량 연식 가격 만 5줄 나오게 
 */
public class Ex03NestedArray {
	private final static int SIZE = 5;
	private final static int INT_COLUMNS = 2;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 내 망한 코드
//		String[] owner = new String[5]; // 5명의 차주인
//		String[] car = new String[5]; // 차종
//		int[][] carAbout = new int[5][2]; // 차 연식과 가격
//		
//		// 차 주의 수만큼 차에 대해 물어보기 (5명)
//		for (int i = 0; i < owner.length; i++) {
//			System.out.print("차 주 명  : ");
//			String name = scan.nextLine();
//
//			System.out.print(name + " 의 차 종 : ");
//			car[i] = scan.nextLine();
//
//			
//			owner[i] = name;
//			// 2차원 배열에 값을 각각 어떻게 넣는지 잘 모르겠다. (입력과 출력 어케 하는지 모르겠다)
//	
//			scan.nextLine();
//		}
//		

		// 소유주 담당 배열
		String[] owners = new String[SIZE];
//		add(owners);
//		System.out.println(owners);
		// 차량 담당 배열
		String[] types = new String[SIZE];

		// 연식-가격 담당 배열
		int[][] yearPriceArray = new int[SIZE][INT_COLUMNS];
		
		// 밑의 for문 대신의 입력 메소드 
		insert(owners, types, yearPriceArray);
//		int a = 3; 
//		add(a);
//		System.out.println(a); // 13이 나와야하는데 왜 3이 나와? 
//		// 왜? 
//		String str = "abc";
//		add(str);
//		System.out.println(str); // 얘도 abcaaaa어쩌고가 나와야하는데 안나와... 
//		// 왜??
//		// ( 밑에 설명)

//		int price = MyScanner.nextInt(scan);
//		System.out.println(price); // MyScanner의 메소드 잘 작동하나 확인 

		
//		// 입력
//		for (int i = 0; i < owners.length; i++) {
//			System.out.print("이름 : ");
//			owners[i] = scan.nextLine();
//
//			System.out.print("차종 : ");
//			types[i] = scan.nextLine();
//
//			System.out.print("연식 : ");
//			yearPriceArray[i][0] = MyScanner.nextInt(scan);
//			System.out.print("가격 : ");
//			yearPriceArray[i][1] = MyScanner.nextInt(scan);
//
//			// 위에서 MyScanner가 아래의 코드에 대한 역할을 수행하기 때문에 지움
//			// scan.nextLine(); // 버퍼메모리 지워주기
//
//		}
		
		// 밑의 for문을 대신할 출력 메소드 
		print(owners, types, yearPriceArray);
		
		// 출력
//		for (int i = 0; i < owners.length; i++) {
//			System.out.println("차주명\t차종\t연식\t가격\t");
//			System.out.printf("%s %s %d %d \n", owners[i], types[i], yearPriceArray[i][0], yearPriceArray[i][1]);
//		}

		scan.close();

		// 내 망한 코드
//		System.out.println("==== 차Table ====");
//		for (int i = 0; i < owner.length; i++) {
//			
//			System.out.println(owner[i] + "의 차");
//			System.out.println("소유주\t차종\t연식\t가격\t"); // 표만들기 끝
//			
//			// 출력
//
//			for(int k = 0; k < owner[i].length(); k++) {
//				System.out.print(owner[i] + "\t");
//				System.out.print(car[k] + "\t");
//				
//			}
//			
//		}

	}

	// 입력하는 메소드
	// 자바에서는 필요한 객체를 즉석에서 만들어서 거기서 쓰면 끝
	private static void insert(String[] nameArray, String[] carArray, int[][] yearPrice) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < nameArray.length; i++) {
			
			System.out.print("이름 : ");
			nameArray[i] = scan.nextLine();

			System.out.print("차종 : ");
			carArray[i] = scan.nextLine();

			System.out.print("연식 : ");
			yearPrice[i][0] = MyScanner.nextInt(scan);
			System.out.print("가격 : ");
			yearPrice[i][1] = MyScanner.nextInt(scan);

		}
		scan.close();
	}
	
	// 출력 메소드 
	private static void print(String[] owners, String[] types, int[][] yearPriceArray) {
		for (int i = 0; i < owners.length; i++) {
			System.out.println("차주명\t차종\t연식\t가격\t");
			System.out.printf("%s\t %s\t %d\t %d\t \n", owners[i], types[i], yearPriceArray[i][0], yearPriceArray[i][1]);
		}
	}

	// call by reference
	// 우리가 파라미터로 기본형 데이터타입을 주거나
	// 혹은 참조형 데이터타입을 주게되면
	// 어떤 일이 벌어질까?

	// 기본형 혹은 뭔가 값을 가지는 친구들(ex. String, 포장 클래스들) -> 힙메모리를 타고 들어가면 값이 있는 경우...
	// 파라미터로 보내도
	// 이런 친구들은 굳이 주소값을 보내주는게 아니라
	// 값 자체를 보내서 컨트롤이 되기 때문에 -> Call by Value
	// 원본이 아닌 복사본이 가는 형태이다.
	// 따라서 메소드 내부에서 수정해도
	// 원본은 바뀌지 않는다.
//	
//	public static void add(int a) {
//		a = a+10;
//	}
//	
//	public static void add(String str) {
//		str +="aaaaaa";
//	}
	// call by reference
	// call by value 의 차이
	// 복사본을 줄지 원본을 줄지의 차이
	// call by value : 복사본
	// call by reference : 원본

	// 근데 그 자체가 값을 안가지는 경우가 2개 있다.
	// 바로 배열과 Collections라는 모음 클래스들이다. -> 힙메모리 타고 들어가면 주소값이 있는 애들.. 그 주소값을 타고 다른 곳으로
	// 가야 실제 값이 있다. 고로 그 자체가 값을 안가지는 애들
	// 이 둘은 call by reference가 일어난다
	// 즉 우리가 원본 파일을 받아서 수정하면
	// 그 원본 파일자체가 바뀌는 것으로 생각하면 편하다
	// ㅇ
//	public static void add(String[] arr) {
//		arr[0] = "a"; 
//		arr[1] = "b"; 
//		arr[2] = "c"; 
//	}
	// 출력하는 메소드

}
