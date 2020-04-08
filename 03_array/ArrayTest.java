class ArrayTest{
	public static void main(String[] args){
		// int[] arr; // 배열 선언 
		// arr = new int[5]; // 배열 크기 5 ( 메모리 할당)

		int[] arr = new int[5]; // 위의 내용 합침
		System.out.println("배열명 arr = " + arr);

		arr[0] = 27;
		arr[1] = 35;
		arr[2] = 12;
		arr[3] = 64;
		arr[4] = 31;

		for(int i = 0; i < arr.length; i++){
			System.out.println("arr[" +i+ "]=" + arr[i]);
		}

		System.out.println("\n거꾸로 출력");

		for(int i = arr.length-1; i >= 0; i--){
			// arr.length-1
			System.out.println("arr[" +i+ "]=" + arr[i]);
		}

		System.out.println("\n홀수데이터만 출력");
		for(int i = 0; i < arr.length; i++){
			if(arr[i]%2 == 1){
				System.out.println("arr[" +i+ "]=" + arr[i]);
			}
		}
	}
}