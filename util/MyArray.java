package util;

/*
 * 배열에 필요한 메소드들을 구현해 놓은 클래스 
 */
public class MyArray {

	// 1.contains
	public static boolean contains(String[] array, String keyword) {
		for (int i = 0; i < array.length; i++) {
			if (keyword.equals(array[i])) {
				return true;
			}
		}
		return false; // 중복이 없다. keyword에 일치하는 array 값이 없다. (false)
	}

	// 오버로딩을 이용해 int 배열의 contains 메소드를 구현해보기
	public static boolean contains(int[] array, int keyword) {
		for (int i = 0; i < array.length; i++) {
			if (keyword == array[i]) {
				return true;
			}
		}
		return false; // 중복이 없다. keyword에 일치하는 array 값이 없다. (false)
	}

	// 우리가 원하는 요소의 위치를 알려주는 메소드
	// indexOf
	public static int indexOf(String[] arr, String keyword) {
		for (int i = 0; i < arr.length; i++) {
			if (keyword.equals(arr[i])) {
				return i; // 찾는 값이 있는 경우, 해당 값을 보여준다.
			}
		}

		return -1; // 찾는 값이 없는 경우
	}

	// int 배열에 대한 indexOf 오버로딩
	public static int indexOf(int[] arr, int keyword) {
		for (int i = 0; i < arr.length; i++) {
			if (keyword == arr[i]) {
				return i;
			}
		}
		return -1;
	}

	// 위의 메소드들을 보고 가장 마지막에 일치하는 요소의 번호를 리턴하는 메소드
	// lastIndexOf
	public static int lastIndexOf(String[] arr, String keyword) {
		for (int i = arr.length - 1; i >= 0; i--) {
			// 배열의 인덱스는 결국 크기 -1 이기 때문에 length -1을 해준다.
			// 배열을 0번째 부터 훑고 싶어서 라고 생각해도.. 뭐 얼추..? 맞는 이야기
			if (keyword.equals(arr[i])) {
				return i;
			}
		}
		return -1;
	}

	public static int lastIndexOf(int[] arr, int keyword) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (keyword == arr[i]) {
				return i;
			}
		}
		return -1;
	}

	// 배열의 크기를 구하는 메소드
	public static int size(String[] arr) {
		return arr.length;
	}

	public static int size(int[] arr) {
		return arr.length;
	}

	// 배열 크기를 1 늘려주는 메소드
	private static int[] expand(int[] arr) {
		// 먼저 기존의 배열 값을 복사
		// arr = {1, 3, 5}
		int[] temp = new int[arr.length]; // 임시저장할 배열

		for (int i = 0; i < arr.length; i++) {

			temp[i] = arr[i];
		}
		// temp = {1, 3, 5}
		arr = new int[temp.length + 1]; // 기존의 것보다 +1 된 배열
		// arr = {0, 0, 0, 0}
		for (int i = 0; i < temp.length; i++) {
			arr[i] = temp[i]; // 기존의 값들도 temp와 똑같은 순서로 들어오게 됨
		}
		// arr = {1, 3, 5 , 0}
		return arr;
	}

	private static String[] expand(String[] arr) {
		String[] temp = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		arr = new String[temp.length + 1];

		for (int i = 0; i < temp.length; i++) {
			arr[i] = temp[i];
		}
		return arr;
	}

	// 배열에 추가해주는 메소드
	// 단, 추가해주는 위치는 무조건 제일 마지막 뒤에 추가
	// 즉, 크기가 자동으로 변하는 배열로 꾸미는 것
	// 이를 통해서 추가가 가능케 되면
	// 배열 자체를 아예 처음에 크기를 0으로 만들어도 상관이 없어진다.
	public static int[] add(int[] arr, int element) {
		int index = arr.length;
		// {1,5 }, 5
		// arr.length ? >> 2 (1과 5)
		// index ? >> 2 (arr.length이므로)

		// 그러면 넘어온 배열의 크기를 늘리고
		// 늘어난 크기 -1 의 인덱스에 추가
		// 넘어온 배열의 크기를 늘리고 늘어나기전 크기의 인덱스에 추가
		arr = expand(arr);
		// arr.length = 3 (expand로 1늘어남)
		// 여기서 마지막 index번호는 2

		arr[index] = element;
		// index의 길이 값이 곧 마지막 index 번호가 되는 것

		return arr;
	}

	// String 오버로딩
	public static String[] add(String[] arr, String element) {
		int index = arr.length;

		arr = expand(arr);
		arr[index] = element;

		return arr;
	}

	// 삭제 메소드
	// 삭제의 경우 크기도 줄어들기
	public static int[] remove(int[] arr, int element) {
		// 해당하는 번호 찾아서
		// 그 번호 전후로 배열을 분리한다.
		// 이후 해당 번호를 빼고
		// 그 앞 배열 뒷배열을 연결시킨다.
		
		// 예시 : arr이 {1, 3, 5, 7, 9}이고 
		// element가 5이다. 
		// 앞부분은 배열의 크기가 2가 나옴(1, 3)
		
		
		
		// {1, 3, 5, 7, 9}
		// 5를 remove 한다고 가정
		// -> {1, 3}, {7, 9}
		// remove(5)
		// {1, 3, 7, 9}
		// 해당하는 번호 어떻게 찾아? >> indexOf가 있잖아 !
		int index = indexOf(arr, element);
		// 그러면, for(int i = 0; i < index; i++) -> 앞부분
		// for(int i = index+1; i < arr.length; i++) -> 뒷부분

		// 앞부분
		if (index != -1) {
			int[] front = new int[index]; 				// index-1이면 index가 -1가 될 수도 있고 그럼 에러 뜸 (배열의 크기에 음수 x)
			// 샘플 데이터 기준으로 front의 length 는 2(1, 3)	// 그래서 배열의 크기가 -1이 되지 않게 if문으로 조건을 넣는다.
			// int[] front = new int[2];와 같은 것.. 
			// 크기 2 , 위치번호 0 1 가능 
			
			// 뒷부분
			// 원래크기 - 앞의 크기 -1
			// 5 - 4 - 1 
			// index크기가 5라는 것은 ... ?????? 여기 모르겠다. 
			int[] back = new int[arr.length - front.length - 1];
			// 나는 arr.length - index - 1 인 줄 알았는데 
			// 왜 front.length인지.. 생각해봐 
			
		}
		return arr;
	}
}
