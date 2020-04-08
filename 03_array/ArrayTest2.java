class ArrayTest2{
	public static void main(String[] args){
		// 크기가 50개인 정수형 배열
		int[] arr = new int[50];
		//65~90 사이의 난수 발생하여 저장 
		int[] count = new int[26]; // 알파벳 갯수 
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*26)+65; 
			
			System.out.print((char)arr[i]+"\t");
		
			// 10줄로 정리 
			if((i+1) % 10 == 0 ){
				// i는 0부터 시작하기 때문에 +1
				System.out.println();
			}

			// A의 갯수 찾기 
			//if(arr[i] == 'A'){	
			//	count++;
			//}
			
			// 배열에 각 알파벳이 몇개 있는지 세보자 
			// arr[0] == 'A' .... count[0]++;
				for(int k = 0; k < count.length; k++){
					if(arr[i] == (k+65)){
						count[k]++;
						// A의 아스키코드는 65이다. 
						// 고로 count[0] 일때 A 65이기 때문에 
						// +1을 하면 count[1] 일때 B 66...	
					}
				}// for k
				

			} // for i

			for(int i = 0; i <count.length; i++){
				System.out.println((char)(i+65)+"의 개수 " + count[i]);
			}		
	}
}
