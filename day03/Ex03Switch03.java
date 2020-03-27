package day03;

import java.util.Scanner;

/*
 * 좀 더 실제로 쓸법한 switch 
 * 
 * 사용자가 주소를 입력하고 
 * 그 주소가 특정값과 같다면 
 * 정상적으로 처리됨
 * 만약 그 외에 주소가 아예 다르면 404
 * 주소는 같지만 뒤에 / 오는 값이 다르면 500 에러가 뜨게 switch 문 만들어보자 
 */
public class Ex03Switch03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("이동할 주소를 입력해주세요");
		String adr = scan.nextLine();
		int statCode = 0;
		
		// 사용자가 입력한 주소가 
		// "/admin/main/1" 이 아니면 
		// 무조건 404라고 만들어주자
		
		if(adr.equals("/admin/main/1")) {
			statCode = 200;
		}else {
			statCode = 404;
		}
		
		switch(statCode) {
		case 200:
			System.out.println("정상 이동");
			break;
		case 404:
			System.out.println("주소가 잘못되었습니다 \n1. 뒤로가기    2. 홈으로 ");
			
			int input = scan.nextInt();
			if(input == 1) {
				System.out.println("뒤로가기 ");
			}else if(input == 2) {
				System.out.println("홈으로");
			}
			break;	
		}
		scan.close();
	}
}
