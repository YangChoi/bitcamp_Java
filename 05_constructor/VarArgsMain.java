class VarArgs{
	
	// �⺻ ������ 
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

// �ߺ� ���� ���� 
	public int sum(int...arr){ // ...���� �ؼ� �Ű������� ������ �����Ӱ� �д� (���������� �迭 ó�� )
		int hap = 0; 
		for(int i = 0; i < arr.length; i++){
			hap += arr[i];
		}
		return hap; // �� ����
	}
}

//=========
class VarArgsMain {
	public static void main(String[] args){
		
		VarArgs aa = new VarArgs();

		System.out.println("�� = " + aa.sum(10, 20));
		// sysout�� �ִ� �޼ҵ���� �� return���� �־���Ѵ�..
		System.out.println("�� = " + aa.sum(10, 20, 30 ));
		System.out.println("�� = " + aa.sum(10, 20, 30 , 40));

	}
}