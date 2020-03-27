package day03;
/*
 * 메소드란
 * 어떠한 값을 주고 
 * 그 값을 연산해서 해당 메소드 리턴된 곳으로 
 * 그 결과값을 보내주는 기능 
 * 
 * C에서는 function 혹은 함수라고 불렀지만 
 * Java에서는 method라고 부른다. 
 * 
 * 
 */
public class Ex16Method {
	// 메소드 선언 
	// (접근제한자 static) returnType name(parameter)
	// 접근제한자 : access modifier
	// 접근제한자는 해당 메소드 혹은 필드가 어디서 접근이 가능한지 범위를 적어준다. 
	// public > protected > default > private
	// public : "공공의" >> 패키지 외/내부, 다른 클래스 어디서든 호출 가능 
	// protected : "보호된" >> 같은 패키지와 상속받은 자식클래스들 호출 가능  
	// default : "기본의" >> 같은 패키지 내부에서만 호출 가능 
	//			 만약, 아무것도 안 적어주면 자동으로 적용
	// private : "사적인" >> 같은 클래스만 접근 가능 
	
	
	// static : 해당 메소드를 메소드 영역에 등록 
	// 만약 static 메소드가 다른 메소드를 호출하게 되면 그 다른 메소드를 객체 생성해서 
	// 호출하는게 아니면 그 다른 메소드도 static이 붙어야한다!
	
	// return type : 해당 메소드가 끝나고 호출 된 곳으로 보내줄 값의 dataType
	// 만약 우리가 정수 2개를 줘서 그 정수들의 합을 구하는 메소드가 있다고 한다면 
	// 해당 메소드의 리턴 타입은? >> int 
	// 하지만 만약 해당 메소드가 아무런 값도 호출된 곳으로 리턴하지 않는다면 
	// void 라고 적어줘야한다.
	
	
	// name : 소문자 + 동사 
	// nextInt(), nextLine(), print()....
	
	// parameter : 이 메소드가 호출 될 때 외부에서 보내주는 값으로써 
	//				dataType name으로 이뤄져 있다. 
	// 만약 해당 메소드가 호출될 때 아무런 값도 필요없다면 
	// 아무것도 안적어줘도 된다. 
	// 또, 파라미터는 일종의 변수 취급이 되어서 
	// 해당 메소드 내부에서는 똑같은 이름의 변수를 생성할 수 없다. 
	// 그리고 메소드를 호출한 곳에서는 굳이 똑같은 이름으로 값을 보내줄 필요까진 없다. 
	
	// 무언가를 봤을 때 메소드인지 아닌지 알아 차리는 방법!
	// 괄호가 붙어 있으면 무조건 메소드다.
	
	
	// 더하기를 해주는 메소드를 만들어보자 
	
	
	public static void main(String[] args) {
		// Ex15GradeBook.main(args);
		int userNumber1 = 10; 
		int userNumber2 = 22;
		// 메소드를 호출 할 때는 
		// 파라미터를 메소드에 선언한 그대로 적어줘여한다. 
		// 만약 add(int a, double b)라고 했는데 
		// add(5, 10) 하면 에러다. 
		// 10은 int이지 double이 아니기 때문에...
		
		int result = add(userNumber1, userNumber2);
		// 보내준 값 userNumber1, userNumber2 지만
		// 메소드 내부에서는 a와 b로 이름을 바꾼다. 
		// 근데 일종의 임시 이름으로 쓰이는 거지 실제 이름이 바뀐것은 아니다. 
		// 따라서 우리가 값을 보내줄 때에는 굳이 이름이 안 똑같아도 된다. 
		
		System.out.println(subtract(userNumber1, userNumber2));
		System.out.println(multiply(add(1,2), subtract(2,3)));
		System.out.println(result);
		
	}
	
	public static int add(int a, int b) {
		// 리턴은 return 이라는 명령어를 통해서 한다. 
		return a + b;
	}
	// - * / 까지 만들기 
	
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
		// return의 특징은 
		// 만나는 순간 해당 메소드가 곧장 종료가 된다는 것이다. 
		if(score > 100 || score < 0) {
			return true; 
			// 여기서 true를 만나면 메소드는 더 나가지 않고 종료된다.. 
		}
		return false;
	}

}
