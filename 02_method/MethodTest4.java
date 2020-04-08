class MethodTest4{
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]); // 숫자형의 문자열을 10진수의 정수형으로 바꿔줌 
		double b = Double.parseDouble(args[1]); // 문자열을 실수형으로 바꿔줌
		
		System.out.println(a+ " + " + b +" = " + (a+b));
	}
}


// 형변환 Casting 
// 기본형은 기본형끼리, 객체형은 객체형끼리만 가능.. 
// 기본형인 int를 객체형인 String으로 형변환 불가 