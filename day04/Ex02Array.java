package day04;

import java.util.Scanner;

/*
 * 배열
 * 한 종류의 데이터 타입이 
 * 내가 지정한 크기만큼 모여있는 것. 
 * 
 * 그런데 배열은 나온지 오래된 개념이다. 
 * 2세대 언어에서부터 이미 배열은 쓰였었고 
 * 3세대에선 오히려 잘 안맞는 개념이 되었다. 
 * 
 * 그래서 우리가 배열을 어떻게 쓰는지 
 * 왜 잘 안쓰이는지 알아보자 
 */
public class Ex02Array {

	public static void main(String[] args) {
		// 배열선언 방법 : 
		// 데이터타입[] 배열이름 = new 데이터타입[크기];
		
		// 만약 크기가 5인 int 배열을 선언한다면? 
		int[] array = new int[5];
		
		
		System.out.println(array); // 결과 : [I@15db9742
		
		
		
		// 이 array는 int가 5개 모여있고 
		// 각각의 int를 하나씩 호출하려면 위치번호를 주어야한다. 
		// 위치번호는 index(인덱스) 라고 부른다. 
		
		// 그럼 0번째에 무슨 값이 들어가있는지 보고 
		// 0번째에 새로운 값을 넣고 다시 찍어보자. 
		System.out.println(array[0]);
		
		// 배열의 각 인덱스번호의 요소들(element)은 
		// 따로 초기화를 안해줘도 기본형 데이터타입의 경우 0으로 초기화가 된다. 
		
		// 우리가 값을 넣을 때에는 
		// array[0]을 커다란 변수의 이름처럼 쓰면 된다.
		array[0] = 5; // 배열 array의 인덱스 0에 5가 들어갔다. 
		System.out.println(array[0]);
		// 배열 등 이렇게 모여있는 collection의 경우에는 
		// 시작하는 인덱스가 0에서 시작한다. 
		// 즉 가장 마지막 인덱스 번호는 
		// 몇번일까? >> 4번 (0부터 시작하므로...)
		// 크기-1이 가장 마지막 인덱스 번호가 된다. 
		// 즉, for문에서 이제는 더이상 종료조건식에 = 이 안붙는다. 
		
		
		// 인덱스의 범위 오류 
//		for(int i = 0; i<= 5; i++) {
//			// 인덱스 번호나 크기를 지정할때 
//			// 변수나 상수가 들어갈 수 있다. 
//			System.out.println(array[i]);
//		}
		// 만약에 index가 가능한 범위를 넘어서면? 
		// java.lang.ArrayIndexOutOfBoundsException이 발생
		// 만약 코딩을 하다 이런 에러를 만나게 되면 
		// index가 잘못 잡혀있는 것이니 
		// index와 관련된 코드를 다시 점검하면 된다. 
		
		// 즉 위의 for loop에선 i의 끝 지점이 5를 포함하는 것이 아닌 
		// 5보다 작다 라고 설정해야 한다. 
		for(int i = 0; i< 5; i++) {
			// 인덱스 번호나 크기를 지정할때 
			// 변수나 상수가 들어갈 수 있다. 
			System.out.println(array[i]);
		}
		
		// 사용자로부터 입력을 받아서 
		// 그 숫자들을 차례대로 나열하는 프로그램을 만들어보자 
		
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
			System.out.print((i+1) + " 번째 숫자를 입력해주세요 "); // 0없이 1부터 시작하도록 +1
			array[i] = scan.nextInt(); 
		}
		for(int i = 0; i < 5; i++) {
			System.out.println("array" + "["+i+"] = "+ array[i]);
		}
		
		String[] stringArray = new String[5];
		// 클래스 배열의 경우에는 
		// 배열 자체에 대한 초기화도 해 줘야 하지만 
		// 각 위치에도 기화를 해줘야한다. 
		for(int i = 0; i < 5; i++) {
			System.out.println("===============");
			System.out.println(stringArray[i]);
			stringArray[i] = new String();
			System.out.println(stringArray[i]);
			System.out.println("===============");
			// null과 ""는 다른 개념이다. 
			// null : 주소가 배정은 되었지만 아직 초기화가 안되어 있는 상태로써 아무런 작업도 해줄 수 없다 
			// "" : 주소가 배정되었고 초기화도 되어있는 상태여서 아무런 값이 없을 뿐 정상적인 상태
			// 
		}
		
		scan.close();
		
	

	}

}
