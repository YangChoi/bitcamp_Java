package day04;

public class Ex01 {

	public static void main(String[] args) {

		int userNumber1 = 10; 
		int userNumber2 = 22;

		int result = add(userNumber1, userNumber2);
		
		double doubleResult = add(3.14, 6.02);
		System.out.println(doubleResult);
		System.out.println(subtract(userNumber1, userNumber2));
		System.out.println(multiply(add(1,2), subtract(2,3)));
		System.out.println(result);
		
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	// add를 오버로딩 해봅시다. 
	// 파라미터만 다르면 된다. (같은 기능이나 파라미터가 달라지는 경우)
	public static double add(double a, double b) {
		return a + b;
	}
	
	
	public static int subtract(int a, int b) {
		return a - b;
	}

	public static int multiply(int a, int b) {
		return a * b;
	}

	
	public static int division(int a, int b) {
		return a / b;
	}

	
	public static boolean validate(int score) {

		if(score > 100 || score < 0) {
			return true; 

		}
		return false;
	}
	
	// 파라미터가 다르다는 것은 어떤 의미일까? 
	// 다음 중 파라미터가 다르다에 포함되는 것은? 
	// 1. 파라미터의 이름
	// 2. 파라미터의 갯수
	// 3. 파라미터의 데이터 타입 
	// 2, 3
	// 만약 이름만 다르다고 메소드가 달라진다면? 
	// public int add(int number1, int number2)
	// public int add(int positiveNumber1, int positiveNumber2)
	// add(3, 5)를 호출할 시에는 무엇이 불러와 지는가? 
	// 컴퓨터에서는 3, 5가 number1인지 positiveNumber2 인지 신경안쓴다. 
	// 그저 데이터 타입이 무엇인지..
	// 따라서 파라미터의 이름은 중요하지 않다. 
	// 만약 add(3, 5, 6)이라고 호출할 시에는 파라미터의 갯수가 다르기 때문에 두 add 모두 호출되지 못한다. 
	
	
	// 오버로딩(overloading) 개념이 나온 이유: 
	// 한 클래스 안에 비슷한 기능을 하지만 파라미터가 달라지는 경우 
	// 굳이 이름을 바꿀 필요없이 똑같은 이름으로 해서 
	// 모아두기 위함이다. 

	// 자바에는 overriding 이라는 개념도 있는데 
	// 오버라이딩의 경우 부모 클래스로부터 상속받은 메소드를 
	// 자식이 다시 정의하는 것을 오버라이딩이라고 한다. 
	
	// 이 파일에서는 우리가 모든 메소드들을 한 파일에 몰아넣었지만 
	// 실제론 메소드가 하는 역할과 어떤 필드들을 공통적으로 가지냐에 따라서 
	// 클래스 별로 분리를 해야한다. 
	// 예시 : 우리가 여기서 만든 add, substract 이런 친구들은 
	//			Calculator.java 라는 별도의 클래스를 만들어서 
	//			그 안에 넣고 우리는 필요에 따라서 Calculator 객체를 만들어서 
	//			그 객체의 메소드를 호출해야한다. 
	
	// 클래스는 공통 분모를 잘 찾아서 만든다. >> 잘 만든 클래스 
	
	// psuedo coding 
	// psuedo? 가짜, 유사한 
	// psuedo coding은 실제 코드는 아니지만 
	// 우리가 어느정도 생각을 정리하면서 
	// 어떠한 코드가 필요하겠다 하면서 대충 코드를 적는 것을 뜻한다. 
	
	// 실제 코딩에서 만약 우리가 계산기를 만들면 
	// 실제로도 실행이 가능한 코드들을 적어줘야 하지만 
	// 개발 전 계획 단계에서는 
	// 그냥 손으로 더하기 (정수, 정수), 더하기(실수, 실수) 이런식으로 적어서 
	// 어떠한 메소드들이 필요하고 
	// 그 메소드들이 어떤 알고리즘이 필요하고 
	// 어떤 데이터를 만들면 편할지 계획을 짤 때 주로 쓰게 된다.
	
	// 수두 코드의 예시 : 
	// 더하기(정수, 정수) {
	//		두개 더한거 리턴하기;
	//}
	
	// 데이터베이스의 기능은 CRUD 이다. 
	// C : CREATE (데이터의 생성)
	// R : RETRIEVE (데이터의 회수)
	// U : UPDATE (데이터의 수정)
	// D : DELETE (데이터의 삭제)
	
	
}
