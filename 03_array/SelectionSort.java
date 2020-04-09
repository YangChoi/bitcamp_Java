import java.util.Arrays;
class SelectionSort {
	public static void main(String[] args){
		// int[] arr = {36, 24, 12, 48, 30}; 배열 
		
		// int[] arr = new int[5];
		// arr = {36, 24, 12, 48, 30}; >> 안됨. 선언하면서 바로 주는거면 몰라도 
		// 이미 위에서 배열 크기 5 선언해놓고 뒤에 값 주는 건 에러 . 
		// 아래와 같이 값을 줘야함 
		// arr[0] = 36;
		
		// int[] arr = new int[5]{36, 24, 12, 48, 30}; // 크기를 지정해주면 안된다.  
		int[] arr = new int[]{36, 24, 12, 48, 30}; 
		int temp;
		
			
		/*		
		for(int i = 0; i < arr.length-1; i++){  // 마지막 방은 가지 않기 때문에 -1 (한바퀴 돌지 않음) 0, 1, 2, 3에서 끝남. arr[4] 안감 (자세한건 노트그림 참고)
			for(int k = i+1; k < arr.length; k++){
				if(arr[i] > arr [k]){ // 오름차순 sort 
					temp = arr[i];
					arr[i] = arr[k];
					arr[k] = temp;
					
				}
			}
		}
		*/

		// 위의 작업을 해주는 sort 메소드 
		Arrays.sort(arr);
		// 자바가 만들어놓은 메소드를 쓸 때 그 메소드가 어떤 클래스에서 왔는지(Arrays) 꼭 알려줘야한다. 

		for(int data : arr){
			System.out.print(data+"  ");
		}
	}
}


