package day03;
/*
 * 반복문
 * 조건식을 test해서 true가 나오면 반복되는 것 
 * 
 * 반복문은 2+1이 있다. 
 * for, while, forEach
 * for는 명확하게 몇회를 반복하라는 의미가 강하다 
 * while은 이 조건식이 true 인 동안 계속 반복한다. (데이터가 있는동안.. 이라는 조건일 때 쓰임)
 * forEach의 경우에는 배열이나 ArrayList 같이 똑같은 자료형이 모여있는 애들을 출력할 때 좋다. 
 */
public class Ex04For {

	public static void main(String[] args) {
		// for 문
		for(int i = 0; i < 5; i++) {
			// i의 현재값 : 0
			// 여기서 i가 5보다 작을 동안 코드가 작동(1씩 증가)해서 
			// i가 4가 되면 for문은 종료된다. 
			System.out.println(i);
		}
		
		// 또 우리가 안에 넣은 i는 굳이 i가 아니어도 된다. 
		// 초기화 값이나 조건식 값도 변수를 넣어줄 수도 있다.
		int standard = 10;
		int startingNum = 6; 
		for(int position = startingNum; position <= standard; position++) {
			System.out.println("standard: " + standard);
			System.out.println("startingNumber : " + startingNum);
			System.out.println("position : " + position);
		}
		// 하지만 전통적으로 for문에 선언되는 변수는 i, j, k 순이다. 
		
	}

}
