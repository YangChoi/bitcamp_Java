// �̸�, ����, ����, ���� ������ �Է� �޾Ƽ� ������ ��� 
import java.util.Scanner;

class SungJuk{
	// ���� �޼ҵ� 
	public int calcTot(int korScore, int engScore, int mathScore){
		return korScore + engScore + mathScore;
	}

	// ��� �޼ҵ� 
	public double calcAvg(int tot){
		return tot/3.0;
	}
	
	// ��� �޼ҵ� 
	public void print(String name, int korScore, int engScore, int mathScore, int tot, double avg){

		System.out.println("\t*** " + name + " ����ǥ ***\t");
		System.out.print("����\t����\t����\t����\t���\n");
		System.out.print(korScore+"\t"
						+engScore+"\t"
						+mathScore+"\t"
						+tot+"\t"
						+ String.format("%.2f", avg)); // %d : 10����
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SungJuk_new sj = new SungJuk_new();

		System.out.print("�̸� �Է� : ");
		String name = scan.next(); // nextLine : ���Ͱ� ����

		System.out.print("�������� �Է� : ");
		int korScore = scan.nextInt();
		System.out.print("�������� �Է� : ");
		int engScore = scan.nextInt();
		System.out.print("�������� �Է� : ");
		int mathScore = scan.nextInt();

		int tot = sj.calcTot(korScore, engScore, mathScore); // ȣ�� 
		double avg = sj.calcAvg(tot);
		
		sj.print(name, korScore, engScore, mathScore, tot, avg);

	}
}