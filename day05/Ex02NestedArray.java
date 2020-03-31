package day05;

import java.util.Scanner;

/*
 * 미국 대입시험 : SAT
 * 수학, 읽기, 쓰기 그리고 각각이 800점씩
 * 한달에 한번씩 열린다. 
 * 내가 제일 잘 본 점수를 본 시험들 중에서 뽑아서 제출
 * 
 * 한 학생이 SAT를 3번 봤고 
 * 그 중에서 제일 잘 나온 점수를 뽑아서 보여주는 프로그램

 */
public class Ex02NestedArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] scoreArray = new int[3][3]; // 3번씩 3과목
		// [3]을 인덱스 번호랑 헷갈리지 말자
		// 여기의 3은 인덱스번호의 3이 아니고 크기의 3이라는 것.
		// 0, 1, 2 이렇게 3개

		// 점수 입력받기
		for (int i = 0; i < scoreArray.length; i++) {
			System.out.println((i + 1) + "회차 입니다. ");

			System.out.print("수학 : ");
			scoreArray[i][0] = scan.nextInt();
			System.out.print("읽기 : ");
			scoreArray[i][1] = scan.nextInt();
			System.out.print("쓰기 : ");
			scoreArray[i][2] = scan.nextInt();

		}
		int[] maxScores = calculateMax(scoreArray);
		System.out.println("학생의 각 최고 점수  ");
		System.out.print("수학 : " + maxScores[0]);
		System.out.print("읽기 : " + maxScores[1]);
		System.out.print("쓰기 : " + maxScores[2]);
		scan.close();
	}

	private static int[] calculateMax(int[][] scoreArray) {
		int[] maxScores = new int[3];
		for (int i = 0; i < scoreArray.length; i++) {
			int mathMax = 0;
			int readingMax = 0;
			int writingMax = 0;
			// 위의 세개가 밑의 for문에 들어가면 아예 max가 0이 되어버리기 때문에 밑의 for문 밖에 있어야한다.
			for (int k = 0; k < scoreArray[i].length; k++) {
//				if (mathMax < scoreArray[i][0]) {
//					mathMax = scoreArray[i][0];
//				} 이 if문은 밑에 삼항연산자가 다 해주는 기능이다.. 

				// 삼항연산자
				// 우리가 어딘가에 값을 정할 때 사용된다.
				// if문, switch문은
				// 조건이 맞으면
				// 특정 메소드나 어떤 코드를 실행해라 가 가능하지만
				// 삼항연산자는 오직 값을 결정할 때에만 쓰인다.
				// 사용법
				// 값 결정할 곳 = 조건식 ? 참일때 값 : 거짓일 때 값
				mathMax = mathMax < scoreArray[i][0] ? scoreArray[i][0] : mathMax;
				// readingMax와 writingMax도
				readingMax = readingMax < scoreArray[i][1] ? scoreArray[i][1] : readingMax;
				writingMax = writingMax < scoreArray[i][2] ? scoreArray[i][2] : writingMax;

			}
			// 값복사 vs 주소값 복사
			// call by value vs call by reference (C)
			maxScores[0] = mathMax;
			maxScores[1] = readingMax;
			maxScores[2] = writingMax;

		}
		return maxScores;

	}

}
