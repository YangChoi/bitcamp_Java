package day02;
/*
 * if-else if-else 구조 
 * 만약 if 조건을 만족하지 않지만 
 * 다시 조건을 체크해서 무언가를 실행해야한다면? 
 * if-else if-else 이런식으로 우리가 구조를 만들어줘서 
 * 한개의 코드블락만 실행되게 만들어줄 수 있다. 
 * 또한 else if는 여러개가 나올 수도 있다. 
 * 
 */
public class Ex10 {

	public static void main(String[] args) {
		int number = 4; 
		
		if(number == 1) {
			System.out.println("1 입니다");
		}else if(number == 2) {
			System.out.println("2 입니다");
		}else if(number == 3) {
			System.out.println("3입니다");
		}else if(number == 4) {
			System.out.println("4입니다");
		}else {
			System.out.println("그 외의 숫자입니다. ");
		}

	}

}
