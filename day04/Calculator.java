package day04;

import day03.Ex16Method;

public class Calculator {
	// 계산을 하는 메소드를 모아둔 클래스
	// 우리가 메인 메소드에서
	// 객체를 만들어 호출할 것이기 때문에
	// static 키워드는 생략 가능하다

	// 만약 객체를 만들지 않고 메소드를 호출할거면
	// static을 붙여야 한다.
	
	// 35분부터 더하기 빼기 곱하기 나누기 4가지 기능을 
	// (정수, 정수), (실수, 실수), (실수, 정수) 로 해서 만들기 
	public static void main(String[] args) {
		// Ex16Method.add(3, 5); // 이렇게 하려면 static을 붙인다. 
		
	}
	
	
	// 더하기 
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static double add(double a, double b) {
		return a + b;
	}
	public static double add(double a, int b) {
		return a + b;
	}
	
	// 빼기 
	public static int sub(int a, int b) {
		return a - b;
	}
	
	public static double sub(double a, double b) {
		return a - b;
	}
	public static double sub(double a, int b) {
		return a - b;
	}
	
	// 곱하기 
	public static int mult(int a, int b) {
		return a * b;
	}
	
	public static double mult(double a, double b) {
		return a * b;
	}
	public static double mult(double a, int b) {
		return a * b;
	}
	
	// 나누기 
	public static int divi(int a, int b) {
		return a / b;
	}
	
	public static double divi(double a, double b) {
		return a / b;
	}
	public static double divi(double a, int b) {
		return a / b;
	}
	
	
	
	
	
	


}
