import java.util.Scanner;

class Examination{
	private String name; 
	private String dap;
	private char[] ox;
	private int score; 
	private static final String JUNG = "11111";
	
	// 생성자 - 데이터 입력받기
	public Examination(){
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		this.name = scan.next();
		System.out.print("답 입력 : ");
		this.dap = scan.next(); // this생략 가능

		ox = new char[5]; // 배열을 여기서 선언하는구나..
}
	
	public void compare(){
		for(int i = 0; i < ox.length; i++){ // dap.length()
			if(dap.charAt(i) == JUNG.charAt(i)){
				ox[i] = 'O';
				score += 20; // 맞을 때마다 점수 20점 플러스 
			}else {
				ox[i] = 'X';
			}	
		}
	}

	// getter
	public String getName(){
		return name;
	}

	public char[] getOx(){
		return ox;
	}
	
	public int getScore(){
		return score;
	}

}

class ExaminationMain2{
	public static void main(String[] args){
	Scanner scan = new Scanner(System.in);

	System.out.print("인원수 입력 :");
	int count = scan.nextInt();

	Examination[] arr = new Examination[count];
	
		for(int i = 0; i < count; i++){
			arr[i] = new Examination(); // 데이터 받고 방 만들기
			arr[i].compare();
			System.out.println();
		}
	// 출력 
		System.out.println("이름\t1 2 3 4 5\t점수");
		for(int i = 0; i < count; i++){
			System.out.print(arr[i].getName()+"\t");
			
			for(int k = 0; k < arr[i].getOx().length; k++){
					System.out.print(arr[i].getOx()[k]+" ");
			}// for k
			System.out.println("\t"+arr[i].getScore()+"\t");
		}// for i
	}
}
