package day01;
/*
 * 비교연산자
 * 비교하는 친구들~
 * 2개의 값을 비교 
 * > >= < <= == !=
 * 비교 연산자는 결과값이 true/false의 논리형이 나오게 됨 
 */
public class Ex05 {

	public static void main(String[] args) {
		double double1 = 3.141;
		double double2 = 4.2;
		System.out.println(double1 > double2); // false 
		System.out.println(double1 >= double2); // false
		System.out.println(double1 < double2); // true
		System.out.println(double1 <= double2); // true
		System.out.println(double1 == double2); // false
		System.out.println(double1 != double2); // true
		// 하지만 비교연산자는 주의할게 2가지가 있다. 
		// 1. 연달아서 값을 비교하지 못한다. 
		//		0 < double1 < 5 : 불가
		// 만약 이렇게 연달아서 비교연산자를 실행해 범위 체크를 하려면 
		// 다음에 배울 논리연산자를 이용해서 연결해야한다. 
		
		// 2. 객체의 비교는 비교연산자를 사용하면 안된다. 
		// 여러개의 문자를 모아둔 것을 우리는 문자열이라고 하고 
		// String 클래스 객체를 만들어서 사용하게 된다. 
		
		// 클래스 변수 즉, 객체 선언은 다음과 같이 한다. 
		// 클래스 객체이름 = new 클래스();
		// 여기서 "클래스 객체이름"은 stack 메모리에 저장된다.
		
		String str1 = new String("abc"); // 참조형 변수 (String = class이므로)
		String str2 = "abc";
		String str3 = str2;
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3); // 셋다 abc 출력 
		
		System.out.println(str1 == str2); // false
		System.out.println(str2 == str3); // true
		System.out.println(str1 == str3); // false
		
		// str1, str2, str3 는 모두 abc라는 값이 들어 있지만 false가 나온다. 
		// 왜일까? 
		// 비교연산자는 절대 힙메모리 내부로 가서 그 안에 
		// 값을 확인해서 비교하지 않고 
		// 오직 stack 영역 메모리에 선언된 값만 비교 하게 된다. 
		// 위의 str1, str2, str3는 
		// 모두 abc라는 글자만 들어가 있지만 
		// 실제 메모리 주소는 str2와 str3만 같고 
		// str1과 나머지는 다르다. 
		// (값을 비교하는 것이 아닌 값의 주소값을 비교하는 것)
		// 그렇기 때문에 false가 나온다. 
		
		// 따라서 객체의 값비교를 할 때는 (주소값이 아니고 진짜 값!) 
		// 비교연산자가 아닌
		// 객체의 메소드를 실행시켜서 비교를 해야한다. 
		
		// 객체의 메소드를 실행할 때는 
		// 이름. 해서 접근하면 된다. 
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str2.equals(str3));
		// 셋다 abc 이기 때문에 결과는 true 이다.
		
		
		/*
		 * 정리 : 
		 * 객체값을 비교하고 싶으면 비교연산자로 비교해선 안된다. 
		 * 객체값을 비교연산자로 비교하면, 객체값을 비교하는 것이 아닌 
		 * 주소값을 비교하기 때문이다. 
		 * 따라서 .equals라는 메소드로 비교 한다.  
		 */

	}

}
