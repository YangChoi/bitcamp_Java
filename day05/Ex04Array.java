package day05;

public class Ex04Array {
	// call by value vs call by reference 
	// 값 호출과 참조 호출 
	// 우리가 파라미터로 무언가를 넘겨주면 도대체 무엇이 가는걸까 
	// 기본형 데이터타입의 경우 변수에 값이 있으니까 그 값이 넘어간다 
	// = 변수 자체가 아니라 값만 넘어간다. 
	// 그러면 변수의 이름과 파라미터의 이름이 같아도 같은 존재일까?
	// 굳이 주소값 자체가 넘어갈 필요 없이 값 만 넘겨주고 
	// 리턴타입으로 똑같은 데이터타입을 받아와서 
	// 그 값으로 초기화해주면??
	// call by value의 장점 : 원본에 손을 안대기 때문에 안전 
	// 						쉽다
	// 그에 반해서 call by reference의 경우 
	// 주소값을 가지고 있는 참조형 데이터 중에서도 
	// 특별하게 배열, collections 가 call by reference가 가능하다. 
	// 왜냐하면 
	// 얘기들은 스택 영역에 힙 메모리로 향하는 주소값을 가지고 있고 
	// 힙 메모리 안에는? 
	// 다시 힙 영역 안의 다른 곳으로 향하는 메모리 주소값을 가지고 있기 때문에 
	// call by reference가 일어나게 된다. 
	// 이 주소값에 의한 참조의 경우 
	// 자바가 힙 영역을 봤을 때 "어 또 주소값이네? " 하면서 일어나게 되는것
	// 위의 내용은 너무 어려워서 그냥 여기까지 하는 걸로....
	
	
	
	// 데이터를 추가하고 나서 변경할 때 조심하기 -> ArrayList 스포 
	
	public static void main(String[] args) {
		// 만약 우리가 자리가 없으면 자동으로 늘어나는 배열이 필요하다면? 
		// 직접 메소드를 만들어서 준비를 해준다. 
		
		// 그런데 배열의 크기를 늘리려면 어떻게 해야할까? 
		
		int[] arr = new int[3];
		// 이 arr은 사이즈가 3이다. 
		// 그러면 우리가 3개까지 밖에 입력하지 못하는데 
		// 자동으로 늘어나가 하려면? 
		arr[0] = 100; 
		arr = expand(arr);
		System.out.println(arr[0]);
		// 곧장 이렇게 하면? 
		// 기존에 입력한 데이터들이 모두 날아간다. 
		arr = new int[4];
		System.out.println(arr[0]);
		// 그럼 배열에서 크기를 늘리려면 어떻게 해야할까? 
		// 데이터를 포기하고 늘리던지 
		// 귀찮은 과정을 통과해야한다.
		// 귀찮은 과정 : 기존의 데이터를 임시보관할 곳에 복사하고 
		// 늘리고 임시보관한 데이터에서 다시 데이터를 복사해오는 것
		System.out.println(arr.length);
		// 결과 4. arr = 4라고 위에서 선언을 했기 때문
		arr[0] = 150;
		arr = expand(arr);
		System.out.println(arr.length);
		System.out.println(arr[0]);
		
	}
	
	// 만약 사용자가 요청하면 배열의 크기를 늘려주는 메소드 
	public static int[] expand(int[] array) {
		// 전통적으로 임시로 무언가 보관하는 변수들은 
		// 다 temp라는 단어가 들어간다(temporary의 줄임말)
		int[] temp = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			temp[i] = array[i];
			//temp에 원본의 데이터가 들어갔다. 
		}
		// array = new int[array.length + 1];
		// 날라갈 위험이 있는 애한테 array.length + 1을 하는건 위험
		array = new int[temp.length + 1]; 
		// 어차피 array와 temp는 같기 때문에 복사본인 temp에다 +1 하자 
		for(int i = 0; i < temp.length; i++) {
			// 여기의 i는 temp의 길이 보다 작아야한다. 
			// array가 temp보다 길다. 그렇기 때문에 i가 마지막칸에 오면 temp는 존재하지 않는 아이가 되어버리고 만다.
			array[i] = temp[i];
			
		}	
		
		// 크기가 늘어난 배열을 보내서 원본에 덮어쓰기 
		return array; 
	}	

}
