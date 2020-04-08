// 2단부터 9단까지 
// 2 * 1 = 2
//,,,
// 9 * 9 = 81
class Gugudan {
	public static void main(String[] args){
		int dan;
		int i;
		System.out.println("구구단");
		for(dan = 2; dan <= 9; dan++){
			System.out.println("=======================");
			for(i = 1; i <= 9; i++){
				System.out.println(dan+"*"+i+ "=" + dan*i);
			}
	
		
		}
	}
	
}
