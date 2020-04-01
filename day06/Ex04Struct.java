package day06;

import java.util.Scanner;

import util.MyScanner;

// 구조체의 배열
public class Ex04Struct {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 구조체의 배열을 만들어보자 
		// 어려워보이지만 속지 맙시다
		// 일반 배열처럼 데이터타입[] 배열이름 = new 데이터타입[크기] 해주면된다. 
		// 그럼 학생 구조체의 데이터타입의 이름은 무엇인가? 
		// Student이다. 
		Student[] students = new Student[3];
		
		// 하지만 우리가 저 배열에 직접 일일이 값을 넣어줄려고 하면
		// 모든 요소에 대해 new Student()를 실행시켜줘야한다 
		// 그러면 입력할 때 마다 임시로 s라는 Student 변수 만들어서 
		// 거기에 값을 넣고 다 넣고나서는 students[i]에 s를 넣어주면 된다. 
		
		for(int i = 0; i < students.length; i++) {
			// 연결할 주소를 가진 Student s를 하나 만들어준다 
			Student s = new Student();
			
			System.out.print("이름 : ");
			String name = scan.next();
			System.out.print("국어 : ");
			int kor = MyScanner.nextInt(scan);
			System.out.print("수학 : ");
			int math  = MyScanner.nextInt(scan);
			System.out.print("영어 : ");
			int eng = MyScanner.nextInt(scan);
			// 입력받은 애들 s에 담아서 배열에 차례대로 넣어주면 된다. 
			
			s.name = name;
			s.kor = kor;
			s.math = math;
			s.eng = eng;
			students[i] = s; // 이 배열안에 입력받은 정보들을 넣는다. 
			
		}
		for(Student s : students) {
			System.out.printf("%s: %03d점\t %03d점\t %03d점\n", s.name, s.kor, s.math, s.eng);
		}
		scan.close();

	}

}
