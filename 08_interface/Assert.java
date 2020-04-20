import java.util.Scanner;

class Assert{
	private int x, y; 
	int result;

	
	// x와 y를 입력받는 input
	public void input(){
		Scanner scan = new Scanner(System.in);
		System.out.print("x를 입력하시오 : ");
		x = scan.nextInt();
		System.out.print("y를 입력하시오 : ");
		y = scan.nextInt();

	}
	// x^y를 구하고 출력하는 output
	public void output(){
		assert y >= 0 : "y는 0보다 크거나 같아야한다"; // 틀리면 멈추고 맞으면 밑으로 내려감 
		// : 이후 메세지 넣기 
		result = 1;
		for(int i = 1; i <= y; i++){
			result *= x;
		}
		System.out.println(result);
	}

	public static void main(String[] args){
		Assert as = new Assert();
		as.input();
		as.output();
	}
}