package com.zoo;

class Zoo2 {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.tiger();
		zoo.giraffe();
		zoo.elephant();
		//zoo.lion(); > private이므로 컴파일 불가
	}
}
