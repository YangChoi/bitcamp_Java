import java.util.Scanner;

class Examination{
	private String name; 
	private String dap;
	private char[] ox = new char[JUNG.length()]; 
	private int score; 
	private static final String JUNG = "11111";

	public Examination(String name, String dap, char[] ox, int score){
		this.name = name; 
		this.dap = dap;
		this.ox = ox;
		this.score = score; 
	}

	// setter 
	public void setName(String name){
		this.name = name; 
	}
	public void setDap(String dap){
		this.dap = dap;
	}
	
	// 비교 
	public void compare(){
		score = 0; 
		for(int i = 0; i < ox.length; i++){
			if(dap.charAt(i) == JUNG.charAt(i)){
				ox[i] = 'O';
				score++;
			}else {
				ox[i] = 'X';
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

	// getter
	public String getName(){
		return name;
	}
	public String getDap(){
		return dap;
	}
	
	public char[] getOx(){
		return ox;
	}
	
	public int getScore(){
		return score;
	}



}

class ExaminationMain{
	public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	System.out.print("인원 수 입력 : ");
	int n = scan.nextInt();

	ExaminationMain[] arr = new ExaminationMain[n];
	Examination m = new Examination();
	
		for(int i = 0; i < arr.length; i++){
			arr[i] = new ExaminationMain();
			System.out.print("이름 입력 : ");
			arr[i].setName(scan.next());
			System.out.print("답 입력 : ");
			arr[i].setDap(scan.next());

			m.compare();
		
		}
 	}
}