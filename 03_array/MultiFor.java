class MultiFor{
	public static void main(String[] args){
		for(int a = 2; a <= 4; a+=2){ // a = 2, a = 4
			for(int b = 1; b <=3; b++){ // b = 1, b = 2, b = 3
				System.out.println("a=" + a + "\t b=" + b);
			}
			System.out.println();
		}
	}
}