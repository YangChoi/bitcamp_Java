// 이름, 국어, 영어, 수학 점수를 입력 받아서 총점과 평균 
import java.util.Scanner;

class SungJuk{
	// 총점 메소드 
	public int calcTot(int korScore, int engScore, int mathScore){
		return korScore + engScore + mathScore;
	}

	// 평균 메소드 
	public double calcAvg(int tot){
		return tot/3.0;
	}
	
	// 출력 메소드 
	public void print(String name, int korScore, int engScore, int mathScore, int tot, double avg){

		System.out.println("\t*** " + name + " 성적표 ***\t");
		System.out.print("국어\t영어\t수학\t총점\t평균\n");
		System.out.print(korScore+"\t"
						+engScore+"\t"
						+mathScore+"\t"
						+tot+"\t"
						+ String.format("%.2f", avg)); // %d : 10진수
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SungJuk_new sj = new SungJuk_new();

		System.out.print("이름 입력 : ");
		String name = scan.next(); // nextLine : 엔터값 먹음

		System.out.print("국어점수 입력 : ");
		int korScore = scan.nextInt();
		System.out.print("영어점수 입력 : ");
		int engScore = scan.nextInt();
		System.out.print("수학점수 입력 : ");
		int mathScore = scan.nextInt();

		int tot = sj.calcTot(korScore, engScore, mathScore); // 호출 
		double avg = sj.calcAvg(tot);
		
		sj.print(name, korScore, engScore, mathScore, tot, avg);

	}
}