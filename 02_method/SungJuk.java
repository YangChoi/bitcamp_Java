// �̸�, ����, ����, ���� ������ �Է� �޾Ƽ� ������ ��� 
import java.util.Scanner;

class SungJuk {
	// ���� �޼ҵ� 
	public int calcTot(int korScore, int engScore, int mathScore){
		return korScore + engScore + mathScore;
	}

	// ��� �޼ҵ� 
	public double calcAvg(double korScore, int engScore, int mathScore){
		return (korScore + engScore + mathScore)/3;
	}
	
	// ��� �޼ҵ� 
	public void print(String name, int korScore, int engScore, int mathScore){
		SungJuk sj = new SungJuk();

		int tot = sj.calcTot(korScore, engScore, mathScore);
		double avg = sj.calcAvg(korScore, engScore, mathScore);

		System.out.println("\t*** " + name + " ����ǥ ***\t");
		System.out.print("����\t����\t����\t����\t���\n");
		System.out.print(korScore+"\t"+engScore+"\t"+mathScore+"\t"+tot+"\t"+avg);
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SungJuk sj = new SungJuk();

		System.out.print("�̸� �Է� : ");
		String name = scan.next(); // nextLine : ���Ͱ� ����

		System.out.print("�������� �Է� : ");
		int korScore = scan.nextInt();
		System.out.print("�������� �Է� : ");
		int engScore = scan.nextInt();
		System.out.print("�������� �Է� : ");
		int mathScore = scan.nextInt();

		
		sj.print(name, korScore, engScore, mathScore);

	}
}