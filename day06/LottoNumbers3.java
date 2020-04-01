package day06;

import java.util.Random;
import java.util.Scanner;
import util.MyArray;

/*
 * 여러게임을 관리해야한다. 
 * 앞서 만든 것은 한게임에 한번씩만 나왔는데 (숫자 단 6개만 나온 것) 
 * 
 * "로또 자동 만원어치요"
 * 사용자가 금액 입력 -> 1000 단위로 몇 게임인지 변환 
 * 그 횟수만큼 배열을 만들어서 통째로 보여준다. (만원어치면 10게임이라는 소리구만)
 * 
 */
public class LottoNumbers3 {
	private static final int SIZE = 6;
	private static final int MAX = 45;
	private static final int PRICE_PER_GAME = 1000;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		System.out.println("로또 판매기");
		System.out.println("얼마어치를 출력할까요? ");
		int money = scan.nextInt();
		// 투입한 금액을 1000으로 나눠서 몇 게임인지를 int game에 저장
		int game = money / PRICE_PER_GAME;
		int[][] totalGames = new int[game][];

		for (int i = 0; i < totalGames.length; i++) {
			totalGames[i] = new int[0];
			// totalGames[i]의 크기를 0으로 설정해야 
			// 밑의 while문에서 size보다 작은 크기에서 하나씩 더해가면서 
			// 랜덤 숫자를 넣을 수 있게 되기 때문
			while (totalGames[i].length < SIZE) {
				int randomNumber = random.nextInt(MAX) + 1;
				if (!MyArray.contains(totalGames[i], randomNumber)) {
					totalGames[i] = MyArray.add(totalGames[i], randomNumber);
				}
			}
			for (int k = 0; k < totalGames[i].length-1; k++) {
				// totalGames에 int가 어딨어..
				// 0번째, 1번째, 2번째로 들어가야 int 값이 있다.
				if (totalGames[i][k] > totalGames[i][k + 1]) {
					int temp = totalGames[i][k];
					totalGames[i][k] = totalGames[i][k + 1];
					totalGames[i][k + 1] = temp;
					k = -1;
				}

			}
		}
//		for (int i = 0; i < totalGames.length; i++) { // 몇번째 게임인지
//			// 그 게임안에 totalGames[i] 호출
//			// i번째 게임의 번호들...
//			// 여기 안에 있던 for문은 while문 끝나고 바로 정렬 들어가게 while문 밑에 넣었다. 
//		}
		int gameNumber = 1;
		for (int[] arr : totalGames) {
			System.out.println("<" + gameNumber + "번 게임 >");
			for (int i : arr) {
				System.out.printf("%3d\t", i);
			}

			System.out.println("\n=================================");
			gameNumber++;
		}
		scan.close();
	}

}
