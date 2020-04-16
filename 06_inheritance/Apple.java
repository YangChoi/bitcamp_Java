package com.apple;
// import는 package 밑으로..
import com.zoo.Zoo;

class Apple {
	public static void main(String[] args) {
		System.out.println("빨간 사과");
		
		//Zoo class의 tiger부르기 
		Zoo zoo = new Zoo();
		zoo.tiger();
		//zoo.giraffe();
		//zoo.elephant();
		//zoo.lion();
		// 접근제어자 public 외에 접근할 수 없음 
	}
}

/*
D:
  java_se
     workspace
	    06_instance
		    Apple.java
			Banana.java
			Zoo.java

			com
			   apple
			      Apple.class ( 패키지 안에는 컴파일된 class 파일)
				  >> java파일과 class파일을 분리시키겠다..
			   banana
			      Banana.class
			   Zoo
			      Zoo.class

				  safari
				     Safari.class


		cd .  : 자식 (06_instance) : 자기자신 
		cd .. : 부모 (workspace) 
*/