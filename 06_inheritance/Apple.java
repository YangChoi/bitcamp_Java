package com.apple;
// import�� package ������..
import com.zoo.Zoo;

class Apple {
	public static void main(String[] args) {
		System.out.println("���� ���");
		
		//Zoo class�� tiger�θ��� 
		Zoo zoo = new Zoo();
		zoo.tiger();
		//zoo.giraffe();
		//zoo.elephant();
		//zoo.lion();
		// ���������� public �ܿ� ������ �� ���� 
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
			      Apple.class ( ��Ű�� �ȿ��� �����ϵ� class ����)
				  >> java���ϰ� class������ �и���Ű�ڴ�..
			   banana
			      Banana.class
			   Zoo
			      Zoo.class

				  safari
				     Safari.class


		cd .  : �ڽ� (06_instance) : �ڱ��ڽ� 
		cd .. : �θ� (workspace) 
*/