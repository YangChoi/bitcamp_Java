import java.util.Arrays;
class SelectionSort {
	public static void main(String[] args){
		// int[] arr = {36, 24, 12, 48, 30}; �迭 
		
		// int[] arr = new int[5];
		// arr = {36, 24, 12, 48, 30}; >> �ȵ�. �����ϸ鼭 �ٷ� �ִ°Ÿ� ���� 
		// �̹� ������ �迭 ũ�� 5 �����س��� �ڿ� �� �ִ� �� ���� . 
		// �Ʒ��� ���� ���� ����� 
		// arr[0] = 36;
		
		// int[] arr = new int[5]{36, 24, 12, 48, 30}; // ũ�⸦ �������ָ� �ȵȴ�.  
		int[] arr = new int[]{36, 24, 12, 48, 30}; 
		int temp;
		
			
		/*		
		for(int i = 0; i < arr.length-1; i++){  // ������ ���� ���� �ʱ� ������ -1 (�ѹ��� ���� ����) 0, 1, 2, 3���� ����. arr[4] �Ȱ� (�ڼ��Ѱ� ��Ʈ�׸� ����)
			for(int k = i+1; k < arr.length; k++){
				if(arr[i] > arr [k]){ // �������� sort 
					temp = arr[i];
					arr[i] = arr[k];
					arr[k] = temp;
					
				}
			}
		}
		*/

		// ���� �۾��� ���ִ� sort �޼ҵ� 
		Arrays.sort(arr);
		// �ڹٰ� �������� �޼ҵ带 �� �� �� �޼ҵ尡 � Ŭ�������� �Դ���(Arrays) �� �˷�����Ѵ�. 

		for(int data : arr){
			System.out.print(data+"  ");
		}
	}
}


