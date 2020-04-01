package day06;

import java.util.Random;

import util.MyArray;

/*
 * 로또번호 추첨기 
 * 20분동안 랜덤 객체 이용해서 
 * 1~45까지 랜던함 숫자를 
 * 크기가 6인 배열에 담기 
 */
public class LottoNumbers {
	private static final int MAX = 45; // static은 사실 잘 안쓰기 때문에 생략해도 된다.
	// 여기서는 우리가 static이 들어간 메인 메소드에서 상수를 사용하기 때문에 적어줬다.
	private static final int SIZE = 6;

	public static void main(String[] args) {
		Random random = new Random();

		int[] lottoNumbers = new int[SIZE]; // 랜덤 숫자 담을 배열

		for (int i = 0; i < lottoNumbers.length; i++) {
			lottoNumbers[i] = random.nextInt(MAX) + 1; // 그냥 MAX 하면 0부터 44까지 나온다.그래서 +1을 해서 1부터 44까지 나오게

		}
		// 향상된 for문, forEach구조
		// 우리가 배열 혹은 collections의 무언가를 쭉 출력할 때
		// 몇번째 위치에 있는 무언가를 굳이 지칭해줄 필요가 있을까? >> 없지. 그냥 쭉 출력하는거니까.
		for (int i : lottoNumbers) {
			// 만약 여기서 i = 20; 이라고 선언해도 바뀌지 않는다.
			// 그대로 lottoNumbers가 바뀌지 않는한 이 안에서 뭘해도 i값은 바뀌지 않는다.

			System.out.println(i);
		}
		// 단 forEach 구조는 2가지 제약이 있다.
		// 1. 데이터를 바꾸더라도 원본은 바뀌지 않는다.
		// 값만 복사해서 보여주는 용도 (위의 i = 20; 의 내용)
		// 2. 원본이 나온 collection의 개수가 바뀌면 안된다. (뭔가 고정값이 아니면 나타내기 힘들다는 듯...? )
		//

		// 여기까지 만든 lottoNumbers의 문제점은 중복이 존재할 수 있다는 것이다.

		// 중복이란 무엇인가?
		// 1. 인덱스가 다르지만
		// 2. lottoNumbers[인덱스]의 값이 같을 때

		for (int i = 0; i < lottoNumbers.length; i++) {
			// lottoNumbers[i]는 기준점이 된다.
			for (int k = 0; k < lottoNumbers.length; k++) {
				// lottoNumbers[k]는 중복인지 검사할 숫자가 된다.
				// if문을 달라서 위치가 다르지만 값이 같은 조건을 만들어보자
				if (lottoNumbers[i] == lottoNumbers[k] && i != k) {
					System.out.println(i + "와" + k + "가 중복이다.");
					// 값이 같고, 인덱스가 다르다면 : 중복이다. (위치가 다르고 값이 같은 경우)
					lottoNumbers[i] = random.nextInt(MAX) + 1; // 새로운 값을 넣어준다.
					k = -1; // 이 if문이 끝나고 ++되어서 0으로 돌아가 0부터 검사를 시작한다. (따라서 0이면 안됨, 0번째 건너뛰니까)
				}
			}
		}
		System.out.println("==== 중복 제거 후 ==== ");
		for (int i : lottoNumbers) {
			System.out.println(i);
		}

		// 로또 번호는 순서대로 나열해서 보여주기 때문에
		// 정렬을 해보자
		// 정렬의 경우 지금 element가 다음 element보다 크면
		// 두개의 위치를 바꿔주면 된다.
		// 지금 요소 : lottoNumbers[i]
		// 다음 요소 : lottoNumbers[i+1]

		// 그렇다면
		// for(int i = 0; i < 어디까지? i++)
		// 크기 -1
		// for(int i = 0; i < lottoNumbers.length -1; i++)
		for (int i = 0; i < lottoNumbers.length - 1; i++) {
			if(lottoNumbers[i] > lottoNumbers[i+1]) {
				// 앞의 것이 더 크다면 뒤로 보내줘야한다 
				int temp = lottoNumbers[i]; 
				// 뒤로 보낼 값을 임시 저장함에 넣고 
				lottoNumbers[i] = lottoNumbers[i+1];
				// 앞에 있는 값에 뒤에 있던 값을 넣는다. 
				lottoNumbers[i+1] = temp;
				// 이 후 뒤에 있는 값에 저장한 i값이 들어 있는 temp 값을 넣는다. 
				i = -1;
				// -1왜?
			}
		}
		System.out.println("==== 정렬 끝남 ====");
		for(int i : lottoNumbers) {
			System.out.println(i);
			
			
			
		}
	}

}
