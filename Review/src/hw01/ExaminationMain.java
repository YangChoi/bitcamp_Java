package hw01;

import java.util.Scanner;

class Examination {
	private String name; 
	private String dap;
	private char[] ox; 
	private int score; 
	private static final String JUNG = "11111"; 
	
	
	Scanner scan = new Scanner(System.in);
	
	public Examination() {}
	
	public Examination(String name, String dap, char[] ox, int scroe) {
		System.out.print("인원수 입력 : ");
		int n = scan.nextInt();
		int[] num = new int[n];
		
		System.out.print("이름 입력 : ");
		name = scan.next();
		System.out.println("답 입력");
		dap = scan.next();
	}
	
	public void compare() {
		
	}
}
public class ExaminationMain {

	public static void main(String[] args) {
		

	}

}
