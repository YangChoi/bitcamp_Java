/*
���� �Է� �޾Ƽ� �������� ���Ͻÿ� 
[������]
java GuguDan   5��
5*1 = 5
....
5*9 = 45;
*/

class GuguDan {
	public static void main(String[] args) {
	System.out.println("java GuguDan");
	int n = Integer.parseInt(args[0]);

	for(int i = 1; i <= 9; i++){
		System.out.println(n + " * " + i + " = " + (n*i));
	}

	}

}