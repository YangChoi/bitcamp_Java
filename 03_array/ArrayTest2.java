class ArrayTest2{
	public static void main(String[] args){
		// ũ�Ⱑ 50���� ������ �迭
		int[] arr = new int[50];
		//65~90 ������ ���� �߻��Ͽ� ���� 
		int[] count = new int[26]; // ���ĺ� ���� 
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*26)+65; 
			
			System.out.print((char)arr[i]+"\t");
		
			// 10�ٷ� ���� 
			if((i+1) % 10 == 0 ){
				// i�� 0���� �����ϱ� ������ +1
				System.out.println();
			}

			// A�� ���� ã�� 
			//if(arr[i] == 'A'){	
			//	count++;
			//}
			
			// �迭�� �� ���ĺ��� � �ִ��� ������ 
			// arr[0] == 'A' .... count[0]++;
				for(int k = 0; k < count.length; k++){
					if(arr[i] == (k+65)){
						count[k]++;
						// A�� �ƽ�Ű�ڵ�� 65�̴�. 
						// ��� count[0] �϶� A 65�̱� ������ 
						// +1�� �ϸ� count[1] �϶� B 66...	
					}
				}// for k
				

			} // for i

			for(int i = 0; i <count.length; i++){
				System.out.println((char)(i+65)+"�� ���� " + count[i]);
			}		
	}
}
