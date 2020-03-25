package day01;
/*
 * 산술연산자 
 * 산술 연산자란 
 * 더하기, 빼기, 곱하기, 나누기, 나머지를 구하는 연산자 
 * 
 */
public class Ex03 {
	public static void main(String[] args) {
		// 각각 + - * / %로 2개의 값 연산시켜서 그 결과 값 사용하게 됨
		int number1 = 5; 
		int number2 = 7;
		
		System.out.println(number1 + number2);
		System.out.println(number1 - number2);
		System.out.println(number1 * number2);
		
		System.out.println(number1 / number2);
		// 같은 데이터 타입끼리의 산술연산자는 무조건 같은 데이터타입이 나오게 된다.
		// + - * 는 int 끼리의 연산에서 소수점이 나올 수 없지만 
		// / 는?? 가능하다. 
		// 이런 경우엔 앞서 선언한 데이터타입으로 나오게 된다.(실수부는 무조건 버려진다)
		// 5/7는 무조건 0이 나온다. 0. 얼마얼마 이기 때문에 int형으로 나타내면 int
		
		System.out.println(number1 % number2);
		// % 연산자는 5/ 7 했을 때 
		// 몫이 0이고 나머지는 5이기 때문에 
		// 5 출력 
		
		number1 = 31; 
		number2 = 6; 
		System.out.println(number1/number2); // 5
		System.out.println(number1%number2); // 1
		
		// 그렇다면 정수/정수 해서 실수까지 나타내려면??
		double result = number1/number2;
		// int형을 double형으로 바꿔주면 되지~
		System.out.println(result);
		// 위의 코드는 number1/ number2의 결과 값을 double의 형태로 바꿔라는 의미이기 때문에 
		// number1/ number2가 먼저 실행되어서 
		// 그 결과값으로 나온 int형인 5를 
		// 실수의 형태로 바꾸기 때문에 
		// 5.0이 나오게 된다. 
		// 만약 5.1666 이런 식으로 표현하고 싶으면
		// 그럴 경우에는 
		// 실수 / 정수 해서 
		// 결과값 자체를 실수로 먼저 바꿔주고 
		// 그 후에 결과값을 실수형 변수에 담아줘야한다 
		result = (double)number1/number2;
		System.out.println(result);
		
		// 그런데 만약 변수에 안담기고 
		// 그냥 숫자가 있는 경우에 
		// 실수로 바꾸려면 어떻게 해야할까? 
		// 예시 : result = 5/7;
		// 우선순위를 생각하자. 
		// 사칙연산중에서 덧셈 뺄셈 보다 곱셈 나눗셈을 먼저 하니까 1.0을 곱해서 실수로 만든 다음 나머지 계산이 이루어지게 하면 실수의 연산이 된다. 
		result = 1.0*5/7;
		System.out.println(result);
		
		// 코딩을 하다보면 
		// 변수 현재값에 다른 값을 산술연산해서 
		// 다시 그 변수에 넣어야하는 경우가 종종 있다. 
		number1 = number1 * 10; 
		// 위의 코드처럼 현재값에 연산을 한 결과값을 다시
		// 해당 변수에 넣는 건 줄여서 쓸 수 있다. 
		number1 /= 10; // number1 = number1 / 10
		// 그런 경우엔 위와 같이 산술연산자와 =을 붙여서 쓴다.
		System.out.println(number1);
		
		// 아래 두 줄의 차이를 설명해보자 
		System.out.println(123+100); // 정수 연산이 된다. 결과 : 223
		System.out.println(123 + "100"); // 정수 + 문자열  결과 : 123100
		
		// 그럼 숫자 + 문자열(=String)은 결과값이 어떻게 될까? 
		// (숫자보다 문자열이 더 크다.) 
		// 2개의 String을 이어서 하나의 String으로 만든다. 
		// 즉, 위 2개의 코드 중 윗줄은 223이라는 값이 나오게 되지만 
		// 아래의 코드는 123100이라는 값이 나오게 된다. 
		// 물론 - * / % 는 안되지만 
		// += 는 된다. 
		
	}
}
