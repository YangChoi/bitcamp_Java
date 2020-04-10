class VarArgs{
	
	// 기본 생성자 
	public VarArgs(){
	}
/*
	public int sum(int a, int b){
		return a+b;
	}
	public int sum(int a, int b, int c){
		return a+b+c;
	}
	public int sum(int a, int b, int c, int d){
		return a+b+c+d;
	}
*/

// 중복 없게 하자 
	public int sum(int...arr){ // ...으로 해서 매개변수의 갯수를 자유롭게 둔다 (내부적으로 배열 처리 )
		int hap = 0; 
		for(int i = 0; i < arr.length; i++){
			hap += arr[i];
		}
		return hap; // 합 리턴
	}
}

//=========
class VarArgsMain {
	public static void main(String[] args){
		
		VarArgs aa = new VarArgs();

		System.out.println("합 = " + aa.sum(10, 20));
		// sysout에 있는 메소드들은 다 return값이 있어야한다..
		System.out.println("합 = " + aa.sum(10, 20, 30 ));
		System.out.println("합 = " + aa.sum(10, 20, 30 , 40));

	}
}