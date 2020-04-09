// 2단부터 9단까지 
// 3등분씩 나누기 
class Gugudan3 {
	public static void main(String[] args){
		int dan, i;
		
		for(int block = 2; block <= 8; block+=3){
			for(i = 1; i<= 9; i++){
				for(dan = block; dan <= block+2; dan++){
					if( dan != 10) { // 10단 뻄
						System.out.print(dan + "*" + i + "=" + dan*i+"\t");
					}
				} // for dan 
				System.out.println();
			} // for i  
		} // for block 
	}
}