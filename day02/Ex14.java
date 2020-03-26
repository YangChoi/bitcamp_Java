package day02;

import java.util.Scanner;

/*
 * 사용자로부터 나이, 성별, 실체 등급을 입력받아서 
 * 남자, 18세 이상, <= 3 이하의 신체등급 일시 "현역" 
 * 남자, 18세 이상, == 4 신체등급 일시 "공익"
 * 그 외에는 다 면제라고 출력되는 프로그램을 작성하세요 
 * 팁1 : 성별 1은 남자 2는 여자라고 출력되게 만드세요 
 */
public class Ex14 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 굳이 18세 미만에게 성별을 물어볼 필요가 없다. 
		// 굳이 여성에게 나이를 입력받을 필요가 없다. 
		System.out.println("성별을 알려주세요 [1] : 남자   [2] : 여자");
		int gender = scan.nextInt();
		if(gender == 1) {
			System.out.print("나이를 알려주세요 ");
			int age = scan.nextInt();
			if(age >= 18) {
				System.out.print("신체 등급을 입력해주세요 : ");
				int level = scan.nextInt();
				if(level > 0 && level <= 3) {
					System.out.println("현역입니다.");
				}else {
					System.out.println("등급 미달로 면제입니다. ");
				}
			}else {
				System.out.println("만 18세 미만은 대상이 아닙니다. ");
			}
		}else if(gender == 2) {
			System.out.println("대상이 아닙니다. ");
		}else {
			System.out.println("잘못 입력했습니다. ");
		}
		scan.close();
	}

}
