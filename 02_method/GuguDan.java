/*
단을 입력 받아서 구구단을 구하시오 
[실행결과]
java GuguDan   5단
5*1 = 5
....
5*9 = 45;
*/

class GuguDan {
	public static void main(String[] args) {
	System.out.println("java GuguDan");
	int n = Integer.parseInt(args[0]);

	for(int i = 1; i <= 9; i++){
		System.out.println(n + " * " + i + " = " + (n*i));
	}

	}

}