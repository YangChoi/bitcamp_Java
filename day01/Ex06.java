package day01;
/*
 * 논리 연산자 
 * 논리형 값에 대한 연산을 한다. 
 * && : and 두개가 모두 true
 * || : or 하나만 true 여도 true ( 2개 중 한개이상이 true면 true)  
 * ! : ~not true는 false로 false는 true로 바꿔준다 
 * 
 */
public class Ex06 {

	public static void main(String[] args) {
		// I
		// l
		// |
		// 이 셋을 잘 구분할 수 있는 글씨체가 좋겠지...
		
		boolean bool1 = true; 
		boolean bool2 = false; 
		
		System.out.println(bool1 && bool2); // false
		System.out.println(bool1 || bool2); // true 
		System.out.println(bool1 && !bool2); // true 
		
		// 0 < double1 < 5 를 비교연산자를 통해 
		// 1. double1이 0보다 크고 
		// 2. double1이 5보다 작다 
		// 로 체크해보자 
		
		double double1 = 3.14;
		System.out.println(0 < double1 && double1 < 5); // true 
		
		double double2 = -3.14;
		System.out.println(0 < double2 && double2 < 5); // false
	}

}
