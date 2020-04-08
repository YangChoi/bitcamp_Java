import java.util.Scanner;

/*
학생의 이름과 답안지를 입력받아서 점수를 구하시오 

이름 입력 : 홍길동
답안지 입력: 12313
charAt으로 한글자 한글자 떼봐라 
이름  1 2 3 4 5 점수 
홍길동 O X X O X 40
*/
class Quiz3 {
	public static final String ANSWER = "11111"; // 상수화 
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		String name; //이름
		String input; // 학생의 답
		int score; // 점수 
		char[] ox = new char[ANSWER.length()]; // 답인지 아닌지 

		System.out.println("이름을 입력하시오");
		name = scan.nextLine();

		System.out.println("답 5개를 입력하시오");
		input = scan.nextLine();
		
		// answer와 input을 비교해야한다. 
		// 그리고 일치하는 갯수를 count해서 출력
		score = 0;
		for(int i = 0; i < 5; i++){
			if(input.charAt(i) == ANSWER.charAt(i)){
				ox[i] = 'O';
				score++;
			}else {
				ox[i] = 'X';

			}
		}
		System.out.println("이름\t1\t2\t3\t4\t5\t점수");
		System.out.println(name+"\t"+
							ox[0]+"\t"+
							ox[1]+"\t"+
							ox[2]+"\t"+
							ox[3]+"\t"+
							ox[4]+"\t"+
							(score*20));
	}
}