package day02;

public class Ex02 {
/*
 * 입력과 출력 
 * 출력 
 * 사실 입력과 출력은 키보드와 화면 뿐 아니라 다른 곳에도 적용 가능 
 * 
 * 입력자체가 우리가 지금은 키보드 입력만 사용하겠지만 
 * 나중엔? 
 * 어딘가 파일에서 입력을 받아올 수도 있고 
 * 어딘가에서 데이터를 읽어오는 행위 자체가 입력이 될 수도 있다. 
 * 
 * 화면에 출력하는 방법 3가지 
 * >> print, printf, println
 * 
 */
	// 과목수 
	private final static int NUMBER_OF_SUBJECT = 5;
	
	public static void main(String[] args) {
		/* 
		 * 자바에서 기본적으로 콘솔에 메세지를 출력하는 방법은 크게 3가지 
		 * 1. print
		 * 		괄호 안의 내용을 출력한다. 
		 * 2. printf
		 * 		print in format의 줄임말
		 * 		괄호 안의 내용을 '형식에 맞추어' 출력 
		 * 3. println
		 * 		print a line의 줄임말 
		 * 		괄호 안의 내용을 한줄에 출력 
		 * 
		 */
		System.out.print("abc");
		// print()는 커서(다음 출력위치)를 옮기지 않는다. 
		// 즉 괄호 안의 내용 출력이 끝나면 그 다음 출력할 것은 무조건 바로 뒤다 (줄바꿈 없음)
		System.out.println("abc");
		// println()의 경우에는 커서를 무조건 다음 줄의 맨 처음으로 옮긴다 (줄바꿈 함) 
		// 즉 다음 출력 내용은 다음 줄의 바로 맨 처음이 된다. 
		System.out.printf("abc");
		// printf의 경우에는 사실 이렇게 쓰는 것이 아니지만 
		// printf도 print 처럼 커서를 무조건 바로 다음칸으로 옮긴다 (줄바꿈 없음) 
		
		System.out.println("출력 끝");
		
		/* 
		 * printf()에 대해 좀 더 공부해 보자 
		 * printf의 경우에는 사실 우리의 메시지를 우리가 원하는 형식으로 출력을 하게 할당해주는 개념이다. 
		 * 
		 *  
		 *  공백 문자 
		 *  만약 우리가 print나 printf를 써야만 하고 
		 *  만약 커서의 위치를 다음 줄이나 탭을 하나 넣어야할 땐? 
		 *  특수한 문자인 \n(줄바꿈, new line), \t(탭)를 통해서 공백을 넣어주게 된다. 
		 */
		
		System.out.print("abc\t");
		System.out.print("bcd\n");
		
		int number = 41; 
		
		// 1. 10진법 ('d'ecimal) : 대쉬가 들어가면 10과 관련된 무엇이겠구나 하고 생각 
		// -A. 10진법 그대로 표시하라 
		System.out.printf("1-A. %d\n", number);
		
		// -B. 10진법을 오른쪽 정렬한 6자리로 표시해라 
		System.out.printf("1-B. %6d\n", number);
		
		// 단, 모든 자리수 설정은 만약 할당 받은 메세지가 더 길면 무시된다. 
		//System.out.printf("1-B. %6d\n", 1234567);
		
		// -B. 10진법을 왼쪽 정렬한 6자리로 표시해라 
		System.out.printf("1-C. %-6d\n", number);
		
		// -D. 10진법을 오른쪽 정렬한 6자리로 표시하고 왼쪽에 빈공간이 있으면 0으로 채워라 
		System.out.printf("1-D. %06d\n", number);
		
		// -E. ERROR 
		// 000041 : 이건 결국 41
		// 410000 : 이건 41이라고 할 수가 없다. 전혀 다른 숫자가 되기 때문에 에러가 난다. 
		// 뒤에 0이 붙는 것은 안된다. 
		//System.out.printf("1-E. %-06d\n", number);
		
		
		// 2. 16진법 (he'x'adecimal)
		// -A. 16진법으로 숫자를 그대로 표시하라 
		number = 43; 
		System.out.printf("2-A. %x\n", number);
		
		// -B. 16진법으로 숫자를 그대로 표시하되 알파벳이 있으면 대문자로 
		System.out.printf("2-B. %X\n", number);
		
		// -C. 16진법으로 오른쪽 정렬해서 6자리로 표시하고 소문자로 표시 
		System.out.printf("2-C. %6x\n", number);
		
		// -D. 16진법으로 오른쪽 정렬한 8자리로 표시하고 왼쪽에 빈자리는 0으로 채우기 대문자로 표시 
		System.out.printf("2-D. %08X\n", number);
		
		// 3. 논리형 ('b'oolean)
		// -A. 소문자로 true/ false 출력
		System.out.printf("3-A, %b\n", true);
		System.out.printf("3-A, %b\n", false);
		System.out.printf("3-A, %b\n", number); 
		// 값이 존재하냐 하지 않냐 이기 때문에 true
		System.out.printf("3-A, %b\n", null);
		// null인 경우 값이 존재하지 않는 것이기 때문에 false
		
		// -B. 대문자로 출력
		System.out.printf("3-B, %B\n", true);
		System.out.printf("3-B, %B\n", false);
		
		// 4. 문자열('S'tring)
		// -A. 스트링의 내용을 그대로 출력하라 
		String str = "abCd";
		System.out.printf("4-A, %s\n", str);
		// -B. 스트링의 내용을 소문자를 대문자로 바꿔서 출력 
		System.out.printf("4-B, %S\n", str);
		
		double d = 3.141592; 
		// 5. 실수('f'loat)
		// -A. 실수를 그대로 출력하라 
		System.out.printf("5-A, %f\n", d); // 소수점까지 포함하기 때문에 8자리 숫자이다 
		
		// -B. 실수를 소숫점 3번째 자리까지 출력 
		System.out.printf("5-B, %.3f\n", d);
		
		// -C. 실수를 5자리로 출력 
		System.out.printf("5-C, %5f\n", d);
		// 출력하고자 하는 것에 비해 d의 자리수가 더 많기 때문에 무시하고 다 출력한다.
		
		// -D. 실수를 10자리로 출력 
		System.out.printf("5-D, %10f\n", d);
		
		// -E. 실수를 5자리로 출력하는데 그 중 소수점은 2자리까지만 출력 
		System.out.printf("5-E, %5.2f\n", d);
		
		// 이러한 %문자는 우리가 여러개를 섞어줄 수 있다. 
		String name = "양아무개";
		int age = 15; 
		int korean = 89; 
		int math = 93; 
		int english = 78;
		int history = 80; 
		int programming = 90; 
	
		
		int sum = korean + math + english + history + programming;
		double avg = sum/(NUMBER_OF_SUBJECT*1.0); // 현재상태에서 ERROR 
		// 현재 NUMBER_OF_SUBJECT가 static 밖에 있기 때문이다. 고로 static을 붙여준다 
		
		System.out.println("===점수표===");
		System.out.printf("이름: %s, 나이:%02d세 "
				+ "\n국어:%02d점, 영어 :%02d점, 수학:%02d점, 역사: %02d점, 프로그래밍: %02d점 "
				+ "\n총점: %03d점, 평균:%05.2f점",
				name, age, korean, english, math, history, programming, sum, avg, args);
		
		
		
	}

}
