import java.io.IOException;

class ExceptionTest2 {
	private int dan;
	
	// 입력
	public void input() throws IOException{ // 구현부 
		System.out.print("단 : ");	
		dan = System.in.read()-'0'; // 1개의 문자로 입력받음 ex> A : 65 a : 97
		// 문자열을 숫자형으로 바꿔주기 위해 -'0'
	}
	// 출력
	public void output(){
		if(dan >= 2 && dan <= 9){
			for(int i = 1; i <= 9; i++){
			System.out.println(dan + "*" + i + "=" + dan*i);	
			}// for
		}else{
			//System.out.println("숫자는 2부터 9까지만 가능");
		
			try{
				// Exception 발생 
				// 내가 원하는 범위에서 벗어나면..
				// throws와는 다름.. : 백신 (잡는 쪽)
				// throw : 바이러스 (퍼트림) 에러를 발생시키는 애들 
				//throw new Exception("숫자는 2부터 9까지만 가능" );
				
				// MakeException 에서 예외 만듦
				throw new MakeException("숫자는 2부터 9까지만 가능" );
			}catch(Exception e){
				e.printStackTrace(); // 에러메시지가 찍힌다. 
			}
		
		}
			
	}
	public static void main(String[] args) throws IOException {
		ExceptionTest2 et = new ExceptionTest2();
		et.input(); // 호출 
		// throws는 호출/구현 둘다 구현되어야한다.
		// 그런데 만약 java가 자체적으로 만든 것을 오버라이드 할 경우에는 
		// 그것을 일일이 찾아 가며 예외를 걸어줄 수 없다. 
		// 그렇기 때문에 자바가 제공하는 Override한 메소드에는 throws를 사용해선 안된다. 
		// 
		et.output();
	}
}
