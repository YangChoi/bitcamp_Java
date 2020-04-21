import java.util.ArrayList;

class PersonMain {
	public ArrayList<PersonDTO> init(){
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("또치", 40);
		PersonDTO cc = new PersonDTO("도우너", 30);

		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc); // 주소값을 각각 담긴다. 
		// list는 이들과는 다르게 자신만의 주소도 또 가지고 있다. 
		
		//return aa, bb, cc; >> 자바에선 불가능 
		 
		return list; // aa, bb, cc 의 주소값이 각각 담겨있다. 
		// list의 주소값을 return 한다. 

	} // 각 aa, bb, cc, 는 이 안에서만 존재 

	public static void main(String[] args) {
		// System.out.println(aa); >> 모름 
		//System.out.println(dto.toString()); // dto에 대한 주소값이 출력된다. 
		
		PersonMain main = new PersonMain();// 호출, return 값 가지고 옴 
		// 하지만 한 번에 세개를 돌려줄 수 없다. 
		// 그렇기 때문에 세개를 ArrayList로 묶는다. 

		ArrayList<PersonDTO> list = main.init(); // 호출 
		// 위의 return list와 이 list는 다른 list이다. 
		// main.init()을 보관해주는(주소받음) 또 다른 list

		/*
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
			// toString() 오버라이딩 안할 때 
			// System.out.println(list.get(i).getName() + list.get(i).getAge());
		}
		*/

		// 확장형 for문 
		for(PersonDTO dto : list){ // 리스트가 왼쪽으로 어떤 타입의 데이터를 주는지 생각한다. 
			System.out.println(dto);
		}
		
	}
}
