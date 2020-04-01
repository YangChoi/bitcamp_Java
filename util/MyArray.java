package util;

/*
 * 배열에 필요한 메소드들을 구현해 놓은 클래스 
 */
public class MyArray {

	// contains
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

		// {1, 3, 5, 7, 9, 11}
		// -> {1, 3}, {7, 9, 11}
		// {1, 3, n, n, n}

		// 해당하는 번호 어떻게 찾아? >> indexOf가 있잖아 !
		// {1, 3, n, n, n} >> arr에 넣어...
		int index = indexOf(arr, element);
		// 그러면, for(int i = 0; i < index; i++) -> 앞부분
		// for(int i = index+1; i < arr.length; i++) -> 뒷부분

		// 앞부분
		if (index != -1) {
			int[] front = new int[index]; // index-1이면 index가 -1가 될 수도 있고 그럼 에러 뜸 (배열의 크기에 음수 x)
			// 샘플 데이터 기준으로 front의 length 는 2(1, 3) // 그래서 배열의 크기가 -1이 되지 않게 if문으로 조건을 넣는다.
			// int[] front = new int[2];와 같은 것..
			// 크기 2 , 위치번호 0 1 가능
			for (int i = 0; i < front.length; i++) {
				front[i] = arr[i];
			}

			// 뒷부분
			// 원래크기 - 앞의 크기 -1
			// 5 - 4 - 1
			// index크기가 5라는 것은 ... ?????? 여기 모르겠다.
			int[] back = new int[arr.length - front.length - 1];
			// 나는 arr.length - index - 1 인 줄 알았는데
			// 왜 front.length인지.. 생각해봐

			// arr에서 3, 4를 가지고 오지만
			// back은? 0에서부터 우리가 값을 넣어야한다.
			int backIndex = 0;
			for (int i = index + 1; i < arr.length; i++) {
				// 그럼 우리가 back을 위한 위치를 따로 만들어서
				// 0에서 1씩 증가하면서 위치를 직접 지정해줘야한다.
				back[backIndex] = arr[i];
				backIndex++;
			}

			// 그럼 이제 arr의 크기는?
			arr = new int[front.length + back.length];
			// 아래의 for문을 새로 작성하도록 한다....
			// for(int i = 0; i < arr.length; i++) {
			// arr[i]번째에 차례대로 front와 back 애들을 넣어주면 된다..
			// arr[i] = front[i]는 문제가 없지만
			// arr[i] = back[i]는?
			// 만약 front의 길이가 3이고 back의 길이가2면?
			// i는 몇번 반복되는가?
			// 5번 ( 각각 3, 2 니까)
			// for문을 통해서
			// arr[i] = front[i] ->
			// i가 0일때 -> 문제 없다.
			// i가 1일 때 -> 문제 없다.
			// i가 2일때 -> 문제 없다.
			// i가 3일때 -> 문제생김 >> front의 길이가 3이면? 인덱스는 0부터 2까지만 있다.
			// if문을 써서 front의 길이까지만 가자
			// 문제해결?
			// arr[i] = back[i]에서 다시 문제 발생
			// 3일 때 ->문제 생김 -> back에는 index 3이 없다(길이 2까지임) 0에서 1까지만 있다.
			// 즉 우리가 front와 back의 값을
			// 새로만든 arr에 복사 할 때
			// for문을 좀 생각해봐야한다는 것
			// 위의 back배열을 만들 때 처럼
			// backIndex를 통해서 우리가 컨트롤 해야한다는 것이다.
			// 두개의 for문을 통해서
			// 첫번째 for문으로 front의 배열을
			// arr에 복사해주고
			// 두번째 for문으로 back 배열을 복사해준다.

			// 앞(front 배열)을 복사하는 for문
			for (int i = 0; i < front.length; i++) {
				arr[i] = front[i];
			}

			// 뒤(back 배열)을 복사하는 for문
			// 아까 만들어둔 backIndex를 0으로 초기화 하자
			// 우리가 만드는 for문은 back을 기준으로 한다.
			// 즉 back의 크기가 3이면?
			// i는 0 1 2 가 된다.
			// 근데 arr[0] arr[1] arr[2] 에는 무엇이 있을까?
			// 이미 우리가 front 값을 입력한게 있기 떄문에 값이 덮어진다.
			// 그러면 backIndex = 0이 아닌 다른 걸로 초기화해야한다.
			// 그 다른 것은 front가 끝난 index가 되어야한다.
			// 그럼 얼마로 초기화해야할까?
			// 0 이 아닌 front.length로 초기화해야한다.
			// 왜냐하면
			// 배열의 마지막 index는 배열길이 -1
			// 따라서
			// front의 맨 마지막 index는 front.length - 1 이니까.
			// 그럼 front가 끝난 arr에 다음으로

			// front의 크기가 5고 back의 크기가 2일 때
			// arr의 새로운 크기는 얼마인가? >> 7
			// 그럼 arr의 가능한 index는 0~6
			// arr[0] 에는 front[0]
			// arr[1] => f1
			// arr[2] => f2
			// arr[3] => f3
			// arr[4] = > b0
			// arr[5] => b1
			// arr[6] => b2

			// front의 크기가 2고 back의 크기가 6일 때
			// arr의 새로운 크기는 얼마인가? >> 8
			// 그럼 arr의 가능한 index는 0~7
			// arr[0] 에는 front[0]
			// arr[1] => f1
			// arr[2] = > b0
			// 그럼 front가 끝나는 위치는? front.length - 1
			// 그럼 arr에서 front가 끝나고
			// 처음으로 back을 집어넣는 위치는? front.length

			// 추가할 index는 front.length가 된다.

			// {1, 3, 5, 7, 9, 11}
			// -> {1, 3, 5, 7}, {11}
			// {1, 3, 5, 7, n}
			backIndex = 2;
			for (int i = 0; i < back.length; i++) {
				arr[backIndex] = back[i];
				backIndex++;
			}
		}

		return arr;
	}

	public static String[] remove(String[] arr, String element) {
		int index = indexOf(arr, element);
		if (index != -1) {
			// 앞
			String[] front = new String[index];
			for (int i = 0; i < front.length; i++) {
				front[i] = arr[i];
			}

			// 뒤
			int backIndex = 0;
			String[] back = new String[arr.length - front.length - 1];
//			for(int i = index; i < back.length; i++) {
//				back[i] = arr[i]; //안됨
//				// back은 0부터 시작해야하는데 이렇게 하면 index부터 시작해버림
//			}
			for (int i = index; i < arr.length; i++) {
				back[backIndex] = arr[i];
				backIndex++;
			}

			arr = new String[front.length + back.length];
			for (int i = 0; i < front.length; i++) {
				arr[i] = front[i];
			}

			backIndex = front.length;
			for (int i = 0; i < back.length; i++) {
				arr[backIndex] = back[i];
				backIndex++;
			}
		}

		return arr;
	}

	// arr : {1, 3, 5, 7, 9}
	// MyArray.remove(arr, 3);
	// 주어진 Index에 따라 삭제하기
	public static int[] removeByIndex(int[] arr, int index) {
		if (index >= 0 && index < arr.length) {
			arr = remove(arr, arr[index]);
		}

		return arr;
	}
	
	public static String[] removeByIndex(String[] arr, int index) {
		
		return (index >= 0 && index < arr.length) ? remove(arr, arr[index]) : arr;
	}
	
	// test해보기 
	// 그런데 얘 말고 다른데에서..
	
	
}
