package day06;
// 훨씬 간단한 버전 
import java.util.Random;

import util.MyArray;

/*
 * 로또번호 추첨기 
 * 20분동안 랜덤 객체 이용해서 
 * 1~45까지 랜던함 숫자를 
 * 크기가 6인 배열에 담기 
 */
public class LottoNumbers2 {
	private static final int MAX = 45; // static은 사실 잘 안쓰기 때문에 생략해도 된다.
	// 여기서는 우리가 static이 들어간 메인 메소드에서 상수를 사용하기 때문에 적어줬다.
	private static final int SIZE = 6;

	public static void main(String[] args) {
		Random random = new Random();

		int[] lottoNumbers = new int[0]; // 랜덤 숫자 담을 배열
		while(lottoNumbers.length < SIZE) {
			int randomNumber = random.nextInt(MAX)+1;
			if(!MyArray.contains(lottoNumbers, randomNumber)) {
				lottoNumbers = MyArray.add(lottoNumbers, randomNumber);
				
			}
		}
	
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
				// 정렬이 한 번 끝나면 코드는 if문 밖으로 나가게 된다. 
				// 그러나 정렬은 lottoNumbers의 배열이 끝날 때까지 계속되어야한다. 
				// if문을 나가서 i가 0부터 시작하면 i++을 만나서 
				// i는 1이 되고 0번째 배열을 무시하게 되어버린다. 
				// 그렇기 때문에 if문을 나가기 전에 i를 -1로 초기화 시켜서 i가 0부터 시작하도록 하는 것이다. 
			}
		}
		System.out.println("==== 정렬 끝남 ====");
		for(int i : lottoNumbers) {
			System.out.println(i);
			
			
			
		}
	}

}
