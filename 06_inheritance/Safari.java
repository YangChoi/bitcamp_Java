package com.zoo.safari;
import com.zoo.Zoo;

class Safari extends Zoo {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.tiger();
		//zoo.giraffe(); // 접근불가 
		// Zoo가 본인 자식의 유무를 모르기 때문에 protected여도 접근 불가 
		//zoo.elephant(); // 접근불가 
		//zoo.lion();
		System.out.println(); 

		Safari safari = new Safari(); 
		// 자식인 자기자신의 객체를 만들어줘야 부모 꺼까지 부를 수 있는 것. 
		safari.tiger();
		safari.giraffe();
		//safari.elephant();
		//safari.lion();
		// 이렇게 하면 protected 들어갈 수 있음 
	}
}
