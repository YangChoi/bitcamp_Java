import java.util.Scanner;

class Examination {
	private String name;
	private String dap;
	private char[] ox;
	private int score;
	private static final String JUNG="11111";
	
	public Examination(){
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		this.name = scan.next();
		System.out.print("답 입력 : ");
		dap = scan.next();

		ox = new char[5];
	}

	public void compare(){
		for(int i=0; i<ox.length; i++){ //dap.length()
			if(JUNG.charAt(i) == dap.charAt(i)){
				ox[i] = 'O';
				score += 20;
			}else
				ox[i] = 'X';
		}//for
	}
	
	public String getName() {
		return name;
	}
	public char[] getOx() {
		return ox;
	}
	public int getScore() {
		return score;
	}
}
//--------------
class ExaminationMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("인원수 입력 : ");
		int count = scan.nextInt();

		Examination[] ar = new Examination[count];
		for(int i=0; i<count; i++){
			ar[i] = new Examination();
			ar[i].compare();
			System.out.println();
		}

		//출력
		System.out.println("이름\t1 2 3 4 5\t점수");
		for(int i=0; i<count; i++){
			System.out.print(ar[i].getName()+"\t");

			for(int j=0; j<ar[i].getOx().length; j++){
				System.out.print(ar[i].getOx()[j]+" ");
			}//for j
			
			System.out.println("\t"+ar[i].getScore());
		}//for i

	}
}
