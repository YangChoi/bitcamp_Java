class ArrayTest{
	public static void main(String[] args){
		// int[] arr; // �迭 ���� 
		// arr = new int[5]; // �迭 ũ�� 5 ( �޸� �Ҵ�)

		int[] arr = new int[5]; // ���� ���� ��ħ
		System.out.println("�迭�� arr = " + arr);

		arr[0] = 27;
		arr[1] = 35;
		arr[2] = 12;
		arr[3] = 64;
		arr[4] = 31;

		for(int i = 0; i < arr.length; i++){
			System.out.println("arr[" +i+ "]=" + arr[i]);
		}

		System.out.println("\n�Ųٷ� ���");

		for(int i = arr.length-1; i >= 0; i--){
			// arr.length-1
			System.out.println("arr[" +i+ "]=" + arr[i]);
		}

		System.out.println("\nȦ�������͸� ���");
		for(int i = 0; i < arr.length; i++){
			if(arr[i]%2 == 1){
				System.out.println("arr[" +i+ "]=" + arr[i]);
			}
		}
	}
}