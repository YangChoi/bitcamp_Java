package day02;

import java.util.Scanner;

/*
 * 점수를 입력받아서 
 * ABCDF를 보여주는 프로그램을 만들되 
 * 만약 1의 자리가 0~3이면 -
 * 			  4~6 이면 0
 *            7~9이면 +
 *            100점이면 A+이 뜨는 프로그램을 작성
 * 예시) 점수를 입력하세요 : 78
 * 		C+
 * 
 * 이번엔 점수를 String으로 변환한 후에 플마 0 을 붙이는 프로그램
 */
public class Ex13 {

	public static void main(String[] args) {

		int number = 12345; 
		// 기본형 데이터타입을 String으로 바꾸는 방법들
		// 1. int + String 사용
		String temp = number + ""; //숫자 더하기 빈 String(null값이 아님..) : 그러면 결과값으로 String이 나온다. 
		// 단점 : 리소스를 제법 먹는다. 
		System.out.println(temp);
		
		// 2. Wrapper Class(포장 클래스) 사용
		temp = Integer.toString(number);
		// 제법 깔끔한 표현 
		System.out.println(temp);
		
		// 3. StringBuilder 사용
		StringBuilder builder = new StringBuilder();
		builder.append(number);
		temp = builder.toString();
		System.out.println(temp);
		
		// temp는 number의 String 형태가 되었다. 
		// temp의 길이를 알아내서 맨 마지막 글자를 추출해서 숫자로 바꾼 후 비교 
		
		System.out.println(temp.length());
		
		// String에서 몇번째에 무슨 글자가 있는지 보고 싶을 땐
		// charAt(위치) 로 볼 수 있다. 
		
		System.out.println(temp.charAt(temp.length()-1)); // 문자열은 가변성을 띄기 때문에 temp.length() -1
		char tempChar = temp.charAt(temp.length()-1);
		// 여기서 나온 charAt()은 결과값이 
		// char 데이터타입이니까 
		// char는 숫자값으로 바꿀 수 있다. 
		System.out.println((int)tempChar);
		// 그럼 tempChar를 1이 49니까 
		// (int)tempChar 48 ~ 51 : -
		// (int)tempChar 52 ~ 54 : 0
		// (int)tempChar 55 ~ 57 : + 
		
		// 서울 -> 도쿄 가는 비행기를 
		// 서울 -> 베이징 -> 홍콩 -> 울란바토르 -> 도쿄 가능 경유 비행기로 끊은 것. 
		
		Scanner scan = new Scanner(System.in);
		
		// 클래스가 없었을 때엔 
		// 입력받은 문자열(char배열)을 int로 바꾸려면 어떻게 해야했을까 
		// 먼저 반복문이라는 친구를 통해서 각 자라의 글자를 추출해서 
		// 제일먼저 한글자라도 char값이 48 ~ 57 사이가 아닌(= 진짜 글자) 인지부터 체크하고 
		// 만약 전부다 48 ~ 57사이의 char 값을 가진다 (= 숫자로만 이루어졌다) 
		// 그러고 나면 각각의 숫자를 0번위치를 예를 들어서 
		// ( 해당 위치의 char 값 - 48 ) -> 실제 숫자로 나옴 
		// ( 배열의 길이 - 위치 (현재는 0 ) ) 한 횟수만큼 10을 제곱해서 
		// 실제 숫자  * 해당 위치의 숫자 + 그 다음거 + 그 다음거 
		
		
		// 그런데 클래스가 나오면서 위의 코드가... 
		String text = scan.nextLine();
		int parsedNumber = Integer.parseInt(text);
		System.out.println(parsedNumber+100);
		
		scan.close();
	}

}
