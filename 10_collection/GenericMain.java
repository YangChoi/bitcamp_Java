class GenericTest<T>{
	private T a; //a가 어떤 타입이 될지 모르기 때문에 제네릭 <T>로 
	
	public void setA(T a){
		this.a = a; 
	}

	public T getA(){
		return a; 	
	}
}

class GenericMain{
	public static void main(String[] args) {
		GenericTest<String> aa = new GenericTest<String>();
		// 실행 때 타입 선택 (String 타입)
		aa.setA("양아무개");
		//aa.setA(25);
		System.out.println("이름 : " + aa.getA());
		
		// 타입은 객체형만 묻는다(int 안됨)
		GenericTest<Integer> bb = new GenericTest<Integer>();
		bb.setA(30);
		System.out.println("나이 : " + bb.getA());
	}
}
