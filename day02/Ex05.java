package day02;
/*
 * 조건문 
 * 조건이 맞으면 실행되는 코드 
 * 조건문은 true/ false가 나오는 논리형 값에 대해서 
 * true 면 실행 / false면 실행하지 않는다 
 * 조건문은 크게 3가지 종류가 있다. 
 * 1. if문
 * 2. switch 문
 * 3. 조건연산자 
 * 2, 3번은 좀 제한적인 조건에서 쓰이게 되지만 
 * 무언가 조건에 따라서 실행을 해야한다면 주로 if문이 사용된다. 
 * 
 */
public class Ex05 {

	public static void main(String[] args) {
		// if문
		// if(조건) {
		//		참일 때 실행할 코드들
		// }
		
		int number = 5; 
		// if문 괄호안에 들어가는 조건은 
		// 무조건 true/false가 나오는 논리연산자, 비교연산자, 메소드가 들어가야만 한다. 
		
		// 값에 따라 연산, 결과값을 주는 것 : 메소드 
		if(number >= 0) {
			System.out.println("자연수 입니다");
			String message = "유효한 범위!"; 
			System.out.println(message);
			
			if(number <= 10) {
				System.out.println("number는 0과 10 사이의 숫자 ");
				// 여기서도 String message 만들 수 없다. 
			}
		}
		//if 문 밖에서는 다시 사용할 수 있는 message
		String message = "유효한 범위!";
		
		// code block 
		// { } 하나의 내용을 코드 블락이라고 한다. 
		// 그럼 위의 if 문의 code block은 몇번 부터 몇번 라인인가? 
		// 나의 경우엔 28부터 30까지 (message 넣기 전 )
		
		// 변수의 유효범위(scope)와 연관되기 때문이다. 
		// 변수의 유효한 범위는 그 변수가 선언된 다음줄부터 
		// 그 변수가 속한 코드블락이 종료될 때까지이다. 
		
		// if 문이나 for문의 경우 
		// 한 줄 만 조건이 맞으면 실행 혹은 반복할 때 
		// {} 생략이 가능하긴 하다. 
		// 하지만! 명확한 범위를 나타내기 위해서 생략하지 말자. 
		
		if(number == 5) {
			System.out.println("숫자는 5입니다.");
		}

	}

}
