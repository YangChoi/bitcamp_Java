package day03;

/*
 * switch 
 * if문에서는 우리가 조건식을 통해서 true 면 실행/ false면 실행 안함 이였지만 
 * 
 * switch에서는 변수를 하나 선택해서 
 * 그 변수가 나올 수 있는 가능한 값 ( = 케이스) 를 만들어서 
 * 그 변수가 해당 케이스를 만족하게 되면 어떤 것을 실행할 지 적어주게 된다. 
 * 
 */
public class Ex01Swtich01 {

	public static void main(String[] args) {
		int num = 1;
		// if(num > 0)
		switch (num) {

		case 1:
			System.out.println("1 입니다");
			break;
			// 만약 break가 생략이 되면 
			// 변수가 만족하는 case 코드부터 
			// break가 나올 때까지 아래를 모두 실행한다.
		case 2:
			System.out.println("2 입니다");
			break;
		case 3:
			System.out.println("3 입니다");
			break;
		// 이클립스 자동 들여쓰기는 ctrl + shift + f
		default:
			System.out.println("그 외입니다");
			break;
		}

	}

}
