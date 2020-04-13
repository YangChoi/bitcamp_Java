class MemberDTO{ // DTO / VO/ Bean 
	private String name; 
	private int age; 
	private String phone, address; 
	

	// int a; // 필드 - 인스턴스 변수(new 해서 쓰는 애들)
	// static int b; // 필드 - 클래스 변수 (new 안하고 쓰는 애들) 

	public MemberDTO() {
	}
	// 생성자 목적 - 객체 초기화 
	// 하지만 이미 널값을 가지고 있는 상태 (따라서 객체 초기화의 목적은 아니다)
	// private으로 걸려있기 있기 때문에 외부에서 들어올 때 
	// setter 대신에 사용한다. 
	// 단 생성자를 통해 들어올 때는 딱 한 번 밖에 사용할 수 없다. 
	// setter의 경우에는 데이터를 수정할 경우 많이 사용함 

	// 생성자 오버로드, 데이터 받기
	public MemberDTO(String name, int age, String phone, String address) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	// getter
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}
	
	// setter를  사용할 수도 있고 생성자를 사용할 수도 있기 때문에 
	// 두개 다 만들어놓은 상태..
	public void setName(String name) {
		this.name = name; 
	}

	public void setAge(int age) {
		this.age = age; 
	}

	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setAddress(String address){
		this.address = address;
	}


}
