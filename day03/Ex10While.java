package day03;

import java.util.Scanner;

/*
 * 반복문의 둘째 while 
 * for loop의 경우엔
 * 명확히 돌아가는 횟수를 볼 수 있었다. 
 * 그에 반해 while은 조건식을 적어주고 
 * 그 조건식이 true면 실행/ false면 종료 식으로 돌아간다. 
 */
public class Ex10While {

	public static void main(String[] args) {
		int count = 0; 
		
		while(count < 4) {
			System.out.println(count + "회째 반복중");
			count++;
		}
		
		System.out.println("while종료");
		// 사실 while의 가장 큰 조건은
		// 숫자와 상관없이 실행이 가능하다는 것 
		// 예를 들어 
		// 사용자가 어떤 값을 입력하고 
		// 다시 입력을 받은 값이 전에 입력한 값과 다르면 ?
		// 같은 값이 들어올 때까지 입력을 하게 만드는 코드를 작성할 때는 
		// for 문으로 가능하긴 하지만 
		// while이 더 적합하다. 
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("비밀 번호를 입력해주세요 ");
		String storedPw = scan.nextLine();
		System.out.println("다시 한 번 더 비밀번호를 입력해주세요 ");
		String triedPw = scan.nextLine();
		
		while(!storedPw.equals(triedPw)) {
			System.out.println("일치하지 않습니다. ");
			System.out.println("다시 한 번 더 입력해주세요 ");
			triedPw = scan.nextLine();
		}
		System.out.println("회원 등록 성공!");
		
		
	
		scan.close();
		
		
	
	}
	
	


}
