import java.util.Scanner;

class StringBufferTest{
	Scanner scan = new Scanner(System.in);
	
	private int dan; 
	
	// 생성자에서 입력을 받는다. 
	public StringBufferTest(){
		Scanner scan = new Scanner(System.in);
		System.out.print("단을 입력하시오 " );
		this.dan = scan.nextInt();
	}

	
	// get
	public int getDan(){
		return dan;
	}

	public void display(){
		StringBuffer buffer = new StringBuffer(); // StringBuffer 초기화 할 땐 "" 안됨 (String 타입과 StringBuffer는 다르기 때문// null로 해줭함)
		
		for(int i = 1; i <=9; i++){
			//System.out.println(this.dan + "*" + i + "=" + dan*i);
						
			buffer.append(dan); // append : 끝에 추가하라 
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan*i);

			System.out.println(buffer);
			buffer.delete(0, buffer.length());
			// 앞서 출력한 것까지 다 붙어서 나오므로 앞에서 출력이 이미 끝난 것들은 
			// delete로 없애준다. 0번째 부터 buffer.length
			// 배열.length  문자열.length()
			
		}
	}


	public static void main(String[] args){
		StringBufferTest sbt = new StringBufferTest(); // 클래스에 메모리 잡기 (메모리 생성 + 생성자)
		// >> 생성자 부름 
		sbt.display();
	}
}

/*
원하는 단 입력 : 7
구구단 출력 
*/