// 2단부터 9단까지 
// 3등분씩 나누기 
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