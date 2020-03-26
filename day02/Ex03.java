package day02;

import java.util.Scanner;

/*
 * 키보드 입력받기 
 * 자바가 미리 만들어놓은 것들을 편하게 쓰자  > 라이브러리 
 */
public class Ex03 {

	public static void main(String[] args) {
		/*
		 * 입력시 3가지 정도 방법이 있지만 
		 * scanner를 사용해서 입력을 처리해 보자 
		 * scanner 의 경우 외부 클래스이기 때문에 import를 통해 스캐너의 위치를 지정해 줘야한다. 
		 */
		// 스캐너 객체 선언 
		Scanner scan = new Scanner(System.in);
		
		// 키보드 입력 받을 때 이제 scanner를 입력 대리인으로 임명을 해서 
		// int 입력 받아와, double 입력 받아와 
		// line 입력(=string) 입력 받아와 시켜서 
		// 알아서 입력 받고 결과값을 보내도록 시킨다. 
		
		System.out.print("숫자를 입력해주세요 : ");
		int number = scan.nextInt();
		System.out.println("사용자가 입력한 숫자는 " + number + " 입니다");
		
		System.out.println("실수를 입력해주세요 : ");
		double d = scan.nextDouble();
		System.out.println("사용자가 입력한 실수는 " + d + " 입니다");
		// 실수 입력하라 할 때 실수 입력하는 것은 상관없다 (.0을 붙여서 실수로 만들 수 있기 때문)
		// 하지만 정수 입력하라 했을 때 실수 입력하는 것은 에러다 
		
		
		// 이 스캐너는 어디서 입력을 받아올까? 
		// 이런 입력을 받는 것들은 절대로 곧장 데이터를 어디선가 갖고 오지 않는다. 
		// Buffer memory 라는 곳에 일단 데이터를 넣고
		// 거기서 차레대로 읽어와서 저장한다. 
		
		// 근데 문제는 
		// 1. \n, \t 는 무엇일까? 
		//		>> 문자다 
		// 2. nextInt(), nextDouble(); 은 버퍼메모리에서 무엇을 읽어올까?
		//		>> 각각 정수와 실수를 읽는다. 즉 숫자를 읽어옴 
		// 3. 입력이 끝낼 때에는 어떻게 끝내는가? 
		//		>> 엔터키로 
		// 4. 마지막으로 nextInt(), nextDouble() 등을 실행시켜서 입력이 끝난 후 엔터키를 치면 그 엔터키는 어떻게 될까? 
		//		>> nextInt(), nextDouble()은 그냥 버퍼메모리에 남겨둔다. 
		
		// 즉 현재 이 프로그램에서 15와 3.14를 입력한 상태에서 버퍼메모리 상황을 보면 
		// 5 \n -> 5만 nextInt()가 가져가지까 \n이 남아있다. 
		// \n3.14\n -> 3,14만 nextDouble()이 가져가니까 
		// \n\n이 버퍼메모리에 남겨져 있다. 
		
		// 그러면 이런 nextInt(), nextDouble() 등의 숫자를 입력받는 메소드를 실행하면 
		// 버퍼메모리에 엔터키가 남아있어서 
		// nextLine()을 어디에 초기화 하는 형식이 아니라 
		// 그냥 단독으로 써줘서 버퍼메모리를 한번 비워주고 
		// 그 다음에 다시 입력을 받게 한다. 
		
		System.out.print("이름을 입력해 주세요 : ");
		// 단 scan.nextLine() 적을 때 주의해야할 것은 
		// 이클립스 자동완성 기능 때문에 scan.nextLine이라고 치면 
		// scan.nextLin()이 아닌 scan.hasNetLine()이 선택된다. 
		// 곧장 엔터치지말고 키보드 위아래 화살표 눌러서 
		// scan.nextLin()이 선택된 것을 확인하고 엔터 눌러야함. 
		
		scan.nextLine(); // 버퍼메모리 한 번 비워주기 작업 
		String name = scan.nextLine(); // 그 다음 다시 입력받기 
		System.out.println("사용자가 입력한 이름은 " + name + " 입니다");
	}

}
