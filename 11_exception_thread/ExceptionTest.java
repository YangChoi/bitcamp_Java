import java.util.Scanner;

class ExceptionTest {
	public static void main(String[] args) {
		// main이 호출되면 String[] args에 데이터 넣을 수 있음
		// main이 호출되는 것은 실행되는 시점 
		// 실행은 javac 컴파일 이후 java 했을 떄

		if(args.length > 0){ // 데이터가 하나 들어올 때 
			System.out.println("args[0] = "+args[0]);
		} // 조건을 걸어주면 데이터를 주지 않아도 오류가 나지 않는다. 
		System.out.println();

		Scanner scan = new Scanner(System.in);
		System.out.println("숫자입력 : ");
		int num2 = scan.nextInt();
		
		// try-catch
		try{ // 이 안에서 오류가 발생할 가능성이 높다 
			int num = Integer.parseInt(args[0]); // 0인덱스에 받은 String 값(배열 args의 데이터 타입이 String 이므로)을 정수형으로 바꾼다. 
			// 만약 args에 호랑이라고 입력했을 때? 
			// 호랑이를 정수형으로 바꿀때? >> NumberFormatException : 왜 숫자의 형식이 아니냐는 에러 
			// 호랑이는 정수형으로 바꿀 수 없다는 에러 뜸
			// (실행할 때 나온 오류)
			
			System.out.print(num+ "/" + num2 + "=" + (num/num2));  // 정수형은 0으로 나눌 시 계산할 수 없다고 나옴
			//System.out.print(num+ "/" + num2 + "=" + ((double)num/num2)); : 실수형은 0으로 나눌 시 infinity 나옴 
		}catch(NumberFormatException e) {
			System.out.println("숫자만 입력하세요"); 
			// 에러메시지를 위와 같이 바꾼다. 
			// 사용자가 보고 실행 시 어떤 문제가 일어나서 프로그램이 실행하지 않는지 알 수 있게. 

		// 0입력시 나오는 연산에러 
		}catch(ArithmeticException e){
			System.out.println("0이외의 숫자를 입력하세요");
		}finally { // 위의 try문에서 문제 없이 잘 해결되어도 여기로 와서 찍는다. 
					// catch에서 오류 메시지를 잡아도 여기로 온다. 
			System.out.println();
			System.out.println("error가 있건 없건 무조건 실행 " );
		}
	}
}
