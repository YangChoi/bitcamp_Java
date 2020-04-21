import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.Comparator;

class PersonSort{
	public static void main(String[] args){
		String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};
		System.out.print("정렬 전 = ");
		
		for(String data : ar){
			System.out.print(data + " ");
		}
		System.out.println();

		Arrays.sort(ar); // sort 시키기 

		System.out.print("정렬 후 = ");
		
		for(String data : ar){
			System.out.print(data + " ");
		}
		System.out.println();

		System.out.println("PersonDTO를 나이 순서로 정렬");
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("또치", 40);
		PersonDTO cc = new PersonDTO("도우너", 30);
		
		// 나이로 정렬하는데 이름도 같이 움직여야한다. 
		// Comparable 사용 

		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		// 리스트 안에 담아준다. 

		System.out.println("정렬 전 : " + list); // 클래스명 @ 16진수 주소값
		// list는 주소값이 안나온다. 항목을 보여준다. 

		// 이제 배열 아니니까 Arrays.sort 쓰지 말고...
		Collections.sort(list); 
		System.out.println("정렬 후 : " + list); 




		System.out.println("PersonDTO를 이름 순서로 정렬");
		Comparator<PersonDTO> com = new Comparator<PersonDTO>(){
			@Override 
			public int compare(PersonDTO o1, PersonDTO o2){
				//return o1.getName().compareTo(o2.getName()); // -1 0 1 오름차순 
					// getName 불러올 경우 문자열 : 크다 작다 물을 수 없으므로 compareTo 
					//compareTo는 앞에서 오버라이드 한 것 불러온 것 
					// 오른쪽이 더 크면 -1
					// 왼쪽이 더 크면 0
					// 같으면 1
				// 내림차순
				//return o2.getName().compareTo(o1.getName()); // -1 0 1
				return o1.getName().compareTo(o2.getName())*-1; // 1 0 -1 

			}   
		}; // 새로운 기준을 세울 때 Comparator, 익명 사용해야함  

		Collections.sort(list, com); // list 만 딸랑 말하면 나이로 정렬이 된다. , com으로 해서 com의 기준으로 정렬이 되도록 한다 
		System.out.println("정렬 후 = " + list);
	}
}
