// 2�ܺ��� 9�ܱ��� 
// 3��о� ������ 
class Gugudan3 {
	public static void main(String[] args){
		int dan, i;
		
		for(int block = 1; block < 10; block+=3){
			for(i = 1; i<= 9; i++){
				for(dan = i; dan < i+3; dan++){
					System.out.print(dan + "*" + i + "=" + dan*i+"\t");
				}
				System.out.println();
			}
		}
	}
}