package day05;

import java.util.Scanner;

public class Ex01NestedArray {

	public static void main(String[] args) {
//		int[][] nestedArray = new int[2][]; // row가 2개 확정
//		int[] array01 = new int[3]; // 첫번째 row는 col이 3개
//		int[] array02 = new int[4]; // 두번째 row는 col이 4개
//		nestedArray[0] = array01;
//		nestedArray[1] = array02;

		// 학생 5명 국영수 점수를 관리하는 2차원배열 + 이름을 가지는 string 배열
		int[][] scoreArray = new int[5][3];
		String[] nameArray = new String[5]; // 학생 이름 배열이 행이 되기 때문에 이차원배열에서도 0번째 배열을 5로 설정 
		// 이걸 보여주려면
		// nameArray[0] 학생
		// 국어 : scoreArray[0][0]
		// 영어 :scoreArray[0][1]

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < nameArray.length; i++) { // 학생 수만큼 for문 돌리기 
			System.out.println("====" + (i + 1) + " 번 학생 ===="); // 학생의 이름을 받는다. 
			System.out.print("이름 : ");
			String name = scan.nextLine(); // 배열String은  nextLine()으로 받는 듯? 
			
			// 점수는 for문 돌리지 않고 그냥 국영수 점수 각각 받는다.
			// [i]는 학생 수
			System.out.println(name + "학생의 국어 점수 : "); 
			scoreArray[i][0] = scan.nextInt();
			System.out.println(name + "학생의 영어 점수 : ");
			scoreArray[i][1] = scan.nextInt();
			System.out.println(name + "학생의 수학 점수 : ");
			scoreArray[i][2] = scan.nextInt();
			
			nameArray[i] = name; // [i]에 이름을 넣어준다. 
			scan.nextLine(); // 엔터키 비워줄 것 (아니면 입력받는 칸이 이상해진다)
		}
		// 출력
		for(int i = 0; i <scoreArray.length; i++) { // 점수 배열의 길이만큼 돌린다. 
			System.out.println("=====" + nameArray[i]+ "====="); // .. 학생의 점수는..
			System.out.println("국어\t영어\t수학\t"); // 국 영 수로 구성되어 있고 ( 여기까지 행 타이틀 만들기 . )
			
			for(int k = 0; k < scoreArray[i].length; k++) { // 다시 점수 배열 길이 만큼
				System.out.print(scoreArray[i][k] + "\t"); // 위에서 입력받은 점수 배열을 순서대로 출력한다. 
				
			}
			System.out.println(); // 줄바꿈 한번 하고 
			printSumAndAverage(scoreArray[i]); // 밑에서 만든 총점과 평균 구하는 메소드 호출 
			System.out.println("============"); // 끝
			System.out.println(scoreArray.length); // 5
			System.out.println(scoreArray[i].length); // 3
		}
	
	
		scan.close();

	}
	// 학생의 점수배열을 주면 
	// 총점과 평균을 출력하는 메소드를 작성하라 
	// 리턴타입은 double이다. 평균까지 구해야하기 때문
	// 객체생성해서 호출하는게 아니기 때문에 static
	private static void printSumAndAverage(int[] scoreArray) { // 점수 배열을 받고
		// 여기 파라미터의 scoreArray는 실제 위에서 선언한 배열 scoreArray랑은 관계 없다. 
		// 이름은 이름일 뿐이다. 
		int sum = 0; // sum 초기화 해주고 
		
		for(int i = 0; i < scoreArray.length; i++) { // 점수 배열의 길이 만큼
			sum += scoreArray[i]; // 점수들을 더해서 sum을 만든다 
 
		}
		double avg = sum/(double)scoreArray.length; // 평균구하기 
		// scoreArray나 sum이나 둘다 정수 int형이기 때문에 결과가 double이 나오려면 둘 중에 하나 아무거나 double로 형변환해주어야한다. 
		
		System.out.println("총점 : " + sum); // 출력형태까지 
		System.out.println("평균 : " + avg);
	}

}
