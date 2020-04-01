package day06;
/* 
 * 학생 이름, 국어, 영어, 수학 점수 여러개 받기 
 * 지금까지 우리가 배운걸로만 생각하면 
 * 이름은 String 이니 String 배열 1개 
 * 국어, 영어, 수학 점수는 int 이니까 int 배열 3개 
 * 
 * 과연 2세대 언어에서는 이 문제를 어떻게 해결했을까? 
 * >> 구조체(Struct)라는 것을 만들어냈다. 
 * 구조체란 그들이 직접 데이터타입을 만드는데 
 * 그 데이터타입은 작은 데이터타입들의 모음집이었다. 
 * 
 * 즉 지금같은 경우에는 
 * 학생이란 커다란 데이터타입을 하나 만들어서 
 * 그 안에 이름이라는 스트링, 국어점수 int, 영어점수 int, 수학점수 int를 가지고 있게 만든 것. 
 * 
 * C에서 구조체 만드는 방법
 * typedef {
 * 	 들어갈 데이터의 종류들
 * } 구조체이름
 * 
 * 하지만 자바에서는... 못만든다!
 * 좀 더 자세하게 말하면 다른 개념에 흡수되었다. 
 * 자바에선 구조체와 해당 구조체가 가지고 있어야 할 기능을 다 합쳐서 
 * '클래스' 라고 부른다!!
 * 
 * 그렇다면 우리가 클래스에 메소드 없이 필드만 만들어주면 
 * 구조체처럼 쓸 수 있지 않을까? 
 */
public class Ex03Struct {

	public static void main(String[] args) {
		// 클래스의 탈을 쓴 구조체도 
		// new 명령어를 통해서 메모리에 자리를 확보해줘야한다. 
		Student s = new Student();
		s.name = "양아무개";
		s.kor = 80;
		s.math = 100;
		s.eng = 30;
		
		System.out.println("이름 : " + s.name);
		System.out.println("국어점수 : " + s.kor);
		System.out.println("수학점수 : " + s.math);
		System.out.println("영어점수 : " + s.eng);

	}

}
