package com.zoo.safari;
import com.zoo.Zoo;

class Safari extends Zoo {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.tiger();
		//zoo.giraffe(); // ���ٺҰ� 
		// Zoo�� ���� �ڽ��� ������ �𸣱� ������ protected���� ���� �Ұ� 
		//zoo.elephant(); // ���ٺҰ� 
		//zoo.lion();
		System.out.println(); 

		Safari safari = new Safari(); 
		// �ڽ��� �ڱ��ڽ��� ��ü�� �������� �θ� ������ �θ� �� �ִ� ��. 
		safari.tiger();
		safari.giraffe();
		//safari.elephant();
		//safari.lion();
		// �̷��� �ϸ� protected �� �� ���� 
	}
}
