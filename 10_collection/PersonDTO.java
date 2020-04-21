class PersonDTO implements Comparable<PersonDTO>{ // 나이와 이름을 함께 묶어 움직이게 해주는 comparable<누구랑 비교할 것인지 :PersonDTO끼리 비교할 것이다.  >
// 1인분의 데이터를 가지고 있는 DTO
// 가장 작은 단위의 클래스 
	private String name; 
	private int age; 

	// 생성자로 데이터 받기 
	public PersonDTO(String name, int age){
		this.name = name; 
		this.age = age; 
	}

	public String getName(){
		return name; 
	}
	
	public int getAge(){
		return age; 
	}

	@Override 
	// 주소값 만 나오는 toString을 오버라이드 해서 
	// 내가 입력한 이름과 나이가 나오도록 한다 
	public String toString(){
		return "이름 = " + name + "\t 나이 ="+ age;
	} 


	// 나이 정렬 
	@Override
	public int compareTo(PersonDTO o){ // 누구랑 비교할 것인지 써주어야한다. 위에 
		/*
		if(this.age < o.age){
			return -1;
		}else if(this.age > o.age){
			return 0; 
		}else {
			return 1; 
		}
		*/

		// 조건 연산자 
		// 조건 ? 참 : 거짓; 
		//return this.age < o.age ? -1 : 1; // 나이 순 오름차순 
		// 같은 값(0)은 신경안쓰는 것 
		return this.age < o.age ? 1 : -1; // 내림차순 
	}
	// 위의 기준이 맘에 안들어 다른 기준으로 바꾸고 싶을 때 
	// Comparator


}
